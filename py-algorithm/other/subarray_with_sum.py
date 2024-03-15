"""
    Tìm tất cả các mảng con có tổng bằng s
"""
def subarrays_with_sum(nums, s):
    result = []
    current_sum = 0
    sum_map = {}

    for index, num in enumerate(nums):
        current_sum += num

        if current_sum == s:
            result.append(nums[0:index + 1])

        if current_sum - s in sum_map:
            for start in sum_map[current_sum - s]:
                result.append(nums[start + 1:index + 1])

        if current_sum not in sum_map:
            sum_map[current_sum] = [index]
        else:
            sum_map[current_sum].append(index)

    return result


# Example usage:
nums = [0, 0, 0, 0, 0]
s = 0
with_sum = subarrays_with_sum(nums, s)
print(len(with_sum))
print(with_sum)
