import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int sort[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;
            sort[i] = temp;
        }

        Arrays.sort(sort);
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int current = 0;
        hashMap.put(sort[0], current);

        for(int i = 1; i < N; i++){
            if(sort[i] != sort[i - 1]){
                current++;
                hashMap.put(sort[i], current);
            }
        }

        for(int i = 0; i < N; i++){
            sb.append(hashMap.get(arr[i])).append(" ");
        }

        System.out.println(sb);
    }
}

