import java.util.*;
import java.io.*;

public class Main{
    static int origin[][], temp[][];
    static int N, M;
    static boolean visited[][];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};

    public static void bfs(int x, int y) {
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()){
            Pair current = queue.remove();
            int currentX = current.x;
            int currentY = current.y;

            for(int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M){
                    continue;
                }
                if(visited[nextX][nextY]){
                    continue;
                }

                if(origin[nextX][nextY] != 0 && !visited[nextX][nextY]){
                    visited[nextX][nextY] = true;
                    queue.add(new Pair(nextX, nextY));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        origin = new int[N][M];
        temp = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken());
            }
        } //input end

        int answer = 0;

        while (true) {
            int count = 0;
            boolean flag = false;

            int check = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(origin[i][j] != 0){
                        check++;
                    }
                    if(origin[i][j] != 0 && !visited[i][j]){
                        count++;
                        flag = true;
                        bfs(i, j);
                    }
                }
            }

            if(!flag || count > 1 || check == 1){
                if(!flag){
                    answer = 0;
                }
                break;
            }

            answer++;
            temp = new int[N][M];
            visited = new boolean[N][M];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(origin[i][j] != 0){
                        int zerocount = 0;
                        for(int x = 0; x < 4; x++){
                            int nextX = i + dx[x];
                            int nextY = j + dy[x];

                            if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M){
                                continue;
                            }

                            if(origin[nextX][nextY] == 0){
                                zerocount++;
                            }
                        }

                        temp[i][j] = Math.max((origin[i][j] - zerocount), 0);
                    }
                }
            } // 빙하 녹이기

            origin = temp;
        }

        System.out.println(answer);
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
