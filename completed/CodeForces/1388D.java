import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        long[] a = new long[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(f.readLine());
        int[] b = new int[n];
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken())-1;
            if(b[i] >= 0) {
                indegree[b[i]]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        ArrayList<Integer> first = new ArrayList<>();
        Stack<Integer> last = new Stack<>();
        long sum = 0;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            sum += a[cur];
            if(a[cur] < 0) {
                last.push(cur+1);
            } else {
                first.add(cur+1);
                if(b[cur] >= 0) {
                    a[b[cur]] += a[cur];
                }
            }
            if(b[cur] >= 0) {
                indegree[b[cur]]--;
                if(indegree[b[cur]] == 0) {
                    queue.offer(b[cur]);
                }
            }
        }
        out.println(sum);
        for(int i = 0; i < first.size(); i++) {
            if(i > 0) {
                out.print(" ");
            }
            out.print(first.get(i));
        }
        while(!last.isEmpty()) {
            out.print(" " + last.pop());
        }
        out.println();
        out.close();
    }
}
