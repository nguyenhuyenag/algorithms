package main

import test_util "go_algorithm/test_util"

// Hàm kiểm tra SNT
func isPrime(n int) bool {
	if n < 2 { return false }
	for i := 2; i*i <= n; i++ {
		if n % i == 0 { return false }
	}
	return true
}

func maximumPrimeDifference(nums []int) int {
	dmax := 0
	return dmax
}

func main() {
	test_util.AssertInt(3, maximumPrimeDifference([]int{4, 2, 9, 5, 3}))
}
