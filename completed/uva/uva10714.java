import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testCases = f.nextInt();
        for(int i = 0; i < testCases; i++){
            int length = f.nextInt();
            int n = f.nextInt();
            int[] ants = new int[n];
            for(int j = 0; j < n; j++){
                ants[j] = f.nextInt();
            }
            int min = 0;
            int max = 0;
            for(int j: ants){
                min = Math.max(min,Math.min(j,length-j));
                max = Math.max(max,Math.max(j,length-j));
            }
            out.println(min + " " + max);
        }
        f.close();
        out.close();
    }
}
