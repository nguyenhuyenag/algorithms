import unittest
from typing import List

"""
    https://leetcode.com/problems/strong-password-checker-ii/
    
     A password is said to be strong if it satisfies all the following criteria:
 
        0. It has at least 8 characters.
        1. It contains at least one lowercase letter.
        2. It contains at least one uppercase letter.
        3. It contains at least one digit.
        4. It contains at least one special character. The special characters are the
           characters in the following string: "!@#$%^&*()-+".
        5. It does not contain 2 of the same character in adjacent positions (i.e., "aab"
           violates this condition, but "aba" does not).
 
  Given a string password, return true if it is a strong password. Otherwise, return false
"""
class Solution(unittest.TestCase):

    def strongPasswordCheckerII(self, password: str) -> bool:
        if len(password) < 8:
            return False

        if not any(c.islower() for c in password):
            return False

        if not any(c.isupper() for c in password):
            return False

        if not any(c.isdigit() for c in password):
            return False

        if not any((c in "!@#$%^&*()-+") for c in password):
            return False

        for i in range(len(password) - 1):
            if password[i] == password[i + 1]:
                return False

        return True

    def test(self):
        self.assertEqual(True, self.strongPasswordCheckerII("IloveLe3tcode!"))
        self.assertEqual(False, self.strongPasswordCheckerII("Me+You--IsMyDream"))
        self.assertEqual(False, self.strongPasswordCheckerII("123456"))


if __name__ == '__main__':
    unittest.main()
