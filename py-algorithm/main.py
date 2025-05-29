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


def generator_1(_from, _to, _step):
    if _step <= 0:
        return []

    result = []
    current = _from

    if _from <= _to:
        while current <= _to:
            result.append(current)
            current += _step
    else:
        while current >= _to:
            result.append(current)
            current -= _step

    return result


def generator(_from, _to, _step):
    if _step == 0:
        return []

    if _from <= _to:
        return list(range(_from, _to + 1, _step))
    else:
        return list(range(_from, _to - 1, -_step))


# r = make_sentences(['hello', 'world'])
# r = make_sentences(['hello', ',', 'world'])
# r = make_sentences(['hello', ',', 'world', '.', '.', '.'])

# r = magic_sum([3, 12, 5, 8, 30, 13])

# r = generator(10, 20, 10)
# r = generator(10, 20, 1)
r = generator(10, 20, 5)

# print(r)
console = r