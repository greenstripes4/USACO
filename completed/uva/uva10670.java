import java.io.*;
import java.util.*;

class Agency implements Comparable<Agency>{
    String name;
    int minCost;
    Agency(String name, int minCost) {
        this.name = name;
        this.minCost = minCost;
    }
    @Override
    public int compareTo(Agency o) {
        if(this.minCost == o.minCost) {
            return this.name.compareTo(o.name);
        }
        return this.minCost-o.minCost;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int cases = Integer.parseInt(f.readLine());
        for(int t = 1; t <= cases; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            Agency[] agencies = new Agency[L];
            for(int i = 0; i < L; i++) {
                String[] agencyFormatted = f.readLine().split(":");
                String name = agencyFormatted[0];
                String[] costs = agencyFormatted[1].split(",");
                int A = Integer.parseInt(costs[0]);
                int B = Integer.parseInt(costs[1]);
                int tempN = N;
                int minCost = 0;
                while(tempN > M) {
                    int halved = tempN/2;
                    if(halved >= M) {
                        minCost += Math.min(B,A*(tempN-halved));
                        tempN /= 2;
                    } else {
                        minCost += A;
                        tempN--;
                    }
                }
                agencies[i] = new Agency(name,minCost);
            }
            Arrays.sort(agencies);
            out.println("Case " + t);
            for(Agency i: agencies) {
                out.println(i.name + " " + i.minCost);
            }
        }
        f.close();
        out.close();
    }
}
