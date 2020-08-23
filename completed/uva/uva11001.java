import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int Vtotal = Integer.parseInt(st.nextToken());
            int V0 = Integer.parseInt(st.nextToken());
            int split = 1;
            int bestSplit = 0;
            double maxLength = 0;
            while(Vtotal*1.0/split > V0) {
                double length = 0.3*Math.sqrt(Vtotal*1.0/split-V0);
                if(Math.abs(length*split-maxLength) < 0.00000001) {
                    bestSplit = 0;
                    break;
                }
                if(length*split > maxLength) {
                    bestSplit = split;
                    maxLength = length*split;
                }
                split++;
            }
            out.println(bestSplit);
        }
        f.close();
        out.close();
    }
}
