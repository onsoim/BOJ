for i in range(int(input())):
	score, add = list(map(int, input().split(" "))), 0
	del score[0]
	for j in range(len(score)): add += score[j]
	avg, count = add / len(score), 0
	for j in range(len(score)):
		if score[j] > avg: count += 1
	print("{:2.3f}%".format(count * 100 / len(score)))

'''
5
5 50 50 70 80 100
7 100 95 90 80 70 60 50
3 70 90 80
3 70 90 81
9 100 99 98 97 96 95 94 93 91
'''