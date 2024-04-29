import java.util.stream.Stream;

public class Pyramid {
    // membuat attribute dari tinggi piramid
    private int pyramidHeight;

    // membuat contructor dari class
    public Pyramid(int pyramidHeight) {
        this.pyramidHeight = pyramidHeight;
    }

    // method yang melakukan print piramid di console
    public void getPyramid() {
        // melakukan iterasi dari o sampai tinggi dari piramid dengan stream
        Stream<String> generatedStream = Stream.iterate(0, n -> n + 1)
                .limit(pyramidHeight)
                .map((index) -> {
                    // membuat string gap
                    String gap = " ".repeat(pyramidHeight - index - 1);
                    // mengembalikan star sesuai dengan tinggi piramid dimulai dari 1
                    return gap + "*".repeat(2 * index + 1);
                });

        // melakukan perulangan untuk print pyramid
        generatedStream.forEach((x) -> {
            System.out.println(x);
        });
    }
}
