import java.io.*;
import java.util.*;

class Elephant implements Comparable<Elephant> {
    int weight;
    int IQ;
    Elephant(int weight, int IQ) {
        this.weight = weight;
        this.IQ = IQ;
    }
    @Override
    public int compareTo(Elephant o) {
        return this.weight > o.weight && this.IQ < o.IQ ? 1 : this.weight < o.weight && this.IQ > o.IQ ? -1 : 0;
    }
}
public class Main {
    private static void printTraceBack(int[] map, int[] traceBack, int index, PrintWriter out) {
        if(index == -1) {
            return;
        }
        printTraceBack(map,traceBack,traceBack[index],out);
        out.println(map[index]+1);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        ArrayList<Elephant> elephants = new ArrayList<>();
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int weight = Integer.parseInt(st.nextToken());
            int IQ = Integer.parseInt(st.nextToken());
            Elephant temp = new Elephant(weight, IQ);
            elephants.add(temp);
        }
        ArrayList<Elephant> unsorted = new ArrayList<>(elephants);
        Collections.sort(elephants, new Comparator<Elephant>() {
            @Override
            public int compare(Elephant elephant, Elephant t1) {
                if(elephant.weight == t1.weight) {
                    return t1.IQ-elephant.IQ;
                }
                return elephant.weight-t1.weight;
            }
        });
        int[] map = new int[elephants.size()];
        for(int i = 0; i < elephants.size(); i++) {
            for(int j = 0; j < unsorted.size(); j++) {
                if(elephants.get(i) == unsorted.get(j)) {
                    map[i] = j;
                    break;
                }
            }
        }
        int[] dp = new int[elephants.size()];
        int[] traceBack = new int[elephants.size()];
        int LIS = 0;
        for(int i = 0; i < elephants.size(); i++) {
            dp[i] = 1;
            traceBack[i] = -1;
            for(int j = 0; j < i; j++) {
                if(elephants.get(i).compareTo(elephants.get(j)) > 0 && dp[j]+1 > dp[i]) {
                    dp[i] = dp[j]+1;
                    traceBack[i] = j;
                }
            }
            LIS = Math.max(LIS,dp[i]);
        }
        out.println(LIS);
        int index = -1;
        for(int i = elephants.size()-1; i >= 0; i--) {
            if(dp[i] == LIS) {
                index = i;
                break;
            }
        }
        printTraceBack(map,traceBack,index,out);
        f.close();
        out.close();
    }
}
