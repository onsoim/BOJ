import sys

print(sys.argv)

# print("n is %d" % (int(sys.argv[1])))
# print("m is %d" % (int(sys.argv[2])))

def recul(index, n):
	print(index),
	if(index != n):
		index+=1
		recul(index,n)

for i in range(int(sys.argv[2])):
	for j in range(int(sys.argv[1])):
		print(j + 1)
