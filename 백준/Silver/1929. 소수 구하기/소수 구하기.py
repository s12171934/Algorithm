n, m = map(int, input().split())
list = [0] * (m + 1)
for i in range(2,m + 1) :
    if list[i] == 1 :
        continue
    if i >= n:
        print(i)
    pointer = 1
    while pointer * i <= m:
        list[pointer * i] = 1
        pointer += 1