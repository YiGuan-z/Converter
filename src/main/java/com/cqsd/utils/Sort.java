package com.cqsd.utils;

public class Sort {
    public static void bubblingSort(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (!flag) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    } else {
                        flag = true;
                    }
                }
            }
        }
    }

    public static int searchBinary(int[] arr, int target) {
        int max = arr.length - 1;
        int low = 0;
        int mid;
        while (max > low) {
            mid = (max + low) >> 1;

            if (target < arr[mid]) {
                max = mid - 1;
            } else if (target > arr[mid]) {
                low = mid + 1;
            } else if (target == arr[mid]) {
                return mid;
            }

        }
        return -1;
    }
}
