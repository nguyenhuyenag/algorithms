package main

import "go_algorithm/test_util"

/*
	https://leetcode.com/problems/binary-prefix-divisible-by-5/

	Cho mảng nums nhị phân. Giả sử x[i] = nums[0..i] -> Chuyển sang dạng thập phân.
	Trả về mảng boolean xem x[i] có chia hết cho 5 hay không.

	Ý tưởng là tính giá trị thập phân của từng x[i]:

		x₀ = nums[0]
		x₁ = nums[0..1] = nums[0] * 2 + nums[1]
		x₂ = nums[0..2] = ((nums[0] * 2 + nums[1]) * 2 + nums[2])

	Tuy nhiên cách này sẽ bị tràn số.

	-> Vì bài toán yêu cầu xem x[i] có chia hết cho 5 hay không, cho nên ta chỉ cần lưu
	phần dư của x[i] khi chia cho 5.
*/
func prefixesDivBy5_Error(nums []int) []bool {
	res := make([]bool, len(nums))
	x_new := 0
	for i, v := range nums{
		x_new = x_new* 2 + v
		res[i] = x_new% 5 == 0
	}
	return res
}

func prefixesDivBy5(nums []int) []bool {
	xNew := 0
	res := make([]bool, len(nums))
	for i := range nums {
		crurrent := xNew * 2 + nums[i] // Tính (phần dư) giá trị hiện tại
		xNew = crurrent % 5
		res[i] = xNew == 0
	}
	return res
}

/*
	(10101)_2 = (((1)*2 + 0)*2 + 1)*2 + 0)*2 + 1
			  = 1⋅2^4 + 0⋅2^3 + 1⋅2^2 + 0⋅2^1 + 1⋅2^0
*/
func main() {
	test_util.AssertSlice([]bool{true, false, false}, prefixesDivBy5([]int{0, 1, 1}))
	test_util.AssertSlice([]bool{false, false, false}, prefixesDivBy5([]int{1, 1, 1}))
}
