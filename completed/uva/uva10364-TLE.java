import java.io.*;
import java.util.*;

public class Main{
    private static boolean solve(int[] sticks, int target, int current, int sides, int left) {
        if(current == target) {
            sides++;
            if(sides == 4) {
                return true;
            }
            if(left < 4-sides) {
                return false;
            }
            return solve(sticks, target, 0, sides, left);
        }
        for(int i = 0; i < sticks.length; i++) {
            if(sticks[i] > 0) {
                if(current+sticks[i] <= target) {
                    int original = sticks[i];
                    sticks[i] = 0;
                    if(solve(sticks, target, current+original, sides, left-1)) {
                        return true;
                    }
                    sticks[i] = original;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        for(int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int M = Integer.parseInt(st.nextToken());
            int[] sticks = new int[M];
            int sum = 0;
            for(int i = 0; i < M; i++) {
                int stick = Integer.parseInt(st.nextToken());
                sticks[i] = stick;
                sum += stick;
            }
            Arrays.sort(sticks);
            for(int i=0;i<M/2;i++){
                int temp = sticks[i];
                sticks[i]=sticks[M-i-1];
                sticks[M-i-1] = temp;
            }
            if(sum%4 == 0) {
                out.println(solve(sticks, sum/4, 0, 0, M) ? "yes" : "no");
            } else {
                out.println("no");
            }
        }
        f.close();
        out.close();
    }
}
