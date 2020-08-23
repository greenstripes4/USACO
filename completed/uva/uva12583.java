import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = f.nextInt();
        for(int i = 1; i <= t; i++) {
            int n = f.nextInt();
            int k = f.nextInt();
            char[] listOfNames = f.next().toCharArray();
            int[] daysBeforeLastMet = new int[26];
            Arrays.fill(daysBeforeLastMet,501);
            int recognized = 0;
            for(int j = 0; j < n; j++) {
                if(daysBeforeLastMet[listOfNames[j]-'A'] <= k) {
                    recognized++;
                }
                for(int l = 0; l < 26; l++) {
                    daysBeforeLastMet[l]++;
                }
                daysBeforeLastMet[listOfNames[j]-'A'] = 1;
            }
            out.println("Case " + i + ": " + recognized);
        }
        f.close();
        out.close();
    }
}
