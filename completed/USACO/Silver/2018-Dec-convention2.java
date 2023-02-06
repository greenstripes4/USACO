import java.io.*;
import java.util.*;

public class Main{
    private static class Cow implements Comparable<Cow>{
        int a, t, s;
        private Cow(int a, int t, int s) {
            this.a = a;
            this.t = t;
            this.s = s;
        }
        @Override
        public int compareTo(Cow o) {
            if(this.a == o.a) {
                return this.s-o.s;
            }
            return this.a-o.a;
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("swap.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowland.in")));
        int N = Integer.parseInt(f.readLine());
        Cow[] cows = new Cow[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            cows[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
        }
        Arrays.sort(cows);
        PriorityQueue<Cow> waiting = new PriorityQueue<>(new Comparator<Cow>() {
            @Override
            public int compare(Cow cow, Cow t1) {
                return cow.s-t1.s;
            }
        });
        waiting.offer(cows[0]);
        int currentTime = cows[0].a;
        int maximumWait = 0;
        int index = 0;
        while(!waiting.isEmpty()) {
            Cow next = waiting.poll();
            maximumWait = Math.max(maximumWait, currentTime-next.a);
            currentTime += next.t;
            int nextIndex = index+1;
            while(nextIndex < N && cows[nextIndex].a <= currentTime) {
                waiting.offer(cows[nextIndex]);
                nextIndex++;
            }
            if(nextIndex < N && waiting.isEmpty()) {
                waiting.offer(cows[nextIndex]);
                currentTime = cows[nextIndex].a;
                index = nextIndex;
            } else {
                index = nextIndex-1;
            }
        }
        out.println(maximumWait);
        f.close();
        out.close();
    }
}
