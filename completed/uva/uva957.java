import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null){
            int Y = Integer.parseInt(input);
            int P = Integer.parseInt(f.readLine());
            int[] popes = new int[P];
            for(int i = 0; i < P; i++){
                popes[i] = Integer.parseInt(f.readLine());
            }
            f.readLine();
            int max = 0;
            int maxStart = -1;
            int maxEnd = -1;
            int cur = 0;
            int curStart = 0;
            int curEnd = 0;
            int L = popes[P-1];
            for(int i = 1; i <= L; i++){
                while(curEnd < P && popes[curEnd] == i){
                    cur++;
                    curEnd++;
                }
                while(curStart < P && popes[curStart] < i-Y+1){
                    cur--;
                    curStart++;
                }
                if(cur > max){
                    max = cur;
                    maxStart = popes[curStart];
                    maxEnd = i;
                }
            }
            out.println(max + " " + maxStart + " " + maxEnd);
        }
        f.close();
        out.close();
    }
}
