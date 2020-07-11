import java.io.*;
import java.util.*;

class Job implements Comparable<Job>{
    int ind;
    int T;
    int S;
    public Job(int ind, int T, int S){
        this.ind = ind;
        this.T = T;
        this.S = S;
    }
    @Override
    public int compareTo(Job o){
        if(T*o.S - o.T*S == 0){
            return ind - o.ind;
        }
        return T*o.S - o.T*S;
    }
}

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        for(int t = 0; t < testcases; t++){
            if(t > 0){
                out.println();
            }
            f.readLine();
            int N = Integer.parseInt(f.readLine());
            Job[] jobs = new Job[N];
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(f.readLine());
                int T = Integer.parseInt(st.nextToken());
                int S = Integer.parseInt(st.nextToken());
                jobs[i] = new Job(i+1,T,S);
            }
            Arrays.sort(jobs);
            out.print(jobs[0].ind);
            for(int i = 1; i < jobs.length; i++){
                out.print(" " + jobs[i].ind);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
