import java.util.*;
import java.io.*;

public class Hororop {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N + 1][N + 1];
        for(int i = 1; i < N + 1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < N + 1; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int dp[][] = new int[N + 1][N + 1];
        for(int i = 1; i < N + 1; i++){
            dp[1][i] = dp[1][i - 1] + arr[1][i];
            dp[i][1] = dp[i - 1][1] + arr[i][1];
        }

        for(int i = 2; i < N + 1; i++) {
            for(int j = 2; j < N + 1; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr[i][j];
            }
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int startx = Integer.parseInt(st.nextToken());
            int starty = Integer.parseInt(st.nextToken());
            int endx = Integer.parseInt(st.nextToken());
            int endy = Integer.parseInt(st.nextToken());

            int answer = dp[endx][endy] - dp[endx][starty - 1] - dp[startx - 1][endy];
            answer += dp[startx - 1][starty - 1];

            sb.append(answer).append('\n');
        }

        System.out.println(sb);
    }
}

