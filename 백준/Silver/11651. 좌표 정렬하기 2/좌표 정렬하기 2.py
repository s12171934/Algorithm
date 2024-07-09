n = int(input())
dots = [[0, 0]] * n
for i in range(n) : dots[i] = [*map(int, input().split())]
dots.sort(lambda dot : (dot[1], dot[0]))
for dot in dots : print(*dot)