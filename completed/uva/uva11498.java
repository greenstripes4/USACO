import java.io.*;
import java.util.StringTokenizer;
//O(n)
//3
//2 1
//10 10
//-10 1
//0 33
//4
//-1000 -1000
//-1000 -1000
//0 0
//-2000 -10000
//-999 -1001
//4
//10000 10000
//-10000 -10000
//10000 -10000
//-10000 10000
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while(!((input = f.readLine()).equals("0"))){
            int test_cases = Integer.parseInt(input);
            StringTokenizer st = new StringTokenizer(f.readLine());
            int divx = Integer.parseInt(st.nextToken());
            int divy = Integer.parseInt(st.nextToken());
            int x;
            int y;
            for(int i = 0; i<test_cases; i++){
                StringTokenizer s = new StringTokenizer(f.readLine());
                x = Integer.parseInt(s.nextToken());
                y = Integer.parseInt(s.nextToken());
                if(x == divx || y == divy){
                    System.out.println("divisa");
                }
                else if(x > divx && y > divy){
                    System.out.println("NE");
                }
                else if(x <divx && y > divy){
                    System.out.println("NO");
                }
                else if(x > divx && y < divy){
                    System.out.println("SE");
                }
                else{
                    System.out.println("SO");
                }
            }
        }
    }
}
