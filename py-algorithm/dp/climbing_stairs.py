import unittest

"""
    https://leetcode.com/problems/climbing-stairs/

	- Có n >= 1 bậc thang, mỗi lần có thể bước lên 1 hoặc 2 bậc.
 	  Hỏi có bao nhiêu cách để leo lên hết n bậc thang?

	Ý tưởng:
		n = 1: 	-> Chỉ có 1 cách: 1

		n = 2: 	-> Có 2 cách: Bước hai lần bậc 1
							  Bước một lần 2 bậc
				-> 2 cách

		n = 3:	-> Có 3 cách: Bước ba lần bậc 1
							  Bước một lần bậc 1, một lần bậc 2
							  Bước một lần bậc 2, một lần bậc 1
				-> 3 cách

		n: 		-> Có 2 cách là từ n - 1 lên, hoặc từ n - 2 lên (do có thể bước 1 hoặc 2 bậc)

				-> f(n) = f(n-1) + f(n-2)

	Công thức: f(1) = 1, f(2) = 2, f(n) = f(n-1) + f(n-2) với n > 2.
"""
class Solution(unittest.TestCase):

    def climbStairs_OK1(self, n: int) -> int:
        if n <= 2:
            return n

        f = n * [0]
        f[0], f[1] = 1, 2

        for i in range(2, n):
            f[i] = f[i - 1] + f[i - 2]

        return f[n - 1]

    def climbStairs(self, n: int) -> int:
        if n <= 2:
            return n

        a, b = 1, 2
        for _ in range(3, n + 1):
            a, b = b, a + b

        return b

    def test_something(self):
        test_cases = [
            (1, 1),
            (2, 2),
            (3, 3)
        ]
        for expected, n in test_cases:
            self.assertEqual(expected, self.climbStairs(n))


if __name__ == '__main__':
    unittest.main()
