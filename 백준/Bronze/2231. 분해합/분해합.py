n, res = int(input()), 0
for i in reversed(range(min(n, 9 * len(str(n))))):
    if sum(map(int, [*str(n - i)])) == i:
        res = n - i
        break
print(res)
