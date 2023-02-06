/*
ID: strongh2
LANG: JAVA
PROG: namenum
TASK: namenum
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class namenum {
    public static void main(String[] args)throws IOException{
        BufferedReader dict = new BufferedReader(new FileReader("dict.txt"));
        BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        HashMap<Character,Character> map = new HashMap<>();
        map.put('A','2');
        map.put('B','2');
        map.put('C','2');
        map.put('D','3');
        map.put('E','3');
        map.put('F','3');
        map.put('G','4');
        map.put('H','4');
        map.put('I','4');
        map.put('J','5');
        map.put('K','5');
        map.put('L','5');
        map.put('M','6');
        map.put('N','6');
        map.put('O','6');
        map.put('P','7');
        map.put('Q',' ');
        map.put('R','7');
        map.put('S','7');
        map.put('T','8');
        map.put('U','8');
        map.put('V','8');
        map.put('W','9');
        map.put('X','9');
        map.put('Y','9');
        map.put('Z',' ');
        String input;
        char[] id = f.readLine().toCharArray();
        boolean yes = false;
        while((input = dict.readLine()) != null){
            char[] word = input.toCharArray();
            if(word.length != id.length){
                continue;
            }
            boolean equals = true;
            for(int i = 0; i < word.length; i++){
                if(map.get(word[i]) != id[i]){
                    equals = false;
                    break;
                }
            }
            if(equals){
                out.println(word);
                yes = true;
            }
        }
        if(!yes){
            out.println("NONE");
        }
        dict.close();
        f.close();
        out.close();
    }
}
