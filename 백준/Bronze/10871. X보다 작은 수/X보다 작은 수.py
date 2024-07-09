n, m = map(int, input().split())
list1 = [*map(int, input().split())]
for i in range(n) :
    if list1[i] < m : print(list1[i], end = " ")