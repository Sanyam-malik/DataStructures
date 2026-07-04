public class MergeSort implements Sort {

    @Override
    public int[] sort(int[] input) {
        if (input == null || input.length <= 1) {
            return input;
        }

        mergeSortHelper(0, input.length - 1, input);
        return input;
    }

    public void mergeSortHelper(int start, int end, int[] input) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSortHelper(start, mid, input);
        mergeSortHelper(mid + 1, end, input);

        sortingParts(start, mid, end, input);
    }

    public void sortingParts(int start, int mid, int end, int[] input) {
        int leftStart = start;
        int leftEnd = mid;
        int rightStart = mid + 1;
        int rightEnd = end;

        int[] output = new int[end - start + 1];
        int index = 0;

        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            if (input[leftStart] <= input[rightStart]) {
                output[index++] = input[leftStart++];
            } else {
                output[index++] = input[rightStart++];
            }
        }

        while (leftStart <= leftEnd) {
            output[index++] = input[leftStart++];
        }

        while (rightStart <= rightEnd) {
            output[index++] = input[rightStart++];
        }

        // Copy merged result back into input
        for (int i = 0; i < output.length; i++) {
            input[start + i] = output[i];
        }
    }

    @Override
    public SortType sortType() {
        return SortType.MERGE;
    }
}