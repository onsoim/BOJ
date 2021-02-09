m, n = map(int,input().split(" "))
mat = []

for i in range(m):
	mat.append(list(input()))

cnt,flag,maxd = 1,0,0
stack = [[0,0,1]]
while stack:
	x,y,depth = stack.pop()
	if maxd < depth: maxd = depth
	cnt = cnt + 1
	mat[x][y] = 0
	if x + 1 == m and y + 1 == n:
		break
	if x + 1 < m and mat[x+1][y] and [x+1,y] not in stack:
		stack.append([x+1,y,depth+1])
		flag += 1
	if y + 1 < n and mat[x][y+1] and [x,y+1] not in stack:
		stack.append([x,y+1,depth+1])
		flag += 1
	if x - 1 >= 0 and mat[x-1][y] and [x-1,y] not in stack:
		stack.append([x-1,y,depth+1])
		flag += 1
	if y - 1 >= 0 and mat[x][y-1] and [x,y-1] not in stack:
		stack.append([x,y-1,depth+1])
		flag += 1
	if not flag:
		cnt -= 1
print(maxd)