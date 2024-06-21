import math
n = int(input())
size = map(int, input().split(" "))
t, p = map(int, input().split(" "))
print(sum(map(lambda i : math.ceil(i / t), size)))
print(*[math.floor(n/p), n%p])