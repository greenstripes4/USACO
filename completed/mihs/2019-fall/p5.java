import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("unitConversion.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("unitConversion.out")));
        int N = Integer.parseInt(f.readLine());
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            String unit = st.nextToken();
            int val = Integer.parseInt(st.nextToken());
            int centimeters = unit.equals("c") ? val : (int) Math.round(val*2.54);
            int kilometers = centimeters/100000;
            centimeters -= kilometers*100000;
            int meters = centimeters/100;
            centimeters -= meters*100;
            out.println(kilometers + " " + meters + " " + centimeters);
        }
        f.close();
        out.close();
    }
}
