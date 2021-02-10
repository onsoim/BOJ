while True:
	num = input().split(" ")
	if num[0] == "0" and num[1] == "0": break
	print(int(num[0]) + int(num[1]))