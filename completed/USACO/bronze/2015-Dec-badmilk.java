import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("badmilk.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("badmilk.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        HashMap<Integer,ArrayList<int[]>> milksDrank = new HashMap<>();
        for(int i = 0; i < D; i++){
            StringTokenizer drinking = new StringTokenizer(f.readLine());
            int p = Integer.parseInt(drinking.nextToken());
            int m = Integer.parseInt(drinking.nextToken());
            int t = Integer.parseInt(drinking.nextToken());
            if(milksDrank.containsKey(p)){
                ArrayList<int[]> milks = milksDrank.get(p);
                milks.add(new int[]{m,t});
            } else {
                ArrayList<int[]> milks = new ArrayList<>();
                milks.add(new int[]{m,t});
                milksDrank.put(p,milks);
            }
        }
        ArrayList<Integer> possibleMilks = new ArrayList<>();
        for(int j = 0; j < S; j++){
            StringTokenizer sick = new StringTokenizer(f.readLine());
            int p = Integer.parseInt(sick.nextToken());
            int t = Integer.parseInt(sick.nextToken());
            ArrayList<int[]> person = milksDrank.get(p);
            for(int[] k: person){
                if(k[1] < t){
                    possibleMilks.add(k[0]);
                }
            }
        }
        int doses = 0;
        for(int l: possibleMilks){
            int count = 0;
            int currentDoses = 0;
            for(int m: possibleMilks){
                if(m == l){
                    count++;
                }
            }
            if(count >= S) {
                for(int n : milksDrank.keySet()) {
                    ArrayList<int[]> drank = milksDrank.get(n);
                    for(int[] o: drank){
                        if(o[0] == l){
                            currentDoses++;
                            break;
                        }
                    }
                }
                if(currentDoses > doses){
                    doses = currentDoses;
                }
            }
        }
        out.println(doses);
        out.close();
        f.close();
    }
}
