k, n = map(int, input().split())
LIST = [0] * k
for i in range(k):
    LIST[i] = int(input())
s, e = 1, max(LIST)
while s <= e :
    m = (s + e) // 2
    res = sum(map(lambda i: i // m, LIST))
    if res >= n :
        s = m + 1
    elif res < n :
        e = m - 1
print(e)
