import unittest


def addStrings(num1: str, num2: str) -> str:
    result = []
    len1, len2 = len(num1), len(num2)
    len_max = max(len1, len2)

    rem = 0
    for i in range(len_max):
        n1 = int(num1[-1 - i]) if i < len1 else 0
        n2 = int(num2[-1 - i]) if i < len2 else 0
        _sum = n1 + n2 + rem
        rem, digit = divmod(_sum, 10)
        result.append(digit)

    if rem > 0:
        result.append(rem)

    result = ''.join(map(str, result[::-1]))

    return result.lstrip('0') or '0'


class MyTest(unittest.TestCase):

    def test_case(self):
        self.assertEqual("3", addStrings("1", "2"))
        self.assertEqual("579", addStrings("123", "456"))
        self.assertEqual("10367", addStrings("800", "9567"))
        self.assertEqual("8670", addStrings("00103", "08567"))
        self.assertEqual("0", addStrings("0", "0"))
