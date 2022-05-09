import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("art2.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("art2.out")));
        int N = Integer.parseInt(f.readLine());
        int[] colors = new int[N];
        for(int i = 0; i < N; i++) {
            colors[i] = Integer.parseInt(f.readLine());
        }
        ArrayList<Integer> indexes = new ArrayList<>();
        boolean[] visited = new boolean[N+1];
        for(int i = 0; i < N; i++) {
            if(colors[i] > 0 && !visited[colors[i]]) {
                visited[colors[i]] = true;
                indexes.add(i);
            }
        }
        visited = new boolean[N+1];
        for(int i = N-1; i >= 0; i--) {
            if(colors[i] > 0 && !visited[colors[i]]) {
                visited[colors[i]] = true;
                indexes.add(i);
            }
        }
        Collections.sort(indexes);
        Stack<Integer> stack = new Stack<>();
        visited = new boolean[N+1];
        int ans = 0;
        for(int i: indexes) {
            if(!visited[colors[i]]) {
                stack.push(colors[i]);
                visited[colors[i]] = true;
            } else {
                if(stack.isEmpty() || stack.pop() != colors[i]) {
                    ans = -1;
                    break;
                }
            }
            ans = Math.max(ans, stack.size());
        }
        out.println(ans);
        f.close();
        out.close();
    }
}