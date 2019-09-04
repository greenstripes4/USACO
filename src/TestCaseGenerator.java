import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Random;
import java.util.HashMap;

enum Field
{
    General, FollowCount, LowLimit, HighLimit, FollowLength, FollowGrid;
}

enum SchemaField
{
    GeneralNumber,
    Section2LineCount,
    Section2NumberMin,
    Section2NumberMax,
    Section2StrlenMin,
    Section2StrlenMax,
    Section3LineCount,
    Section3NumberMin,
    Section3NumberMax,
    Section3StrlenMin,
    Section3StrlenMax,
    GeneralStr,
}

enum Key
{
    Schema, // "%d %s %d %s"
    Field, // SchemaField[]
    Lines, // int
    NumberBoundaries, // long[][]
    NumberIsSorted, //Boolean
    StrlenBoundaries, // long[][]
    StrCharsets; //char[][]
}

public class TestCaseGenerator {
    // Enable result file (only if you have a bruce force solution as the Main
    // class ready)
    static boolean enableOutput = true;

    // Target folder to store test cases
    static String problem = "stacking";
    static int edgeCaseNumber = 10;
    static int randomCaseNumber = 10;

    // Section Configs
    static HashMap<Key, Object>[] config = new HashMap[]{
            new HashMap<>() {{
                put(Key.Schema, "%d %d");
                put(Key.Field, new SchemaField[]{
                        SchemaField.Section2NumberMax,
                        SchemaField.Section2LineCount
                });
                put(Key.Lines, 1);
                put(Key.NumberBoundaries, new long[][]{
                        {1, 1000000},
                        {1, 25000}
                });
                put(Key.NumberIsSorted, false);
            }},
            new HashMap<>() {{
                put(Key.Schema, "%d %d");
                put(Key.Field, new SchemaField[]{
                        SchemaField.GeneralNumber,
                        SchemaField.GeneralNumber
                });
                put(Key.NumberBoundaries, new long[][]{
                        {1, Integer.MAX_VALUE},
                        {1, Integer.MAX_VALUE}
                });
                put(Key.NumberIsSorted, true);
            }}
    };

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

    public static long GenerateNumberArg(long min, long max, boolean isEdgeCase) {
        if (isEdgeCase) {
            return getEdgeNumberInRange(min, max);
        } else {
            return getRandomNumberInRange(min, max);
        }
    }

