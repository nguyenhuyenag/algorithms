import re

"""
    Nếu x = ',' thì cộng trực tiếp
    Nếu x != ',' thì cộng x + ' '
"""


def make_sentences_2(parts):
    result = " ".join(parts).strip() + '.'
    result = result.replace(" ,", ",")
    result = result.replace(" .", ".")
    return re.sub(r'\.+$', '.', result)


def make_sentences(parts):
    return ' '.join(parts).replace(' ,', ',').strip(' .') + '.'


def magic_sum(arr):
    result = 0
    for x in arr:
        # print(x, divmod(x, 2))
        if divmod(x, 2)[1] != 0 and '3' in str(x):
            result += x

    return result


def generator(_from, _to, _step):
    result = []
    if _step <= 0:
        return result

    current = _from
    while current <= _to:
        result.append(current)
        if current >= _to:
            break
        current += _step

    return result


# r = make_sentences(['hello', 'world'])
# r = make_sentences(['hello', ',', 'world'])
# r = make_sentences(['hello', ',', 'world', '.', '.', '.'])

# r = magic_sum([3, 12, 5, 8, 30, 13])

# r = generator(10, 20, 10)
# r = generator(10, 20, 1)
r = generator(10, 20, 5)

print(r)
