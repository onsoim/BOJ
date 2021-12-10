def calc(x):
	global cnt
	if x > n: return
	if x == n: cnt += 1
	calc(x+1)
	calc(x+2)
	calc(x+3)

for _ in range(int(input())):
	cnt,n = 0,int(input())
	calc(0)
	print(cnt)