import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int oven[] = new int[D];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < D; i++){
            oven[i] = Integer.parseInt(st.nextToken());
        }

        int pizza[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            pizza[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < D - 1; i++){
            if(oven[i] < oven[i + 1]){
                oven[i + 1] = oven[i];
            }
        }

        boolean fail = false;
        int end = D;
        for(int i = 0; i < N; i++){
            int current = pizza[i];

            if(end == 0){
                fail = true;
                break;
            }

            for(int j = end - 1; j >= 0; j--){
                if(oven[j] >= current){
                    end = j;
                    break;
                }
                if(j == 0){
                    fail = true;
                }
            }
            if(fail){
                break;
            }
        }

        if(fail){
            System.out.println(0);
        }else{
            System.out.println(end + 1);
        }

    }
}
