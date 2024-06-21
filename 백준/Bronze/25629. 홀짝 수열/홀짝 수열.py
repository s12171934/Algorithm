n = int(input())
print(1 if n - sum(map(lambda i : int(i) % 2, input().split(" "))) == n // 2 else 0)