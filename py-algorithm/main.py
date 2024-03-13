# def is_anagram(s1: str, s2: str):
#     if len(s1) != len(s2): return False
#     mark = [0] * 26
#     for i in range(len(s1)):
#         mark[ord(s1[i]) - ord('a')] += 1
#         mark[ord(s2[i]) - ord('a')] -= 1
#
#     return all(val == 0 for val in mark)
#
# if __name__ == '__main__':
#     s1 = 'abc'
#     s2 = 'bca'
#     print(is_anagram(s1, s2))
