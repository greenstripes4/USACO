import java.io.*;
import java.util.*;

public class Main{
    private static class Instrument implements Comparable<Instrument>{
        private int number;
        private int stands;
        private int priority;
        private Instrument(int number, int stands) {
            this.number = number;
            this.stands = stands;
            int temp = number/stands;
            priority = temp+(temp*stands == number ? 0 : 1);
        }
        @Override
        public int compareTo(Instrument o) {
            return o.priority-this.priority;
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int p = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            p -= n;
            st = new StringTokenizer(f.readLine());
            PriorityQueue<Instrument> instruments = new PriorityQueue<>();
            for(int i = 0; i < n; i++) {
                instruments.offer(new Instrument(Integer.parseInt(st.nextToken()), 1));
            }
            while(!instruments.isEmpty() && p > 0) {
                Instrument next = instruments.poll();
                next.stands++;
                int temp = next.number/next.stands;
                next.priority = temp+(temp*next.stands == next.number ? 0 : 1);
                p--;
                if(next.priority > 1) {
                    instruments.offer(next);
                }
            }
            int max = 1;
            while(!instruments.isEmpty()) {
                Instrument next = instruments.poll();
                max = Math.max(max, next.priority);
            }
            out.println(max);
        }
        f.close();
        out.close();
    }
}
