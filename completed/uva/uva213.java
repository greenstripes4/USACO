/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.io.*;
import java.util.*;

public class Main{
    //static BufferedReader f;
    //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static ArrayList<Character> buffer = new ArrayList<>();
    static int ind = 0;
    public static String read(int count) throws IOException{
        StringBuilder sb = new StringBuilder();
        while(count > 0){
            if(ind >= buffer.size()){
                char[] add = f.readLine().toCharArray();
                for(char i: add){
                    buffer.add(i);
                }
            } else {
                sb.append(buffer.get(ind));
                ind++;
                count--;
            }
        }
        return sb.toString();
    }
    public static String nextCode(String cur){
        int l = cur.length();
        int rep = 0;
        for(char i: cur.toCharArray()){
            rep = Character.getNumericValue(i) | (rep << 1);
        }
        rep++;
        if((1<<l)-1 != rep){
            return String.format("%0"+l+"d",Integer.parseInt(Integer.toBinaryString(rep)));
        } else {
            return String.format("%0"+(l+1)+"d",0);
        }
    }
    public static void main(String[] args) throws IOException {
        //f = new BufferedReader(new FileReader("uva.in"));
        String t;
        while((t = f.readLine()) != null){
            char[] arr = t.toCharArray();
            String code = "0";
            HashMap<String,Character> map = new HashMap<>();
            for(char i: arr){
                map.put(code,i);
                code = nextCode(code);
            }
            StringBuilder sb = new StringBuilder();
            String next;
            while(!(next = read(3)).equals("000")){
                int l = 0;
                for(char i: next.toCharArray()){
                    l = Character.getNumericValue(i) | (l << 1);
                }
                String target = Integer.toBinaryString((1<<l)-1);
                String encode;
                while(!(encode = read(l)).equals(target)){
                    sb.append(map.get(encode));
                }
            }
            out.println(sb.toString());
        }
        out.close();
        f.close();
    }
}
