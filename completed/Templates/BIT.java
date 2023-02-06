import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static long[] BIT;
    private static void update(int index, int add) {
        while(index <= N) {
            BIT[index] += add;
            index += index&-index;
        }
    }
    private static long query(int index) {
        long sum = 0;
        while(index > 0) {
            sum += BIT[index];
            index -= index&-index;
        }
        return sum;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        f.close();
        out.close();
    }
}
