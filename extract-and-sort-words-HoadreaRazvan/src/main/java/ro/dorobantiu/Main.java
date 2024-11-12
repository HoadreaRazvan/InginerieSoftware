package ro.dorobantiu;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String inputFilePath = "input2.txt";
        String outputFilePath = "output1.txt";

        extractWords(inputFilePath, outputFilePath);
    }

    public static void extractWords(String inputFilePath, String outputFilePath) {
        Set<String> words = new TreeSet<>();
        try (Scanner scanner = new Scanner(new File(inputFilePath))) {
            while (scanner.hasNext())
                words.add(scanner.next().replaceAll("[^a-zA-Z0-9]", "").toLowerCase());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (String word : words) {
                bufferedWriter.write(word);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}