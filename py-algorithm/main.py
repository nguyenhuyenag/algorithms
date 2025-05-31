lst1 = [
    {'firstName': 'Noah', 'lastName': 'M.', 'country': 'Switzerland', 'continent': 'Europe', 'age': 19,
     'language': 'JavaScript'},
    {'firstName': 'Maia', 'lastName': 'S.', 'country': 'Tahiti', 'continent': 'Oceania', 'age': 28,
     'language': 'JavaScript'},
    {'firstName': 'Shufen', 'lastName': 'L.', 'country': 'Taiwan', 'continent': 'Asia', 'age': 35, 'language': 'HTML'},
    {'firstName': 'Sumayah', 'lastName': 'M.', 'country': 'Tajikistan', 'continent': 'Asia', 'age': 30,
     'language': 'CSS'}
]


def count_developers(lst):
    # count = 0
    # for x in lst:
    #     if x['language'] == 'JavaScript' and x['continent'] == 'Europe':
    #         count += 1
    #
    # return count
    return sum(1 for x in lst if x['language'] == 'JavaScript' and x['continent'] == 'Europe')
