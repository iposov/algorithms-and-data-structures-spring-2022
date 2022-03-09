import sys
import subprocess
from importlib import import_module
from pathlib import Path

def run_test_case(lab_dir, test, lab_out, test_num):
    print('\tRunning...', end=' ')
    tmp_out = lab_out / f'{test_num}.tmp.out'
    cmd = ['cargo', 'run', '--release']
    with test.open('r') as i, tmp_out.open('w') as o:
        res = subprocess.run(cmd, cwd=lab_dir, stdin=i, stdout=o)
    if res.returncode != 0:
        print(f'failed, returned {res.returncode}')
        return False

    if not exists(tmp_out):
        print('failed, no output file')
        return False

    print('ok')
    return True

def get_test_expected_out_file(lab_dir, test_dir, test_num):
    dyn_m_path = lab_dir / 'get_out_file_name.py'
    if dyn_m_path.is_file():
        m_path = str(dyn_m_path).replace('/', '.').rstrip('.py')
        out_file_name = import_module(m_path).get_out_file_name(test_num)
    else:
        out_file_name = f'{test_num}.out'
    return test_dir / out_file_name

def validate_test_case_result(lab_dir, test_dir, lab_out, test_num):
    print('\tAsserting...', end=' ');
    out = get_test_expected_out_file(lab_dir, test_dir, test_num);
    tmp_out = lab_out / f'{test_num}.tmp.out'
    res = subprocess.run(['diff', '-u', str(out), str(tmp_out)],
            capture_output=True, text=True)
    if res.returncode != 0:
        print(f'failed, returned {res.returncode}')
        formated_stdout = res.stdout[:-1].replace('\n', '\n\t')
        print(f'\t{formated_stdout}')
        return False

    print('ok')

    return True

def exists(path):
    if not path is Path:
        path = Path(path)
    return path.is_file()

def prepare():
    Path('./tmp/').mkdir()

def clear_tmp_out():
    def rm_tree(pth: Path):
        for child in pth.iterdir():
            if child.is_file():
                child.unlink()
            else:
                rm_tree(child)
        pth.rmdir()
    rm_tree(Path('./tmp/'))

def run_lab(lab_dir):
    lab_dir_name = lab_dir.name
    print(f'Found lab: {lab_dir_name}')

    lab_out = Path(f'./tmp/{lab_dir_name}/')
    lab_out.mkdir()

    passed_count = 0
    failed_count = 0
    skipped_count = 0
    for lab_test in sorted(Path(lab_dir_name).glob('*.in')):
        test_num = lab_test.stem
        print(f'Found test case #{test_num}: {lab_test}')

        if not run_test_case(lab_dir, lab_test, lab_out, test_num):
            skipped_count += 1
            continue

        if not exists(f'{lab_out}/{test_num}.tmp.out'):
            print('Expected test result not found. Skip validation')
            skipped_count += 1
            continue

        test_dir = lab_test.parent
        test_passed = validate_test_case_result(lab_dir, test_dir, lab_out, test_num)
        passed_inc, failed_inc = (1, 0) if test_passed else (0, 1)
        passed_count += passed_inc
        failed_count += failed_inc
    return (passed_count, failed_count, skipped_count)

def main():
    prepare()

    base_dir = Path('./solution')
    if len(sys.argv) == 2:
        lab_dirs = [base_dir / sys.argv[1]]
    else:
        lab_dirs = list(sorted(base_dir.glob('*')))

    passed_count = 0
    failed_count = 0
    skipped_count = 0
    for lab_dir in lab_dirs:
        (p, f, s) = run_lab(lab_dir)
        passed_count += p
        failed_count += f
        skipped_count += s
        print()

    print(f'Passed: {passed_count}, Failed: {failed_count}, Skipped: {skipped_count}')

    return failed_count

def finalize(ex):
    clear_tmp_out()
    return 0 if ex is None else 255

if __name__ == '__main__':
    try:
        ec = main()
    except Exception as ex:
        finalize(ex)
        raise
    else:
        ec = finalize(None)

    sys.exit(ec)

