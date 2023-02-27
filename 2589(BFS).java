import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char map[][];
    static int R, C;
    static int temp[][];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};

    public static void bfs(int x, int y) {
        boolean visited[][] = new boolean[R][C];
        Queue<Tuple> queue = new LinkedList<>();

        visited[x][y] = true;
        queue.add(new Tuple(x, y, 0));
        while (!queue.isEmpty()) {
            Tuple current = queue.remove();

            int currentX = current.x;
            int currentY = current.y;
            int count = current.count;

            if(temp[currentX][currentY] < count){
                temp[currentX][currentY] = count;
            }

            for(int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= R || nextY >= C){
                    continue;
                }
                if(map[nextX][nextY] == 'W') {
                    continue;
                }

                if(!visited[nextX][nextY]){
                    visited[nextX][nextY] = true;
                    queue.add(new Tuple(nextX, nextY, count + 1));
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        temp = new int[R][C];

        for(int i = 0; i < R; i++) {
            String s = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int max = 0;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++){
                if(map[i][j] == 'L'){
                    bfs(i, j);
                }
            }
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++){
                max = Math.max(max, temp[i][j]);
            }
        }

        System.out.println(max);
    }
}
class Tuple{
    int x;
    int y;
    int count;
    Tuple(int x, int y, int c){
        this.x = x;
        this.y = y;
        count = c;
    }
}
