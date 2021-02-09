num = [0,0,0,0,0,0,0,0,0,0]
A, B, C = int(input()), int(input()), int(input())

result = str(A*B*C)
for i in range(len(result)): num[int(result[i])] += 1
for i in range(len(num)): print(num[i])