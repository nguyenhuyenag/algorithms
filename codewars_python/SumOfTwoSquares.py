# https://www.codewars.com/kata/52217066578afbcc260002d0/train/python
# 0     -->  [ [0, 0] ]
# 1     -->  [ [0, 1] ]
# 2     -->  [ [1, 1] ]
# 3     -->  []
# 4     -->  [ [0, 2] ]
# 5     -->  [ [1, 2] ]
# 25    -->  [ [0, 5], [3, 4] ]
# 325   -->  [ [1, 18], [6, 17], [10, 15] ]

import numpy as np
import unittest

def decompose(n):
    result = decompose_helper(n * n, n)
    return np.array(result[:-1]) if result else np.array([])


def decompose_helper(remain, n):
    if remain == 0:
        return [0]

    for i in range(n, 0, -1):
        if (remain - i ** 2) >= 0:
            temp_result = decompose_helper(remain - i ** 2, i)

            if temp_result is not None:
                return temp_result + [i]

    return None


class TestDecompose(unittest.TestCase):
    def assertArrayEqual(self, arr1, arr2):
        np.testing.assert_array_equal(np.array(arr1), np.array(arr2))

    def test_cases(self):
        self.assertArrayEqual(decompose(0), [[0, 0]])
        self.assertArrayEqual(decompose(1), [[0, 1]])
        self.assertArrayEqual(decompose(2), [[1, 1]])
        self.assertArrayEqual(decompose(3), [])
        self.assertArrayEqual(decompose(4), [[0, 2]])
        self.assertArrayEqual(decompose(5), [[1, 2]])
        self.assertArrayEqual(decompose(25), [[0, 5], [3, 4]])
        self.assertArrayEqual(decompose(325), [[1, 18], [6, 17], [10, 15]])


if __name__ == '__main__':
    unittest.main()
