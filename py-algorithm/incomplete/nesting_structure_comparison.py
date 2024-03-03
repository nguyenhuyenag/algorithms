import unittest
from typing import List

"""
    https://www.codewars.com/kata/520446778469526ec0000001/
    
    Kiểm tra 2 list có cùng cấu trúc hay không?
"""


class Solution(unittest.TestCase):

    def same_structure_as(self, list1, list2):
        if type(list1) != type(list2):
            return False

        if len(list1) != len(list2):
            return False

        for v1, v2 in zip(list1, list2):
            if type(v1) != type(v2):
                return False

            if type(v1) is list and type(v2) is list:
                if len(v1) != len(v2):
                    return False

                return self.same_structure_as(v1, v2)

        return True

    def test(self):
        # Return True
        # self.assertEqual(True, self.same_structure_as([1, 1, 1], [2, 2, 2]))
        # self.assertEqual(True, self.same_structure_as([1, [1, 1]], [2, [2, 2]]))

        # Return False
        # self.assertEqual(False, self.same_structure_as([1, [1, 1]], [[2, 2], 2]))
        # self.assertEqual(False, self.same_structure_as([1, [1, 1]], [[2], 2]))
        # self.assertEqual(False, self.same_structure_as([1, [1, 1]], [2, [2]]))
        # self.assertEqual(False, self.same_structure_as([[[], []]], [[1, 1]]))

        self.assertEqual(False, self.same_structure_as([1, '[', ']'], ['[', ']', 1]))
        # self.assertEqual(False, self.same_structure_as([-13, 11], [5, []]))


if __name__ == '__main__':
    unittest.main()
