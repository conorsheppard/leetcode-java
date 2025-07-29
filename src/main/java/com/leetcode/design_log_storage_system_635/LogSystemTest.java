package com.leetcode.design_log_storage_system_635;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogSystemTest {
    @Test
    void testRetrieve() {
        LogSystem logSystem = new LogSystem();
        logSystem.put(1, "2017:01:01:23:59:59");
        logSystem.put(2, "2017:01:01:22:59:59");
        logSystem.put(3, "2016:01:01:00:00:00");

        assertEquals(List.of(1, 2, 3), logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year"));
        assertEquals(List.of(1, 2), logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour"));
    }
}
