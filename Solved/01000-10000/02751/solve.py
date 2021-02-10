import sys
num = []
for i in range(int(input())): num.append(int(sys.stdin.readline()))
print(*sorted(num),sep="\n")