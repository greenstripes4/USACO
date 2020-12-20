import java.io.*;
import java.util.*;

public class Main{
    private static boolean canSplit(int[] sticks, boolean[] used, int target, int current, int built, int need, int start) {
        if(built == need-1) {
            return true;
        }
        if(current == target) {
            return canSplit(sticks, used, target, 0, built+1, need, 0);
        }
        int lastInvalid = -1;
        for(int i = start; i < sticks.length; i++) {
            if(!used[i] && sticks[i] != lastInvalid && current+sticks[i] <= target) {
                used[i] = true;
                if(canSplit(sticks, used, target, current+sticks[i], built, need, i+1)) {
                    return true;
                }
                used[i] = false;
                lastInvalid = sticks[i];
                if(current==0)
                    return false;
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
        String input;
        while(!(input = f.readLine()).equals("0")) {
            long start = System.nanoTime();
            int n = Integer.parseInt(input);
            int[] sticks = new int[n];
            StringTokenizer st = new StringTokenizer(f.readLine());
            int sum = 0;
            for(int i = 0; i < n; i++) {
                sticks[i] = Integer.parseInt(st.nextToken());
                sum += sticks[i];
            }
            Arrays.sort(sticks);
            for(int i = 0; i < n/2; i++) {
                int temp = sticks[i];
                sticks[i] = sticks[n-i-1];
                sticks[n-i-1] = temp;
            }
            for(int i = sticks[0]; i <= sum; i++) {
                if(sum%i == 0 && canSplit(sticks, new boolean[n], i, 0, 0, sum/i, 0)) {
                    out.println(i);
                    break;
                }
            }
            long end = System.nanoTime();
            long ms = ((end - start) / 1000000);
            //System.out.println("test passed in " + ms + "ms time");
        }
        f.close();
        out.close();
    }
}
