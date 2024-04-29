public class MergeSort {

    // inisialisasi attribute dalam kelas
    private int[] array;
    private int[] leftHalf;
    private int[] rightHalf;

    // constructor class dengan parameter array
    public MergeSort(int[] array) {
        this.array = array;
    }

    // method untuk mengembalikan nilai array yang telah di sorting
    public int[] getSort() {
        mergeSort(array);
        return array;
    }

    // method untuk sorting array
    private void mergeSort(int[] array) {
        int length = array.length;

        // kondisi ketika hanya ada satu value di dalam array
        if (length < 2) {
            return;
        }

        // mencari nilai medium
        int midIndex = length / 2;

        // membagi array menjadi 2, kiri dan kanan
        leftHalf = new int[midIndex];
        rightHalf = new int[length - midIndex];

        // mengisi nilai dari array utama ke array yang telah dibagi
        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = array[i];
        }

        for (int i = midIndex; i < length; i++) {
            rightHalf[i - midIndex] = array[i];
        }

        // memanggil method secara rekursif sampai array length sama dengan 1
        mergeSort(leftHalf);
        mergeSort(rightHalf);

        // melakukan proses penggabungan array yang telah dibagi
        merge(array, leftHalf, rightHalf);
    }

    // method untuk menggabungkan array
    private void merge(int[] array, int[] leftHalf, int[] rightHalf) {
        // inisialisasi panjang array kiri dan kanan
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        // inisialisasi nilai awal dari index array kiri, kanan, dan merged array
        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = 0;

        // melakukan perulangan untuk mengisikan nilai dari merged array atau sorting
        while (leftIndex < leftSize && rightIndex < rightSize) {
            // menguji kondisi jika array bagian kiri lebih rendah dari array bagian kanan
            if (leftHalf[leftIndex] <= rightHalf[rightIndex]) {
                array[mergedIndex] = leftHalf[leftIndex];
                leftIndex++;
            } else {
                array[mergedIndex] = rightHalf[rightIndex];
                rightIndex++;
            }
            mergedIndex++;
        }

        // berulang ketika index dari array bagian kiri masih ada yang kurang dari
        // panjang array kiri
        while (leftIndex < leftSize) {
            array[mergedIndex] = leftHalf[leftIndex];
            leftIndex++;
            mergedIndex++;
        }

        // berulang ketika index dari array bagian kanan masih ada yang kurang dari
        // panjang array kanan
        while (rightIndex < rightSize) {
            array[mergedIndex] = rightHalf[rightIndex];
            rightIndex++;
            mergedIndex++;
        }

    }

}