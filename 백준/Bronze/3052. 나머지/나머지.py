mod = [0] * 42
for i in range(10) : mod[int(input()) % 42] = 1
print(sum(mod))