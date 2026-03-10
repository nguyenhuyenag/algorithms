package main

import "go_algorithm/test_util"

/*
	https://leetcode.com/problems/rearrange-array-elements-by-sign/

	- Cho mảng số nguyên (số lượng số âm và dương bằng nhau). Sắp xếp lại mảng
	theo thứ tự dương-âm xen kẻ vẫn đảm bảo thứ tự tương đối của các số dương
	và âm không thay đổi.

	Ví dụ: [3,1,-2,-5,2,-4] = [3,1,2], [-2,-5,-4] -> [3,-2,1,-5,2,-4]
*/
func rearrangeArray_OK(nums []int) []int {
	// var pos []int
	// var neg []int

	n := len(nums)

	pos := make([]int, 0, n/2)
	neg := make([]int, 0, n/2)

	for _, v := range nums {
		if v > 0 {
			pos = append(pos, v)
		} else {
			neg = append(neg, v)
		}
	}

	p := 0
	for i := 0; i < len(nums); i += 2 {
		nums[i] = pos[p]
		nums[i+1] = neg[p]
		p++
	}

	return nums
}

func rearrangeArray(nums []int) []int {
	res := make([]int, len(nums))
	i, j := 0, 1 // Index của phần tử dương và âm
	for _, v := range nums {
		if v > 0 {
			res[i] = v
			i += 2
		} else {
			res[j] = v
			j += 2
		}
	}
	return res
}

func main() {
	test_util.AssertList([]int{3, -2, 1, -5, 2, -4}, rearrangeArray([]int{3, 1, -2, -5, 2, -4}))
	test_util.AssertList([]int{1, -1}, rearrangeArray([]int{-1, 1}))
}
