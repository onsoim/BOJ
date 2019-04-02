def calc(A,B,C):
	if B == 1: return A % C
	if B % 2 == 0: return calc(A,B/2,C) ** 2 % C
	if B % 2 == 1: return A * (calc(A,(B-1)/2,C) ** 2) % C

A,B,C = map(int,input().split(" "))
print(calc(A,B,C))