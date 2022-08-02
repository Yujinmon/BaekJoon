import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int arr[] = new int[8001];
        int sum = 0;

        int middle[] = new int[N];

        for(int i = 0; i < N; i++){
            int temp = Integer.parseInt(br.readLine());
            sum += temp;
            middle[i] = temp;
            arr[temp + 4000]++;

            if(temp < min){
                min = temp;
            }
            if(temp > max){
                max = temp;
            }
        }
        Arrays.sort(middle);

        sb.append((int)Math.round((double)sum / N)).append('\n').append(middle[N/2]).append('\n');

        int countMax = 0;

        for(int i = min+4000; i < max+4001; i++){
            if(countMax < arr[i]){
                countMax = arr[i];
            }
        }
        if(countMax == 1){
            if(N == 1){
                sb.append(min).append('\n');
            }else{
                sb.append(middle[1]).append('\n');
            }
        }else{
            int count = 1;
            for(int i = min+4000; i < max+4001; i++){
                if(countMax == arr[i]){
                    count++;
                }
            }
            if(count == 2){
                for(int i = min+4000; i < max+4001; i++){
                    if(countMax == arr[i]){
                        sb.append(i - 4000).append('\n');
                        break;
                    }
                }
            }else{
                count = 1;
                for(int i = min+4000; i < max+4001; i++){
                    if(countMax == arr[i]){
                        count++;
                        if(count == 3){
                            sb.append(i - 4000).append('\n');
                            break;
                        }
                    }
                }
            }
        }

        sb.append(middle[N-1] - middle[0]).append('\n');

        System.out.println(sb);
    }
}
//1. N을 입력받고 N배열을 생성해준다
//2. 배열에 값을저장하면서 전체합도 구해준다
//3. 정렬
//4. 이후 전체적으로 탐색하면서 최대최소값을 구함.
//5. 중앙값같은경우에는 N이 홀수라하였으니 N/2번째인덱스값을출력해준다
