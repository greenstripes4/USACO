/*
ID: strongh2
LANG: JAVA
PROG: namenum
TASK: namenum
 */

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class namenum {
    public static String[] subArr(String[] arr, int start, int end){
        String[] sub = new String[end-start];
        int ind = 0;
        for(int i = start; i < end; i++){
            sub[ind] = arr[i];
            ind++;
        }
        return sub;
    }
    public static String[] allNames(String[] arr, HashMap<String,String[]> map){
        if(arr.length == 1){
            return map.get(arr[0]).clone();
        }
        String[] before = allNames(subArr(arr,0,arr.length-1),map);
        String[] after = map.get(arr[arr.length-1]).clone();
        String[] names = new String[before.length * after.length];
        int index=0;
        for(int i = 0; i < before.length; i++){
            for(int j = 0; j < after.length; j++){
                names[index++]= before[i] + after[j];
            }
        }
        return names;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader dict = new BufferedReader(new FileReader("dict.txt"));
        BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        HashMap<String,String[]> map = new HashMap<>();
        map.put("2",new String[]{"A","B","C"});
        map.put("3",new String[]{"D","E","F"});
        map.put("4",new String[]{"G","H","I"});
        map.put("5",new String[]{"J","K","L"});
        map.put("6",new String[]{"M","N","O"});
        map.put("7",new String[]{"P","R","S"});
        map.put("8",new String[]{"T","U","V"});
        map.put("9",new String[]{"W","X","Y"});
        String input;
        String[] id = f.readLine().split("");
        boolean yes = false;
        HashMap<String,String> words = new HashMap<>();
        while((input = dict.readLine()) != null){
            words.put(input,"");
        }
        String[] names = allNames(id,map);
        for(String i: names){
            if(words.containsKey(i)){
                out.println(i);
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
