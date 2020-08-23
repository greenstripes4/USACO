import java.io.*;
import java.util.*;

class Ant implements Comparable<Ant> {
    int index;
    int location;
    String direction;
    Ant(int index, int location, String direction) {
        this.index = index;
        this.location = location;
        this.direction = direction;
    }
    @Override
    public int compareTo(Ant o) {
        return this.location-o.location;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        for(int t = 1; t <= N; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int L = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            Ant[] initialAnts = new Ant[n];
            Ant[] finalAnts = new Ant[n];
            for(int i = 0; i < n; i++) {
                StringTokenizer ant = new StringTokenizer(f.readLine());
                initialAnts[i] = new Ant(i,Integer.parseInt(ant.nextToken()),ant.nextToken());
                finalAnts[i] = new Ant(-1,initialAnts[i].location+(initialAnts[i].direction.equals("L") ? -1 : 1)*T,initialAnts[i].direction);
            }
            Arrays.sort(initialAnts);
            Arrays.sort(finalAnts);
            int[] order = new int[n];
            for(int i = 0; i < n; i++) {
                order[initialAnts[i].index] = i;
            }
            for(int i = 0; i < n-1; i++) {
                if(finalAnts[i].location == finalAnts[i+1].location) {
                    finalAnts[i].direction = "Turning";
                    finalAnts[i+1].direction = "Turning";
                }
            }
            out.println("Case #" + t + ":");
            for(int i = 0; i < n; i++) {
                int index = order[i];
                if(finalAnts[index].location < 0 || finalAnts[index].location > L) {
                    out.println("Fell off");
                } else {
                    out.println(finalAnts[index].location + " " + finalAnts[index].direction);
                }
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
