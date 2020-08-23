import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        for(int c1 = 1; c1 <= 2000; c1++) {
            if(c1*c1*c1*c1 > 2000000000) {
                break;
            }
            for(int c2 = c1; c2 <= 2000; c2++) {
                if(c1*c2*c2*c2 > 2000000000) {
                    break;
                }
                for(int c3 = c2; c3 <= 2000; c3++) {
                    if(c1*c2*c3*c3 > 2000000000) {
                        break;
                    }
                    int curSum = c1+c2+c3;
                    int curProduct = c1*c2*c3;
                    if(curProduct == 1000000 || (curSum*1000000)%(curProduct-1000000) != 0) {
                        continue;
                    }
                    int c4 = (curSum*1000000)/(curProduct-1000000);
                    if(c3 > c4 || curSum+c4 > 2000 || curProduct*c4 > 2000000000) {
                        continue;
                    }
                    out.println(String.format("%.2f",c1/100.0) + " " + String.format("%.2f",c2/100.0) + " " + String.format("%.2f",c3/100.0) + " " + String.format("%.2f",c4/100.0));
                }
            }
        }
        //f.close();
        out.close();
    }
}
