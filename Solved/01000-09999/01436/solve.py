
N = int(input())

cnt, num = 0, 666

while True:
    if "666" in str(num):
        cnt += 1
        if cnt == N:
            print(num)
            break
    num += 1
