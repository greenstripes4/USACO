import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int i = 0; i < T; i++){
            HashMap<Integer,Integer> firstList = new HashMap<>();
            HashMap<Integer,Integer> secondList = new HashMap<>();
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            StringTokenizer list1 = new StringTokenizer(f.readLine());
            for(int j = 0; j < N; j++){
                int val = Integer.parseInt(list1.nextToken());
                firstList.put(val,firstList.getOrDefault(val,0)+1);
            }
            StringTokenizer list2 = new StringTokenizer(f.readLine());
            for(int j = 0; j < M; j++){
                int val = Integer.parseInt(list2.nextToken());
                secondList.put(val,secondList.getOrDefault(val,0)+1);
            }
            int removals = 0;
            for(int j: firstList.keySet()){
                removals += Math.abs(secondList.getOrDefault(j,0)-firstList.get(j));
                secondList.remove(j);
            }
            for(int j: secondList.keySet()){
                removals += Math.abs(firstList.getOrDefault(j,0)-secondList.get(j));
            }
            out.println(removals);
        }
        f.close();
        out.close();
    }
}
