import unittest

from typing import List

"""
    https://leetcode.com/problems/pascals-triangle/
    
    Cho số nguyên n, trả về n dòng của tam giác Pascal.
    Trong tam giác Pascal, mỗi số bằng tổng của hai số nằm trực tiếp phía trên nó.
    
    Ý tưởng:
        - Hàng đầu tiên luôn là:
                [1]
        - Mỗi hàng bắt đầu và kết thúc bằng 1
            [1, ..., 1]
        - Các phần tử ở giữa được tính bằng:
            row[j] = prevRow[j−1] + prevRow[j]
"""


class Solution(unittest.TestCase):

    def generate(self, n: int) -> List[List[int]]:
        result = []
        # Tam giác có n dòng
        for i in range(n):
            # khởi tạo dòng toàn 1
            row = [1] * (i + 1)
            # Cập nhật các giá trị ở giữa (trừ 2 đầu mút)
            for j in range(1, i):
                previous_row = result[i - 1]
                row[j] = previous_row[j - 1] + previous_row[j]

            result.append(row)  # append sau khi hoàn thiện row

        return result

    @unittest.skip
    def test_1(self):
        self.assertEqual([[1]], self.generate(1))

    def test_2(self):
        self.assertEqual([[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]], self.generate(5))


if __name__ == '__main__':
    unittest.main()
