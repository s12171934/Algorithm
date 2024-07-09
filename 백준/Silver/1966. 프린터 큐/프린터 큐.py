TC = int(input())
for _ in range(TC):
    n, m = map(int, input().split())
    list = [*map(int, input().split())]
    pointer,count = [0]*11, 0
    for p in reversed(range(list[m],10)):
        pointer[p] = pointer[p + 1]
        for i in range(n):
            if list[(pointer[p+1] + i) % n] == p:
                count += 1
                pointer[p] = (pointer[p+1] + i) % n
                if pointer[p] == m:
                    break
    print(count)