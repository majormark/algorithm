package com.backtracking.graph;

import java.util.*;

public class ReconstructItinerary {

    public LinkedList<String> path;
    Map<String, Map<String, Integer>> map;

    public List<String> findItinerary(List<List<String>> tickets) {

        path = new LinkedList<>();
        map = new HashMap<>();
        HashMap<String, Map<String, Integer>> map = new HashMap<>();
        for (List<String> flight : tickets) {
            Map<String, Integer> tmp;
            if (map.containsKey(flight.get(0))) {
                tmp = map.get(flight.get(0));
                tmp.put(flight.get(1), tmp.getOrDefault(flight.get(1), 0) + 1);
            } else {
                tmp = new TreeMap<>();
                tmp.put(flight.get(1), 1);
            }
            map.put(flight.get(0), tmp);
        }
        path.add("JFK");
        backtrack(tickets.size());
        return path;
    }

    public boolean backtrack(int ticketNum) {
        if (path.size() == ticketNum + 1) {
            return true;
        }

        for (Map.Entry<String, Integer> entry : map.get(path.getLast()).entrySet()) {
            int count = entry.getValue();
            if (count == 0) continue;
            path.add(entry.getKey());
            entry.setValue(count - 1);
            backtrack(ticketNum);
            path.removeLast();
            entry.setValue(count);
        }
        return false;
    }
}
