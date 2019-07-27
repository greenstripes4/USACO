import java.io.*;
//O(1)
//78
//7835
//19078
//944
//1
//4
//0
//2000000000

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        int cases = Integer.parseInt(f.readLine());
        for(int i = 0; i < cases; i++){
            input = f.readLine();
            char[] seq = input.toCharArray();
            if(input.equals("1") || input.equals("4") || input.equals("78")){
                System.out.println("+");
            }
            else if(seq[seq.length-1] == '5' && seq[seq.length-2] == '3'){
                System.out.println("-");
            }
            else if(seq[0] == '9' && seq[seq.length-1] == '4'){
                System.out.println("*");
            }
            else{
                System.out.println("?");
            }
        }
    }
}
