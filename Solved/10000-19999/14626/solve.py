
sum, flag = 0, 1
for i, v in enumerate(input()):
    if v != "*": sum += int(v) * 3 if i % 2 else int(v)
    elif i % 2: flag = 3

for i in range(10):
    if (sum + i * flag) % 10 == 0: print(i)
