N, M = map(int, input().split(' '))
count = 1

while M > N:
    count += 1

    if M % 2 == 0:
        M = int(M / 2)
    elif M % 10 == 1:
        M = int(M / 10)
    else:
        M = 0
    
    if M < N: count = -1

print(count)
