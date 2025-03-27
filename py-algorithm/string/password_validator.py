import re
import unittest

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

    def password_1(self, pwd: str) -> bool:
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

    def password_2(self, s: str) -> bool:
        CRITERIA = (str.islower, str.isupper, str.isdigit)
        return len(s) > 7 and all(any(map(f, s)) for f in CRITERIA)

    def password_3(self, s: str):
        if not len(s) >= 8:
            return False
        if not any(char.islower() for char in s):
            return False
        if not any(char.isupper() for char in s):
            return False
        if not any(char.isdigit() for char in s):
            return False
        return True

    def password(self, s: str):
        patterns = (r'[A-Z]', r'[a-z]', r'[0-9]', r'.{8,}')
        return all([re.search(pattern, s) for pattern in patterns])

    def test(self):
        self.assertEqual(True, self.password("Abcd1234"))
        self.assertEqual(False, self.password("Abcd123"))
        self.assertEqual(True, self.password("AbcdefGhijKlmnopQRsTuvwxyZ1234567890"))
        self.assertEqual(False, self.password("ABCD1234"))
        self.assertEqual(True, self.password("Ab1!@#$%^&*()-_+={}[]|\:;?/>.<,"))
        self.assertEqual(False, self.password("!@#$%^&*()-_+={}[]|\:;?/>.<,"))


if __name__ == '__main__':
    unittest.main()
