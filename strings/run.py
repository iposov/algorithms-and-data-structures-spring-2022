import subprocess
import time
from joblib import Parallel, delayed

script_name = "strings.py"
tests_to_run = 6
start_test = 1
in_file_type = ".in"
out_file_type = "_my.out"
compare_file_type = ".out"

mt = False
n_jobs = 8


def run_script_and_test(script_name, in_file_name, out_file_name, compare_file_name):
    with open(in_file_name, 'r') as in_file, open(out_file_name, 'w') as out_file:
        subprocess.run(["python", script_name], stdout=out_file, stdin=in_file)
    try:
        subprocess.check_output(["FC", out_file_name, compare_file_name], shell=True).decode("cp866")
    except subprocess.CalledProcessError:
        return False
    else:
        return True


def make_names_and_run(i):
    _in_file_name = str(i) + in_file_type
    _out_file_name = str(i) + out_file_type
    _compare_file_name = str(i) + compare_file_type
    start = time.time()
    result = run_script_and_test(script_name, _in_file_name, _out_file_name, _compare_file_name)
    end = time.time()
    print(str(i) + ": " + ("success" if result else "fail") + ", time: " + str(round(end - start, 5)))


if mt:
    Parallel(n_jobs=n_jobs)(delayed(make_names_and_run)(i) for i in range(start_test, tests_to_run + 1))
else:
    for i in range(start_test, tests_to_run + 1):
        make_names_and_run(i)
