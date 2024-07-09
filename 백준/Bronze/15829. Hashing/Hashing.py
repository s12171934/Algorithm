int(input())
n, i = 0, 0
for c in input():
    n += (ord(c) - 96) * (31 ** i); i += 1
print(n % 1234567891)