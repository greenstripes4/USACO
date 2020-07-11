import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            int k = f.nextInt();
            if(k == 0) {
                break;
            }
            int m = f.nextInt();
            boolean[] courses = new boolean[10000];
            for(int i = 0; i < k; i++) {
                courses[f.nextInt()] = true;
            }
            boolean isValid = true;
            for(int i = 0; i < m; i++) {
                int c = f.nextInt();
                int r = f.nextInt();
                int taken = 0;
                for(int j = 0; j < c; j++) {
                    if(courses[f.nextInt()]) {
                        taken++;
                    }
                }
                if(taken < r) {
                    isValid = false;
                }
            }
            out.println(isValid ? "yes" : "no");
        }
        f.close();
        out.close();
    }
}
