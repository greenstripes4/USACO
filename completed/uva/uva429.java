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
        int N = Integer.parseInt(f.readLine());
        f.readLine();
        for(int i = 0; i < N; i++){
            ArrayList<String> dict = new ArrayList<>();
            String word;
            while(!(word = f.readLine()).equals("*")){
                dict.add(word);
            }
            HashMap<String,ArrayList<String>> map = new HashMap<>();
            for(int j = 0; j < dict.size(); j++){
                for(int k = j+1; k < dict.size(); k++){
                    if(dict.get(j).length() == dict.get(k).length()){
                        int diff = 0;
                        char[] w1 = dict.get(j).toCharArray();
                        char[] w2 = dict.get(k).toCharArray();
                        for(int l = 0; l < w1.length; l++){
                            if(w1[l] != w2[l]){
                                diff++;
                            }
                        }
                        if(diff == 1){
                            if(map.containsKey(dict.get(j))){
                                map.get(dict.get(j)).add(dict.get(k));
                            } else {
                                ArrayList<String> temp = new ArrayList<>();
                                temp.add(dict.get(k));
                                map.put(dict.get(j),temp);
                            }
                            if(map.containsKey(dict.get(k))){
                                map.get(dict.get(k)).add(dict.get(j));
                            } else {
                                ArrayList<String> temp = new ArrayList<>();
                                temp.add(dict.get(j));
                                map.put(dict.get(k),temp);
                            }
                        }
                    }
                }
            }
            while(true) {
                String s = f.readLine();
                if(s==null || s.length() == 0){
                    break;
                }
                StringTokenizer st = new StringTokenizer(s);
                String root = st.nextToken();
                String targ = st.nextToken();
                HashSet<String> visited = new HashSet<>();
                int steps = 0;
                Queue<String> queue = new LinkedList<>();
                queue.add(root);
                boolean found = false;
                while(!queue.isEmpty()){
                    int size = queue.size();
                    for(int j = 0 ; j < size; j++) {
                        String temp = queue.poll();
                        if (temp.equals(targ)) {
                            found = true;
                            break;
                        }
                        for (String k : map.get(temp)) {
                            if (!visited.contains(k)) {
                                queue.add(k);
                                visited.add(k);
                            }
                        }
                    }
                    if(found){
                        break;
                    }
                    steps++;
                }
                out.println(root + " " + targ + " " + steps);
            }
            if(i != N-1){
                out.println();
            }
        }
        out.close();
        f.close();
    }
}