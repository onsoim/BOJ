def marking(N,x,y):
	if not xx[x] and not yy[y] and not xy[x+y-1] and not yx[N-x+y-1]:
		xx[x] += 1
		yy[y] += 1
		xy[x+y] += 1
		yx[N+x-y-1] += 1
	print(xx,yy,xy,yx)

N,cnt = int(input()),0

xx,yy = [0 for i in range(N)],[0 for i in range(N)]
xy,yx = [0 for i in range(N*2-1)],[0 for i in range(N*2-1)]
'''
visited = []
for i in range(N):
	for j in range(N):
		if not array[i][j]:
			marking(N,i,j)
			# visited.append([i,j])
			# print(visited)
'''
marking(int(input()),int(input()),int(input()))