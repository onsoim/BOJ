a, b, S = [], [], 0

n = int(input())
a = map(int, input().split(' '))
b = map(int, input().split(' '))
# for _ in range(n): a.append(int(input()))
# for _ in range(n): b.append(int(input()))

a, b = sorted(a), sorted(b, reverse=True)
for i in range(n): S += (a[i] * b[i])
print(S)