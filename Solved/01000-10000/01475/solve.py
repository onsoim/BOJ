num = [0,0,0,0,0,0,0,0,0,0]
door,index = input(),0

for i in range(len(door)): num[int(door[i])] += 1
mix = num[6] + num[9]
num[6],num[9] = int(mix/2),int(mix/2)
if int((mix+1)/2) != int(mix/2): num[6] += 1
for i in range(10):
	if num[i] > num[index]: index = i
print(num[index])