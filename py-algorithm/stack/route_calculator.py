import re
import unittest

"""
    https://www.codewars.com/kata/581bc0629ad9ff9873000316/train/python
    
    You will be passed a strings of any length containing numbers and operators:
        '+' = add
        '-' = subtract
        '*' = multiply
        '$' = divide
        
    calculate('1+1')     => '2'
    calculate('10$2')    => '5'
    calculate('1.5*3')   => '4.5'
    
    calculate('5+5+5+5') => '20'
    calculate('1000$2.5$5+5-5+6$6') =>'81'
    
    calculate('10-9p')   =>  '400: Bad request'
"""


def validate_expression(expr):
    """Kiểm tra xem biểu thức chỉ chứa các ký tự hợp lệ"""
    allowed_chars = ".0123456789+-*$"
    allowed_set = set(allowed_chars)
    return all(c in allowed_set for c in expr)


def infix_to_rpn(expr):
    """Chuyển biểu thức từ dạng trung tố sang RPN"""
    # Tách token (số và toán tử)
    tokens = re.findall(r'(\d+\.?\d*|\.\d+|\+|\-|\*|\$)', expr)

    precedence = {'+': 1, '-': 1, '*': 2, '$': 2}
    output = []
    operator_stack = []

    for token in tokens:
        if token.replace('.', '').isdigit():  # Nếu là số
            output.append(token)
        else:  # Nếu là toán tử
            while (operator_stack and
                   precedence[operator_stack[-1]] >= precedence[token]):
                output.append(operator_stack.pop())
            operator_stack.append(token)

    # Đẩy các toán tử còn lại vào output
    while operator_stack:
        output.append(operator_stack.pop())

    return output


def evaluate_rpn(rpn_tokens):
    """Tính toán giá trị của biểu thức RPN"""
    stack = []
    for token in rpn_tokens:
        if token.replace('.', '').isdigit():  # Nếu là số
            stack.append(float(token))
        else:  # Nếu là toán tử
            if len(stack) < 2:
                return None  # Lỗi: không đủ toán hạng
            b = stack.pop()
            a = stack.pop()
            if token == '+':
                stack.append(a + b)
            elif token == '-':
                stack.append(a - b)
            elif token == '*':
                stack.append(a * b)
            elif token == '$':
                if b == 0:
                    return None  # Lỗi: chia cho 0
                stack.append(a / b)

    if len(stack) != 1:
        return None  # Lỗi: biểu thức không hợp lệ

    result = stack[0]
    # Trả về int nếu là số nguyên, ngược lại trả về float
    return float(result)


def calculate(expr):
    """Hàm chính để tính toán biểu thức"""
    if not validate_expression(expr):
        return '400: Bad request'

    try:
        rpn_tokens = infix_to_rpn(expr)
        result = evaluate_rpn(rpn_tokens)
        if result is None:
            return '400: Bad request'
        return result
    except:
        return '400: Bad request'


class Solution(unittest.TestCase):

    def test_case(self):
        cases = (
            ("1.1", 1.1),  # returns the number if no commands given
            ("10+5", 15),  # addition
            ("8-2", 6),  # subtraction
            ("4*3", 12),  # muliplication
            ("18$2", 9),  # division
            ("5+8-8*2$4", 9),  # multiple commands
            ("3x+1", "400: Bad request")  # handles incorrect input
        )

        for x, y in cases:
            self.assertEqual(y, calculate(x))


if __name__ == '__main__':
    unittest.main()
