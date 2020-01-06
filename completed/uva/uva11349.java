/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        HashMap<String,Integer> map = new HashMap<>();
        String[] letters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        int ind = 1;
        Queue<String> queue = new LinkedList<>();
        for(String i: letters){
            queue.add(i);
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String next = queue.poll();
                map.put(next,ind);
                ind++;
                if(next.length() < 5){
                    for(int ascii = next.charAt(next.length()-1) + 1; ascii <= 'z'; ascii++){
                        queue.add(next + (char) ascii);
                    }
                }
            }
        }
        String input;
        while((input = f.readLine()) != null){
            if(map.containsKey(input)) {
                out.println(map.get(input));
            } else {
                out.println(0);
            }
        }
        f.close();
        out.close();
    }
}
