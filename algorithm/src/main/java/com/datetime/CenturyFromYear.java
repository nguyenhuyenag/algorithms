package com.datetime;

public class CenturyFromYear {

	static int centuryFromYear(int year) {
		if (year % 100 == 0) {
			year = year / 100;
		} else {
			year = (year / 100) + 1;
		}
		return year;
	}

	public static void main(String[] args) {
		int test = centuryFromYear(2021);
		System.out.println(test);

	}

}
