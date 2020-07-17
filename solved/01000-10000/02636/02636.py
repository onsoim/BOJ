def bfs(x,y):
	visited,queue,queue2 = [],[[x,y]],[]
	while queue:
		x,y = queue.pop(0)
		visited.append([x,y])
		if x + 1 < N:
			if array[x+1][y]:
				if [x+1,y] not in queue2: queue2.append([x+1,y])
				array[x+1][y] = 2
			elif [x+1,y] not in visited and [x+1,y] not in queue:
				queue.append([x+1,y])
		if x - 1 >= 0:
			if array[x-1][y]:
				if [x-1,y] not in queue2: queue2.append([x-1,y])
				array[x-1][y] = 2
			elif [x-1,y] not in visited and [x-1,y] not in queue:
				queue.append([x-1,y])
		if y + 1 < M:
			if array[x][y+1]:
				if [x,y+1] not in queue2: queue2.append([x,y+1])
				array[x][y+1] = 2
			elif [x,y+1] not in visited and [x,y+1] not in queue:
				queue.append([x,y+1])
		if y - 1 >= 0:
			if array[x][y-1]:
				if [x,y-1] not in queue2: queue2.append([x,y-1])
				array[x][y-1] = 2
			elif [x,y-1] not in visited and [x,y-1] not in queue:
				queue.append([x,y-1])
	for i in range(len(queue2)):
		array[queue2[i][0]][queue2[i][1]] = 0
	return len(queue2)

N,M = map(int,input().split(" "))
array = []
for i in range(N):
	array.append(list(map(int,input().split(" "))))
tmp = cnt = bfs(0,0)
th = 0
while cnt:
	cnt = bfs(0,0)
	th += 1
	if cnt: tmp = cnt
print("%d\n%d" %(th,tmp))
