import unittest

"""
    https://leetcode.com/problems/process-string-with-special-operations-i/
    
    Bạn được cho một chuỗi s gồm các chữ cái tiếng Anh viết thường và các ký tự đặc biệt: *, #, %.

    Hãy xây dựng một chuỗi mới result bằng cách xử lý s từ trái sang phải theo các quy tắc sau:

        - Nếu ký tự là một chữ cái viết thường, thêm nó vào cuối result.
        - Ký tự ‘*’ sẽ xóa ký tự cuối cùng của result, nếu tồn tại.
        - Ký tự ‘#’ sẽ nhân đôi result hiện tại và nối nó vào chính nó (tức là result ← result + result).
        - Ký tự ‘%’ sẽ đảo ngược chuỗi result.

    Hãy trả về chuỗi result cuối cùng sau khi xử lý toàn bộ các ký tự trong s.
"""


class Solution(unittest.TestCase):

    def processStr(self, s: str) -> str:
        result = []
        for c in s:
            if c == '*':
                if result:
                    result.pop()
            elif c == '#':
                result.extend(result)  # Nhân đôi kết quả
            elif c == '%':
                result.reverse()
            else:
                result.append(c)

        return ''.join(result)

    def test_1(self):
        self.assertEqual("ba", self.processStr("a#b%*"))

    def test_2(self):
        self.assertEqual("", self.processStr("z*#"))


if __name__ == '__main__':
    unittest.main()
