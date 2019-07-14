import java.io.*;
//O(1)
//X
//Y
//-X
//not really a point...

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        while((input = f.readLine()) != null){
            System.out.println(input);
        }
    }
}
