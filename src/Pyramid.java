import java.util.stream.Stream;

public class Pyramid {
    private int pyramidHeight;

    public Pyramid(int pyramidHeight) {
        this.pyramidHeight = pyramidHeight;
    }

    public void getPyramid() {
        Stream<String> generatedStream = Stream.iterate(0, n -> n + 1)
                .limit(pyramidHeight)
                .map((index) -> {
                    String gap = " ".repeat(pyramidHeight - index - 1);
                    return gap + "*".repeat(2 * index + 1);
                });

        generatedStream.forEach((x) -> {
            System.out.println(x);
        });
    }
}
