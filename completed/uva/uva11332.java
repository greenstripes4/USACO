import java.io.*;
//O(n)
//2
//11
//47
//1234567892
//2000000000
//1
//0

public class Main{
    public static int digitalRoot(int num){
        if(num < 10){
            return num;
        }
        int temp = 0;
        while(num > 0){
            temp += num%10;
            num = num/10;
            }
        return digitalRoot(temp);

    }
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        while(!((input = f.readLine()).equals("0"))){
            System.out.println(digitalRoot(Integer.parseInt(input)));
        }
    }
}
