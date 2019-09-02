import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Random;

public class TestCaseGenerator {
    // Enable result file (only if you have a bruce force solution as the Main
    // class ready)
    static boolean enableOutput = true;

    // Target folder to store test cases
    static String problem = "gifts";
    static int edgeCaseNumber = 10;
    static int randomCaseNumber = 10;

    // First line config
    static boolean hasPrefixLine = true;
    static boolean firstNumberCount = true;
    static int prefixNumbers = 2;
    static boolean prefixIsSorted = false;
    static long[][] prefixBoundaries = { { 1, 1000 }, { 1, 1000000000 } };

    // Following line config
    static int numberPerLine = 2;
    static int numberLines = 100;
    static boolean numberIsSorted = false;
    static long[][] numberBoundaries = { { 0, 1000000000 }, { 0, 1000000000 } };

    // Edge cases
    static String[] edges = { "Low", "Low+1", "High-1", "High" };

    public static long getEdgeNumberInRange(long min, long max) {
        Random r = new Random();
        int edge = r.nextInt(edges.length);
        switch (edge) {
        case 0:
            return min;
        case 1:
            return min + 1;
        case 2:
            return max - 1;
        case 3:
            return max;
        }
        return min + (long) (Math.random() * (max + 1 - min));
    }

    public static long getRandomNumberInRange(long min, long max) {
        return min + (long) (Math.random() * (max + 1 - min));
    }

    public static String GenerateEdgeNumberLine(int number, long[][] boundaries, boolean isSorted) {
        long[] result = new long[number];
        result[0] = getEdgeNumberInRange(boundaries[0][0], boundaries[0][1]);
        for (int i = 1; i < number; i++) {
            if (isSorted) {
                result[i] = getEdgeNumberInRange(result[i - 1], boundaries[i][1]);
            } else {
                result[i] = getEdgeNumberInRange(boundaries[i][0], boundaries[i][1]);
            }
        }

        String resultStr = "";
        String delim = "";
        for (long i : result) {
            resultStr += delim + i;
            delim = " ";
        }
        return resultStr;
    }

    public static String GenerateRandomNumberLine(int number, long[][] boundaries, boolean isSorted) {
        long[] result = new long[number];
        result[0] = getRandomNumberInRange(boundaries[0][0], boundaries[0][1]);
        for (int i = 1; i < number; i++) {
            if (isSorted) {
                result[i] = getRandomNumberInRange(result[i - 1], boundaries[i][1]);
            } else {
                result[i] = getRandomNumberInRange(boundaries[i][0], boundaries[i][1]);
            }
        }

        String resultStr = "";
        String delim = "";
        for (long i : result) {
            resultStr += delim + i;
            delim = " ";
        }
        return resultStr;
    }

    public static String GenerateNumberLine(int number, long[][] boundaries, boolean isEdgeCase, boolean isSorted) {
        if (isEdgeCase) {
            return GenerateEdgeNumberLine(number, boundaries, isSorted);
        } else {
            return GenerateRandomNumberLine(number, boundaries, isSorted);
        }
    }

    public static void GenerateTestCase(String caseFile, boolean isEdgeCase) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(caseFile)));
        int lines = numberLines;
        if (hasPrefixLine) {
            String prefix = GenerateNumberLine(prefixNumbers, prefixBoundaries, isEdgeCase, prefixIsSorted);
            out.println(prefix);
            if (firstNumberCount) {
                lines = Integer.parseInt(prefix.split(" ")[0]);
            }
            for (int i = 0; i < lines; i++) {
                out.println(GenerateNumberLine(numberPerLine, numberBoundaries, isEdgeCase, numberIsSorted));
            }
        }
        out.close();
    }

    public static void GenerateOutput(String inputFile, String outputFile) throws IOException {
        File targetInput = new File(problem + ".in");
        File targetOutput = new File(problem + ".out");
        File input = new File(inputFile);
        File output = new File(outputFile);
        if (targetInput.exists()) {
            targetInput.delete();
        }
        if (targetOutput.exists()) {
            targetOutput.delete();
        }
        if (output.exists()) {
            output.delete();
        }
        Files.copy(input.toPath(), targetInput.toPath());
        long start = System.nanoTime();
        MainBruteforce.main(null);
        long end = System.nanoTime();
        Files.copy(targetOutput.toPath(), output.toPath());
    }

    public static void main(String[] args) throws IOException {
        int i = 1;
        for (; i <= edgeCaseNumber; i++) {
            String input = "ray-test\\" + problem + "\\" + i + ".in";
            GenerateTestCase(input, true);

            if (enableOutput) {
                String output = "ray-test\\" + problem + "\\" + i + ".out";
                GenerateOutput(input, output);
            }
        }

        for (; i <= (edgeCaseNumber + randomCaseNumber); i++) {
            String input = "ray-test\\" + problem + "\\" + i + ".in";
            GenerateTestCase(input, false);

            if (enableOutput) {
                String output = "ray-test\\" + problem + "\\" + i + ".out";
                GenerateOutput(input, output);
            }
        }
    }

}
