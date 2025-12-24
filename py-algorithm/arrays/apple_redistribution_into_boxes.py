import unittest

from typing import List

"""
    https://leetcode.com/problems/apple-redistribution-into-boxes/

    Cho mảng apple, capacity có kích thước là n, m.
        - Có n túi, trong đó túi thứ i chứa apple[i] quả táo.
        - Có m hộp và hộp thứ i chứa capacity[i] quả táo
    Tìm số hộp ít nhất để chứa hết táo
    + Lưu ý. Táo từ cùng một túi có thể được chia vào các hộp khác nhau.

    -> Vì táo từ một túi có thể chia nhỏ, nên chỉ cần quan tâm đến TỔNG SỐ TÁO,
    không cần quan tâm từng túi riêng lẻ.

    -> Có totalApples = sum(apple) quả táo. Cần chọn ít nhất bao nhiêu hộp từ danh
    sách capacity để tổng sức chứa ≥ totalApples?

    Ví dụ:
        apple = [1, 3, 2]        → totalApples = 6
        capacity = [4, 3, 1, 5, 2]
    => Cần chọn các hộp có tổng sức chứa ≥ 6
"""


class Solution(unittest.TestCase):

    def minimumBoxes_OK(self, apple: List[int], capacity: List[int]) -> int:
        total_apples = sum(apple)
        capacity = sorted(capacity, reverse=True)

        boxes_used = 0
        current_capacity = 0
        for cap in capacity:
            current_capacity += cap
            boxes_used = boxes_used + 1
            if current_capacity >= total_apples:
                break

        return boxes_used

    def minimumBoxes(self, apple: List[int], capacity: List[int]) -> int:
        total_apples = sum(apple)
        capacity.sort()

        boxes_used = 0
        current_capacity = 0
        for cap in reversed(capacity):
            current_capacity += cap
            boxes_used = boxes_used + 1
            if current_capacity >= total_apples:
                break

        return boxes_used

    def test_1(self):
        self.assertEqual(2, self.minimumBoxes(apple=[1, 3, 2], capacity=[4, 3, 1, 5, 2]))

    def test_2(self):
        self.assertEqual(4, self.minimumBoxes(apple=[5, 5, 5], capacity=[2, 4, 2, 7]))


if __name__ == '__main__':
    unittest.main()
