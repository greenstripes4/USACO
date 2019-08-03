import java.io.*;
import java.util.HashMap;
/*
O(n)
KHAWN
PFISTER
BOBBY
*/

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        HashMap<Character,String> map = new HashMap<>();
        map.put('B',"1");
        map.put('F',"1");
        map.put('P',"1");
        map.put('V',"1");
        map.put('C',"2");
        map.put('G',"2");
        map.put('J',"2");
        map.put('K',"2");
        map.put('Q',"2");
        map.put('S',"2");
        map.put('X',"2");
        map.put('Z',"2");
        map.put('D',"3");
        map.put('T',"3");
        map.put('L',"4");
        map.put('M',"5");
        map.put('N',"5");
        map.put('R',"6");
        while((input = f.readLine()) != null){
            char[] letters = input.toCharArray();
            StringBuilder code = new StringBuilder();
            String prev = "-1";
            for(char j: letters){
                if(map.containsKey(j) && !(map.get(j).equals(prev))){
                    code.append(map.get(j));
                }
                prev = (map.containsKey(j)) ? map.get(j) : "-1";
            }
            System.out.println(code);
        }
    }
}
