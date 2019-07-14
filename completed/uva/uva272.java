import java.io.*;
//O(n)
//"To be or not to be," quoth the Bard, "that
//is the question".
//The programming contestant replied: "I must disagree.
//To `C' or not to `C', that is The Question!"
//
//""
//"
//'
//`

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        int quoteType = 0;
        while((input = f.readLine()) != null){
            char[] chars = input.toCharArray();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<chars.length; i++) {
                if (chars[i] != '"') {
                    sb.append(chars[i]);
                } else if (quoteType == 0) {
                    sb.append("``");
                    quoteType = 1;
                } else {
                    sb.append("''");
                    quoteType = 0;
                }
            }
            System.out.println(sb.toString());
        }
    }
}
