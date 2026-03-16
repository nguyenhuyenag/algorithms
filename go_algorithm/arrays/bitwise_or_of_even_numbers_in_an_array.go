package main

import "go_algorithm/test_util"

/*
	https://leetcode.com/problems/bitwise-or-of-even-numbers-in-an-array/

	Cho mảng số nguyên nums. Hãy trả về kết quả phép OR theo từng bit của
	tất cả các số chẵn trong mảng.

	Nếu nums không có số chẵn nào thì trả về 0.
*/
func evenNumberBitwiseORs(nums []int) int {
	res := 0
	for _, v := range nums {
		if v % 2 == 0 {
			res |= v
		}
	}
	return res
}

func main() {
	test_util.AssertInt(0, evenNumberBitwiseORs([]int{7, 9, 11}))
	test_util.AssertInt(6, evenNumberBitwiseORs([]int{1, 2, 3, 4, 5, 6}))
}
