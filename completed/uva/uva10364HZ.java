import java.io.*;
import java.util.*;

public class Main{
    static int[] sticks;
    static int target;
    static boolean[] Visited;
    static boolean OK;
    static int M;

    private static void solve(int current, int sides, int start) {
        if(OK) return;
        if(sides==3) {
            OK=true;
            return;
        }
        if(current>target) return;
        if(current == target) {
            solve(0, sides+1, 0);
        }
        for(int i = start; i < M; i++) {
            if(!Visited[i]) {
                Visited[i]=true;
                solve(current+sticks[i], sides, i+1);
                Visited[i]=false;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        int N = f.nextInt();
        for(int t = 0; t < N; t++) {
            M = f.nextInt();
            sticks = new int[M];
            Visited = new boolean[M];
            int sum = 0;
            OK=false;
            for(int i = 0; i < M; i++) {
                sticks[i] = f.nextInt();
                sum += sticks[i];
            }
            target = sum/4;
            if(sum%4 == 0) {
                solve(0, 0, 0);
                System.out.println( OK ? "yes" : "no");
            } else {
                System.out.println("no");
            }
        }
    }
}
