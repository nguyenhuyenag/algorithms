# from decimal import Decimal, getcontext
# getcontext().prec = 1_00
#
#
# def cycle(n: int) -> int:
#     s = str(Decimal(1) / Decimal(69))
#     # print(result)
#     index = s.index('.')
#     j = 1
#     if index != -1:
#         for i in range(index + 1, len(s)):
#             x = s[index + 1:i + 1]
#             y = s[i + 1:i + 1 + j]
#             j += 1
#             if x == y:
#                 # print(f"{i} -> {x} = {y}")
#                 return j - 1
#
#         return -1
#
#
# if __name__ == '__main__':
#     v = cycle(69)
#     print(v)
#
# # from decimal import Decimal, getcontext
# # getcontext().prec = 1_00  # Số 15 ở đây là số lượng chữ số thập phân bạn muốn
# # result = Decimal(1) / Decimal(69)
# # print(result)
