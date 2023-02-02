import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());

        for(int i = 1; i < N; i++){
            int temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;
        }

        int dp[] = new int[N];
        dp[0] = 1;

        for(int i = 1; i < N; i++){
            if(arr[i] <= arr[i - 1]){
                arr[i] += arr[i - 1];
                dp[i] = dp[i - 1] + 1;
            }else{
                int count = dp[i - 1];
                int temp = arr[i - 1];
                for(int j = i + 1; j < N; j++){
                    if(temp >= arr[j]){
                        temp += arr[j];
                        count++;
                    }else{
                        break;
                    }
                }

                int secCount = 1;
                temp = arr[i];
                for(int j = i + 1; j < N; j++) {
                    if(temp >= arr[j]){
                        temp += arr[j];
                        secCount++;
                    }else{
                        break;
                    }
                }

                if(count > secCount){
                    arr[i] = arr[i - 1];
                    dp[i] = dp[i - 1];
                }else{
                    dp[i] = 1;
                }
            }
        }

        System.out.println(dp[N - 1]);
    }
}
