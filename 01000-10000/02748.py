a,b,n = 0,1,int(input())
for i in range(2,n,1):
	c = a + b
	a = b
	b = c
print(a+b)