import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
//O(1)
//HELLO
//HOLA
//HALLO
//BONJOUR
//CIAO
//ZDRAVSTVUJTE
//PJSDKJFHIU
//#


public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        String input;
        HashMap<String,String> langs = new HashMap();
        langs.put("HELLO", "ENGLISH");
        langs.put("HOLA", "SPANISH");
        langs.put("HALLO", "GERMAN");
        langs.put("BONJOUR", "FRENCH");
        langs.put("CIAO", "ITALIAN");
        langs.put("ZDRAVSTVUJTE", "RUSSIAN");
        int casenum = 1;
        while(!((input = f.readLine()).equals("#"))){
            System.out.println("Case " + casenum + ": " + langs.containsKey(input) ? langs.get(input):"UNKNOWN");
            casenum++;
        }
    }
}
