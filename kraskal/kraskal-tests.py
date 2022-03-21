# import os
#
# os.makedirs("sets")
# os.makedirs("kraskal")
#
# for deg in range(2, 23):
#     with open(f"sets/2to{deg}.in", "w") as finput, open(f"sets/2to{deg}.out", "w") as foutput, \
#             open("kraskal/2to{deg}.in", "w") as finputkraskal, open("kraskal/2to{deg}.out", "w") as foutputkraskal:
#         finput.write(f"{2 ** deg}\n")
#         n = 2 ** deg
#         # 0-1 2-3 4-5 6-7 8-9 10-11 12-13 14-15
#         # 0-2 4-6 8-10 12-14
#         # 0-4 8-12
#         # 0-8
#         weight = 1
#         delta = 1
#         while delta < n:
#             x = 0
#             while x + delta < n:
#                 finput.write(f"{x} {x + delta}\n")
#                 finputkraskal.write(f"{x} {x + delta} {weight}\n")
#                 x += 2 * delta
#
#             delta *= 2
#             weight += 2
#
#         for t in range(n - 2):
#             foutput.write("NO\n")
#         foutput.write("YES\n")
#
#         for v in range(1, n / 2):
#             finputkraskal.write(f"0 {v} {weight - 1}\n")
#
#       1           3
#       2           4
#             0
#
#
#
#
#