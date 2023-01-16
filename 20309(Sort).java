import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        boolean success = true;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++) {
            int temp = Integer.parseInt(st.nextToken());

            if(temp % 2 == 0){
                if(i % 2 != 0){
                    success = false;
                    break;
                }
            }else{
                if(i % 2 == 0){
                    success = false;
                    break;
                }
            }
        }

        if(success){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
