num,test,count = input(),100,0

if int(num) < 10:
	print(0)
	exit()

calc = num
while int(calc) != num:
	print(calc[0], calc[1])

	count += 1