import java.io.*;
import java.util.*;

public class Main {
    private static String encode(Queue<Integer> s1, Queue<Integer> s2) {
        StringBuilder sb = new StringBuilder();
        for(int i: s1) {
            sb.append(i);
            sb.append(" ");
        }
        for(int i: s2) {
            sb.append(" ");
            sb.append(i);
        }
        return sb.toString();
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int k1 = Integer.parseInt(st.nextToken());
        Queue<Integer> s1 = new LinkedList<>();
        for(int i = 0; i < k1; i++) {
            s1.offer(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(f.readLine());
        int k2 = Integer.parseInt(st.nextToken());
        Queue<Integer> s2 = new LinkedList<>();
        for(int i = 0; i < k2; i++) {
            s2.offer(Integer.parseInt(st.nextToken()));
        }
        HashSet<String> seen = new HashSet<>();
        int steps = 0;
        while(!s1.isEmpty() && !s2.isEmpty()) {
            String temp = encode(s1, s2);
            if(seen.contains(temp)) {
                steps = -1;
                break;
            }
            seen.add(temp);
            int first = s1.poll();
            int second = s2.poll();
            if(first > second) {
                s1.offer(second);
                s1.offer(first);
            } else {
                s2.offer(first);
                s2.offer(second);
            }
            steps++;
        }
        if(steps == -1) {
            out.println(-1);
        } else {
            out.println(steps + " " + (s1.isEmpty() ? 2 : 1));
        }
        f.close();
        out.close();
    }
}