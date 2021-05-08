import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] sticks;
    private static int target;
    private static boolean solve(int current, int sides, int start) {
        if(current == target) {
            sides++;
            if(sides == 3) {
                return true;
            }
            return solve(0, sides, 0);
        }
        int fail = 0;
        for(int i = start; i < sticks.length; i++) {
            if(sticks[i] > 0) {
                if(current+sticks[i] <= target && sticks[i] != fail) {
                    int original = sticks[i];
                    sticks[i] = 0;
                    if(solve(current+original, sides, i+1)) {
                        return true;
                    }
                    sticks[i] = original;
                    fail = sticks[i];
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
            sticks = new int[M];
            int sum = 0;
            for(int i = 0; i < M; i++) {
                int stick = Integer.parseInt(st.nextToken());
                sticks[i] = stick;
                sum += stick;
            }
            Arrays.sort(sticks);
            for(int i = 0;i < M/2; i++) {
                int temp = sticks[i];
                sticks[i] = sticks[M-i-1];
                sticks[M-i-1] = temp;
            }
            target = sum/4;
            if(sum%4 == 0 && sticks[0] <= target) {
                out.println(solve(0, 0, 0) ? "yes" : "no");
            } else {
                out.println("no");
            }
        }
        f.close();
        out.close();
    }
}
