import java.io.*;
//O(1)
//Hajj
//Umrah

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        int count = 1;
        while(!(((input = f.readLine()).equals("*")))){
            if(input.equals("Hajj")){
                System.out.println("Case " + count + ": " + "Hajj-e-Akbar");
            }
            else{
                System.out.println("Case " + count + ": " + "Hajj-e-Asghar");
            }
            count++;
        }
    }
}
