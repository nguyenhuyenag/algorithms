"""
    https://www.codewars.com/kata/51e0007c1f9378fa810002a9/
    Viết một hàm thực hiện các thao tác sau:
        i - increments the value (initially 0)
        d - decrements the value
        s - squares the value
        o - outputs the value into the return array
"""
import unittest


def parse_OK(data):
    v = 0
    result = []
    for c in data:
        if c == 'i':
            v += 1
        elif c == 'd':
            v -= 1
        elif c == 's':
            v = v ** 2
        elif c == 'o':
            result.append(v)

    return result


def parse(data):
    v, result = 0, []

    operations = {
        'i': lambda x: x + 1,
        'd': lambda x: x - 1,
        's': lambda x: x ** 2,
        'o': lambda x: result.append(x)
    }

    for c in data:
        operations[c](v)

    return result

class MyTest(unittest.TestCase):

    def my_test(self):
        self.assertEquals([8, 64], parse("iiisdoso"))
        self.assertEquals([0, 0, 0], parse("ooo"))

if __name__ == '__main__':
    unittest.main()