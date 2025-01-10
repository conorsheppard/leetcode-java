package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindDisappearedNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return IntStream.range(1, nums.length + 1).filter(i -> !numsSet.contains(i)).boxed().toList();
    }

    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            result.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            result.remove(Integer.valueOf(nums[i]));
        }
        return result;
    }

    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> resultList = new ArrayList<>(IntStream.range(1, nums.length + 1).boxed().toList());
        Arrays.stream(nums).forEach(num -> resultList.remove(Integer.valueOf(num)));
        return resultList;
    }
}
