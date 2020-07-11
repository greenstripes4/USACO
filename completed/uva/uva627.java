import sun.reflect.generics.tree.Tree;

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
            out.println("-----");
            int n = Integer.parseInt(input);
            HashMap<Integer,TreeSet<Integer>> visible = new HashMap<>();
            for(int i = 0; i < n; i++) {
                String[] source = f.readLine().split("-");
                if(source.length == 2) {
                    String[] destinations = source[1].split(",");
                    int routerId = Integer.parseInt(source[0]);
                    visible.put(routerId, new TreeSet<>());
                    for (String j : destinations) {
                        visible.get(routerId).add(Integer.parseInt(j));
                    }
                }
            }
            int m = Integer.parseInt(f.readLine());
            for(int i = 0; i < m; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                Queue<Integer> queue = new LinkedList<>();
                queue.add(start);
                HashMap<Integer,Integer> traceBack = new HashMap<>();
                boolean found = false;
                while(!queue.isEmpty()) {
                    int size = queue.size();
                    for(int j = 0; j < size; j++) {
                        int temp = queue.poll();
                        if(temp == end) {
                            found = true;
                            break;
                        }
                        if(visible.containsKey(temp)) {
                            for (int k : visible.get(temp)) {
                                if (!traceBack.containsKey(k)) {
                                    queue.add(k);
                                    traceBack.put(k, temp);
                                }
                            }
                        }
                    }
                    if(found) {
                        break;
                    }
                }
                if(found) {
                    ArrayList<Integer> ans = new ArrayList<>();
                    ans.add(end);
                    while(!traceBack.get(end).equals(start)) {
                        end = traceBack.get(end);
                        ans.add(end);
                    }
                    ans.add(start);
                    Collections.reverse(ans);
                    out.print(ans.get(0));
                    for(int j = 1; j < ans.size(); j++) {
                        out.print(" " + ans.get(j));
                    }
                    out.println();
                } else {
                    out.println("connection impossible");
                }
            }
        }
        f.close();
        out.close();
    }
}
