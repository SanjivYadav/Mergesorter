package com.sanjiv.sort.merge;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class SortedListMerger<T extends Comparable<T>> implements Callable<List<T>> {

    private List<T> left;
    private List<T> right;

    private List<T> result;

    public SortedListMerger(List<T> left, List<T> right) {
        this.left = left;
        this.right = right;
        this.result = new ArrayList<>();
    }

    public List<T> merge(List<T> left, List<T> right) {

        int leftIndex = 0;
        int rightIndex = 0;

        // compare and add the elements to result list
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex).compareTo(right.get(rightIndex)) < 0) {
                result.add(left.get(leftIndex));
                leftIndex++;
            } else {
                result.add(right.get(rightIndex));
                rightIndex++;
            }
        }

        // add the remaining elements from left or right lists
        while (leftIndex < left.size()) {
            result.add(left.get(leftIndex));
            leftIndex++;
        }
        while (rightIndex < right.size()) {
            result.add(right.get(rightIndex));
            rightIndex++;
        }

        // return the combined result list
        return result;
    }

    @Override
    public List<T> call() throws Exception {
        return merge(left, right);
    }
}
