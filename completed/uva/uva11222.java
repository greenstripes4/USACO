import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = f.nextInt();
        for(int i = 0; i < T; i++){
            TreeSet<Integer> p1 = new TreeSet<>();
            TreeSet<Integer> p2 = new TreeSet<>();
            TreeSet<Integer> p3 = new TreeSet<>();
            p1.add(10001);
            p2.add(10002);
            p3.add(10003);
            int problemsSolved1 = f.nextInt();
            for(int j = 0; j < problemsSolved1; j++){
                p1.add(f.nextInt());
            }
            int problemsSolved2 = f.nextInt();
            for(int j = 0; j < problemsSolved2; j++){
                p2.add(f.nextInt());
            }
            int problemsSolved3 = f.nextInt();
            for(int j = 0; j < problemsSolved3; j++){
                p3.add(f.nextInt());
            }
            ArrayList<Integer> duplicates = new ArrayList<>();
            for(int j: p1){
                if(p2.contains(j) || p3.contains(j)){
                    duplicates.add(j);
                }
            }
            for(int j: p2){
                if(p1.contains(j) || p3.contains(j)){
                    duplicates.add(j);
                }
            }
            for(int j: p3){
                if(p1.contains(j) || p2.contains(j)){
                    duplicates.add(j);
                }
            }
            for(int j: duplicates){
                p1.remove(j);
                p2.remove(j);
                p3.remove(j);
            }
            ArrayList<TreeSet<Integer>> allProblems = new ArrayList<>();
            allProblems.add(p1);
            allProblems.add(p2);
            allProblems.add(p3);
            Collections.sort(allProblems, new Comparator<TreeSet<Integer>>() {
                @Override
                public int compare(TreeSet<Integer> integers, TreeSet<Integer> t1) {
                    if(integers.size() == t1.size()){
                        return integers.last()-t1.last();
                    }
                    return t1.size()-integers.size();
                }
            });
            out.println("Case #" + (i+1) + ":");
            int best = allProblems.get(0).size();
            int ind = 0;
            while(ind < 3 && allProblems.get(ind).size() == best){
                out.print(allProblems.get(ind).last()-10000 + " " + (allProblems.get(ind).size()-1));
                int sentinel = allProblems.get(ind).last();
                for(int j: allProblems.get(ind)){
                    if(j == sentinel){
                        break;
                    }
                    out.print(" " + j);
                }
                out.println();
                ind++;
            }
        }
        f.close();
        out.close();
    }
}
