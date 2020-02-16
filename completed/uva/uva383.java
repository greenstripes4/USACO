/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import javax.print.DocFlavor;
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("loan.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int datasets = Integer.parseInt(f.readLine());
        out.println("SHIPPING ROUTES OUTPUT");
        out.println();
        for(int i = 0; i < datasets; i++) {
            out.println("DATA SET  " + (i+1));
            out.println();
            StringTokenizer st = new StringTokenizer(f.readLine());
            int warehouses = Integer.parseInt(st.nextToken());
            int connections = Integer.parseInt(st.nextToken());
            int queries = Integer.parseInt(st.nextToken());
            HashMap<String,HashSet<String>> map = new HashMap<>();
            StringTokenizer st2 = new StringTokenizer(f.readLine());
            for(int j = 0; j < warehouses; j++){
                map.put(st2.nextToken(),new HashSet<>());
            }
            for(int j = 0; j < connections; j++){
                StringTokenizer st3 = new StringTokenizer(f.readLine());
                String a = st3.nextToken();
                String b = st3.nextToken();
                map.get(a).add(b);
                map.get(b).add(a);
            }
            for(int j = 0; j < queries; j++){
                StringTokenizer st4 = new StringTokenizer(f.readLine());
                int size = Integer.parseInt(st4.nextToken());
                String root = st4.nextToken();
                String dest = st4.nextToken();
                Queue<String> queue = new LinkedList<>();
                HashSet<String> visited = new HashSet<>();
                queue.add(root);
                visited.add(root);
                int legs = 0;
                boolean found = false;
                while(!queue.isEmpty()){
                    int s = queue.size();
                    for(int k = 0; k < s; k++){
                        String temp = queue.poll();
                        if(temp.equals(dest)){
                            found = true;
                            break;
                        }
                        for(String neighbor: map.get(temp)){
                            if(!visited.contains(neighbor)){
                                queue.add(neighbor);
                                visited.add(neighbor);
                            }
                        }
                    }
                    if(found){
                        break;
                    }
                    legs++;
                }
                if(found){
                    out.println("$" + (size*legs*100));
                } else {
                    out.println("NO SHIPMENT POSSIBLE");
                }
            }
            out.println();
        }
        out.println("END OF OUTPUT");
        out.close();
        f.close();
    }
}
