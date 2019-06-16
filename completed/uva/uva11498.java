import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while(!((input = f.readLine()).equals("0"))){
            int test_cases = Integer.parseInt(input);
            StringTokenizer st = new StringTokenizer(f.readLine());
            int divx = Integer.parseInt(st.nextToken());
            int divy = Integer.parseInt(st.nextToken());
            int resx, resy;
            for(int i = 0; i<test_cases; i++){
                StringTokenizer s = new StringTokenizer(f.readLine());
                resx = Integer.parseInt(s.nextToken());
                resy = Integer.parseInt(s.nextToken());
                if(resx == divx || resy == divy){
                    System.out.println("divisa");
                }
                else if(resx > divx && resy > divy){
                    System.out.println("NE");
                }
                else if(resx <divx && resy > divy){
                    System.out.println("NO");
                }
                else if(resx > divx && resy < divy){
                    System.out.println("SE");
                }
                else{
                    System.out.println("SO");
                }
            }
        }
    }
}
