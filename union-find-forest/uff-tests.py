import os
from zipfile import ZipFile, ZIP_DEFLATED
from random import seed, sample
from uff import UFF

seed(123)

os.makedirs("tests", exist_ok=True)
with ZipFile('uff-tests.zip', mode="w", compression=ZIP_DEFLATED, compresslevel=9) as tests_zip:
    for deg in 2, 3, 4, 7, 10, 15, 17, 18, 19, 20:
        infile = f"tests/2to{deg}.in"
        outfile = f"tests/2to{deg}.out"
        with open(infile, "w") as finput, open(outfile, "w") as foutput:
            finput.write(f"{2 ** deg} {2 ** deg}\n")
            n = 2 ** deg
            # 0-1 2-3 4-5 6-7 8-9 10-11 12-13 14-15
            # 0-2 4-6 8-10 12-14
            # 0-4 8-12
            # 0-8
            delta = 1
            while delta < n:
                x = 0
                while x + delta < n:
                    finput.write(f"{x} {x + delta}\n")
                    x += 2 * delta

                delta *= 2

            x1, x2 = sample(range(n), 2)
            finput.write(f"{x1} {x2}\n")

            for t in range(n - 1):
                foutput.write("NO\n")
            foutput.write("YES\n")
        tests_zip.write(infile)
        tests_zip.write(outfile)


    def generate(f, n, m):
        infile = f"tests/{f}.in"
        outfile = f"tests/{f}.out"
        with open(infile, "w") as finput, open(outfile, "w") as foutput:
            finput.write(f"{n} {m}\n")
            uff = UFF(n)
            for test in range(m):
                a, b = sample(range(n), 2)
                aa = uff.find(a)
                bb = uff.find(b)
                print(a, b, file=finput)
                if aa == bb:
                    print("YES", file=foutput)
                else:
                    print("NO", file=foutput)
                    uff.union(a, b)
        tests_zip.write(infile)
        tests_zip.write(outfile)

    generate(1, 4, 10)
    generate(2, 10, 10)
    generate(3, 100, 50)
    generate(4, 1000000, 100000)
