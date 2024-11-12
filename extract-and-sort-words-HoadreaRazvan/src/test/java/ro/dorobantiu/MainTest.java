package ro.dorobantiu;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @ParameterizedTest
    @MethodSource("provideInputs")
    void extractWords(String inputFilePath, List<String> expected) throws IOException {
        String outputFile = inputFilePath + ".output.txt";
        Path outputFileAsPath = Path.of(outputFile);
        Files.deleteIfExists(outputFileAsPath);
        Main.extractWords(inputFilePath, outputFile);
        assertAll(
                () -> assertLinesMatch(Files.readAllLines(outputFileAsPath), expected),
                () -> assertTrue(Files.deleteIfExists(outputFileAsPath))
        );
    }

    private static List<Arguments> provideInputs() {
        return List.of(
                Arguments.of("input1.txt", Arrays.asList("amet", "dolor", "ipsum", "lorem", "sit")),
                Arguments.of("input2.txt", Arrays.asList("care", "contine", "cu", "cuvinte", "de", "fie",
                        "fisier", "fisierul", "litera", "mai", "mare", "multe", "prin", "punctuatie", "semne",
                        "separate", "si", "spatiu")),
                Arguments.of("input3.txt", IntStream.range(0, 1000000).mapToObj(t -> "" + t)
                        .sorted()
                        .toList())
        );
    }
}