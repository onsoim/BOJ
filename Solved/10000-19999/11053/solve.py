N = int(input())

MAX = {}

for i in map(int, input().split(' ')):
    if i not in MAX: MAX[i] = 1
    for m in list(MAX):
        if i > m:
            if MAX[i] <= MAX[m]:
                MAX[i] = MAX[m]+ 1

print(sorted(MAX.items(), key=lambda item: item[1], reverse=True)[0][1])
