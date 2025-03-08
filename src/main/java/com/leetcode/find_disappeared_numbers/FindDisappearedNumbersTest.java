package com.leetcode.find_disappeared_numbers;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import static com.leetcode.find_disappeared_numbers.FindDisappearedNumbers.findDisappearedNumbers;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindDisappearedNumbersTest {

    @Test
    public void testCase1() {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        assertEquals(List.of(5, 6), findDisappearedNumbers(nums));
    }

    @Test
    public void testCase2() {
        int[] nums = {1, 1};
        assertEquals(List.of(2), findDisappearedNumbers(nums));
    }

    @SneakyThrows
    @Test
    public void testCase3() {
        String testFilePath = "src/main/java/com/leetcode/find_disappeared_numbers/resources/numsTestCase3.txt";
        try (FileInputStream inputStream = new FileInputStream(testFilePath)) {
            String str = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            int[] nums = Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
            FileInputStream resultStream = new FileInputStream(testFilePath);
            str = IOUtils.toString(resultStream, StandardCharsets.UTF_8);
            List<Integer> result = Arrays.stream(str.split(", ")).mapToInt(Integer::parseInt).boxed().toList();
            assertEquals(findDisappearedNumbers(nums), result);
        }
    }
}
