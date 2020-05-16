import java.io.*;
import java.util.*;

public class Main{
    private static ArrayList<String> allRoutes;
    private static void dfs(HashMap<Integer,ArrayList<Integer>> adjacent, HashSet<Integer> seen, String path, int cur, int tar, PrintWriter out){
        if(cur == tar){
            allRoutes.add(path);
            out.println(path);
            return;
        }
        for(int i: adjacent.get(cur)){
            if(!seen.contains(i)){
                seen.add(i);
                dfs(adjacent,seen,path+" "+i,i,tar,out);
                seen.remove(i);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testCase = 1;
        while(f.hasNext()){
            out.println("CASE " + testCase + ":");
            int target = f.nextInt();
            allRoutes = new ArrayList<>();
            HashMap<Integer,ArrayList<Integer>> adjacent = new HashMap<>();
            for(int i = 1; i < 21; i++){
                adjacent.put(i,new ArrayList<>());
            }
            while(true){
                int a = f.nextInt();
                int b = f.nextInt();
                if(a == 0 && b == 0){
                    break;
                }
                adjacent.get(a).add(b);
                adjacent.get(b).add(a);
            }
            HashSet<Integer> seen = new HashSet<>();
            seen.add(1);
            dfs(adjacent,seen,"1",1,target,out);
            out.println("There are " + allRoutes.size() + " routes from the firestation to streetcorner " + target + ".");
            testCase++;
        }
        f.close();
        out.close();
    }
}
