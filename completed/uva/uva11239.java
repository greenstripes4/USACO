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
        while(true){
            HashMap<String,String> map = new HashMap<>();
            HashSet<String> allProjects = new HashSet<>();
            HashSet<String> avoid = new HashSet<>();
            String input;
            String curTopic = null;
            while(!(input = f.readLine()).equals("1") && !input.equals("0")){
                String temp = input.toUpperCase();
                if(temp.equals(input)){
                    curTopic = input;
                    allProjects.add(curTopic);
                } else {
                    if(!map.getOrDefault(input,curTopic).equals(curTopic)){
                        avoid.add(input);
                        map.remove(input);
                    } else if(!avoid.contains(input)) {
                        map.put(input,curTopic);
                    }
                }
            }
            allProjects.add(curTopic);
            if(input.equals("0")) {
                break;
            }
            HashMap<String,Integer> tally = new HashMap<>();
            for(String topic: allProjects){
                tally.put(topic,0);
            }
            for(String i: map.keySet()){
                tally.put(map.get(i),tally.get(map.get(i))+1);
            }
            String[][] arr = new String[tally.size()][2];
            int ind = 0;
            for(String i: tally.keySet()){
                arr[ind][0] = i;
                arr[ind][1] = Integer.toString(tally.get(i));
                ind++;
            }
            Arrays.sort(arr, new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    if(Integer.parseInt(o1[1]) == Integer.parseInt(o2[1])){
                        return o1[0].compareTo(o2[0]);
                    }
                    return Integer.parseInt(o1[1]) > Integer.parseInt(o2[1]) ? -1:1;
                }
            });
            for(String[] i: arr){
                out.println(i[0] + " " + i[1]);
            }
        }
        out.close();
        f.close();
    }
}
