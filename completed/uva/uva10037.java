import java.io.*;
import java.util.*;

public class Main{
    private static ArrayList<int[]> ans;
    private static int time;
    private static void solve(int[] people){
        if(people.length == 1) {
            ans.add(new int[]{people[0]});
            time += people[0];
        } else if(people.length == 2) {
            ans.add(new int[]{people[0],people[1]});
            time += Math.max(people[0],people[1]);
        } else if(people.length == 3) {
            ans.add(new int[]{people[0],people[1]});
            ans.add(new int[]{people[0]});
            ans.add(new int[]{people[0],people[2]});
            time += people[0]+people[1]+people[2];
        } else {
            if(people[1] + people[1] < people[0] + people[people.length-2]) {
                ans.add(new int[]{people[0],people[1]});
                ans.add(new int[]{people[1]});
                ans.add(new int[]{people[people.length-1],people[people.length-2]});
                ans.add(new int[]{people[0]});
                time += people[0]+people[1]+people[1]+people[people.length-1];
            } else {
                ans.add(new int[]{people[0],people[people.length-1]});
                ans.add(new int[]{people[0]});
                ans.add(new int[]{people[0],people[people.length-2]});
                ans.add(new int[]{people[0]});
                time += people[0]+people[0]+people[people.length-2]+people[people.length-1];
            }
            solve(Arrays.copyOfRange(people,0,people.length-2));
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = f.nextInt();
        for(int t = 0; t < testcases; t++){
            if(t > 0) {
                out.println();
            }
            ans = new ArrayList<>();
            time = 0;
            int n = f.nextInt();
            int[] people = new int[n];
            for(int i = 0; i < n; i++){
                people[i] = f.nextInt();
            }
            Arrays.sort(people);
            solve(people);
            out.println(time);
            for(int[] i: ans){
                out.print(i[0]);
                for(int j = 1; j < i.length; j++){
                    out.print(" " + i[j]);
                }
                out.println();
            }
        }
        f.close();
        out.close();
    }
}
