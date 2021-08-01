import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        char[] cycle = {'R', 'O', 'Y', 'G'};
        for(int i = 0; i < n-3; i++) {
            out.print(cycle[i%4]);
        }
        out.print("B");
        out.print("I");
        out.println("V");
        f.close();
        out.close();
    }
}