'''
def gcd(a,b):
	if a < b: a,b = b,a
	while b: a,b = b,a%b
	return a

def lcm(a,b):
	return a*b//gcd(a,b)
'''
for i in range(int(input())):
	M,N,x,y = map(int,input().split(" "))
	flag = -1
	if M > N:
		for j in range(M):
			if (M * j + x) % N == y % N:
				flag = M * j + x
				break
	else:
		for j in range(N):
			if (N * j + y) % M == x % M:
				flag = N * j + y
				break
	print(flag)