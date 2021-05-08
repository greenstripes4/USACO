import java.io.*;
import java.util.*;

public class Main {
    private static class Status {
        private String num;
        private int mod;
        private Status(int x, int n) {
            num = Integer.toString(x);
            mod = x%n;
        }
        private Status(String num, int mod) {
            this.num = num;
            this.mod = mod;
        }
        private Status next(int i, int n) {
            return new Status(num+i, (mod*10+i)%n);
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = 1;
        while(f.hasNext()) {
            int n = f.nextInt();
            int m = f.nextInt();
            boolean[] invalid = new boolean[10];
            for(int i = 0; i < m; i++) {
                invalid[f.nextInt()] = true;
            }
            Queue<Status> queue = new LinkedList<>();
            boolean[] visited = new boolean[n];
            for(int i = 1; i < 10; i++) {
                Status temp = new Status(i, n);
                if(!invalid[i] && !visited[temp.mod]) {
                    queue.offer(temp);
                    visited[temp.mod] = true;
                }
            }
            String ans = "-1";
            while(!queue.isEmpty()) {
                Status temp = queue.poll();
                if(temp.mod == 0) {
                    ans = temp.num;
                    break;
                }
                for(int i = 0; i < 10; i++) {
                    Status next = temp.next(i, n);
                    if(!invalid[i] && !visited[next.mod]) {
                        queue.offer(next);
                        visited[next.mod] = true;
                    }
                }
            }
            out.println("Case " + t++ + ": " + ans);
        }
        f.close();
        out.close();
    }
}