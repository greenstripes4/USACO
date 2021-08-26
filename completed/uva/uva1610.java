import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            int n = Integer.parseInt(f.readLine());
            if(n == 0) {
                break;
            }
            String[] str = new String[n];
            for(int i = 0; i < n; i++) {
                str[i] = f.readLine();
            }
            Arrays.sort(str);
            char[] a = str[n/2-1].toCharArray();
            char[] b = str[n/2].toCharArray();
            if(a.length < b.length) {
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < a.length; i++) {
                    if(a[i] == b[i]) {
                        sb.append(a[i]);
                    } else {
                        if(i == a.length-1) {
                            sb.append(a[i]);
                        } else {
                            sb.append((char) (a[i]+1));
                        }
                        break;
                    }
                }
                out.println(sb);
            } else {
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < b.length; i++) {
                    if(a[i] == b[i]) {
                        sb.append(a[i]);
                    } else {
                        if(i == b.length-1) {
                            if(i == a.length-1) {
                                sb.append(a[i]);
                            } else if(a[i]+1 == b[i]) {
                                sb.append(a[i]);
                                int j;
                                for(j = i+1; j < a.length && a[j] == 'Z'; j++) {
                                    sb.append(a[j]);
                                }
                                if(j < a.length) {
                                    if(j == a.length-1) {
                                        sb.append(a[j]);
                                    } else {
                                        sb.append((char) (a[j]+1));
                                    }
                                }
                            } else {
                                sb.append((char) (a[i]+1));
                            }
                        } else {
                            if(i == a.length-1) {
                                sb.append(a[i]);
                            } else {
                                sb.append((char) (a[i]+1));
                            }
                        }
                        break;
                    }
                }
                out.println(sb);
            }
        }
        f.close();
        out.close();
    }
}