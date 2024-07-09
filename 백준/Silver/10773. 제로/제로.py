from collections import deque

k = int(input())
stack = deque()
for _ in range(k):
    num = int(input())
    if num == 0:
        stack.pop()
    else:
        stack.append(num)
print(sum(stack))
