public class MergeSort {

    private int[] array;
    private int[] leftHalf;
    private int[] rightHalf;

    public MergeSort(int[] array) {
        this.array = array;
    }

    public int[] getSort() {
        mergeSort(array);
        return array;
    }

    private void mergeSort(int[] array) {
        int length = array.length;

        if (length < 2) {
            return;
        }

        int midIndex = length / 2;

        leftHalf = new int[midIndex];
        rightHalf = new int[length - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = array[i];
        }

        for (int i = midIndex; i < length; i++) {
            rightHalf[i - midIndex] = array[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(array, leftHalf, rightHalf);
    }

    private void merge(int[] array, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = 0;

        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (leftHalf[leftIndex] <= rightHalf[rightIndex]) {
                array[mergedIndex] = leftHalf[leftIndex];
                leftIndex++;
            } else {
                array[mergedIndex] = rightHalf[rightIndex];
                rightIndex++;
            }
            mergedIndex++;
        }

        while (leftIndex < leftSize) {
            array[mergedIndex] = leftHalf[leftIndex];
            leftIndex++;
            mergedIndex++;
        }

        while (rightIndex < rightSize) {
            array[mergedIndex] = rightHalf[rightIndex];
            rightIndex++;
            mergedIndex++;
        }

    }

}
