import unittest

"""
    https://leetcode.com/problems/smallest-integer-divisible-by-k/
    Cho một số nguyên dương k. Hãy tìm độ dài của số nguyên dương nhỏ nhất n sao cho:
        - n chia hết cho k,
        - n chỉ gồm toàn chữ số 1.
    Hãy trả về độ dài của n. Nếu không tồn tại số n như vậy, trả về -1.
    Lưu ý: Số n có thể quá lớn và không thể lưu trong kiểu số nguyên 64-bit.

    Xem thêm: BinaryPrefixDivisibleBy5.java

    Ý tưởng: Ta sẽ tìm số có dạng: 1, 11, 111,... tuy nhiên số này sẽ tăng rất nhanh, cho nên
    không thể dùng cách thông thường.

    Ta sẽ xây dựng số từng bước, tuy nhiên không phải lưu phần dư của số khi chia cho k.

    Gọi xi là số dư của số gồm i chữ số '1' khi chia cho k. Ta có công thức

        x[i] = (x[i-1] * 10 + '1') mod k

    Giá trị ban đầu là x[1] = 1 mod k.

    Nếu ở bước nào đó mà x[i] = 0 thì ta tìm được số cần tìm.

    Khi nào trả về -1?

    Một số khi chia cho k thì sẽ số sẽ là: 0, 1, 2, ..., k−1. Do đó nếu thực hiện k lần mà không
    xuất hiện số 0 thì dừng.
    
    Xem thêm: binary_prefix_divisible_by_5.py
"""


class Solution(unittest.TestCase):

    def smallestRepunitDivByK(self, k: int) -> int:
        remainder = 0
        for length in range(1, k + 1):
            remainder = (remainder * 10 + 1) % k
            if remainder == 0:
                return length
        return -1

    def smallestRepunitDivByK_While(self, k: int) -> int:
        length = 0
        remainder = 0

        while length < k:
            remainder = (remainder * 10 + 1) % k
            length += 1
            if remainder == 0:
                return length

        return -1

    def test_1(self):
        self.assertEqual(1, self.smallestRepunitDivByK(1))
        self.assertEqual(-1, self.smallestRepunitDivByK(2))


if __name__ == '__main__':
    unittest.main()
