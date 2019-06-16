import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int q = 0;
        while((input = f.readLine()) != null){
            StringBuilder out = new StringBuilder();
            char[] x = input.toCharArray();
            for(int i = 0; i<x.length; i++){
                if(x[i] != '"'){
                    out.append(x[i]);
                }
                else{
                    if(q == 0){
                        out.append("``");
                        q = 1;
                    }
                    else{
                        out.append("''");
                        q = 0;
                    }
                }
            }
            System.out.println(out);
        }
    }
}
