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
        ArrayList<String[]> lines = new ArrayList<>();
        String input;
        int maxLength = 0;
        while((input = f.readLine()) != null){
            String lineFormatted = input.trim().replaceAll(" +"," ");
            String[] words = lineFormatted.split(" ");
            maxLength = Math.max(maxLength,words.length);
            lines.add(words);
        }
        int[] indexes = new int[maxLength];
        for(int i = 0; i < indexes.length; i++){
            int max = 0;
            for(String[] j: lines){
                if(i < j.length && j[i].length() > max){
                    max = j[i].length();
                }
            }
            indexes[i] = max+1;
        }
        for(String[] i: lines){
            StringBuilder res = new StringBuilder();
            for(int j = 0; j < i.length; j++){
                if(j < i.length-1) {
                    res.append(String.format("%1$-" + indexes[j] + "s", i[j]));
                } else {
                    res.append(i[j]);
                }
            }
            out.println(res);
        }
        f.close();
        out.close();
    }
}
