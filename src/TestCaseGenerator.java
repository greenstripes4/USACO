import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Random;

enum Field
{
    General, FollowCount, LowLimit, HighLimit;
}

public class TestCaseGenerator {
    // Enable result file (only if you have a bruce force solution as the Main
    // class ready)
    static boolean enableOutput = true;

    // Target folder to store test cases
    static String problem = "stacking";
    static int edgeCaseNumber = 10;
    static int randomCaseNumber = 10;

    // First line number config
    static boolean hasPrefixLine = true;
    static boolean prefixIsNumber = true;
    static Field[] prefixSchema = {Field.HighLimit, Field.FollowCount};
    static int prefixNumbers = 2;
    static boolean prefixIsSorted = false;
    static long[][] prefixBoundaries = { { 1, 1000000 }, { 1, 25000 } };
    static int prefixStrs = 1;
    static long[][] prefixStrlenBoundaries = { {1, 1000} };
    static char[][] prefixCharsets = { { '1', '0' } };

    // Following line number config
    static boolean hasFollowLine = true;
    static boolean followIsNumber = true;
    static int numberPerLine = 2;
    static int numberLines = 100;
    static boolean numberIsSorted = true;
    static long[][] numberBoundaries = { { 1, 10000 }, { 1, 10000 }};
    static int strPerLine = 1;
    static long[][] followStrlenBoundaries = { {1, 1000} };
    static char[][] followCharsets = { { 'B', '.' } };

    // Edge cases
    static String[] edges = { "Low", "Low+1", "High-1", "High", "Medium" };

    public static long getEdgeNumberInRange(long min, long max) {
        if(min == max) {
            return min;
        }
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
        case 4:
            return (min+max)/2;
        default:
            return max;
        }
    }

    public static long getRandomNumberInRange(long min, long max) {
        return min + (long) (Math.random() * (max - min));
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

    public static String GenerateEdgeStrLine(int number, long[][] boundaries, char[][] charsets, boolean isSorted) {
        String[] result = new String[number];
        for (int i = 0; i < number; i++) {
            int strlen = (int)getEdgeNumberInRange(boundaries[i][0], boundaries[i][1]);
            char[] str = new char[strlen];
            Random r = new Random();
            for (int j=0; j<strlen; j++) {
                str[j] = charsets[i][r.nextInt(charsets[i].length)];
            }
            result[i] = new String(str);
        }

        String resultStr = "";
        String delim = "";
        for (String i : result) {
            resultStr += delim + i;
            delim = " ";
        }
        return resultStr;
    }

    public static String GenerateRandomStrLine(int number, long[][] boundaries, char[][] charsets, boolean isSorted) {
        String[] result = new String[number];
        for (int i = 0; i < number; i++) {
            int strlen = (int)getRandomNumberInRange(boundaries[i][0], boundaries[i][1]);
            char[] str = new char[strlen];
            Random r = new Random();
            for (int j=0; j<strlen; j++) {
                str[j] = charsets[i][r.nextInt(charsets[i].length)];
            }
            result[i] = new String(str);
        }

        String resultStr = "";
        String delim = "";
        for (String i : result) {
            resultStr += delim + i;
            delim = " ";
        }
        return resultStr;
    }

    public static String GenerateStrLine(int number, long[][] boundaries, char[][] charsets, boolean isEdgeCase, boolean isSorted) {
        if (isEdgeCase) {
            return GenerateEdgeStrLine(number, boundaries, charsets, isSorted);
        } else {
            return GenerateRandomStrLine(number, boundaries, charsets, isSorted);
        }
    }

    public static void GenerateTestCase(String caseFile, boolean isEdgeCase) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(caseFile)));
        int lines = numberLines;
        if (hasPrefixLine) {
            if(prefixIsNumber) {
                String prefix = GenerateNumberLine(prefixNumbers, prefixBoundaries, isEdgeCase, prefixIsSorted);
                String[] prefixFields = prefix.split(" ");
                out.println(prefix);
                // Update config based on prefix
                for (int i = 0; i < prefixNumbers; i++) {
                    switch (prefixSchema[i]) {
                        case FollowCount:
                            lines = Integer.parseInt(prefixFields[i]);
                            break;
                        case LowLimit:
                            long lowLimit = Long.parseLong(prefix.split(" ")[i]);
                            for (long[] numberBoundary : numberBoundaries) {
                                numberBoundary[0] = lowLimit;
                            }
                            break;
                        case HighLimit:
                            long highLimit = Long.parseLong(prefix.split(" ")[i]);
                            for (long[] numberBoundary : numberBoundaries) {
                                numberBoundary[1] = highLimit;
                            }
                            break;
                    }
                }
            } else { // Str prefix
                String prefix = GenerateStrLine(prefixStrs, prefixStrlenBoundaries, prefixCharsets, isEdgeCase, prefixIsSorted);
                out.println(prefix);
            }
        }
        if(hasFollowLine) {
            if(followIsNumber) {
                for (int i = 0; i < lines; i++) {
                    out.println(GenerateNumberLine(numberPerLine, numberBoundaries, isEdgeCase, numberIsSorted));
                }
            }else { //follow is str
                    out.println(GenerateStrLine(strPerLine, followStrlenBoundaries, followCharsets, isEdgeCase, numberIsSorted));
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
        String targetDir = "ray-test\\" + problem + "\\";
        File directory = new File(targetDir);
        if (! directory.exists()){
            directory.mkdirs();
        }
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
