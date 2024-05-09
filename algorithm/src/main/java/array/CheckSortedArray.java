package array;

public class CheckSortedArray {

    public static boolean isSortedArray(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSorted(int[] array) {
        boolean ascending = true;   // Giả sử mảng là đang tăng dần
        boolean descending = true;  // Giả sử mảng là đang giảm dần

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                ascending = false; // mảng không tăng dần
            }
            if (array[i] < array[i + 1]) {
                descending = false; // mảng không giảm dần
            }
        }

        /**
         * Sau khi duyệt hết mảng
         *  Nếu ascending không đổi    -> tăng dần
         *  Nếu descending không đổi   -> giảm dần
         */
        return ascending || descending;
    }


    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 4};
        int[] arr2 = {5, 3, 0, 1, 0, -1};
        int[] arr3 = {3, 2, 1, -1};
        System.out.println("isSorted = " + isSorted(arr1));
        System.out.println("isSorted = " + isSorted(arr2));
        System.out.println("isSorted = " + isSorted(arr3));
    }

}
