/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */


import java.io.*;
import java.util.*;

public class Main{
    public static int getIndex(String command, HashMap<Character,int[]> map){
        if(command.contains("[") && command.contains("]")){
            char name = command.charAt(0);
            int nextInd = getIndex(command.substring(2,command.length()-1),map);
            if(!map.containsKey(name)){
                return -1;
            }
            if(nextInd < 0 || nextInd >= map.get(name).length){
                return -1;
            }
            return map.get(name)[nextInd];
        }
        return Integer.parseInt(command);
    }
    public static boolean check(String[] assignment, HashMap<Character,int[]> map){
        char name1 = assignment[0].charAt(0);
        int index1 = getIndex(assignment[0].substring(2,assignment[0].length()-1),map);
        if(assignment[1].contains("[") && assignment[1].contains("]")){
            char name2 = assignment[1].charAt(0);
            int index2 = getIndex(assignment[1].substring(2,assignment[1].length()-1),map);
            if(!map.containsKey(name1) || !map.containsKey(name2)){
                return false;
            }
            if(index1 < 0 || index2 < 0 || index1 >= map.get(name1).length || index2 >= map.get(name2).length){
                return false;
            }
            if(map.get(name2)[index2] == -1){
                return false;
            }
            map.get(name1)[index1] = map.get(name2)[index2];
        } else {
            if(!map.containsKey(name1)){
                return false;
            }
            if(index1 < 0 || index1 >= map.get(name1).length){
                return false;
            }
            map.get(name1)[index1] = Integer.parseInt(assignment[1]);
        }
        return true;
    }
    public static boolean isValidCommand(String command, HashMap<Character,int[]> map){
        String[] parts = command.split("=");
        if(parts.length == 1) {
            char name = parts[0].charAt(0);
            int size = Integer.parseInt(parts[0].substring(2,parts[0].length()-1));
            int[] temp = new int[size];
            Arrays.fill(temp,-1);
            map.put(name,temp);
            return true;
        }
        return check(parts,map);
    }
    public static void main(String[] args) throws IOException {
        //long start = System.nanoTime();
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        while(!(input = f.readLine()).equals(".")){
            HashMap<Character,int[]> map = new HashMap<>();
            boolean isValid = isValidCommand(input,map);
            int lineNumber = 1;
            String nextCommand;
            while(!(nextCommand = f.readLine()).equals(".") && isValid){
                lineNumber++;
                if(!isValidCommand(nextCommand,map)){
                    isValid = false;
                }
            }
            if(isValid){
                out.println(0);
            } else {
                out.println(lineNumber);
            }
        }
        f.close();
        //out.flush();
        //long end = System.nanoTime();
        //long ms = ((end - start) / 1000000);
        //out.println("Run for " + ms + "ms");
        out.close();
    }
}
