from testslib.TestsSuite import TestsSuite
from image_clusterization import count_islands_quadratic_memory
from random import choices

with TestsSuite() as testSuite:
    # random tests
    for m, n in (4, 4), (20, 20), (100, 200), (3000, 4000):
        for density in 10, 50, 90:

            testCase = testSuite.get()
            statement = testCase.statement()
            answer = testCase.answer()
            lines = []

            print("working on test case", m, 'by', n, 'density', density)

            for i in range(m):
                line = ''.join(choices('#.', weights=[density, 100 - density], k=n))
                print(line, file=statement)
                lines.append(line)

            islands = count_islands_quadratic_memory(m, n, lines)
            print(islands, file=answer)
