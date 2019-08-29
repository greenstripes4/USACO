import java.io.*;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
O(n)
Register 2004 200
Register 2005 300
#
5
 */

class Pair implements Comparable<Pair>{
    public int id;
    public int time;
    public Pair(int id, int time){
        this.id = id;
        this.time = time;
    }
    public int compareTo(Pair o){
        if(this.time == o.time){
            return (this.id > o.id) ? 1:-1;
        }
        return (this.time > o.time) ? 1:-1;
    }
}
public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        HashMap<Integer,Integer> periods = new HashMap<>();
        PriorityQueue<Pair> returns = new PriorityQueue<>();
        String input;
        while(!((input = f.readLine()).equals("#"))){
            StringTokenizer st = new StringTokenizer(input);
            st.nextToken();
            int id = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            periods.put(id,p);
            returns.add(new Pair(id,p));
        }
        int k = Integer.parseInt(f.readLine());
        for(int i = 0; i < k; i++){
            Pair next = returns.poll();
            out.println(next.id);
            next.time += periods.get(next.id);
            returns.add(next);
        }
        f.close();
        out.close();
    }
}
