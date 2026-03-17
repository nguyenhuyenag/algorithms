package main

import "go_algorithm/test_util"

/*
	https://leetcode.com/problems/find-three-consecutive-integers-that-sum-to-a-given-number/

	Cho một số nguyên num, hãy trả về ba số nguyên liên tiếp (dưới dạng mảng đã sắp xếp) sao cho
	tổng của chúng bằng num.

	Nếu không thể biểu diễn num thành tổng của ba số nguyên liên tiếp, hãy trả về một mảng rỗng.

	Ý tưởng:

		Vì: n + (n + 1) + (n + 2) = num -> 3n + 3 = num -> n = num / 3 - 1

		=> Tức là num phải chia hết cho 3.
*/
func sumOfThree_TimeLimitExceeded(n int64) []int64 {
	for i := int64(0); i < n; i++ {
		if i + (i + 1) + (i + 2) == n {
			return []int64{i, i + 1, i + 2}
		}
	}
	return []int64{}
}

func sumOfThree(num int64) []int64 {
	if num % 3 != 0 {
		return []int64{}
	}
	n := (num - 3) / 3
	return []int64{n, n + 1, n + 2}
}

func main() {
	test_util.AssertSlice([]int64{}, sumOfThree(4))
	test_util.AssertSlice([]int64{10, 11, 12}, sumOfThree(33))
	test_util.AssertSlice([]int64{}, sumOfThree(455172614))
}
