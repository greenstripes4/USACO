/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("loan.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        Scanner f = new Scanner(System.in);
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int caseNumber = 0;
        while(true){
            int NC = f.nextInt();
            if(NC == 0){
                break;
            }
            HashMap<Integer,HashSet<Integer>> connections = new HashMap<>();
            HashSet<Integer> nodes = new HashSet<>();
            for(int i = 0; i < NC; i++){
                int a = f.nextInt();
                int b = f.nextInt();
                nodes.add(a);
                nodes.add(b);
                if(connections.containsKey(a)){
                    connections.get(a).add(b);
                } else {
                    HashSet<Integer> temp = new HashSet<>();
                    temp.add(b);
                    connections.put(a,temp);
                }
                if(connections.containsKey(b)){
                    connections.get(b).add(a);
                } else {
                    HashSet<Integer> temp = new HashSet<>();
                    temp.add(a);
                    connections.put(b,temp);
                }
            }
            while(true){
                int root = f.nextInt();
                int TTL = f.nextInt();
                int temp = TTL;
                if(root == 0 && TTL == 0){
                    break;
                }
                caseNumber++;
                Queue<Integer> queue = new LinkedList<>();
                HashSet<Integer> visited = new HashSet<>();
                queue.add(root);
                visited.add(root);
                boolean rootInNodes = true;
                if(!nodes.contains(root)){
                    rootInNodes = false;
                    nodes.add(root);
                }
                while(TTL > 0 && !queue.isEmpty()){
                    int size = queue.size();
                    for(int i = 0; i < size; i++){
                        int next = queue.poll();
                        if(connections.containsKey(next)) {
                            for (int j : connections.get(next)) {
                                if (!visited.contains(j)) {
                                    queue.add(j);
                                    visited.add(j);
                                }
                            }
                        }
                    }
                    TTL--;
                }
                out.println("Case " + caseNumber + ": " + (nodes.size()-visited.size()) + " nodes not reachable from node " + root + " with TTL = " + temp + ".");
                if(!rootInNodes){
                    nodes.remove(root);
                }
            }
        }
        f.close();
        out.close();
        //out.close();
        //f.close();
    }
}
