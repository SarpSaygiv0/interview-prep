package com.easy.classphotos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClassPhotos {


    // notes
    // even number of student
    // one row red one row blue

    // student in the back row must be taller than front row

    // input 1 : red shirt students with their height
    // input 2 : blue shirt students with their height

    // returns if the photo can be taken

    // red:  [5, 8, 1, 3, 4]
    // blue: [6, 9, 2, 4, 5]

    // sorted red: [1, 3, 4, 5, 8]
    // sorted blue: [2, 4, 5, 6, 9]

    public static boolean classPhotos(ArrayList<Integer> redShirtStudents, ArrayList<Integer> blueShirtStudents) {
        List<Integer> sortedReds = redShirtStudents.stream().sorted(Comparator.reverseOrder()).toList();
        List<Integer> sortedBlues = blueShirtStudents.stream().sorted(Comparator.reverseOrder()).toList();
        List<Integer> backRow = sortedReds.get(0) >= sortedBlues.get(0) ? sortedReds : sortedBlues;
        boolean isBackRowRed = backRow.get(0).equals(sortedReds.get(0));
        List<Integer> frontRow = isBackRowRed ? sortedBlues : sortedReds;

        for (int i = 0; i <backRow.size(); i++) {
            if (backRow.get(i) <= frontRow.get(i))
                return false;
        }

        return true;
    }

    public static boolean classPhotos2(ArrayList<Integer> red, ArrayList<Integer> blue) {
        red.sort(Comparator.reverseOrder());
        blue.sort(Comparator.reverseOrder());
        return fitsBehind(red, blue) || fitsBehind(blue, red);
    }

    private static boolean fitsBehind(List<Integer> back, List<Integer> front) {
        for (int i = 0; i < back.size(); i++) {
            if (back.get(i) <= front.get(i))
                return false;
        }
        return true;
    }
}
