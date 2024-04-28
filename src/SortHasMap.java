import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortHasMap {
    private Map<String, String> map;

    public SortHasMap(Map<String, String> map) {
        this.map = map;
    }

    public Map<String, String> sortByValue() {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (prev, next) -> prev, LinkedHashMap::new));
    }
}
