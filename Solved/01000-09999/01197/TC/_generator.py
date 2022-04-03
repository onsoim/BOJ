
import random

# V = random.randrange(2, 10000)
V = random.randrange(2, 5)
# E = random.randrange(V, 100000)
E = random.randrange(V, 15)
print(V, E)

for i in range(E):
    if i < V - 1:
        # print(1, random.randrange(2, V), random.randrange(-2147483648, 2147483647))
        print(1, i + 2, random.randrange(-10, 10))
    else:
        A = random.randrange(1, V + 1)
        B = random.randrange(1, V + 1)

        while (A == B): B = random.randrange(1, V + 1)
        # print(A, B, random.randrange(-2147483648, 2147483647))
        print(A, B, random.randrange(-100, 100))
