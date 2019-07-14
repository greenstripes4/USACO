import java.io.*;
import java.util.StringTokenizer;
//O(1)
//0 30 0 30
//5 35 5 35
//0 20 0 20
//7 27 7 27
//0 10 0 10
//9 19 9 19
//0 1 0 0
//39 39 39 39
//0 39 0 39
//39 0 39 0
//30 5 30 5
//30 5 5 30
//5 30 5 30
// 0 0 0 0



public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while(!(input = f.readLine()).equals("0 0 0 0")){
            StringTokenizer st = new StringTokenizer(input);
            int pos = Integer.parseInt(st.nextToken());
            int com1 = Integer.parseInt(st.nextToken());
            int com2 = Integer.parseInt(st.nextToken());
            int com3 = Integer.parseInt(st.nextToken());
            int n1;
            int n2;
            int n3;
            if(pos < com1){
                n1 = 9*(pos + 40 - com1);
            } else {
                n1 = 9*(pos-com1);
            }

            if(com2 < com1){
                n2 = 9*(com2 + 40 - com1);
            } else {
                n2 = 9*(com2-com1);
            }

            if(com2 < com3){
                n3 = 9*(com2+40-com3);
            } else {
                n3 = 9*(com2 - com3);
            }

            System.out.println(n1+n2+n3+1080);
        }
    }
}