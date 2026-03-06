package testutil

import "fmt"

const (
	Red   = "\033[31m"
	Green = "\033[32m"
	Reset = "\033[0m"
)

func AssertEquals[T comparable](name string, expected, actual T) {
	if expected == actual {
		fmt.Printf(Green+"PASS: %s"+Reset+"\n", name)
	} else {
		fmt.Printf(Red+"FAIL: %-10s | expected: %-5v | got: %-5v"+Reset+"\n",
			name, expected, actual)
	}
}
