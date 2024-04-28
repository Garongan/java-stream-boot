import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

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
        // inisisalisasi array dengan length 10
        int[] numbers = new int[10];
        // insialisasi array dengan angka random
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }

        System.out.println("Array Awal: ");
        System.out.println(Arrays.toString(numbers));

        // inisialisasi class merge sort beserta parameter array
        MergeSort mergeSort = new MergeSort(numbers);

        // reassign array numbers dengan hasil sorting
        numbers = mergeSort.getSort();

        System.out.println("Sorted Array: ");
        System.out.println(Arrays.toString(numbers));

        // insialisasi class pyramid beserta heigt yang di inginkan
        Pyramid pyramid = new Pyramid(5);

        // print pyramid
        pyramid.getPyramid();

        // mendapatkan jumlah semua element dari numbers
        int sum = IntStream.of(numbers).sum();
        System.out.println("Jumlah dari array numbers: " + sum);

        // inisialisasi class custom file
        CustomFile customFile = new CustomFile();

        // memanggil fungsi mendapatkan string dari file teks
        customFile.getString();

        // memanggil fungsi menemukan string dari file teks
        String foundWord = customFile.findWord("Alvindo");
        System.out.println(foundWord);

        // inisialisasi map
        Map<String, String> newMap = new HashMap<>();
        newMap.put("name", "Alvindo Tri Jatmiko");
        newMap.put("age", "24");
        newMap.put("address", "Jl. Topaz 7");

        System.out.println("Before sort by value: ");
        System.out.println(newMap);

        // inisialisasi class sortHasMap
        SortHasMap sortHasMap = new SortHasMap(newMap);

        Map<String,String> sortByValue = sortHasMap.sortByValue();

        System.out.println("After sort by value: ");
        System.out.println(sortByValue);
        
    }
}
