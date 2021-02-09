alpha = [3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,10]
s,time = input(),0
for i in list(s): time += alpha[ord(i)-65]
print(time)