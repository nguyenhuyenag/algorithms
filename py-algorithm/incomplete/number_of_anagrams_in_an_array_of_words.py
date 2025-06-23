import unittest

from collections import Counter

"""
    https://www.codewars.com/kata/587e18b97a25e865530000d8/
"""


def anagram_counter(words):
    sort_works = [''.join(sorted(word)) for word in words]
    count = Counter(sort_works)
    return sum(n * (n - 1) // 2 for n in count.values() if n > 1)


class Solution(unittest.TestCase):
    sample_test_cases = [
        ([], 0),
        (['dell', 'ledl', 'abc', 'cba'], 2),
        (['dell', 'ledl', 'lled', 'cba'], 3),
        (['dell', 'ledl', 'abc', 'cba', 'bca', 'bac', 'cab'], 11),
    ]

    def test_1(self):
        for words, expected in self.sample_test_cases:
            self.assertEqual(anagram_counter(words), expected)


if __name__ == '__main__':
    unittest.main()
