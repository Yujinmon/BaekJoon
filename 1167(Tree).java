import java.util.*;
import java.io.*;

public class Main{
    static ArrayList<Pair> arrayList[];
    static boolean visited[];
    static int V;
    static int max;
    static int sum;
    static int maxNode = 1;

    public static void dfs(int start){
        visited[start] = true;
        for (Pair p : arrayList[start]){
            if(!visited[p.end]){
                sum += p.cost;
                dfs(p.end);

                if(sum >= max){
                    max = sum;
                    maxNode = p.end;
                }
                sum -= p.cost;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());

        arrayList = new ArrayList[V + 1];
        for(int i = 0; i < V + 1; i++){
            arrayList[i] = new ArrayList<>();
        }

        for(int i = 0; i < V; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());

            while (true){
                int end = Integer.parseInt(st.nextToken());
                if(end == -1){
                    break;
                }
                int cost = Integer.parseInt(st.nextToken());
                arrayList[start].add(new Pair(end, cost));
            }
        }

        visited = new boolean[V + 1];
        dfs(1);

        max = 0;
        sum = 0;
        visited = new boolean[V + 1];
        dfs(maxNode);

        System.out.println(max);
    }
}
class Pair{
    int end;
    int cost;
    Pair(int e, int c){
        end = e;
        cost = c;
    }
}
