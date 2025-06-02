import unittest

from math import gcd
from fractions import Fraction
from typing import List
from queue import PriorityQueue
from collections import Counter
import itertools

from sympy import sequence

"""
    https://chat.deepseek.com/a/chat/s/2254a695-60db-4e60-a408-7dea80f08fca
    
    Tóm tắt quy tắc:
    
        - Tìm nguyên âm đầu tiên:
        
            + Nếu nguyên âm đầu tiên ở vị trí 0, thêm "way".
            + Nếu không có, thêm "ay".
            + Nếu có phụ âm trước nguyên âm đầu tiên, di chuyển chúng về cuối + "ay".
        
        - Xử lý chữ hoa, dấu câu, số:
        
            + Giữ nguyên kiểu chữ, dấu câu, và bỏ qua số.
"""


def pig_latin(word):
    vowels = {'a', 'e', 'i', 'o', 'u'}
    lower_word = word.lower()

    # Case 1: Word starts with vowel
    if lower_word[0] in vowels:
        return word + 'way'

    # Case 2: Word has no vowels
    if not any(char in vowels for char in lower_word):
        return word + 'ay'

    # Case 3: Word starts with consonant(s)
    for i, char in enumerate(lower_word):
        if char in vowels:
            # Handle capitalization
            if word[0].isupper():
                return word[i].upper() + word[i + 1:] + word[:i].lower() + 'ay'
            return word[i:] + word[:i] + 'ay'


def translate(sentence):
    words = sentence.split()
    return ' '.join(pig_latin(word) for word in words)


class Solution(unittest.TestCase):

    def test_examples(self):
        cases = [
            ['hello world', 'ellohay orldway'],
            ['Hello World', 'Ellohay Orldway'],
            ['Pizza? Yes Please!!', 'Izzapay? Esyay Easeplay!!'],
            ['How are you?', 'Owhay areway ouyay?'],
        ]

        for sentence, expected in cases:
            self.assertEqual(translate(sentence), expected)


if __name__ == '__main__':
    unittest.main()
