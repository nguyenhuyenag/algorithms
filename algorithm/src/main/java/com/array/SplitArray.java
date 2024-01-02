package com.array;

import java.util.List;
import java.util.ArrayList;

public class SplitArray {

    /**
     * Chia 1 mảng thành n mảng con
     */
    public static <T> List<List<T>> splitList(List<T> list, int n) {
        List<List<T>> result = new ArrayList<>();
        int partitionSize 	= list.size() / n;	// Dự đoán kích thước 1 list con
        int remaining 		= list.size() % n;	// Phần dư
        int currentIndex = 0;
        for (int i = 0; i < n; i++) {
            int subListSize = partitionSize;	// Kích thước 1 list con thực tế
            if (remaining > 0) {
                remaining--;
                subListSize++;
            }
            // int subListSize = partitionSize + (remaining-- > 0 ? 1 : 0);
            result.add(list.subList(currentIndex, currentIndex + subListSize));
            currentIndex += subListSize;
        }
        return result;
    }

}
