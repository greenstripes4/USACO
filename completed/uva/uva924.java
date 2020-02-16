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
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int E = Integer.parseInt(f.readLine());
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < E; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int friends = Integer.parseInt(st.nextToken());
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 0; j < friends; j++){
                temp.add(Integer.parseInt(st.nextToken()));
            }
            map.put(i,temp);
        }
        int testCases = Integer.parseInt(f.readLine());
        for(int i = 0; i < testCases; i++){
            int source = Integer.parseInt(f.readLine());
            Queue<Integer> queue = new LinkedList<>();
            HashSet<Integer> seen = new HashSet<>();
            queue.add(source);
            seen.add(source);
            int maxBoomSize = 0;
            int firstBoomDay = 0;
            int layers = 0;
            while(!queue.isEmpty()){
                layers++;
                int size = queue.size();
                for(int j = 0; j < size; j++){
                    int temp = queue.poll();
                    ArrayList<Integer> friends = map.get(temp);
                    for(int k: friends){
                        if(!seen.contains(k)){
                            queue.add(k);
                            seen.add(k);
                        }
                    }
                }
                size = queue.size();
                if(size > maxBoomSize){
                    maxBoomSize = size;
                    firstBoomDay = layers;
                }
            }
            if(layers == 1){
                out.println(0);
            } else {
                out.println(maxBoomSize + " " + firstBoomDay);
            }
        }
        out.close();
        f.close();
    }
}