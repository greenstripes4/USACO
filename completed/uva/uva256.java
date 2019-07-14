import java.io.*;
import java.util.Stack;
import java.util.TreeSet;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        while((input = f.readLine()) != null){
            int numDigits = Integer.parseInt(input);
            int max = 0;
            for(int i = 0; i < numDigits; i++){
                max *= 10;
                max += 9;
            }
            long time1 = System.nanoTime();
            long m = 1;
            for(int n = 0; n < numDigits/2; n++){
                m *= 10;
            }
            long b = 0;
            while(b*b <= max){
                long num = b*b;
                long p1 = num%m;
                long p2 = num / m;
                if(p1+p2 == b){
                    switch(numDigits){
                        case 2:
                            System.out.printf("%02d",num);
                            System.out.println();
                            break;
                        case 4:
                            System.out.printf("%04d",num);
                            System.out.println();
                            break;
                        case 6:
                            System.out.printf("%06d",num);
                            System.out.println();
                            break;
                        case 8:
                            System.out.printf("%08d",num);
                            System.out.println();
                            break;
                    }
                }
                b++;
            }
        }
        long time2 = System.nanoTime();
        System.out.println(time2-time1);
    }
}
