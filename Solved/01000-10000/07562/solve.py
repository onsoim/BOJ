def count(n,start,end):
	visited,queue = [[0 for rows in range(n)] for cols in range(n)],[[start[0],start[1]]]
	xi,yi = [-1,-1,-2,-2,1,1,2,2],[-2,2,-1,1,-2,2,-1,1]
	end_x,end_y = map(int,end)
	while queue:
		x,y = map(int, queue.pop(0))
		visited[x][y] += 1
		if x == end_x and y == end_y: break
		for i in range(8):
			tx,ty = x + xi[i],y + yi[i]
			if tx < 0 or tx >= n or ty < 0 or ty >= n or visited[tx][ty]: continue
			queue.append([tx,ty])
			visited[tx][ty] = visited[x][y]
	return visited[end_x][end_y] - 1

for _ in range(int(input())):
	n = int(input())
	start = input().split(" ")
	end = input().split(" ")
	print(count(n,start,end))