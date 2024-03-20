def encrypt(n: int) -> int:
    numStr = str(n)
    max_digit = max(int(digit) for digit in numStr)
    return int(str(max_digit) * len(numStr))


print(encrypt(123))