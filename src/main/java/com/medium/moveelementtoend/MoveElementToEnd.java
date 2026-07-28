package com.medium.moveelementtoend;

import java.util.Comparator;
import java.util.List;

public class MoveElementToEnd {

    // [2, 1, 2, 2, 2, 3, 4, 2], 2
    // [1, 2, 2, 2, 2, 2, 3, 4]
    // arr[i] == toMove -> int window = i;
    // while (window < arr.length && arr[window] == toMove)
    //    window++;
    // int windowToEnd = arr.length - window
    // i = 1, window = 6, windowToEnd = 2
    //
    //  while windowToEnd > 0
    //     swap(arr[i], arr[window])
    //     window++;
    //     i++;
    //
    public List<Integer> moveElementToEnd(List<Integer> list, int toMove) {
        list.sort(Comparator.naturalOrder());
        int start = 0;
        for (int i = 0; i <list.size(); i++) {
            if (list.get(i) == toMove) {
                start = i;
                break;
            }
        }
        int window = start;
        while (window < list.size() && list.get(window) == toMove) {
            window++;
        }
        while (list.size() - window > 0) {
            swap(start, window, list);
            window++;
            start++;
        }
        return list;
    }

    private static void swap(Integer i1, Integer i2, List<Integer> list) {
        Integer temp = list.get(i1);
        list.set(i1, list.get(i2));
        list.set(i2, temp);
    }

    // [2, 1, 2, 2, 2, 3, 4, 2], 2
    // [1, 3, 5, 0, 4, 0, 0], 0

    public List<Integer> moveElementToEndPointers(List<Integer> list, int toMove) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            while(left < right && list.get(left) != toMove)
                left++;
            if (list.get(right) != toMove)
                swap(left, right, list);
            right--;
        }
        return list;
    }


}
