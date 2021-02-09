import random

count = random.randint(0,100)
print(f"1\n{count}")
for i in range(count):
    print(random.choice(['U', 'D', 'F', 'B', 'R', 'L']) + random.choice(['+', '-']), end=" ")
print()