import java.io.*;
import java.util.StringTokenizer;
/*
O(n)
2
3
LEFT
RIGHT
SAME AS 2
5
LEFT
SAME AS 1
SAME AS 2
SAME AS 1
SAME AS 4
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        int cases = Integer.parseInt(f.readLine());
        for(int i = 0; i < cases; i++){
            int count = 0;
            int num_ins = Integer.parseInt(f.readLine());
            String[] instructions = new String[num_ins];
            for(int j = 0; j < num_ins; j++){
                String command = f.readLine();
                if(command.equals("LEFT") || command.equals("RIGHT")){
                    instructions[j] = command;
                } else {
                    StringTokenizer st = new StringTokenizer(command);
                    st.nextToken();
                    st.nextToken();
                    int index = Integer.parseInt(st.nextToken());
                    instructions[j] = instructions[index-1];
                }
                if(instructions[j].equals("LEFT")){
                    count--;
                }
                else{
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
