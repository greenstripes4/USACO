import java.io.*;
import java.util.*;

public class Main{
    private static long getNextValue(long S) {
        if(S == 1) {
            return 0;
        }
        if(S == 3) {
            return 2;
        }
        long choice1 = S+1;
        long choice2 = S-1;
        int operations1 = 0;
        int operations2 = 0;
        while(choice1 > 0 && choice1%2 == 0) {
            choice1 /= 2;
            operations1++;
        }
        while(choice2 > 0 && choice2%2 == 0) {
            choice2 /= 2;
            operations2++;
        }
        return operations1 > operations2 ? S+1 : S-1;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(f.hasNext()) {
            long S = f.nextLong();
            int operations = 0;
            while(S > 0) {
                if(S%2 == 0) {
                    S /= 2;
                } else {
                    S = getNextValue(S);
                }
                operations++;
            }
            out.println(operations);
        }
        f.close();
        out.close();
    }
}