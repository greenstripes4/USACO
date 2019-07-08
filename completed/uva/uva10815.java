import java.io.*;
import java.util.TreeSet;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        TreeSet<String> s = new TreeSet<>();
        while((input = f.readLine()) != null){
            StringTokenizer st = new StringTokenizer(input);
            while(st.hasMoreTokens()){
                StringBuilder w = new StringBuilder();
                char[] word = st.nextToken().toLowerCase().toCharArray();
                for(char i: word){
                    if((int) i >= (int) 'a' && (int) i <= (int) 'z'){
                        w.append(i);
                    } else {
                        if(w.length() != 0) {
                            s.add(w.toString());
                        }
                        w = new StringBuilder();
                    }
                }
                if(w.length() != 0) {
                    s.add(w.toString());
                }
            }
        }
        for(String i: s){
            System.out.println(i);
        }
    }
}
