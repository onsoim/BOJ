N = int(input())
MAX, candidate = -1000, 0

for i in map(int, input().split(' ')):
    if i > MAX and i > candidate + MAX:
        MAX = candidate = i
    else:
        candidate += i

        if candidate > MAX:
            MAX = candidate
        if candidate < 0:
            candidate = 0

print(MAX)
