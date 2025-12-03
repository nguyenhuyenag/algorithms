import unittest
from typing import Dict

"""
    https://www.codewars.com/kata/55f89832ac9a66518f000118/
    
    Rút gọn biểu thức: -a+5ab+3a-c-2a -> -c+5ab
"""
class Solution(unittest.TestCase):

    # -abc+3a+2ac -> ['-abc','3a','2ac']
    @staticmethod
    def poly_to_array(poly: str):
        result = []
        current_term = ""
        for char in poly:
            if char in "+-" and current_term:
                result.append(current_term)
                current_term = char
            else:
                current_term += char

        # Thêm phần tử cuối cùng vào kết quả
        if current_term:
            result.append(current_term)

        # Loại bỏ dấu "+" ở đầu các thành phần không mang ý nghĩa
        return [term.lstrip('+') for term in result]

    # ["-abc","3a","2ac"] -> {'abc':-1, 'a':3, 'ac':2}
    @staticmethod
    def poly_array_to_dict(poly_array):
        the_dict = {}
        for v in poly_array:
            # Extract coefficient and variable
            coeff_str = ''.join(['' if char.isalpha() else char for char in v])
            coeff = -1 if coeff_str == '-' else int(coeff_str) if coeff_str else 1
            var = ''.join(sorted(['' if not char.isalpha() else char for char in v]))

            # Update dictionary
            the_dict[var] = the_dict.get(var, 0) + coeff

        # Sort dictionary by key length
        return dict(sorted(the_dict.items(), key=lambda x: (len(x[0]), x[0])))

    @staticmethod
    def get_result(sorted_dict: Dict):
        result = []
        for var, coeff in sorted_dict.items():
            sign = "+" if coeff > 0 else "-"
            if coeff == 0:
                continue
            elif coeff in (-1, 1):
                coeff = sign
            else:
                coeff = sign + str(abs(coeff))

            result.append(coeff + var)

        return ''.join(result).lstrip('+')

    def simplify(self, poly) -> str:
        poly_array = self.poly_to_array(poly)
        the_dict = self.poly_array_to_dict(poly_array)
        return self.get_result(the_dict)

    def test(self):
        self.assertEqual("cd+abcd", self.simplify("dc+dcba"))
        self.assertEqual("xy", self.simplify("2xy-yx"))
        self.assertEqual("-c+5ab", self.simplify("-a+5ab+3a-c-2a"))
        self.assertEqual("3a+2ac-abc", self.simplify("-abc+3a+2ac"))
        self.assertEqual("x-y", self.simplify("-y+x"))
        self.assertEqual("-x+y", self.simplify("y-x"))
        self.assertEqual("3fk-kq+5kv-22qvy+fkqvy", self.simplify("3fk-kq+5kv-2qvy+fkqvy-20qvy"))


if __name__ == '__main__':
    unittest.main()
