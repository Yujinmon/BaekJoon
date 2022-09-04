import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Naong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        boolean arr[][] = new boolean[N][N];

        for(int i = 0; i < K; i++){ //사과위치 true
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int indexI = Integer.parseInt(st.nextToken());
            int indexJ = Integer.parseInt(st.nextToken());

            arr[indexI-1][indexJ-1] = true;
        }

        String check[] = new String[10001];
        int L = Integer.parseInt(br.readLine());
        for(int i = 0; i < L; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int num = Integer.parseInt(st.nextToken());
            String temp = st.nextToken();

            check[num] = temp;
        }

        int count = 0;
        int snake = 1; //뱀 몸길이

        int currentI = 0;
        int currentJ = 0;

        int dx[] = {0, 1, 0, -1}; //우 하 상 좌
        int dy[] = {1, 0, -1, 0};
        int currentDirection = 0; //처음엔 0,0 에서 오른쪽간다함

        Deque<Pair> queue = new ArrayDeque<>();

        while(true){
            if(currentI > N-1 || currentJ > N-1){
                break;
            }
            if(check[count] != null){
                if(check[count].equals("D")){ //D면 오른쪽턴
                    currentDirection++;
                }else{ //L인경우
                    currentDirection--;
                }
            }

        }
    }
}


