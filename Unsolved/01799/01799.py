'''
5
1 1 0 1 1
0 1 0 0 0
1 0 1 0 1
1 0 0 0 0
1 0 1 1 1
'''
import copy

def start(size,a,b):
	visited,stack = [],[[a,b]]
	tmp = copy.deepcopy(array)
	xy,yx = [],[]
	for i in range(size*2-1):
		xy.append(0)
		yx.append(0)
	print(tmp,xy,yx)
	while stack:
		x,y = map(int,stack.pop())

	return 0

size = int(input())
array,big = [],0
for _ in range(size):
	array.append(list(map(int,input().split(" "))))

print((array))

for i in range(size*size):
	if array[i//size][i%size]:
		tmp = start(size,i//size,i%size)
		if big < tmp: big = tmp

print(big)