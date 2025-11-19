import unittest


def reverse_invert(lst):
    result = []
    for x in lst:
        if type(x) == int:
            if x < 0:
                reversed_num = int(str(abs(x))[::-1])
            else:
                reversed_num = -int(str(x)[::-1])

            result.append(reversed_num)

    return result


"""
    Yêu cầu:
        - Lọc bỏ tất cả các phần tử không phải số nguyên (integer) trong list.
        - Đảo ngược giá trị của các số nguyên còn lại (reverse từng chữ số và đổi dấu).
        - Trả về list mới với kết quả sau khi xử lý.
"""


class Solution(unittest.TestCase):

    def test_1(self):
        self.assertEqual([-1, -21, -78, 24, -5], reverse_invert([1, 12, 'a', 3.4, 87, 99.9, -42, 50, 5.6]))
        self.assertEqual([-1, -2, -3, -4, -5], reverse_invert([1, 2, 3, 4, 5]))


if __name__ == '__main__':
    unittest.main()
