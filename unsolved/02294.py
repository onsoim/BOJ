import sys

sys.setrecursionlimit(1500)

def calc(i,cnt):
	if i > k: return
	if i == k and mcnt > cnt:
		mcnt = cnt
	for i in range(n):
		calc(i+value[i],cnt+1)


n,k = map(int,input().split())
value = []

for _ in range(n):
	value.append(int(input()))

mcnt = k // value[0]

calc(0,0)
print(mcnt)