    public static void GenerateTestCaseFromConfig(String caseFile, boolean isEdgeCase) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(caseFile)));
        int sectionCount = config.length;
        for(int i=0; i<sectionCount; i++) {
            GenerateSectionFromMap(out, isEdgeCase, config[i]);
        }
        out.close();
    }

    public static void GenerateSectionFromMap(PrintWriter out, boolean isEdgeCase, HashMap<Key, Object> keyObjectHashMap) {
        String schema = (String) keyObjectHashMap.get(Key.Schema);
        SchemaField[] schemaField = (SchemaField[]) keyObjectHashMap.get(Key.Field);
        long[][] numBoundaries = (long[][]) keyObjectHashMap.get(Key.NumberBoundaries);
        Boolean numIsSorted = (Boolean) keyObjectHashMap.get(Key.NumberIsSorted);
        long[][] strBoundaries = (long[][]) keyObjectHashMap.get(Key.StrlenBoundaries);
        char[][] strChars = (char[][]) keyObjectHashMap.get(Key.StrCharsets);
        int lines = (int)keyObjectHashMap.get(Key.Lines);

        String[] fields = schema.split(" ");
        for(int i=0;i<lines;i++) {
            Object[] args = new Object[fields.length];
            int numCount = 0;
            int strCount = 0;
            int argCount = 0;
            long lastNum = Long.MIN_VALUE;
            for (int j = 0; j < fields.length; j++) {
                if (fields[j].equals("%d")) {
                    long numArg = 0;
                    long min = numBoundaries[numCount][0];
                    long max = numBoundaries[numCount][1];
                    if (numIsSorted == true) {
                        min = Math.max(lastNum, min);
                    }
                    if (isEdgeCase) {
                        numArg = getEdgeNumberInRange(min, max);
                    } else {
                        numArg = getRandomNumberInRange(min, max);
                    }
                    lastNum = numArg;
                    refineConfig(schemaField[argCount], numArg);
                    numCount++;
                    args[argCount++] = numArg;
                } else if (fields[j].equals("%s")) {
                    String strArg = "";
                    int strlen = 0;
                    if (isEdgeCase) {
                        strlen = (int)getEdgeNumberInRange(strBoundaries[strCount][0], strBoundaries[strCount][1]);
                    } else {
                        strlen = (int)getRandomNumberInRange(strBoundaries[strCount][0], strBoundaries[strCount][1]);
                    }
                    char[] str = new char[strlen];
                    Random r = new Random();
                    for (int k = 0; k < strlen; k++) {
                        str[k] = strChars[strCount][r.nextInt(strChars[strCount].length)];
                    }
                    strArg = new String(str);
                    strCount++;
                    args[argCount++] = strArg;
                }
            }
            out.println(String.format(schema, args));
        }
    }

    public static void refineConfig(SchemaField schemaField, long numArg) {
        switch(schemaField){
            case Section2LineCount:
                config[1].put(Key.Lines, (int)numArg);
                break;
            case Section2NumberMin:
                long[][] sec2Boundaries1 = (long[][])config[1].get(Key.NumberBoundaries);
                for(long[] boundary : sec2Boundaries1){
                    boundary[0] = numArg;
                }
                config[1].put(Key.NumberBoundaries, sec2Boundaries1);
                break;
            case Section2NumberMax:
                long[][] sec2Boundaries2 = (long[][])config[1].get(Key.NumberBoundaries);
                for(long[] boundary : sec2Boundaries2){
                    boundary[1] = numArg;
                }
                config[1].put(Key.NumberBoundaries, sec2Boundaries2);
                break;
            case Section2StrlenMin:
                long[][] sec2Boundaries3 = (long[][])config[1].get(Key.StrlenBoundaries);
                for(long[] boundary : sec2Boundaries3){
                    boundary[0] = numArg;
                }
                config[1].put(Key.StrlenBoundaries, sec2Boundaries3);
                break;
            case Section2StrlenMax:
                long[][] sec2Boundaries4 = (long[][])config[1].get(Key.StrlenBoundaries);
                for(long[] boundary : sec2Boundaries4){
                    boundary[1] = numArg;
                }
                config[1].put(Key.StrlenBoundaries, sec2Boundaries4);
                break;
            case Section3LineCount:
                config[2].put(Key.Lines, (int)numArg);
                break;
            case Section3NumberMin:
                long[][] sec3Boundaries1 = (long[][])config[2].get(Key.NumberBoundaries);
                for(long[] boundary : sec3Boundaries1){
                    boundary[0] = numArg;
                }
                config[2].put(Key.NumberBoundaries, sec3Boundaries1);
                break;
            case Section3NumberMax:
                long[][] sec3Boundaries2 = (long[][])config[2].get(Key.NumberBoundaries);
                for(long[] boundary : sec3Boundaries2){
                    boundary[1] = numArg;
                }
                config[2].put(Key.NumberBoundaries, sec3Boundaries2);
                break;
            case Section3StrlenMin:
                long[][] sec3Boundaries3 = (long[][])config[2].get(Key.StrlenBoundaries);
                for(long[] boundary : sec3Boundaries3){
                    boundary[0] = numArg;
                }
                config[2].put(Key.StrlenBoundaries, sec3Boundaries3);
                break;
            case Section3StrlenMax:
                long[][] sec3Boundaries4 = (long[][])config[2].get(Key.StrlenBoundaries);
                for(long[] boundary : sec3Boundaries4){
                    boundary[1] = numArg;
                }
                config[2].put(Key.StrlenBoundaries, sec3Boundaries4);
                break;
        }
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
            GenerateTestCaseFromConfig(input, true);

            if (enableOutput) {
                String output = "ray-test\\" + problem + "\\" + i + ".out";
                GenerateOutput(input, output);
            }
        }

        for (; i <= (edgeCaseNumber + randomCaseNumber); i++) {
            String input = "ray-test\\" + problem + "\\" + i + ".in";
            GenerateTestCaseFromConfig(input, false);

            if (enableOutput) {
                String output = "ray-test\\" + problem + "\\" + i + ".out";
                GenerateOutput(input, output);
            }
        }
    }

}
