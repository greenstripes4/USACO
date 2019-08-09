import java.io.*;
import java.util.*;
//O(n)
//1
//
//12
//4873279
//ITS-EASY
//888-4567
//3-10-10-10
//888-GLOP
//TUT-GLOP
//967-11-11
//310-GINO
//F101010
//888-1200
//-4-8-7-3-2-7-9-
//487-3279


public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(f.readLine());
        boolean first = true;
        HashMap<Character, Integer> mapping = new HashMap<>();
        mapping.put('A',2);
        mapping.put('B',2);
        mapping.put('C',2);
        mapping.put('D',3);
        mapping.put('E',3);
        mapping.put('F',3);
        mapping.put('G',4);
        mapping.put('H',4);
        mapping.put('I',4);
        mapping.put('J',5);
        mapping.put('K',5);
        mapping.put('L',5);
        mapping.put('M',6);
        mapping.put('N',6);
        mapping.put('O',6);
        mapping.put('P',7);
        mapping.put('R',7);
        mapping.put('S',7);
        mapping.put('T',8);
        mapping.put('U',8);
        mapping.put('V',8);
        mapping.put('W',9);
        mapping.put('X',9);
        mapping.put('Y',9);
        for(int i = 0; i < testCases; i++){
            if(!first){
                System.out.println();
            }
            else{
                first = false;
            }
            f.readLine();
            int numNumbers = Integer.parseInt(f.readLine());
            TreeMap<String, Integer> numAppearances = new TreeMap<>();
            for(int j = 0; j < numNumbers; j++){
                char[] number = f.readLine().replaceAll("[^a-zA-Z0-9]", "").toCharArray();
                StringBuilder sb = new StringBuilder();
                for(int k = 0; k < 7; k++){
                    if(k == 3){
                        sb.append('-');
                    }
                    if(mapping.containsKey(number[k])){
                        sb.append(mapping.get(number[k]));
                    }
                    else{
                        sb.append(number[k]);
                    }
                }
                if(numAppearances.containsKey(sb.toString())){
                    int original = numAppearances.get(sb.toString());
                    numAppearances.put(sb.toString(), original + 1);
                }
                else{
                    numAppearances.put(sb.toString(), 1);
                }
            }
            boolean duplicate = false;
            for(String n: numAppearances.keySet()){
                if(numAppearances.get(n) > 1){
                    System.out.println(n + " " + numAppearances.get(n));
                    duplicate = true;
                }
            }
            if(!duplicate){
                System.out.println("No duplicates.");
            }
        }
    }
}
