public class MergeSort {

    public int[] mergeSort(int[] array, int low, int high) {
        if (low == high) {
            int[] barier = new int[1];
            barier[0] = array[low];
            return barier;
        }

        int mid = (low + high) / 2;

        int[] lefHalf = mergeSort(array, low, mid);
        int[] rightHalf = mergeSort(array, mid + 1, high);

        int[] merged = mergeTwoArray(lefHalf, rightHalf);

        return merged;
    }

    private int[] mergeTwoArray(int[] left, int[] right) {
        int[] sorted = new int[left.length + right.length];

        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                sorted[k] = left[i];
                i++;
            } else {
                sorted[k] = right[j];
                j++;
            }
            k++;
        }

        if (i == left.length) {
            while (j < right.length) {
                sorted[k] = right[j];
                k++;
                j++;
            }
        }

        if (j == right.length) {
            while (i < left.length) {
                sorted[k] = left[i];
                k++;
                i++;
            }
        }

        return sorted;
    }

}
