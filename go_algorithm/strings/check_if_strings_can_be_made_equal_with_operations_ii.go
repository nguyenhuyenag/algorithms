package main

import (
	"go_algorithm/test_util"
)

/*
	https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-ii/

	Cho 2 chuỗi s1 và s2. Ta có thể hoán đổi ký tự tại 2 vị trí i, j bất kỳ nếu i < j và
	(j - i) chẵn.

	Trả về true nếu có thể làm cho s1 == s2, ngược lại trả về false.

	Ý tưởng:

		- Vì chỉ được swap khi j - i chẵn, tức (i,j) cùng chẵn hoặc lẽ (cùng parity).
		- Vì:
			Ta có thể swap tự do trong cùng parity.
			→ Thứ tự không quan trọng
			→ Chỉ cần số lượng giống nhau (multiset).
*/
func checkStrings_1(s1 string, s2 string) bool {
	// Nếu khác độ dài thì -> false
	if len(s1) != len(s2) {
		return false
	}
	even := make([]int, 26)
	odd := make([]int, 26)

	for i := range s1 {
		if i%2 == 0 {
			even[s1[i]-'a']++
			even[s2[i]-'a']--
		} else {
			odd[s1[i]-'a']++
			odd[s2[i]-'a']--
		}
	}

	for i := 0; i < 26; i++ {
		if even[i] != 0 || odd[i] != 0 {
			return false
		}
	}

	return true
}

// Dùng mảng 2 chiều
func checkStrings(s1 string, s2 string) bool {
	if len(s1) != len(s2) {
		return false
	}

	cnt := [2][26]int{}

	for i := 0; i < len(s1); i++ {
		cnt[i%2][s1[i]-'a']++
		cnt[i%2][s2[i]-'a']--
	}

	for i := 0; i < 2; i++ {
		for j := 0; j < 26; j++ {
			if cnt[i][j] != 0 {
				return false
			}
		}
	}

	return true
}

func main() {
	test_util.AssertBool(false, checkStrings("abe", "bea"))
	test_util.AssertBool(true, checkStrings("abcdba", "cabdab"))
	test_util.AssertBool(false, checkStrings("axa", "bxb"))
}
