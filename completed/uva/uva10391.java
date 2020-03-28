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
        ArrayList<String> words = new ArrayList<>();
        HashSet<String> quickSearch = new HashSet<>();
        String word;
        while((word = f.readLine()) != null){
            words.add(word);
            quickSearch.add(word);
        }
        Collections.sort(words);
        ArrayList<String> printed = new ArrayList<>();
        HashSet<String> printedQuickSearch = new HashSet<>();
        for(String i: words){
            for(int j = 0; j < i.length(); j++){
                String w1 = i.substring(0,j);
                String w2 = i.substring(j);
                if(quickSearch.contains(w1) && quickSearch.contains(w2) && !printedQuickSearch.contains(i)){
                    printed.add(i);
                    printedQuickSearch.add(i);
                }
            }
        }
        for(String i: printed){
            out.println(i);
        }
        f.close();
        out.close();
    }
}
