import java.io.*;
import java.util.*;

class Lake implements Comparable<Lake> {
    int lakeId;
    int f;
    int d;
    int t;
    Lake(int lakeId, int f, int d, int t) {
        this.lakeId = lakeId;
        this.f = f;
        this.d = d;
        this.t = t;
    }
    @Override
    public int compareTo(Lake o) {
        if(this.f == o.f) {
            return this.lakeId-o.lakeId;
        }
        return o.f-this.f;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        boolean first = true;
        while(true) {
            int n = f.nextInt();
            if(n == 0) {
                break;
            }
            if(!first) {
                out.println();
            }
            int m = f.nextInt()*60;
            int[] fi = new int[n];
            for(int i = 0; i < n; i++) {
                fi[i] = f.nextInt();
            }
            int[] di = new int[n];
            for(int i = 0; i < n; i++) {
                di[i] = f.nextInt();
            }
            int[] ti = new int[n-1];
            for(int i = 0; i < n-1; i++) {
                ti[i] = f.nextInt()*5;
            }
            Lake[] lakes = new Lake[n];
            lakes[0] = new Lake(0,fi[0],di[0],0);
            for(int i = 1; i < n; i++) {
                lakes[i] = new Lake(i,fi[i],di[i],ti[i-1]+lakes[i-1].t);
            }
            int maxFish = 0;
            int[] bestTimeAllocation = new int[n];
            for(int i = 0; i < n; i++) {
                PriorityQueue<Lake> currentLakes = new PriorityQueue<>();
                for(int j = 0; j <= i; j++) {
                    if(lakes[j].f > 0) {
                        currentLakes.add(new Lake(lakes[j].lakeId, lakes[j].f, lakes[j].d, lakes[j].t));
                    }
                }
                int timeLeft = m-lakes[i].t;
                int fish = 0;
                int[] currentTimeAllocation = new int[n];
                while(timeLeft > 0 && !currentLakes.isEmpty()) {
                    Lake next = currentLakes.poll();
                    fish += next.f;
                    next.f -= next.d;
                    currentTimeAllocation[next.lakeId] += 5;
                    timeLeft -= 5;
                    if(next.f > 0) {
                        currentLakes.add(next);
                    }
                }
                if(timeLeft > 0) {
                    currentTimeAllocation[0] += timeLeft;
                }
                boolean moreTimeInEarlierLakes = false;
                for(int j = 0; j < n; j++) {
                    if(currentTimeAllocation[j] > bestTimeAllocation[j]) {
                        moreTimeInEarlierLakes = true;
                        break;
                    } else if(currentTimeAllocation[j] < bestTimeAllocation[j]) {
                        break;
                    }
                }
                if(fish > maxFish || (fish == maxFish && moreTimeInEarlierLakes)) {
                    maxFish = fish;
                    bestTimeAllocation = currentTimeAllocation;
                }
            }
            out.print(bestTimeAllocation[0]);
            for(int i = 1; i < bestTimeAllocation.length; i++) {
                out.print(", " + bestTimeAllocation[i]);
            }
            out.println();
            out.println("Number of fish expected: " + maxFish);
            first = false;
        }
        f.close();
        out.close();
    }
}
