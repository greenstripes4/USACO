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
            char[] temp = f.readLine().toCharArray();
            boolean[] taken = new boolean[temp.length];
            for(int i = 0; i < temp.length; i++) {
                if(temp[i] == 'D') {
                    taken[i] = true;
                } else if(temp[i] == 'B') {
                    taken[i] = true;
                    if(i > 0) {
                        taken[i-1] = true;
                    }
                    if(i > 1) {
                        taken[i-2] = true;
                    }
                } else if (temp[i] == 'S') {
                    taken[i] = true;
                    if(i > 0) {
                        taken[i-1] = true;
                    }
                    if(i < temp.length-1) {
                        taken[i+1] = true;
                    }
                }
            }
            int cnt = 0;
            for(boolean i: taken) {
                if(!i) {
                    cnt++;
                }
            }
            out.println("Case " + t + ": " + cnt);
        }
        f.close();
        out.close();
    }
}
