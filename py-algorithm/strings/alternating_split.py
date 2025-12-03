import unittest

"""
    https://www.codewars.com/kata/57814d79a56c88e3e0000786/
    
    Mã hóa: Cho chuỗi s, di chuyển các ký tự có index chẵn về cuối, index lẽ lên đầu. Thực hiện n lần.
    
    Viết hàm encrypt và decrypt
"""
class Solution(unittest.TestCase):

    def encrypt_helper(self, s):
        result = []

        for i in range(1, len(s), 2):
            result.append(s[i])

        for i in range(0, len(s), 2):
            result.append(s[i])

        return ''.join(result)

    def decrypt_helper(self, s):
        result = []
        half = len(s) // 2

        for i in range(half):
            result.append(s[i + half])
            result.append(s[i])

        if len(s) % 2 != 0:
            result.append(s[-1])

        return ''.join(result)

    def encrypt(self, text, n):
        if n == 0: return text
        for _ in range(n):
            text = self.encrypt_helper(text)
        return text

    def decrypt(self, text, n):
        if n == 0: return text
        for _ in range(n):
            text = self.decrypt_helper(text)
        return text

    def test_encrypt(self):
        self.assertEqual("This is a test!", self.encrypt("This is a test!", 0))
        self.assertEqual("hsi  etTi sats!", self.encrypt("This is a test!", 1))
        self.assertEqual("s eT ashi tist!", self.encrypt("This is a test!", 2))
        self.assertEqual(" Tah itse sits!", self.encrypt("This is a test!", 3))
        self.assertEqual("This is a test!", self.encrypt("This is a test!", 4))
        self.assertEqual("This is a test!", self.encrypt("This is a test!", -1))
        self.assertEqual("hskt svr neetn!Ti aai eyitrsig", self.encrypt("This kata is very interesting!", 1))

    def test_decrypt(self):
        self.assertEqual("This is a test!", self.decrypt("This is a test!", 0))
        self.assertEqual("This is a test!", self.decrypt("hsi  etTi sats!", 1))
        self.assertEqual("This is a test!", self.decrypt("s eT ashi tist!", 2))
        self.assertEqual("This is a test!", self.decrypt(" Tah itse sits!", 3))
        self.assertEqual("This is a test!", self.decrypt("This is a test!", 4))
        self.assertEqual("This is a test!", self.decrypt("This is a test!", -1))
        self.assertEqual("This kata is very interesting!", self.decrypt("hskt svr neetn!Ti aai eyitrsig", 1))


if __name__ == '__main__':
    unittest.main()
