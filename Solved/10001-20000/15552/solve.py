import sys

for i in range(int(input())):
	A,B = map(int, sys.stdin.readline().rstrip().split(" "))
	print(A + B)