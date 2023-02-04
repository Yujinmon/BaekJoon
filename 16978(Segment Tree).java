import java.util.*;
import java.io.*;

public class Main{
    static int A[];
    static int N, M;
    static long answer[], tree[];
    static ArrayList<Tuple> queries;
    static ArrayList<Pair> change;

    public static void init(int node, int start, int end){
        if(start == end){
            tree[node] = A[start];
        }else{
            int mid = start + end >> 1;
            init(node * 2, start, mid);
            init(node * 2 + 1, mid + 1, end);

            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }

    public static void update(int node, int start, int end, int target, int value){
        if(target < start || target > end){
            return;
        }
        if(start == end){
            A[target] = value;
            tree[node] = value;
            return;
        }

        int mid = start + end >> 1;
        update(node * 2, start, mid, target, value);
        update(node * 2 + 1, mid + 1, end, target, value);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public static long query(int node, int start, int end, int left, int right){
        if(left > end || right < start){
            return 0;
        }
        if(left <= start && end <= right){
            return tree[node];
        }
        int mid = start + end >> 1;
        long leftSum = query(node * 2, start, mid, left, right);
        long rightSum = query(node * 2 + 1, mid + 1, end, left, right);
        return leftSum + rightSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        A = new int[N + 1];
        tree = new long[N * 4];
        change = new ArrayList<>();
        queries = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        init(1, 1, N);

        M = Integer.parseInt(br.readLine());
        answer = new long[M + 1];
        change.add(new Pair(0, 0));

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int what = Integer.parseInt(st.nextToken());

            if(what == 1){
                int index = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                change.add(new Pair(index, value));
            }else{
                int q = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                queries.add(new Tuple(q, s, e, i));
            }
        } //input end

        Collections.sort(queries, new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                return o1.query - o2.query;
            }
        });

        boolean check[] = new boolean[change.size() + 1];
        check[0] = true;

        for(Tuple current : queries){
            int num = current.query;

            if(!check[num]){
                for(int i = 1; i <= num; i++){
                    if(check[i]){
                        continue;
                    }
                    Pair temp = change.get(i);
                    update(1, 1, N, temp.index, temp.value);
                    check[i] = true;
                }
            }

            int l = current.start;
            int r = current.end;
            answer[current.order] = query(1, 1, N, l, r);
        }

        for(long num : answer){
            if(num != 0){
                sb.append(num).append('\n');
            }
        }

        System.out.print(sb);
    }
}
class Tuple{
    int query;
    int start;
    int end;
    int order;
    Tuple(int q, int s, int e, int o){
        query = q;
        start = s;
        end = e;
        order = o;
    }
}
class Pair{
    int index;
    int value;
    Pair(int i, int v){
        index = i;
        value = v;
    }
}
