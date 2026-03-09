package main

import "go_algorithm/test_util"

/*
https://leetcode.com/problems/valid-anagram/

Anagrams là hai chuỗi s1, s2 có cùng những ký tự (bằng nhau sau khi sắp xếp).
*/
func isAnagram_OK(s1 string, s2 string) bool {
	mark := [26]int{}
	// Mark s1
	for _, c := range s1 {
		mark[c-'a']++
	}
	// Mark s2
	for _, c := range s2 {
		mark[c-'a']--
		// Return sớm
		if mark[c-'a'] < 0 {
			return false
		}
	}
	// Check
	for _, v := range mark {
		if v != 0 {
			return false
		}
	}

	return true
}

func isAnagram(s1, s2 string) bool {
	if len(s1) != len(s2) {
		return false
	}

	var count [26]int
	for i := range s1 {
		count[s1[i]-'a']++
		count[s2[i]-'a']--
	}

	for _, v := range count {
		if v != 0 {
			return false
		}
	}

	return true
}

func main() {
	test_util.AssertBool(true, isAnagram("anagram", "nagaram"))
	test_util.AssertBool(false, isAnagram("rat", "car"))
}
