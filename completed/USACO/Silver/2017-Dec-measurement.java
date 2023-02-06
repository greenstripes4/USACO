import java.io.*;
import java.util.*;

class Measurement implements Comparable<Measurement> {
    private int day;
    int ID;
    int change;
    Measurement(int day, int ID, int change) {
        this.day = day;
        this.ID = ID;
        this.change = change;
    }
    @Override
    public int compareTo(Measurement o) {
        return this.day-o.day;
    }
}

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        Measurement[] log = new Measurement[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer entry = new StringTokenizer(f.readLine());
            int day = Integer.parseInt(entry.nextToken());
            int ID = Integer.parseInt(entry.nextToken());
            int change = Integer.parseInt(entry.nextToken());
            log[i] = new Measurement(day,ID,change);
        }
        Arrays.sort(log);
        TreeMap<Integer,Integer> numPeople = new TreeMap<>();
        HashMap<Integer,Integer> milkProduction = new HashMap<>();
        numPeople.put(G,1000000000);
        int changes = 0;
        for(Measurement i: log) {
            int originalProduction = milkProduction.getOrDefault(i.ID,G);
            int updatedProduction = originalProduction+i.change;
            int originalMax = numPeople.lastKey();
            int maxPeople = numPeople.get(originalProduction);
            numPeople.put(originalProduction,numPeople.get(originalProduction)-1);
            if(numPeople.get(originalProduction) == 0) {
                numPeople.remove(originalProduction);
            }
            numPeople.put(updatedProduction,numPeople.getOrDefault(updatedProduction,0)+1);
            milkProduction.put(i.ID,updatedProduction);
            int updatedMax = numPeople.lastKey();
            if((originalProduction < originalMax && updatedProduction >= originalMax) ||
                    (originalProduction == originalMax && updatedProduction > originalMax && maxPeople > 1) ||
                    (originalProduction == originalMax && updatedProduction == updatedMax && numPeople.get(updatedMax) > 1) ||
                    (originalProduction == originalMax && updatedProduction < updatedMax)) {
                changes++;
            }
        }
        out.println(changes);
        f.close();
        out.close();
    }
}
