num, score, add = int(input()), list(map(int,input().split(" "))), 0
score.sort(reverse=True)
for i in range(num): add += score[i]
print(add * 100 / score[0] / num)