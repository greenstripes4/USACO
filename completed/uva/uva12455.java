import java.io.*;
import java.util.*;

public class Main{
    private static boolean dfs(int[] bars, int curLength, int tarLength, int index){
        if(curLength == tarLength){
            return true;
        }
        for(int i = index; i < bars.length; i++){
            if(curLength+bars[i] <= tarLength){
                if(dfs(bars,curLength+bars[i],tarLength,i+1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(f.readLine());
            int p = Integer.parseInt(f.readLine());
            int[] bars = new int[p];
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int j = 0; j < p; j++){
                bars[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(bars);
            if(dfs(bars,0,n,0)){
                out.println("YES");
            } else {
                out.println("NO");
            }
        }
        f.close();
        out.close();
    }
}
