package main

import "go_algorithm/test_util"

/*
	https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/

	- Cho số nguyên n. Liên tục thay chuỗi bằng dãy tổng 2 chữ số kề nhau (mod 10) cho đến
	khi còn 2 chữ số, rồi kiểm tra xem chúng có bằng nhau không.

	Ví dụ:
		Giả sử s = "1234"

		Bước 1:
			(1 + 2) % 10 = 3
			(2 + 3) % 10 = 5
			(3 + 4) % 10 = 7
			→ s = "357"

		Bước 2:
			(3 + 5) % 10 = 8
			(5 + 7) % 10 = 2
			→ s = "82"

		Chuỗi còn 2 chữ số là 8 và 2, không bằng nhau → trả về false.
*/
func hasSameDigits(s string) bool {
	size := len(s)

	// Array digits
	digits := make([]int, size)
	for i := 0; i < size; i++ {
		digits[i] = int(s[i] - '0')
	}

	// Loop until size > 2
	for size > 2 {
		next := make([]int, size-1)
		for i := 0; i < size-1; i++ {
			next[i] = (digits[i] + digits[i+1]) % 10
		}
		digits = next
		size--
	}
	return digits[0] == digits[1]
}

func main() {
	test_util.AssertBool(true, hasSameDigits("3902"))
	test_util.AssertBool(false, hasSameDigits("34789"))
	test_util.AssertBool(false, hasSameDigits("1234"))
}
