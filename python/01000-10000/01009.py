left = [
	[10],
	[1],
	[2,4,8,6],
	[3,9,7,1],
	[4,6],
	[5],
	[6],
	[7,9,3,1],
	[8,4,2,6],
	[9,1]
]

for i in range(int(input())):
	data = input().split(" ")
	# print(int(data[0]) ** int(data[1]) % 10)
	# print(int(math.pow(int(data[0]),int(data[1]))) % 10)
	a, b = int(data[0]) % 10, int(data[1]) - 1
	print(left[a][b % len(left[a])])

# 10 10 => 10