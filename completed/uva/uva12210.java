import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        int testcase = 1;
        while(!(input = f.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int B = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int[] bachelors = new int[B];
            for(int i = 0; i < B; i++) {
                bachelors[i] = Integer.parseInt(f.readLine());
            }
            for(int i = 0; i < S; i++) {
                f.readLine();
            }
            if(B <= S) {
                out.println("Case " + testcase + ": 0");
            } else {
                int youngestBachelor = 60;
                for(int i: bachelors) {
                    youngestBachelor = Math.min(youngestBachelor,i);
                }
                out.println("Case " + testcase + ": " + (B-S) + " " + youngestBachelor);
            }
            testcase++;
        }
        f.close();
        out.close();
    }
}
