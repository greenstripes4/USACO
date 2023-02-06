import java.io.*;
import java.util.*;
/*
    // Target folder to store test cases
    static String problem = "stacking";
    static int edgeCaseNumber = 10;
    static int randomCaseNumber = 10;

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
