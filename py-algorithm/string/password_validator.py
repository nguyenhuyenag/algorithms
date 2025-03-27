import unittest

from math import gcd
from fractions import Fraction
from tkinter.constants import DISABLED
from typing import List
from queue import PriorityQueue
from collections import Counter
import itertools

"""
    https://www.codewars.com/kata/56a921fa8c5167d8e7000053/
    
    The rules for a valid password are as follows:
        - There needs to be at least 1 uppercase letter.
        - There needs to be at least 1 lowercase letter.
        - There needs to be at least 1 number.
        - The password needs to be at least 8 characters long.
    You are permitted to use any methods to validate the password.
"""


class Solution(unittest.TestCase):

    def password(self, pwd: str) -> bool:
        if len(pwd) < 8:
            return False

        has_number = False
        has_lowercase = False
        has_uppercase = False

        for c in pwd:
            if c.islower():
                has_lowercase = True
            elif c.isupper():
                has_uppercase = True
            elif c.isdigit():
                has_number = True

            # Early exit if all conditions are met
            if has_number and has_lowercase and has_uppercase:
                break

        return has_number and has_lowercase and has_uppercase

    def test(self):
        self.assertEqual(True, self.password("Abcd1234"))
        self.assertEqual(False, self.password("Abcd123"))
        self.assertEqual(True, self.password("AbcdefGhijKlmnopQRsTuvwxyZ1234567890"))
        self.assertEqual(False, self.password("ABCD1234"))
        self.assertEqual(True, self.password("Ab1!@#$%^&*()-_+={}[]|\:;?/>.<,"))
        self.assertEqual(False, self.password("!@#$%^&*()-_+={}[]|\:;?/>.<,"))


if __name__ == '__main__':
    unittest.main()
