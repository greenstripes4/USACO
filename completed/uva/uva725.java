import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        boolean first = true;
        while(!((input = f.readLine()).equals("0"))){
            if(!first){
                System.out.println();
            }
            else{
                first = false;
            }
            int N = Integer.parseInt(input);
            boolean found = false;
            for(int i = 1234; i <= 98765; i++){
                if(i % N != 0){
                    continue;
                }
                int result = i / N;
                String part1 = (Integer.toString(i).length() == 4) ? "0" + i: Integer.toString(i);
                String part2;
                if(Integer.toString(result).length() < 5){
                    StringBuilder sb = new StringBuilder();
                    int difference = 5 - Integer.toString(result).length();
                    for(int j = 0; j < difference; j++){
                        sb.append(0);
                    }
                    sb.append(result);
                    part2 = sb.toString();
                }
                else {
                    part2 = Integer.toString(result);
                }
                char[] digits = (part1 + part2).toCharArray();
                boolean[] all_digits = new boolean[10];
                for(int j = 0; j < 10; j++){
                    all_digits[j] = false;
                }
                for(int k = 0; k < 10; k++){
                    if(all_digits[Character.getNumericValue(digits[k])] == true){
                        break;
                    }
                    else{
                        all_digits[Character.getNumericValue(digits[k])] = true;
                    }
                }
                boolean success = true;
                for(boolean l: all_digits){
                    if(!l){
                        success = false;
                    }
                }
                if(success){
                    found = true;
                    System.out.println(part1 + " / " + part2 + " = " + N);
                }
            }
            if(!found){
                System.out.println("There are no solutions for " + N + ".");
            }
        }
    }
}
