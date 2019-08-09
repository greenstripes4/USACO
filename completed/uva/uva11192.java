import java.io.*;
import java.util.StringTokenizer;
//O(n^2)
//3 ABCEHSHSH
//5 FA0ETASINAHGRI0NATWON0QA0NARI0
//0


public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (!((input = f.readLine()).equals("0"))) {
            StringTokenizer st=new StringTokenizer(input);
            int length=Integer.parseInt(st.nextToken());
            String str=st.nextToken();
            length= str.length()/length;
            StringBuilder sb=new StringBuilder();
            int prev = 0;
            for (int i = length; i <= str.length(); i += length) {
                char[] temp = str.substring(prev,i).toCharArray();
                prev = i;
                for(int j = 0; j < (temp.length+1)/2; j++){
                    char t = temp[j];
                    temp[j] = temp[temp.length-j-1];
                    temp[temp.length-j-1] = t;
                }
                for(char k: temp){
                    sb.append(k);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
