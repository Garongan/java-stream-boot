import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class CustomFile {
    private final String pathString = "text.txt";
    private final Path path;

    public CustomFile() {
        Path path = Paths.get(this.pathString);
        this.path = path;
    }

    private void createFile() {
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            Files.write(path, "1, 2, 3, 4, 5\n".getBytes(), StandardOpenOption.APPEND);
            Files.write(path, "Alvindo Tri Jatmiko\n".getBytes(), StandardOpenOption.APPEND);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteFile() {
        try {
            Files.deleteIfExists(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getString() {
        createFile();
        try {
            byte[] bytes = Files.readAllBytes(path);
            List<Byte> stringFromBytes = new ArrayList<>();

            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] >= 65 && bytes[i] <= 122) {
                    stringFromBytes.add(bytes[i]);
                }
            }

            byte[] newBytes = new byte[stringFromBytes.size()];
            for (int i = 0; i < stringFromBytes.size(); i++) {
                newBytes[i] = stringFromBytes.get(i);
            }

            System.out.println(new String(newBytes));
            deleteFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String findWord(String input) {
        createFile();
        final String[] found = { "" };
        final int[] lineNumber = { 0 };
        try {
            List<String> lines = Files.readAllLines(path);
            lines.stream()
                    .forEach(string -> {
                        for (String split : string.split(" ")) {
                            lineNumber[0]++;
                            if (split.contains(input)) {
                                found[0] = "Word found in line number " + lineNumber[0] + ": " + string;
                            }
                        }
                    });
        } catch (Exception e) {
            found[0] = "Not Found";
            e.printStackTrace();
        }
        deleteFile();
        return found[0];
    }
}
