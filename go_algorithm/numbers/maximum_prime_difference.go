package main

import (
	"go_algorithm/test_util"
	"math"
)

/*
	https://leetcode.com/problems/maximum-prime-difference/

	Cho mảng số nguyên nums. Giả sử x, y là thứ tự của 2 số nguyên tố trong mảng.
	Tìm giá trị lớn nhất của |x - y|.

	Ví dụ: nums = [4, 2, 9, 5, 3] -> Kết quả là 3.

	- Vì A_1=2, A_3=5, A_4=3 là các SNT. Nên kết quả là |4 - 1| = 3 là giá trị lớn
	nhất cần tìm.
*/

// Hàm kiểm tra SNT
func isPrime(n int) bool {
	if n < 2 {
		return false
	}
	for i := 2; i*i <= n; i++ {
		if n%i == 0 {
			return false
		}
	}
	return true
}

func maximumPrimeDifference_OK1(nums []int) int {
	// Đánh dấu các SNT trong mảng
	n := len(nums)
	mark := make([]bool, n)
	for i, v := range nums {
		if isPrime(v) {
			mark[i] = true
		}
	}
	i1, i2 := 0, 0
	for i := range mark {
		if mark[i] {
			i1 = i
		}
		if mark[(n-1)-i] {
			i2 = (n - 1) - i
		}
	}
	return int(math.Abs(float64(i1 - i2)))
}

func maximumPrimeDifference_OK2(nums []int) int {
	// Tìm 2 SNT đầu tiên và cuối cùng
	first, last := -1, -1
	for i, v := range nums {
		if isPrime(v) {
			// Nếu v là SNT và first = -1 -> gán first = i
			if first == -1 {
				first = i
			}
			// Nếu first đã có vị trí thì sẽ gán cho last = i.
			// Gán đến cuối cùng thì last sẽ là vị trí lớn nhất.
			last = i
		}
	}
	return last - first
}

func maximumPrimeDifference(nums []int) int {
	l, r := 0, len(nums) - 1
	// Tìm SNT đầu tiên từ trái sang phải
	for l <= r {
		leftCheck := isPrime(nums[l])
		rightCheck := isPrime(nums[r])
		// Cả 2 vị trí là SNT -> Dừng và trả về kết quả
		if leftCheck && rightCheck {
			return r - l
		} else 				// Nếu có một trong hai không phải là SNT
			if !leftCheck {	// Nếu left không phải là SNT -> Tăng l
				l++
			} else { 		// Ngược lại, nếu right không phải là SNT -> Giảm r
				r--
			}
	}
	return 0
}

func main() {
	test_util.AssertInt(0, maximumPrimeDifference([]int{4, 8, 2, 8}))
	test_util.AssertInt(3, maximumPrimeDifference([]int{4, 2, 9, 5, 3}))
}
