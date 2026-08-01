package com.medium.taskassignment;

import java.util.*;
import java.util.stream.IntStream;

public class TaskAssignment {

    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        List<Integer> sortedTasks = new ArrayList<>(tasks);
        Map<Integer, List<Integer>> taskToIndex = new HashMap<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < tasks.size(); i++) {
            taskToIndex.computeIfAbsent(tasks.get(i), integer -> new ArrayList<>()).add(i);
        }
        sortedTasks.sort(Comparator.naturalOrder());
        int left = 0;
        int right = tasks.size() - 1;
        while (left <= right) {
            List<Integer> indexes1 = taskToIndex.get(sortedTasks.get(left));
            List<Integer> indexes2 = taskToIndex.get(sortedTasks.get(right));

            result.add(new ArrayList<>(List.of(
                    indexes1.removeLast(),
                    indexes2.removeLast()
            )));
            left++;
            right--;
        }

        return result;
    }

    public ArrayList<ArrayList<Integer>> taskAssignmentAlternative(int k, ArrayList<Integer> tasks) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Integer[] byDuration = IntStream.range(0, tasks.size()).boxed().toArray(Integer[]::new);
        Arrays.sort(byDuration, Comparator.comparingInt(tasks::get));

        for (int i = 0; i < tasks.size() / 2; i++) {
            result.add(new ArrayList<>(List.of(byDuration[i], byDuration[tasks.size() - 1 - i])));
        }

        return result;
    }
}
