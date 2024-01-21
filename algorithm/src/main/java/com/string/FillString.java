package com.string;

public class FillString {

    // Using StringBuilder
    public static void fillPrefix(String s, int lenRequired) {
        int numZeros = Math.max(0, lenRequired - s.length());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numZeros; i++) {
            result.append('0');
        }
        result.append(s);
        System.out.println("result = " + result.toString());
    }

    // Using repeat()
    public static void fillSuffix(String s, int lenRequired) {
        int numZeros = Math.max(0, lenRequired - s.length());
        StringBuilder ans = new StringBuilder(s);
        ans.append("0".repeat(numZeros));
        System.out.println("result = " + ans.toString());
    }

    public static void main(String[] args) {
        String s = "123";
        int lenRequired = 6;
        fillPrefix(s, lenRequired);
        fillSuffix(s, lenRequired);
    }

}
