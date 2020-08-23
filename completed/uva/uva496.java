import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st1 = new StringTokenizer(input);
            HashSet<Integer> set1 = new HashSet<>();
            StringTokenizer st2 = new StringTokenizer(f.readLine());
            HashSet<Integer> set2 = new HashSet<>();
            while(st1.hasMoreTokens()) {
                set1.add(Integer.parseInt(st1.nextToken()));
            }
            while(st2.hasMoreTokens()) {
                set2.add(Integer.parseInt(st2.nextToken()));
            }
            if(set2.containsAll(set1) && set2.size() > set1.size()) {
                out.println("A is a proper subset of B");
            } else if(set1.containsAll(set2) && set1.size() > set2.size()) {
                out.println("B is a proper subset of A");
            } else if(set1.containsAll(set2)) {
                out.println("A equals B");
            } else {
                boolean disjoint = true;
                for(int i: set1) {
                    if(set2.contains(i)) {
                        disjoint = false;
                    }
                }
                out.println(disjoint ? "A and B are disjoint" : "I'm confused!");
            }
        }
        f.close();
        out.close();
    }
}
