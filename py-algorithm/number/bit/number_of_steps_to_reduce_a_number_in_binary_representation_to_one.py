import unittest

"""
    https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/

    Cho một số dưới dạng nhị phân. Tìm số bước cần thiết để giảm số đó về 1 (thập phân) theo
    các quy tắc sau:

        - Nếu số hiện tại là số chẵn, bạn phải chia nó cho 2.

        - Nếu số hiện tại là số lẻ, bạn phải cộng thêm 1 vào nó.

    Đảm bảo rằng với mọi trường hợp kiểm thử, bạn luôn có thể đưa số đó về 1.

    ** Quy tắc cộng 1 vào binary:

        Đi từ phải sang trái:
            - Gặp 1 → đổi thành 0, tiếp tục carry (nhớ 1).
            - Gặp 0 → đổi thành 1, dừng.
            - Nếu hết mà vẫn carry → thêm 1 vào đầu.
"""


class Solution(unittest.TestCase):

    def numSteps(self, s: str) -> int:
        count = 0
        s = list(s)

        while len(s) > 1:
            if s[-1] == '0':
                s.pop() # Chia 2 tức bỏ bit cuối
            else:
                i = len(s) - 1
                while i >= 0 and s[i] == '1':
                    s[i] = '0'
                    i -= 1

                if i >= 0:
                    s[i] = '1'
                else:
                    s.insert(0, '1')

            count += 1

        return count

    def test_1(self):
        self.assertEqual(6, self.numSteps("1101"))

    def test_2(self):
        self.assertEqual(1, self.numSteps("10"))


if __name__ == '__main__':
    unittest.main()
