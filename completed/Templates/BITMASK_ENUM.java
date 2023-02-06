import java.io.*;
import java.util.*;

public class Main {
    private static void process(int subset) {

    }
    private static void enumerateSubsets(int mask) {
        for(int subset = mask; subset > 0; subset = mask&(subset-1)) {
            process(subset);
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        f.close();
        out.close();
    }
}
