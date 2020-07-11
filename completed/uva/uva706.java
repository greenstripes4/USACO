import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int s = Integer.parseInt(st.nextToken());
            char[] chars = st.nextToken().toCharArray();
            if(s == 0 && chars[0] == '0'){
                break;
            }
            int mid = (2*s+3)/2;
            int bottom = 2*s+2;
            for(int i = 0; i < 2*s+3; i++){
                for(int j = 0; j < chars.length; j++){
                    if(j > 0){
                        out.print(' ');
                    }
                    if(i == 0) {
                        switch (chars[j]) {
                            case '1':
                            case '4':
                                for (int k = 0; k < s + 2; k++) {
                                    out.print(' ');
                                }
                                break;
                            default:
                                out.print(' ');
                                for (int k = 0; k < s; k++) {
                                    out.print('-');
                                }
                                out.print(' ');
                        }
                    } else if(i == mid) {
                        switch (chars[j]) {
                            case '1':
                            case '7':
                            case '0':
                                for (int k = 0; k < s + 2; k++) {
                                    out.print(' ');
                                }
                                break;
                            default:
                                out.print(' ');
                                for (int k = 0; k < s; k++) {
                                    out.print('-');
                                }
                                out.print(' ');
                        }
                    } else if(i == bottom) {
                        switch (chars[j]) {
                            case '1':
                            case '4':
                            case '7':
                                for (int k = 0; k < s + 2; k++) {
                                    out.print(' ');
                                }
                                break;
                            default:
                                out.print(' ');
                                for (int k = 0; k < s; k++) {
                                    out.print('-');
                                }
                                out.print(' ');
                        }
                    } else {
                        if(i < mid) {
                            switch (chars[j]) {
                                case '1':
                                case '2':
                                case '3':
                                case '7':
                                    for(int k = 0; k < s+1; k++) {
                                        out.print(' ');
                                    }
                                    out.print('|');
                                    break;
                                case '5':
                                case '6':
                                    out.print('|');
                                    for(int k = 0; k < s+1; k++) {
                                        out.print(' ');
                                    }
                                    break;
                                default:
                                    out.print('|');
                                    for(int k = 0; k < s; k++) {
                                        out.print(' ');
                                    }
                                    out.print('|');
                            }
                        } else {
                            switch (chars[j]) {
                                case '1':
                                case '3':
                                case '4':
                                case '5':
                                case '7':
                                case '9':
                                    for(int k = 0; k < s+1; k++) {
                                        out.print(' ');
                                    }
                                    out.print('|');
                                    break;
                                case '2':
                                    out.print('|');
                                    for(int k = 0; k < s+1; k++) {
                                        out.print(' ');
                                    }
                                    break;
                                default:
                                    out.print('|');
                                    for(int k = 0; k < s; k++) {
                                        out.print(' ');
                                    }
                                    out.print('|');
                            }
                        }
                    }
                }
                out.println();
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
