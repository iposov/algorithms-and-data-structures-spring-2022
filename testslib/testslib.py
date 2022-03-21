import os


class TestFile:

    def __init__(self, name):
        self.text = []
        self.name = name

    def write(self, text):
        self.text.append(text)

    def writeln(self, text):
        self.text += [text, '\n']

    def to_file(self, path):
        with open(path, mode='w', encoding="utf-8") as f:
            f.write(str(self))

    def __str__(self):
        return ''.join(self.text)


class TestArchive:

    def __init__(self, tests_name):
        self.files = []
        self.tests_name = tests_name
        os.makedirs(tests_name, exist_ok=True)

    def put(self, test_file):
        self.files.append(test_file)
