import java.util.concurrent.ThreadLocalRandom;

public class QuickSort implements Sort {

    @Override
    public int[] sort(int[] input) {
        if (input == null || input.length <= 1) {
            return input;
        }

        quickSort(input, 0, input.length - 1);
        return input;
    }

    private void quickSort(int[] input, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivotIndex = partition(input, low, high);

        quickSort(input, low, pivotIndex - 1);
        quickSort(input, pivotIndex + 1, high);
    }

    private int partition(int[] input, int low, int high) {
        // Pick a random pivot and move it to the end
        int randomIndex = ThreadLocalRandom.current().nextInt(low, high + 1);
        swap(randomIndex, high, input);

        int pivot = input[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (input[j] <= pivot) {
                swap(i++, j, input);
            }
        }

        swap(i + 1, high, input);
        return i + 1;
    }

    @Override
    public SortType sortType() {
        return SortType.QUICK;
    }
}