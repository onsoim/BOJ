def group(N,i,j):
	count,stack = 0,[[i,j]]
	while stack:
		x,y = map(int,stack.pop(0))
		array[x][y] = 0
		if array[x][y] != "0":
			count += 1
			try:
				if x > 0 and array[x-1][y] == "1":
					if [x-1,y] not in stack:
						stack.append([x-1,y])
			except: pass
			try:
				if y > 0 and array[x][y-1] == "1":
					if [x,y-1] not in stack: 
						stack.append([x,y-1])
			except: pass
			try:
				if x < N - 1 and array[x+1][y] == "1":
					if [x+1,y] not in stack: 
						stack.append([x+1,y])
			except: pass
			try:
				if y < N - 1 and array[x][y+1] == "1":
					if [x,y+1] not in stack: 
						stack.append([x,y+1])
			except: pass
	return count

N,array,total = int(input()),[],[]

for _ in range(N): array.append(list(input()))

for i in range(N):
	for j in range(N):
		if array[i][j] == "1": total.append(group(N,i,j))

total.sort()
print(len(total))
for i in range(len(total)):
	print(total[i])