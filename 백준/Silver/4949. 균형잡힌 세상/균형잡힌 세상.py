from collections import deque

while True:
    str = input()
    if str == "." : break
    stack = deque()
    for c in str:
        if c == "(" or c == "[":
            stack.append(c)
        elif c == "]":
            if stack:
                if stack.pop() == "[":
                    continue
                else:
                    break
            else:
                break
        elif c == ")":
            if stack:
                if stack.pop() == "(":
                    continue
                else:
                    break
            else:
                break
    print("yes" if c == "." and not stack else "no")
