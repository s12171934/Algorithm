from collections import deque

n = int(input())
list, stack, res = deque(), deque(), deque()
for _ in range(n):
    list.append(int(input()))
while list:
    stack.append(list.pop())
    res.append("-")
    while stack:
        temp = stack.pop()
        if temp == n:
            res.append("+")
            n -= 1
        else:
            stack.append(temp)
            break
if stack:
    print("NO")
else:
    while res:
        print(res.pop())
