
import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
/*
O(n)
dog ogday
cat atcay
pig igpay
froot ootfray
loops oopslay
atcay
ittenkay
oopslay
*/

public class Main{
    public static void main(String[] args) throws Exception {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1")));
        HashMap<String,String> dictionary = new HashMap<>();
        String translation;
        while((translation = f.readLine()) != null){
            if(translation.equals("")){
                break;
            }
            StringTokenizer st = new StringTokenizer(translation);
            String english = st.nextToken();
            String foreign = st.nextToken();
            dictionary.put(foreign,english);
        }
        String word;
        while((word = f.readLine()) != null){
            if(dictionary.containsKey(word)){
                out.println(dictionary.get(word));
            } else {
                out.println("eh");
            }
        }
        f.close();
        out.close();
    }
}
