import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        private int val;
        private Node next;
        private Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
    private static class LinkedList {
        private Node head;
        private Node tail;
        private LinkedList() {
            head = new Node(-1);
            tail = head;
        }
        private void append(int val) {
            tail.next = new Node(val);
            tail = tail.next;
        }
        private void append(LinkedList o) {
            if(o.head.next == null) {
                return;
            }
            tail.next = o.head.next;
            tail = o.tail;
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        LinkedList[] indexes = new LinkedList[500001];
        for(int i = 0; i <= 500000; i++) {
            indexes[i] = new LinkedList();
        }
        int q = Integer.parseInt(f.readLine());
        int idx = 0;
        while(q-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            if(t == 1) {
                indexes[x].append(idx++);
            } else {
                int y = Integer.parseInt(st.nextToken());
                if(x == y) {
                    continue;
                }
                indexes[y].append(indexes[x]);
                indexes[x] = new LinkedList();
            }
        }
        int[] res = new int[idx];
        for(int i = 0; i <= 500000; i++) {
            Node temp = indexes[i].head;
            while(temp.next != null) {
                res[temp.next.val] = i;
                temp = temp.next;
            }
        }
        out.print(res[0]);
        for(int i = 1; i < idx; i++) {
            out.print(" " + res[i]);
        }
        out.println();
        f.close();
        out.close();
    }
}
