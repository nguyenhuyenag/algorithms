package main

import (
	"go_algorithm/test_util"
)

/*
	https://leetcode.com/problems/search-a-2d-matrix/

	Cho một ma trận số nguyên kích thước m × n, có hai tính chất sau:

	  - Mỗi hàng được sắp xếp theo thứ tự không giảm (non-decreasing).
	  - Phần tử đầu tiên của mỗi hàng lớn hơn phần tử cuối cùng của hàng trước đó.

	Cho một số nguyên target. Hãy trả về true nếu target tồn tại trong ma trận, ngược
	lại	trả về false.

	Ý tưởng: Nếu làm phẳng ma trận thì sẽ được một mảng tăng dần -> binarySearch.
*/
func searchMatrix(matrix [][]int, target int) bool {
	m := len(matrix)
	n := len(matrix[0])
	for i := 0; i < m; i++ {
		l, r := 0, n - 1
		for l <= r {
			mid := l + (r - l) / 2
			if matrix[i][mid] == target {
				return true
			} else if matrix[i][mid] < target {
				l = mid + 1
			} else {
				r = mid - 1
			}
		}
	}
	return false
}

func main() {
	matrix := [][]int {
		{1, 3, 5, 7},
		{10, 11, 16, 20},
		{23, 30, 34, 60},
	}
	test_util.AssertBool(true, searchMatrix(matrix, 11))
	test_util.AssertBool(false, searchMatrix(matrix, 100))
}
