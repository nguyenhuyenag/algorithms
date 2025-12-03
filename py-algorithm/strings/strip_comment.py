import unittest

"""
    https://www.codewars.com/kata/51c8e37cee245da6b40000bd/train/python/
    
    Xóa commnet trong chuỗi:
    
        apples, pears # and bananas         apples, pears
        grapes                        ->    grapes
        bananas !apples                     bananas
"""
class Solution(unittest.TestCase):

    @staticmethod
    def strip_comments(text, markers):
        ss = text.split('\n')
        for i, s in enumerate(ss):
            for marker in markers:
                index = s.find(marker)
                if index != -1:
                    s = s[:index].rstrip()
            ss[i] = s

        return '\n'.join(ss)

    def test(self):
        self.assertEqual("apples, pears\ngrapes\nbananas",
                         self.strip_comments("apples, pears # and bananas\ngrapes\nbananas !apples", ["#", "!"]))
        self.assertEqual('a\nc\nd', self.strip_comments('a #b\nc\nd $e f g', ['#', '$']))
        self.assertEqual(' a\nc\nd', self.strip_comments(' a #b\nc\nd $e f g', ['#', '$']))


if __name__ == '__main__':
    unittest.main()
