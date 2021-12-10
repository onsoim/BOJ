N,graph = int(input()),{}

for i in range(N):
	line,tmp = input().split(" "),[]
	for j in range(N):
		if line[j] == "1":
			tmp.append(j+1)
	graph[i+1] = set(tmp)

for i in range(N):
	start,count = i + 1,0
	visited,queue = [],[start]
	while queue:
		vertex = queue.pop(0)
		if vertex not in visited:
			if len(queue) == 0 and vertex == start: pass
			else: visited.append(vertex)
			if count > N * N: break
			tmp = sorted(graph[vertex].difference(visited))
			for i in range(len(tmp)):
				if tmp[i] not in graph[start]:
					graph[start] = set(list(graph[start]) + [tmp[i]])
			queue += tmp
			count += 1

for i in range(N):
	tmp,out = list(graph[i+1]),[]
	for j in range(N):
		if j + 1 in tmp: out.append(1)
		else: out.append(0)
	print(" ".join(str(x) for x in out))
