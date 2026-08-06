package com.medium.minheap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {

    List<Integer> heap = new ArrayList<>();

    public MinHeap(List<Integer> array) {
        heap = buildHeap(array);
    }

    public List<Integer> buildHeap(List<Integer> array) {
        int startIdx = ((array.size() - 1) - 1) / 2;
        for (int i = startIdx; i >= 0; i--) {
            siftDown(i, array.size() - 1, array);
        }

        return array;
    }

    public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
        int firstChild = currentIdx * 2 + 1;
        while (firstChild <= endIdx) {
            int smallerChildIdx = getSmallerChildIdx(heap, firstChild, endIdx);
            if (heap.get(currentIdx) < heap.get(smallerChildIdx)) return;
            swap(currentIdx, smallerChildIdx, heap);
            currentIdx = smallerChildIdx;
            firstChild = currentIdx * 2 + 1;
        }
    }

    private static int getSmallerChildIdx(List<Integer> heap, int firstChild, int endIdx) {
        if (firstChild + 1 > endIdx) return firstChild;
        return heap.get(firstChild) <= heap.get(firstChild + 1) ? firstChild : firstChild + 1;
    }

    public void siftUp(int currentIdx, List<Integer> heap) {
        int parentIdx = (currentIdx - 1) / 2;
        while (heap.get(parentIdx) > heap.get(currentIdx)) {
            swap(currentIdx, parentIdx, heap);
            currentIdx = parentIdx;
            parentIdx = (currentIdx - 1) / 2;
        }
    }

    public int peek() {
        return heap.getFirst();
    }

    public int remove() {
        swap(0, heap.size() - 1, heap);
        int value = heap.removeLast();
        siftDown(0, heap.size() - 1, heap);
        return value;
    }

    public void insert(int value) {
        heap.add(value);
        siftUp(heap.size() - 1, heap);
    }

    private void swap(int i, int j, List<Integer> array) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}
