import java.io.*;
import java.math.BigInteger;
/*
O(n)
6
7
13
1
2147483647
0
*/
public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1")));
        String input;
        while(!((input = f.readLine()).equals("0"))){
            int n = Integer.parseInt(input);
            char[] binRep = Integer.toBinaryString(n).toCharArray();
            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();
            int count = 0;
            for(int j = 0; j < 32; j++){
                if(j < binRep.length) {
                    int index = binRep.length - j - 1;
                    if (binRep[index] == '1') {
                        if (count % 2 == 0) {
                            a.append('1');
                            b.append('0');
                        } else {
                            b.append('1');
                            a.append('0');
                        }
                        count++;
                    } else {
                        a.append('0');
                        b.append('0');
                    }
                } else {
                    a.append('0');
                    b.append('0');
                }
            }
            a = a.reverse();
            b = b.reverse();
            //out.println(binConverter(new BigInteger(a.toString())) + " " + binConverter(new BigInteger(b.toString())));
            out.println(Integer.parseInt(a.toString(), 2) + " " + Integer.parseInt(b.toString(), 2));
        }
        out.close();
        f.close();
    }
}
