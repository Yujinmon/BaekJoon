import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B {
    static int N, L, R, total, tempCount;
    static int arr[][];
    static boolean visited[][];

    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static ArrayList<Pair> arrayList = new ArrayList<>();
    public static void bfs(int x, int y) {
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Pair current = queue.remove();

            arrayList.add(current);
            total += arr[current.x][current.y];
            tempCount++;

            for(int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N){
                    continue;
                }

                int diff = Math.abs(arr[current.x][current.y] - arr[nextX][nextY]);

                if(!visited[nextX][nextY] && (diff >= L && diff <= R)){
                    visited[nextX][nextY] = true;
                    queue.add(new Pair(nextX, nextY));
                }
            }
        }
    }

    public static void init(int num) {
        for (Pair temp : arrayList) {
            arr[temp.x][temp.y] = num;
        }
    }


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    arrayList = new ArrayList<>();
                    total = 0;
                    tempCount = 0;
                    bfs(i, j);

                    int num = (total / arrayList.size());

                    init(num);

                    count++;
                }
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        if(count == (N * N)){
            System.out.println(0);
        }else{
            System.out.println(count);
        }
    }
}
class Pair{
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
