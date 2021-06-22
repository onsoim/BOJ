N = int(input())
MAX = {}

for i in map(int, input().split(' ')):
    if i not in MAX: MAX[i] = i
    for m in list(MAX):
        if i > m and MAX[i] - i <= MAX[m]:
            MAX[i] = MAX[m] + i

print(sorted(MAX.items(), key=lambda item: item[1], reverse=True)[0][1])
