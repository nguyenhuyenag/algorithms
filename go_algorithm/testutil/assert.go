package testutil

import "fmt"

const (
	Red   = "\033[31m"
	Green = "\033[32m"
	Reset = "\033[0m"
)

func AssertEquals[T comparable](name string, expected, actual T) {
	if expected == actual {
		fmt.Printf(Green+"✔ PASS: "+Reset+" %-10s\n", name)
	} else {
		fmt.Printf(Red+"❌ FAIL: "+Reset+" %-10s (expected=%v, got=%v)\n",
			name, expected, actual)
	}
}
