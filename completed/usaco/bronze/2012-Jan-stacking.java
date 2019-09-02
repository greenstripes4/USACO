import java.io.*;
import java.util.*;
/*
    // Target folder to store test cases
    static String problem = "stacking";
    static int edgeCaseNumber = 10;
    static int randomCaseNumber = 10;

    // First line config
    static boolean hasPrefixLine = true;
    static Field[] prefixSchema = {Field.HighLimit, Field.FollowCount};
    static int prefixNumbers = 2;
    static boolean prefixIsSorted = false;
    static long[][] prefixBoundaries = { { 1, 1000000 }, { 1, 25000 } };

    // Following line config
    static int numberPerLine = 2;
    static int numberLines = 100;
    static boolean numberIsSorted = true;
    static long[][] numberBoundaries = { { 1, 10000 }, { 1, 10000 }};

 */
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("stacking.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("stacking.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] diff = new int[N+1];
        for(int i = 0; i < K; i++){
            StringTokenizer instruction = new StringTokenizer(f.readLine());
            int start = Integer.parseInt(instruction.nextToken());
            int end = Integer.parseInt(instruction.nextToken());
            diff[start-1]++;
            diff[end]--;
        }
        int[] data = new int[N];
        int val = 0;
        for(int j = 0; j < N; j++){
            val += diff[j];
            data[j] = val;
        }
        Arrays.sort(data);
        out.println(data[N/2]);
        out.close();
        f.close();
    }
}
