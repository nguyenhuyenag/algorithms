package main

import (
	"go_algorithm/testutil"
	"testing"
)

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

func TestNumSpecial(t *testing.T) {
	result := numSpecial([][]int{
		{1, 0, 0},
		{0, 0, 1},
		{1, 0, 0},
	})

	testutil.AssertEquals(t, 1, result)
}
