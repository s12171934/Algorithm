n,sum,mod = 0,0,1
for c in input():
    if c != "+" and c != "-" :
        n = 10 * n + int(c)
    else:
        sum += n * mod
        if c == "-":
            mod = -1
        n = 0
print(sum + n * mod)