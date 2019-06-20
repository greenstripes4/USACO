import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int c = 0;
        while(!((input = f.readLine()).equals("*"))){
            c++;
            if(input.equals("Hajj")){
                System.out.println("Case " + c + ": Hajj-e-Akbar");
            }
            else{
                System.out.println("Case " + c + ": Hajj-e-Asghar");
            }
        }
    }
}