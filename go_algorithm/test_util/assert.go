package test_util

import (
	"fmt"
	"slices"
)

const (
	Red   = "\033[31m"
	Green = "\033[32m"
	Reset = "\033[0m"
)

const width = 10

func AssertBool(expected, actual bool) {
	if expected == actual {
		fmt.Printf(Green + "✔ PASS: " + Reset + " %-*v\n", width, actual)
	} else {
		fmt.Printf(Red + "❌ FAIL:" + Reset + " %-*v expected=%v, got=%v\n",
			width, actual, expected, actual)
	}
}

func AssertInt(expected, actual int) {
	if expected == actual {
		fmt.Printf(Green + "✔ PASS: " + Reset + " %-*d\n", width, actual)
	} else {
		fmt.Printf(Red + "❌ FAIL:" + Reset + " %-*d (expected=%d, got=%d)\n",
			width, actual, expected, actual)
	}
}

func AssertSlice[T comparable](expected, actual []T) {
	if slices.Equal(expected, actual) {
		fmt.Printf(Green + "✔ PASS: " + Reset + " %v\n", actual)
	} else {
		fmt.Printf(Red + "❌ FAIL: " + Reset + " got=%v, expected=%v\n", actual, expected)
	}
}
