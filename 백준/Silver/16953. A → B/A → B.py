a,b= map(int, input().split())
c = 1
while True :
    if a == b:
        print(c)
        break
    if (b % 2 == 1 and b % 10 != 1) or a > b:
        print(-1)
        break
    if b % 2 == 1:
        b = b // 10
    else:
        b /= 2
    c += 1