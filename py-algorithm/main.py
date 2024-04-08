from typing import List


def test(arr: List[int]):
    arr.sort()


if __name__ == '__main__':
    nums1 = [1, 2, 3, 0, 0, 0]
    m = 3
    nums2 = [4, 5, 6]
    n = 3
    nums1[(m + n) - n:] = nums2
    print(nums1)
