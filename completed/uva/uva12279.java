import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
//O(n)
//5
//3 4 0 0 1
//4
//2 0 0 0
//7
//1 2 3 4 5 0 0
//6
//99 99 99 0 99 99
//8
//99 99 99 99 99 99 99 99
//3
//0 0 0
//2
//1 0
//0

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        int count = 1;
        while(!((input = f.readLine()).equals("0"))){
            StringTokenizer temp = new StringTokenizer(input);
            int cases = Integer.parseInt(temp.nextToken());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int c = 0;
            for(int i = 0 ; i < cases; i++){
                if(Integer.parseInt(st.nextToken()) != 0){
                    c++;
                }
                else{
                    c--;
                }
            }
            System.out.println("Case " + count + ": " + c);
            count++;
        }
    }
}
