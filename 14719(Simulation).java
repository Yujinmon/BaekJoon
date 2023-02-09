import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int block[][] = new int[H][W];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++) {
            int temp = Integer.parseInt(st.nextToken());
            for(int j = 0; j < temp; j++){
                block[j][i] = 1;
            }
        }

        int sum = 0;
        for(int i = 0; i < H; i++) {
            for(int j = 1; j < W; j++) {
                if(block[i][j] != 1 && block[i][j - 1] == 1) {
                    int end = j;
                    boolean flag = false;

                    int count = 0;
                    while (true) {
                        if(end == W){
                            break;
                        }
                        if(block[i][end] == 1){
                            flag = true;
                            break;
                        }
                        end++;
                        count++;
                    }

                    if(flag) {
                        sum += count;
                    }
                }
            }
        }

        System.out.println(sum);
    }
}
