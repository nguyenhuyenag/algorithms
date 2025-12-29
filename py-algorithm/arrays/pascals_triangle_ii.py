import unittest

from typing import List

"""
    https://leetcode.com/problems/pascals-triangle-ii/
    
    Cho số nguyên n, trả về dòng thứ n của tam giác Pascal (đếm từ 0)
    
    Ý tưởng:
        - Hàng đầu tiên luôn là:
                [1]
        - Mỗi hàng bắt đầu và kết thúc bằng 1
            [1, ..., 1]
        - Các phần tử ở giữa được tính bằng:
            row[j] = prevRow[j−1] + prevRow[j]
"""


class Solution(unittest.TestCase):

    # def generate(self, n: int) -> List[List[int]]:
    #     result = []
    #     # Tam giác có n dòng
    #     for i in range(n):
    #         # khởi tạo dòng toàn 1
    #         row = [1] * (i + 1)
    #         # Cập nhật các giá trị ở giữa (trừ 2 đầu mút)
    #         for j in range(1, i):
    #             previous_row = result[i - 1]
    #             row[j] = previous_row[j - 1] + previous_row[j]
    #
    #         result.append(row)  # append sau khi hoàn thiện row
    #
    #     return result

    def getRow_OK1(self, rowIndex: int) -> List[int]:
        pascal = []
        i = 0
        while len(pascal) <= rowIndex:
            row = [1] * (i + 1)
            for j in range(1, i):
                previous_row = pascal[i - 1]
                row[j] = previous_row[j - 1] + previous_row[j]

            pascal.append(row)
            i = i + 1

        return pascal[rowIndex]

    # In-place DP
    def getRow_OK2(self, rowIndex: int) -> List[int]:
        row = [1] * (rowIndex + 1)
        for i in range(2, rowIndex + 1):
            for j in range(i - 1, 0, -1):
                row[j] += row[j - 1]

        return row

    # Binomial coefficient
    def getRow(self, rowIndex: int) -> List[int]:
        row = [1]
        for k in range(1, rowIndex + 1):
            row.append(row[-1] * (rowIndex - k + 1) // k)

        return row

    # @unittest.skip
    def test_1(self):
        self.assertEqual([1], self.getRow(0))

    def test_2(self):
        self.assertEqual([1, 1], self.getRow(1))

    def test_3(self):
        self.assertEqual([1, 3, 3, 1], self.getRow(3))


if __name__ == '__main__':
    unittest.main()
