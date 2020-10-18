import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine().replaceAll("[^0-9]"," "));
            int firstVal = Integer.parseInt(st.nextToken())*50;
            if(st.hasMoreTokens()) {
                int secondVal = Integer.parseInt(st.nextToken());
                firstVal += secondVal*5;
            }
            double weight = firstVal/100.0;
            if(weight == (int)weight) {
                out.println("Case " + t + ": " + (int)weight);
            } else {
                out.println("Case " + t + ": " + weight);
            }
        }
        f.close();
        out.close();
    }
}
