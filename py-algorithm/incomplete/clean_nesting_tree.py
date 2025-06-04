import unittest
from parameterized import parameterized

"""
    https://www.codewars.com/kata/67c9c1cdf96c66388eb35cd4/
"""


# def is_cleanly_nested(arr):
#     stack = []
#     for x in str(arr):
#         if x == '[':
#             stack.append(x)
#         elif x == ']':
#             if not stack:
#                 return False
#
#             stack.pop()
#
#     return len(stack) == 0

def is_cleanly_nested(arr):
    if not isinstance(arr, list):
        return False

    for element in arr:
        if isinstance(element, list):
            if not is_cleanly_nested(element):  # Recursively check nested lists
                return False

    # Additional check for proper nesting structure if needed
    # (Add your specific rules here)
    return True

class TestSolution(unittest.TestCase):

    # @unittest.skip("Skipping this test temporarily")
    @parameterized.expand([
        ("case1", [[[[]], [[]], [[]]], [[]], [[]]], True),
        ("case2", [], True),
        ("case3", [[], []], True)
    ])
    def test_is_cleanly_nested(self, name, test_input, expected):
        self.assertEqual(is_cleanly_nested(test_input), expected)

    # @unittest.skip("Skipping this test temporarily")
    def test_002(self):
        test_cases = [
            ([[[[]], [[]], [[]]], [[]], [[]]], True),
            ([], True),
            ([[], []], True),
            ([[[], [], []], [[], [[]]]], False),
            ([[[[[]], [[]]], [[]]], [[]]], True),
            ([[[[[]], [[]], []], [[]]], [[]]], False),
            ([[[[[[], [], [], []], [[[[]], [[]], [[]]]]], [[], [], [], [], [], []]]], [[], [], [], []]], True),
            ([[[], [], [], [], []]], True),
            ([[[[], [], []], [[], [], []], [[], [], []], [[], [], [], [], [], []]]], True),
            (
                [[], [[], [[], [[], [], [], []], [[[], [], [], []], [], [], [[], [], [], [], [], []]], []], []], [], [],
                 [],
                 []], False),
            ([[], [[], [], []], []], False),
            ([[], [], [[], [[], [], [], []], [], []], [], [], []], False),
        ]

        for arr, expected in test_cases:
            self.assertEqual(is_cleanly_nested(arr), expected)


if __name__ == '__main__':
    unittest.main()

# arr = [[[[[]], [[]], []], [[]]], [[]]]
# for x in str(arr):
#     print(x)
# # print(str(arr))
