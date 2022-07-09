package com.cqsd.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    @Test
    void bubblingSort() {
        int[] nums = new int[]{ 3, 1, 7, 53, 2};
        Sort.bubblingSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    void searchBinary() {
        int nums[]=new int[]{1, 3, 7, 2, 53};
        int i = Sort.searchBinary(nums, 7);
        System.out.println(i);
    }
}