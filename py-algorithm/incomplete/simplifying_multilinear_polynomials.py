import unittest

"""
    https://www.codewars.com/kata/55f89832ac9a66518f000118/
"""
class Solution(unittest.TestCase):

    def simplify(self, poly) -> str:
        pass

    def test(self):
        self.assertEqual("cd+abcd", self.simplify("dc+dcba"))
        self.assertEqual("xy", self.simplify("2xy-yx"))
        self.assertEqual("-c+5ab", self.simplify("-a+5ab+3a-c-2a"))
        self.assertEqual("3a+2ac-abc", self.simplify("-abc+3a+2ac"))


if __name__ == '__main__':
    unittest.main()
