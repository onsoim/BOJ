import copy

def virus():
	global big
	safe, tmp_virus = 0, copy.deepcopy(tmp_build)
	for i in range(N):
		for j in range(M):
			if tmp_virus[i][j] == 2:
				cnt,check,queue = 0,[0,2],[[i,j]]
				while queue:
					x,y = queue.pop(0)
					tmp_virus[x][y] = 3
					if x + 1 < N and tmp_virus[x+1][y] in check and [x+1,y] not in queue:
						queue.append([x+1,y])
					if x - 1 >= 0 and tmp_virus[x-1][y] in check and [x-1,y] not in queue:
						queue.append([x-1,y])
					if y + 1 < M and tmp_virus[x][y+1] in check and [x,y+1] not in queue:
						queue.append([x,y+1])
					if y - 1 >= 0 and tmp_virus[x][y-1] in check and [x,y-1] not in queue:
						queue.append([x,y-1])
	for i in range(N):
		for j in range(M):
			if tmp_virus[i][j] == 0: safe += 1
	if safe > big: big = safe

def build_wall(x=0,y=0,cnt=0):
	if cnt == 3:
		virus()
		return
	if y == M:
		build_wall(x+1,0,cnt)
		return
	if x == N: return
	if tmp_build[x][y]:
		build_wall(x,y+1,cnt)
		return
	tmp_build[x][y] = 1
	build_wall(x,y+1,cnt+1)
	tmp_build[x][y] = 0
	build_wall(x,y+1,cnt)

N, M = map(int,input().split(" "))
array,big = [],0
for _ in range(N): array.append(list(map(int,input().split(" "))))

tmp_build = copy.deepcopy(array)
build_wall()
print(big)
