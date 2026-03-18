package main

import "go_algorithm/test_util"

/*
	- https://leetcode.com/problems/climbing-stairs/

	- Có n >= 1 bậc thang, mỗi lần có thể bước lên 1 hoặc 2 bậc.
 	  Hỏi có bao nhiêu cách để leo lên hết n bậc thang?

	Ý tưởng:
		n = 1: 	-> Chỉ có 1 cách: 1

		n = 2: 	-> Có 2 cách: Bước hai lần bậc 1
							 Bước một lần 2 bậc
				-> 2 cách

		n = 3:	-> Có 3 cách: Bước ba lần bậc 1
							 Bước một lần bậc 1, một lần bậc 2
							 Bước một lần bậc 2, một lần bậc 1
				-> 3 cách

		n: 		-> Có 2 cách là từ n - 1 lên, hoặc từ n - 2 lên (do có thể bước 1 hoặc 2 bậc)

				-> f(n) = f(n-1) + f(n-2)

	Công thức: f(1) = 1, f(2) = 2, f(n) = f(n-1) + f(n-2) với n > 2.
 */
func climbStairs_TLE(n int) int {
	if n <= 2 {
		return n
	}
	return climbStairs_TLE(n-1) + climbStairs_TLE(n-2)
}

func climbStairs_OK1(n int) int {
	if n <= 2 {
		return n
	}

	f := make([]int, n)
	f[0], f[1] = 1, 2
	for i := 2; i < n; i++ {
		f[i] = f[i-1] + f[i-2]
	}
	return f[n-1] // Do mảng bắt đầu từ 0
}

func climbStairs(n int) int {
	if n <= 2 {
		return n
	}
	a, b := 1, 2
	for i := 3; i <= n; i++ {
		a, b = b, a+b
	}
	return b
}

func main() {
	test_util.AssertInt(1, climbStairs(1))
	test_util.AssertInt(2, climbStairs(2))
	test_util.AssertInt(3, climbStairs(3))
}
