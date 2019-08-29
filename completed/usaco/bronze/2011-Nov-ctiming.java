import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("ctiming.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ctiming.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int d = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int dDiff = d - 11;
        int hDiff = h - 11;
        int mDiff = m - 11;
        if(mDiff < 0){
            hDiff--;
            mDiff += 60;
        }
        if(hDiff < 0){
            dDiff--;
            hDiff += 24;
        }
        int elapsedTime = dDiff * 1440 + hDiff * 60 + mDiff;
        if(elapsedTime < 0){
            out.println(-1);
        } else {
            out.println(elapsedTime);
        }
        out.close();
        f.close();
    }
}
