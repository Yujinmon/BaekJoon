import java.util.*;
import java.io.*;

public class Main{
    static int V;
    static ArrayList<Pair> arrayList[];
    static boolean visited[];
    static int max = 0;
    static int sum = 0;

    public static void dfs(int start){
        visited[start] = true;

        for(Pair next : arrayList[start]){
            if(!visited[next.end]){
                sum += next.cost;
                dfs(next.end);

                max = Math.max(max, sum);
                sum -= next.cost;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());
        arrayList = new ArrayList[V + 1];
        visited = new boolean[V + 1];

        for(int i = 0; i < V + 1; i++){
            arrayList[i] = new ArrayList<>();
        }

        for(int i = 0; i < V - 1; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());

            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arrayList[start].add(new Pair(end, cost));
            arrayList[end].add(new Pair(start, cost));
        }

        for(int i = 1; i < V + 1; i++){
            visited = new boolean[V + 1];
            sum = 0;
            dfs(i);
        }

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
