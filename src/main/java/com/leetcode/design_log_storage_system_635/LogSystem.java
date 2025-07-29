package com.leetcode.design_log_storage_system_635;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogSystem {
    private final List<Log> logs = new ArrayList<>();
    private final Map<String, Integer> granularityMap = new HashMap<>();

    public LogSystem() {
        granularityMap.put("Year", 4);
        granularityMap.put("Month", 7);
        granularityMap.put("Day", 10);
        granularityMap.put("Hour", 13);
        granularityMap.put("Minute", 16);
        granularityMap.put("Second", 19);
    }

    public void put(int id, String timestamp) {
        logs.add(new Log(id, timestamp));
    }

    public List<Integer> retrieve(String start, String end, String granularity) {
        List<Integer> res = new ArrayList<>();
        int i = granularityMap.get(granularity);
        String s = start.substring(0, i);
        String e = end.substring(0, i);

        logs.forEach(log -> {
            String t = log.ts.substring(0, i);
            if (s.compareTo(t) <= 0 && t.compareTo(e) <= 0) res.add(log.id);
        });

        return res;
    }

    private static class Log {
        int id;
        String ts;

        Log(int id, String ts) {
            this.id = id;
            this.ts = ts;
        }
    }
}
