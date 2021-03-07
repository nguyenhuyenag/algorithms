package com.datetime;

public class CenturyFromYear {

	public static int centuryFromYear(int year) {
		if (year % 100 == 0) {
			return year / 100;
		}
		return (year / 100) + 1;
	}

	public static void main(String[] args) {
		int test = centuryFromYear(2021);
		System.out.println(test);

	}

}
