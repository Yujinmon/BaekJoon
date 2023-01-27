import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static long count;
    static long A[];
    static ArrayList<Long> tree[];

    public static void init(int node, int start, int end){
        if(start == end){
            tree[node] = new ArrayList<>();
            tree[node].add(A[start]);
        }else{
            int mid = start + end >> 1;
            init(node * 2, start, mid);
            init(node * 2 + 1, mid + 1, end);

            tree[node] = new ArrayList<>();

            int leftIndex = 0;
            int rightIndex = 0;
            while (leftIndex < tree[node * 2].size() && rightIndex < tree[node * 2 + 1].size()){
                if(tree[node * 2].get(leftIndex) > tree[node * 2 + 1].get(rightIndex)){
                    count += (tree[node * 2].size() - leftIndex);
                    tree[node].add(tree[node * 2 + 1].get(rightIndex));

                    rightIndex++;
                }else if(tree[node * 2].get(leftIndex) == tree[node * 2 + 1].get(rightIndex)){
                    tree[node].add(tree[node * 2].get(leftIndex));
                    tree[node].add(tree[node * 2 + 1].get(rightIndex));

                    leftIndex++;
                    rightIndex++;
                }else{ //우측이 더큰거
                    tree[node].add(tree[node * 2].get(leftIndex));

                    leftIndex++;
                }
            }

            //남은 원소없나체크
            if(leftIndex < tree[node * 2].size()){
                while (leftIndex < tree[node * 2].size()){
                    tree[node].add(tree[node * 2].get(leftIndex));
                    leftIndex++;
                }
            }
            if(rightIndex < tree[node * 2 + 1].size()){
                while (rightIndex < tree[node * 2 + 1].size()){
                    tree[node].add(tree[node * 2 + 1].get(rightIndex));
                    rightIndex++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        A = new long[N + 1];
        tree = new ArrayList[N * 4];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        init(1, 1, N);

        System.out.println(count);
    }
}
