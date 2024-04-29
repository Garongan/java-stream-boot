import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class CustomFile {
    // membuat attribute path
    private final String pathString = "text.txt";
    private final Path path;

    // membuat constructor class
    public CustomFile() {
        Path path = Paths.get(this.pathString);
        this.path = path;
    }

    // method untuk membuat file
    private void createFile() {
        try {
            // melakukan check jika file belum ada maka akan di buat
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            // menulis nilai ke dalam file txt
            Files.write(path, "1, 2, 3, 4, 5\n".getBytes(), StandardOpenOption.APPEND);
            Files.write(path, "Alvindo Tri Jatmiko\n".getBytes(), StandardOpenOption.APPEND);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // method untuk melakukan delete file sesuai path
    private void deleteFile() {
        try {
            Files.deleteIfExists(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // method untuk mendapatkan string => string disini adalah abjad dari a sampai z
    // lowercase maupun uppercase
    public void getString() {
        // membuat file
        createFile();
        try {
            // membaca seluruh byte di file teks dan menyimpan ke variable array byte
            byte[] bytes = Files.readAllBytes(path);
            // membuat list untuk menampung byte yang merupakan abjad
            List<Byte> stringFromBytes = new ArrayList<>();

            // berulang untuk mencari byte yang merupakan abjad
            for (int i = 0; i < bytes.length; i++) {
                // kondisi abjad adalah di range 65 sampai 122
                if (bytes[i] >= 65 && bytes[i] <= 122) {
                    stringFromBytes.add(bytes[i]);
                }
            }

            // membuat array byte baru agar dapat melakukan konversi dari byte ke string
            byte[] newBytes = new byte[stringFromBytes.size()];
            // mengisi nilai dari array byte
            for (int i = 0; i < stringFromBytes.size(); i++) {
                newBytes[i] = stringFromBytes.get(i);
            }

            // print hasil string
            System.out.println(new String(newBytes));
            // delete file
            deleteFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // method untuk mencari kata di file teks
    public String findWord(String input) {
        // membuat file
        createFile();

        // inisialisasi array string dan int dengan value kosong
        final String[] found = { "" };
        final int[] lineNumber = { 0 };
        try {
            // membaca setiap line pada file
            List<String> lines = Files.readAllLines(path);
            // stream dary list lines
            lines.stream()
                    .forEach(string -> {
                        // melakukan perulangan untuk setiap kata dari kalimat, dipisahkan dengan spasi
                        for (String split : string.split(" ")) {
                            // mengisikan nilai dari array lineNumber index 0
                            lineNumber[0]++;
                            if (split.contains(input)) {
                                // mengisikan string dari array found index ke 0
                                found[0] = "Word found in line number " + lineNumber[0] + ": " + string;
                            }
                        }
                    });
            // ketika gagal mengambalikan nilai tidak ditemukan
            found[0] = "Not Found";
        } catch (Exception e) {
            e.printStackTrace();
        }
        deleteFile();
        return found[0];
    }
}