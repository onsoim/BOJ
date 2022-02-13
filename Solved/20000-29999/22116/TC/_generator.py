
import random

N = random.randrange(1, 1000)
print(N)

for i in range(N):
    print(' '.join(list(map(str, random.sample(range(1, 1000000000), N)))))
