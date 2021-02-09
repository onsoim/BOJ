import sys

def DFS(graph, start):
	visited,stack = [],[start]
	while stack:
		vertex = stack.pop()
		if vertex not in visited:
			visited.append(vertex)
			stack += reversed(sorted(list(graph[vertex].difference(visited))))
	return visited

def BFS(graph, start):
	visited,queue = [],[start]
	while queue:
		vertex = queue.pop(0)
		if vertex not in visited:
			visited.append(vertex)
			queue += sorted(graph[vertex].difference(visited))
	return visited

N,M,V = map(int, sys.stdin.readline().rstrip().split(" "))
edges,dfs_graph,bfs_graph = [],{},{}

for _ in range(M):
	v1,v2 = map(int, sys.stdin.readline().rstrip().split(" "))
	edges.append([v1,v2])

for i in range(N):
	tmp = []
	for j in range(M):
		if edges[j][0] == i + 1:
			tmp.append(edges[j][1])
		if edges[j][1] == i + 1:
			tmp.append(edges[j][0])
	dfs_graph[i+1],bfs_graph[i+1] = set((tmp)),set((tmp))

print(" ".join(str(x) for x in DFS(dfs_graph,V)))
print(" ".join(str(x) for x in BFS(bfs_graph,V)))
