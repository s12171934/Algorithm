a, b, c = input(), input(), input()
if a == "Fizz":
    if b == "Buzz":
        print("Fizz")
    else:
        print("FizzBuzz" if (int(b) + 2) % 5 == 0 else "Fizz")
elif a == "Buzz":
    if b == "Fizz":
        print(int(c) + 1)
    else:
        print(int(b) + 2)
elif a == "FizzBuzz":
    print("Fizz")
else:
    print("Buzz" if (int(a) + 3) % 5 == 0 else int(a) + 3)
