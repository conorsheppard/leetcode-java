package com.leetcode.min_time_to_visit_all_points;

import org.junit.jupiter.api.Test;

import static com.leetcode.min_time_to_visit_all_points.MinTimeToVisitAllPoints.minTimeToVisitAllPoints;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinTimeToVisitAllPointsTest {

    @Test
    public void testCase1() {
        int[][] points = {
                {1, 1},
                {3, 4},
                {-1, 0}
        };

        assertEquals(7, minTimeToVisitAllPoints(points));
    }

    @Test
    public void testCase2() {
        int[][] points = {
                {3, 2},
                {-2, 2}
        };

        assertEquals(5, minTimeToVisitAllPoints(points));
    }

    @Test
    public void testCase3() {
        int[][] points = {
                {559, 511},
                {932, 618},
                {-623, -443},
                {431, 91},
                {838, -127},
                {773, -917},
                {-500, -910},
                {830, -417},
                {-870, 73},
                {-864, -600},
                {450, 535},
                {-479, -370},
                {856, 573},
                {-549, 369},
                {529, -462},
                {-839, -856},
                {-515, -447},
                {652, 197},
                {-83, 345},
                {-69, 423},
                {310, -737},
                {78, -201},
                {443, 958},
                {-311, 988},
                {-477, 30},
                {-376, -153},
                {-272, 451},
                {322, -125},
                {-114, -214},
                {495, 33},
                {371, -533},
                {-393, -224},
                {-405, -633},
                {-693, 297},
                {504, 210},
                {-427, -231},
                {315, 27},
                {991, 322},
                {811, -746},
                {252, 373},
                {-737, -867},
                {-137, 130},
                {507, 380},
                {100, -638},
                {-296, 700},
                {341, 671},
                {-944, 982},
                {937, -440},
                {40, -929},
                {-334, 60},
                {-722, -92},
                {-35, -852},
                {25, -495},
                {185, 671},
                {149, -452}
        };

        assertEquals(49088, minTimeToVisitAllPoints(points));
    }

    @Test
    public void testCase4() {
        int[][] points = {
                {3, 4},
                {4, 4},
                {8, 8}
        };
        assertEquals(5, minTimeToVisitAllPoints(points));
    }
}
