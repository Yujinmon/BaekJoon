import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    public static void insert(int k, Node n){
        if(n.key > k){
            if(n.left == null){
                n.left = new Node(k);
            }else{
                insert(k, n.left);
            }
        }else{
            if(n.right == null){
                n.right = new Node(k);
            }else{
                insert(k, n.right);
            }
        }
    }

    public static void postorder(Node n){
        if(n != null){
            postorder(n.left);
            postorder(n.right);
            sb.append(n.key).append('\n');
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Node root;

        root = new Node(Integer.parseInt(input));

        while ((input = br.readLine()) != null){
            insert(Integer.parseInt(input), root);
        }

        postorder(root);

        System.out.println(sb);
    }
}
class Node{
    int key;
    Node left, right;
    Node(int k){
        key = k;
        left = null;
        right = null;
    }
}
