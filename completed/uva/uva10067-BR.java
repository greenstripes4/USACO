import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int initial = Integer.parseInt(st.nextToken()) * 1000 + Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken()) * 10 + Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int target = Integer.parseInt(st.nextToken()) * 1000 + Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken()) * 10 + Integer.parseInt(st.nextToken());
            boolean[] seen = new boolean[10000];
            int n = Integer.parseInt(f.readLine());
            for(int j = 0; j < n; j++){
                st = new StringTokenizer(f.readLine());
                int forbidden = Integer.parseInt(st.nextToken()) * 1000 + Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken()) * 10 + Integer.parseInt(st.nextToken());
                seen[forbidden] = true;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.add(initial);
            boolean found = false;
            int steps = 0;
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int j = 0; j < size; j++) {
                    int next = queue.poll();
                    if (next == target) {
                        found = true;
                        break;
                    }
                    int first = next / 1000;
                    next %= 1000;
                    int second = next / 100;
                    next %= 100;
                    int third = next / 10;
                    next %= 10;
                    int fourth = next;
                    int transformation1 = ((first + 1) % 10) * 1000 + second * 100 + third * 10 + fourth;
                    if (!seen[transformation1]) {
                        queue.add(transformation1);
                        seen[transformation1] = true;
                    }
                    int transformation2 = first * 1000 + ((second + 1) % 10) * 100 + third * 10 + fourth;
                    if (!seen[transformation2]) {
                        queue.add(transformation2);
                        seen[transformation2] = true;
                    }
                    int transformation3 = first * 1000 + second * 100 + ((third + 1) % 10) * 10 + fourth;
                    if (!seen[transformation3]) {
                        queue.add(transformation3);
                        seen[transformation3] = true;
                    }
                    int transformation4 = first * 1000 + second * 100 + third * 10 + ((fourth + 1) % 10);
                    if (!seen[transformation4]) {
                        queue.add(transformation4);
                        seen[transformation4] = true;
                    }
                    int transformation5 = ((first - 1) < 0 ? 9 : first - 1) * 1000 + second * 100 + third * 10 + fourth;
                    if (!seen[transformation5]) {
                        queue.add(transformation5);
                        seen[transformation5] = true;
                    }
                    int transformation6 = first * 1000 + ((second - 1) < 0 ? 9 : second - 1) * 100 + third * 10 + fourth;
                    if (!seen[transformation6]) {
                        queue.add(transformation6);
                        seen[transformation6] = true;
                    }
                    int transformation7 = first * 1000 + second * 100 + ((third - 1) < 0 ? 9 : third - 1) * 10 + fourth;
                    if (!seen[transformation7]) {
                        queue.add(transformation7);
                        seen[transformation7] = true;
                    }
                    int transformation8 = first * 1000 + second * 100 + third * 10 + ((fourth - 1) < 0 ? 9 : fourth - 1);
                    if (!seen[transformation8]) {
                        queue.add(transformation8);
                        seen[transformation8] = true;
                    }
                }
                if(found){
                    break;
                }
                steps++;
            }
            out.println(found ? steps:-1);
            f.readLine();
        }
        f.close();
        out.close();
    }
}
