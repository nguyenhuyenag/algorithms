package util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ATM {

	public static void atm(Map<Integer, Integer> coins, int n) {
		int i, menhgia, soto;
		Map<Integer, Integer> map = new LinkedHashMap<>();
		Set<Entry<Integer, Integer>> set = coins.entrySet();
		for (Entry<Integer, Integer> loaiTien : set) {
			soto = loaiTien.getValue();
			if (soto > 0) {
				menhgia = loaiTien.getKey();
				for (i = soto; i > 0; i--) {
					if (n >= i * menhgia) {
						map.put(menhgia, i); // đổi được i tờ menhgia
						loaiTien.setValue(menhgia - i);
						n -= i * menhgia; // còn dư
						break;
					}
				}
			}
		}
		if (n == 0) {
			map.forEach((k, v) -> System.out.println(v + " tờ " + k));
		} else {
			System.out.println("ATM không đủ tiền, còn thiếu " + n);
		}
	}

	public static LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

	public static void main(String[] args) {
		int n = 500;
		map.put(200, 1);
		map.put(100, 5);
		map.put(50, 15);
		atm(map, n);
	}

}
