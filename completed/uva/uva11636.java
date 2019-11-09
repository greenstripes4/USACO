import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));;
        String input;
        int casenumber = 1;
        while((input = f.readLine()) != null){
            int number = Integer.parseInt(input);
            if(number < 0){
                break;
            }
            int pasteCommands = 0;
            int lines = 1;
            while(lines < number){
                lines += (int) Math.pow(2,pasteCommands);
                pasteCommands++;
            }
            out.println("Case " + casenumber + ": " + pasteCommands);
            casenumber++;
        }
        f.close();
        out.close();
    }
}