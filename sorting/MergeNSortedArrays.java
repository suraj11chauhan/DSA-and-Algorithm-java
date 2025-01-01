package com.test.practices.sorting;

import java.util.PriorityQueue;
import java.util.Arrays;

public class MergeNSortedArrays {
    public static void main(String[] args) {
        int[][] a = {
                {1, 4, 6, 7},
                {3, 2, 5, 8},
                {11, 17, 19, 20},
                // Add more sorted sub-arrays as needed
        };

        // Sort the individual arrays first, since the provided arrays are not sorted
        for (int[] array : a) {
            Arrays.sort(array);
        }

        // Merge the sorted arrays
        int[] result = mergeSortedArrays(a);

        // Print the result
        System.out.println(Arrays.toString(result));
    }

    public static int[] mergeSortedArrays(int[][] arrays) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>();
        int totalLength = 0;

        // Initialize the heap with the first element of each array
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                minHeap.offer(new Element(arrays[i][0], i, 0));
                totalLength += arrays[i].length;
            }
        }

        int[] mergedArray = new int[totalLength];
        int index = 0;

        // Extract the smallest element from the heap and add the next element from the same array
        while (!minHeap.isEmpty()) {
            Element current = minHeap.poll();
            mergedArray[index++] = current.value;

            if (current.elementIndex + 1 < arrays[current.arrayIndex].length) {
                minHeap.offer(new Element(
                        arrays[current.arrayIndex][current.elementIndex + 1],
                        current.arrayIndex,
                        current.elementIndex + 1
                ));
            }
        }

        return mergedArray;
    }
}

// Helper class to store the elements along with their array and index
class Element implements Comparable<Element> {
    int value;
    int arrayIndex;
    int elementIndex;

    public Element(int value, int arrayIndex, int elementIndex) {
        this.value = value;
        this.arrayIndex = arrayIndex;
        this.elementIndex = elementIndex;
    }

    @Override
    public int compareTo(Element other) {
        return Integer.compare(this.value, other.value);
    }
}
