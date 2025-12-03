import unittest


# Đếm số bit cần có để chuyển đổi từ a sang b
def convert_bits(a, b):
    count = 0
    bit_a = bin(a)[2:]
    bit_b = bin(b)[2:]

    # Pad the shorter strings with leading zeros
    max_len = max(len(bit_a), len(bit_b))
    bit_a = bit_a.zfill(max_len)
    bit_b = bit_b.zfill(max_len)

    for x in range(max_len):
        if bit_a[x] != bit_b[x]:
            count += 1

    return count


"""
    https://www.codewars.com/kata/538948d4daea7dc4d200023f/
"""


class Solution(unittest.TestCase):

    def test_something(self):
        self.assertEqual(2, convert_bits(31, 14))
        self.assertEqual(3, convert_bits(7, 17))
        self.assertEqual(5, convert_bits(31, 0))


if __name__ == '__main__':
    unittest.main()
