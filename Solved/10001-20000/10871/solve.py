N, X = map(int, input().split(" "))

A = list(map(int,input().split(" ")))
small = []

for i in range(N): 
	if A[i] < X: 
		small.append(str(A[i]))

print(" ".join(small))