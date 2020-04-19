import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true){
            int n = f.nextInt();
            int d = f.nextInt();
            int r = f.nextInt();
            if(n == 0 && d == 0 && r == 0){
                break;
            }
            int[] morning = new int[n];
            int[] afternoon = new int[n];
            for(int i = 0; i < n; i++){
                morning[i] = f.nextInt();
            }
            for(int i = 0; i < n; i++){
                afternoon[i] = f.nextInt();
            }
            Arrays.sort(morning);
            Arrays.sort(afternoon);
            int[] totalHours = new int[n];
            for(int i = 0; i < n; i++){
                totalHours[i] = morning[i]+afternoon[n-i-1];
            }
            int totalOvertime = 0;
            for(int i = 0; i < n; i++){
                totalOvertime += (Math.max(totalHours[i]-d,0)*r);
            }
            out.println(totalOvertime);
        }
        f.close();
        out.close();
    }
}
