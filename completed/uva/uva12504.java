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
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        int T = Integer.parseInt(f.readLine());
        for(int i = 0; i < T; i++){
            String first = f.readLine();
            String second = f.readLine();
            String[] keyValuesFirst = first.substring(1,first.length()-1).split(",");
            String[] keyValuesSecond = second.substring(1,second.length()-1).split(",");
            HashMap<String,String> map1 = new HashMap<>();
            HashMap<String,String> map2 = new HashMap<>();
            for(String j: keyValuesFirst){
                String[] entry = j.split(":");
                if(entry.length == 2) {
                    map1.put(entry[0], entry[1]);
                }
            }
            for(String j: keyValuesSecond){
                String[] entry = j.split(":");
                if(entry.length == 2) {
                    map2.put(entry[0], entry[1]);
                }
            }
            ArrayList<String> added = new ArrayList<>();
            ArrayList<String> removed = new ArrayList<>();
            ArrayList<String> changed = new ArrayList<>();
            for(String j: map2.keySet()){
                if(map1.containsKey(j)){
                    if(!map1.get(j).equals(map2.get(j))){
                        changed.add(j);
                    }
                } else {
                    added.add(j);
                }
            }
            for(String j: map1.keySet()){
                if(!map2.containsKey(j)){
                    removed.add(j);
                }
            }
            Collections.sort(added);
            Collections.sort(removed);
            Collections.sort(changed);
            if(added.size() == 0 && removed.size() == 0 && changed.size() == 0){
                out.println("No changes");
            } else {
                if(added.size() > 0){
                    out.print("+");
                    for(int j = 0; j < added.size(); j++){
                        if(j > 0){
                            out.print(",");
                        }
                        out.print(added.get(j));
                    }
                    out.println();
                }
                if(removed.size() > 0){
                    out.print("-");
                    for(int j = 0; j < removed.size(); j++){
                        if(j > 0){
                            out.print(",");
                        }
                        out.print(removed.get(j));
                    }
                    out.println();
                }
                if(changed.size() > 0){
                    out.print("*");
                    for(int j = 0; j < changed.size(); j++){
                        if(j > 0){
                            out.print(",");
                        }
                        out.print(changed.get(j));
                    }
                    out.println();
                }
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
