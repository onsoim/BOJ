for i in range(int(input())):
	price = int(input())
	for j in range(int(input())):
		option = input().split(" ")
		price += int(option[0]) * int(option[1])
	print(price)