import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        /*
         * 1. Tulis program java yang mengilustrasikan pengurutan gabungan
         * 2. Bisakah anda membuat piramida karakter di java stream?
         * 3. Bagaimana cara mendapatkan jumlah semua elemen dalam array integer di java
         * stream?
         * 4. Bagaimana cara menemukan string dalam file teks di java?
         * 5. Tulis program java yang mengurutkan hashmap berdasarkan nilainya
         */
        int[] numbers = { 4, 1, 2, 3 };
        System.out.println("Array Awal: ");
        System.out.println(Arrays.toString(numbers));

        MergeSort mergeSort = new MergeSort();
        int[] sorted = mergeSort.mergeSort(numbers, 0, numbers.length - 1);

        System.out.println("Sorted Array: ");
        System.out.println(Arrays.toString(sorted));
    }
}
