import unittest


def generate_hashtag_OK_2(s):
    hashtag = "#"
    for word in s.split():
        hashtag += word.capitalize()
    return False if (len(s) == 0 or len(hashtag) > 140) else hashtag


def generate_hashtag(s):
    s = s.title()
    s = s.replace(" ", "")
    return False if (len(s) == 0 or len(s) > 140) else '#' + s


class MyTest(unittest.TestCase):

    def test_isPP_with_perfect_power(self):
        self.assertEqual("#HelloThereThanksForTryingMyKata", generate_hashtag(" Hello there thanks for trying my Kata"))


if __name__ == '__main__':
    unittest.main()
