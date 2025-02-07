package com.leetcode.min_time_to_visit_all_points;

import java.util.*;
import java.util.stream.IntStream;

public class MinTimeToVisitAllPoints {
    public static int minTimeToVisitAllPoints(int[][] points) {
        int seconds = 0;
        for (int i = 1; i < points.length; i++)
            seconds += Math.max(Math.abs(points[i-1][0] - points[i][0]), Math.abs(points[i-1][1] - points[i][1]));
        return seconds;
    }

    public static int minTimeWithStream(int[][] points) {
        return IntStream
                .range(1, points.length)
                .map(i -> Math.max(Math.abs(points[i-1][0] - points[i][0]), Math.abs(points[i-1][1] - points[i][1])))
                .sum();
    }

    public static int minTimeToVisitAllPointsStack(int[][] points) {
        int seconds = 0;
        List<List<Integer>> pointsList = new ArrayList<>(Arrays.stream(points).map(arr -> Arrays.stream(arr).boxed().toList()).toList());
        Collections.reverse(pointsList);
        Stack<List<Integer>> pointsStack = new Stack<>();
        pointsStack.addAll(pointsList);
        List<Integer> curPoints = pointsStack.pop();

        for (int i = 1; i < points.length; i++) {
            var dist = Math.max(Math.abs(Math.subtractExact(curPoints.get(0), points[i][0])),
                    Math.abs(Math.subtractExact(curPoints.get(1), points[i][1])));
            seconds += dist;
            curPoints = pointsStack.pop();
        }

        return seconds;
    }

    public static int minTimeToVisitAllPoints2(int[][] points) {
        int seconds = 0;

        int curX = points[0][0];
        int curY = points[0][1];

        for (int i = 1; i < points.length; i++) {
            int targetX = points[i][0];
            int targetY = points[i][1];

            if (curX == targetX) {
                seconds = seconds + Math.abs(targetY - curY);
                curY = targetY;
            } else if (curY == targetY) {
                seconds = seconds + Math.abs(targetX - curX);
                curX = targetX;
            } else {
                var xDist = targetX - curX;
                var yDist = targetY - curY;
                if (Math.abs(xDist) > Math.abs(yDist)) {
                    curX = curX + yDist;
                    curY = targetY;
                    seconds = seconds + Math.abs(yDist);
                    xDist = targetX - curX;
                    seconds = seconds + Math.abs(xDist);
                    curX = targetX;
                } else {
                    curY = curY + xDist;
                    curX = targetX;
                    seconds = seconds + Math.abs(xDist);
                    yDist = targetY - curY;
                    seconds = seconds + Math.abs(yDist);
                    curY = targetY;
                }
            }
        }

        return seconds;
    }
}
