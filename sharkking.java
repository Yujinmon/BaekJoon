import java.util.*;
import java.io.*;

public class Main {
    static int R, C, M;
    static int result;
    static Shark sea[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    public static void moveShark() {
        Shark temp[][] = new Shark[R + 1][C + 1];

        for(int i = 1; i < R + 1; i++){
            for(int j = 1; j < C + 1; j++) {
                Shark current = sea[i][j];
                if(current.exist){
                    int speed = current.speed;
                    int direction = current.direction;

                    int nextx = dx[direction - 1] * speed + i;
                    int nexty = dy[direction - 1] * speed + j;


                }
            }
        }
    }
    public static void catchShark(int j) {
        for(int i = 1; i < R + 1; i++) {
            Shark current = sea[i][j];
            if(current.exist) {
                result += current.size;
                sea[i][j] = new Shark(false, 0, 0, 0);
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sea = new Shark[R + 1][C + 1];
        for(int i = 0; i < R + 1; i++) {
            for(int j = 0; j < C + 1; j++) {
                sea[i][j] = new Shark(false, 0,0, 0);
            }
        } // initialize

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int direc = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());

            sea[x][y] = new Shark(true, speed, direc, size);
        } // storing sharks, input end

        for(int i = 1; i < C + 1; i++) {
            catchShark(i);
            moveShark();
        }

    }
}
class Shark {
    boolean exist;
    int speed;
    int direction;
    int size;
    Shark(boolean e, int s, int d, int si){
        exist = e;
        speed = s;
        direction = d;
        size = si;
    }
}
