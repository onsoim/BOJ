
sum = 0
for i in range(10):
    mushroom = int(input())
    if sum + mushroom < 100 or sum + (mushroom + 1) // 2 - 1 < 100:
        sum += mushroom
    else: break

    if sum == 100: break

print(sum)
