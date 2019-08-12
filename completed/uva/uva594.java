import java.io.*;
/*
O(1);
123456789
-123456789
1
16777216
20034556
0
*/
public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1")));
        String input;
        while((input = f.readLine()) != null){
            int value = Integer.parseInt(input);
            int original = value;
            int byte1 = value&255;
            value >>= 8;
            int byte2 = value&255;
            value >>= 8;
            int byte3 = value&255;
            value >>= 8;
            int byte4 = value&255;
            int newValue = byte1;
            newValue <<= 8;
            newValue += byte2;
            newValue <<= 8;
            newValue += byte3;
            newValue <<= 8;
            newValue += byte4;
            System.out.println(original + " converts to " + newValue);
        }
        out.close();
        f.close();
    }
}
