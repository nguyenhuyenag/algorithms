import unittest

from parameterized import parameterized

"""
    https://www.codewars.com/kata/58df8b4d010a9456140000c7
    
    Cho số nguyên n, hãy tìm số đối xứng (palindrome) gần n nhất, nếu có 2 giá trị thì chọn số lớn hơn.
    
    Trả về "Not valid" nếu đầu vào không phải số nguyên hoặc nhỏ hơn 0.
    
    Ở bài này, số đối xứng (palindrome) là số nguyên dương có ít nhất 2 chữ số
"""


def is_palindrome(num: int) -> bool:
    return num > 10 and str(num) == str(num)[::-1]


def palindrome(num):
    if not isinstance(num, int) or num < 0:
        return "Not valid"

    # Nếu số đã là đối xứng thì trả về chính nó
    if is_palindrome(num):
        return num

    left, right = num - 1, num + 1

    # Tìm số đối xứng bên trái và dừng nếu nó nhỏ hơn 10
    while left > 9 and not is_palindrome(left):
        left -= 1

    # Tìm số đối xứng bên phải
    while left != right and not is_palindrome(right):
        right += 1

    # Nếu không tìm thấy số đối xứng bên trái thì trả về số bên phải
    if left < 10:
        return right

    diff_left = num - left
    diff_right = right - num
    if diff_left < diff_right:
        return left
    elif diff_left > diff_right:
        return right

    return max(left, right)


class TestSolution(unittest.TestCase):

    @parameterized.expand([
        (8, 11),
        (281, 282),
        (1029, 1001),
        (1221, 1221),
        ("1221", "Not valid")
    ])
    def test_is_cleanly_nested(self, x, expected):
        self.assertEqual(palindrome(x), expected)


if __name__ == '__main__':
    unittest.main()
