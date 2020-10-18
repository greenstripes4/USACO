import java.io.*;
import java.util.*;

public class Main{
    private static boolean solve(int[] sticks, int[] sideLengths, int[] lastInvalid, int target, int index) {
        if(index == sticks.length) {
            return true;
        }
        int currentStick = sticks[index];
        for(int i = 0; i < 4; i++) {
            if(/*currentStick != lastInvalid[i] && */currentStick+sideLengths[i] <= target) {
                sideLengths[i] += currentStick;
                if(solve(sticks, sideLengths, lastInvalid, target, index+1)) {
                    return true;
                }
                sideLengths[i] -= currentStick;
                lastInvalid[i] = currentStick;
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
            int max = 0;
            for(int i = 0; i < M; i++) {
                int length = Integer.parseInt(st.nextToken());
                sticks[i] = length;
                sum += length;
                max = Math.max(max, length);
            }
            if(sum%4 != 0 || max > sum/4) {
                out.println("no");
                continue;
            }
            Arrays.sort(sticks);
            for(int i = 0; i < M/2; i++) {
                int temp = sticks[i];
                sticks[i] = sticks[M-i-1];
                sticks[M-i-1] = temp;
            }
            int[] sideLengths = new int[4];
            int[] lastInvalid = new int[4];
            out.println(solve(sticks, sideLengths, lastInvalid, sum/4, 0) ? "yes" : "no");
        }
        f.close();
        out.close();
    }
}
