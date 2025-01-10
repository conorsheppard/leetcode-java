package org.example;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import static org.example.FindDisappearedNumbers.findDisappearedNumbers;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindDisappearedNumbersTest {

    @Test
    public void testCase1() {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        assertEquals(findDisappearedNumbers(nums), Arrays.asList(5, 6));
    }

    @Test
    public void testCase2() {
        int[] nums = {1, 1};
        assertEquals(findDisappearedNumbers(nums), List.of(2));
    }

    @Test
    public void testCase3() {
        try (FileInputStream inputStream = new FileInputStream("src/test/resources/numsTestCase3.txt")) {
            String str = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            int[] nums = Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
            FileInputStream resultStream = new FileInputStream("src/test/resources/resultTestCase3.txt");
            str = IOUtils.toString(resultStream, StandardCharsets.UTF_8);
            List<Integer> result = Arrays.stream(str.split(", ")).mapToInt(Integer::parseInt).boxed().toList();
            assertEquals(findDisappearedNumbers(nums), result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
