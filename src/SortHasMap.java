import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortHasMap {
    // inisialisasi attribute dari class
    private Map<String, String> map;

    // membuat constructor dari class
    public SortHasMap(Map<String, String> map) {
        this.map = map;
    }

    // method sort by value dari hashmap
    public Map<String, String> sortByValue() {
        // melakukan stream untuk mendapatkan enrty set
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue()) // memanggil fungsi sorted dengan parameter yang di compare adalah
                                                      // value
                .collect(Collectors.toMap(
                        Map.Entry::getKey, // melakukan collect untuk mendapatkan map key
                        Map.Entry::getValue, // mendapatkan value
                        (prev, next) -> prev, LinkedHashMap::new));
    }
}