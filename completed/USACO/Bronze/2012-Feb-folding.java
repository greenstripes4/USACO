import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("folding.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("folding.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] knots = new int[N];
        for(int i = 0; i < N; i++){
            knots[i] = Integer.parseInt(f.readLine());
        }
        Arrays.sort(knots);
        int count = 0;
        for(double j = 0.5; j < L; j += 0.5){
            ArrayList<Integer> less = new ArrayList<>();
            ArrayList<Integer> more = new ArrayList<>();
            for(int k: knots){
                if(k < j){
                    less.add(k);
                }
                else if(k > j){
                    more.add(k);
                }
            }
            boolean isValid = true;
            for(int l = 0; l < Math.min(less.size(), more.size()); l++){
                if(j - less.get(less.size() - l - 1) != more.get(l) - j){
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                count++;
            }
        }
        out.println(count);
        out.close();
        f.close();
    }
}
