package com.string;

public class FillString {

    public static void fillPrefix(String s, int lenRequired) {
        int numZeros = Math.max(0, lenRequired - s.length());
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < numZeros; i++) {
            ans.append('0');
        }
        ans.append(s);
        System.out.println("ans = " + ans.toString());
    }

    public static void fillSuffix(String s, int lenRequired) {
        int numZeros = Math.max(0, lenRequired - s.length());
        StringBuilder ans = new StringBuilder(s);
        ans.append("0".repeat(numZeros));
        System.out.println("ans = " + ans.toString());
    }

    public static void main(String[] args) {
        String s = "123";
        int lenRequired = 6;
        fillPrefix(s, lenRequired);
        fillSuffix(s, lenRequired);
    }

}
