import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            HashSet<Integer> leju = new HashSet<>();
            HashSet<Integer> rony = new HashSet<>();
            HashSet<Integer> sujon = new HashSet<>();
            st = new StringTokenizer(f.readLine());
            for(int i = 0; i < L; i++) {
                leju.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(f.readLine());
            for(int i = 0; i < R; i++) {
                rony.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(f.readLine());
            for(int i = 0; i < S; i++) {
                sujon.add(Integer.parseInt(st.nextToken()));
            }
            HashSet<Integer> all = new HashSet<>();
            all.addAll(leju);
            all.addAll(rony);
            all.addAll(sujon);
            int lejuHas = 0;
            int ronyHas = 0;
            int sujonHas = 0;
            for(int i: leju) {
                if(!rony.contains(i) && !sujon.contains(i)) {
                    lejuHas++;
                }
            }
            for(int i: rony) {
                if(!leju.contains(i) && !sujon.contains(i)) {
                    ronyHas++;
                }
            }
            for(int i: sujon) {
                if(!leju.contains(i) && !rony.contains(i)) {
                    sujonHas++;
                }
            }
            int lejuDoesntHave = 0;
            int ronyDoesntHave = 0;
            int sujonDoesntHave = 0;
            for(int i: all) {
                boolean lejuContains = leju.contains(i);
                boolean ronyContains = rony.contains(i);
                boolean sujonContains = sujon.contains(i);
                if(lejuContains && ronyContains && !sujonContains) {
                    sujonDoesntHave++;
                }
                if(lejuContains && sujonContains && !ronyContains) {
                    ronyDoesntHave++;
                }
                if(ronyContains && sujonContains && !lejuContains) {
                    lejuDoesntHave++;
                }
            }
            out.println("Case #" + t + ":");
            out.println(lejuHas + " " + lejuDoesntHave);
            out.println(ronyHas + " " + ronyDoesntHave);
            out.println(sujonHas + " " + sujonDoesntHave);
        }
        f.close();
        out.close();
    }
}
