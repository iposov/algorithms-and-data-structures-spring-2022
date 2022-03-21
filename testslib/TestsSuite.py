import os
from zipfile import ZipFile, ZIP_DEFLATED


class TestCase:

    def __init__(self, name, tests_folder):
        self._files_prefix = f'{tests_folder}/{name}.'
        self.name = name
        self._statement = open(self.statement_file_name(), mode='w', encoding='utf8')
        self._answers = {}

    def answer(self, answer_name=''):
        if answer_name in self._answers:
            return self._answers[answer_name]
        new_file = open(self.answer_file_name(answer_name), mode='w', encoding="utf8")
        self._answers[answer_name] = new_file
        return new_file

    def statement(self):
        return self._statement

    def statement_file_name(self):
        return self._files_prefix + 'in'

    def answer_file_name(self, answer_name=''):
        if answer_name == '':
            return self._files_prefix + 'out'
        return self._files_prefix + answer_name + '.out'

    def all_file_names(self):
        return [self.statement_file_name()] + [self.answer_file_name(answer_name) for answer_name in self._answers]

    def close(self):
        self.statement().close()
        for answer_file in self._answers.values():
            answer_file.close()


class TestsSuite:

    def __init__(self, tests_folder='.', maximal_non_zip_size=10 * 2 ** 10):
        self.files = []
        self.tests_folder = tests_folder
        self.maximal_non_zip_size = maximal_non_zip_size
        os.makedirs(tests_folder, exist_ok=True)
        self.next_text_index = 1
        self.test_cases = []

    def get(self, name=None):
        if name is None:
            name = str(self.next_text_index)
            self.next_text_index += 1

        test_case = TestCase(name, self.tests_folder)
        self.test_cases.append(test_case)
        return test_case

    def close(self):
        for test_case in self.test_cases:
            test_case.close()

        # put big files inside archive
        for test_case in self.test_cases:
            total_size = 0
            all_files = test_case.all_file_names()
            for file_name in all_files:
                total_size += os.path.getsize(file_name)
            if total_size > self.maximal_non_zip_size:
                with ZipFile(f'{self.tests_folder}/{test_case.name}.zip', mode="w", compression=ZIP_DEFLATED,
                             compresslevel=9) as zip:
                    for file in all_files:
                        zip.write(file)
                        os.unlink(file)

    def __enter__(self):
        return self

    # TODO put each .close() inside a try-block
    def __exit__(self, exc_type, exc_val, exc_tb):
        self.close()
