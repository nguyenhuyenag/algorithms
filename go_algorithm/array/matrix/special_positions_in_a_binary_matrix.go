package main

import (
	"go_algorithm/test_util"
)

/*
	https://leetcode.com/problems/special-positions-in-a-binary-matrix/

	Cho ma trận M: m x n. Một vị trí (i,j) là đặc biệt nếu:
	  - M[i][j] = 1.
	  - Các vị trị khác theo hàng và cột đều là 0.

	Đếm sô điểm đặc biệt trong M.
*/
func numSpecial(mat [][]int) int {
	count := 0
	m := len(mat)
	n := len(mat[0])

	rowSum := make([]int, m)
	colSum := make([]int, n)

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			rowSum[i] += mat[i][j]
			colSum[j] += mat[i][j]
		}
	}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1 {
				count++
			}
		}
	}

	return count
}

func main() {
	result := numSpecial([][]int{
		{1, 0, 0},
		{0, 0, 1},
		{1, 0, 0},
	})
	test_util.AssertInt(1, result)
	test_util.AssertInt(20000, result)
}
