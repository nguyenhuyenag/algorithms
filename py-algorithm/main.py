# def maximumOddBinaryNumber(s: str) -> str:
#     chars = sorted(s, key=lambda x: int(x), reverse=True)
#     chars[0], chars[-1] = chars[-1], chars[0]
#     return ''.join(chars)
#
# # Example usage
# result = maximumOddBinaryNumber("1010")
# print(result)

l = [1, 2, 3, 4]
l[0], l[-1] = l[-1], l[0]
print(l)
