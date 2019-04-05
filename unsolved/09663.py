def marking(N,x,y):
	if not xx[x] and not yy[y] and not xy[x+y-1] and not yx[N-x+y-1]:
		xx[x] += 1
		yy[y] += 1
		xy[x+y] += 1
		yx[N+x-y-1] += 1
	print(xx,yy,xy,yx)

def count(x,y,cnt):
	print("xxxx")
#	if cnt == N:



N,cnt = int(input()),0
count()
# xx,yy = [0 for i in range(N)],[0 for i in range(N)]
# xy,yx = [0 for i in range(N*2-1)],[0 for i in range(N*2-1)]

#visited,stack = [],[[-1,0]]
#while stack:
#	x,y = map(int,stack.pop())
#	for i in range(N):
		
'''
for
for i in range(N):
	for j in range(N):
		if 0 in xx:

	while queue:
		marking(N,0,i)

visited = []
for i in range(N):
	for j in range(N):
		if not array[i][j]:
			marking(N,i,j)
			# visited.append([i,j])
			# print(visited)
'''
# marking(int(input()),int(input()),int(input()))