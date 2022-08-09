import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       HashMap<String, Integer> hashMap = new HashMap<>();

       int N = Integer.parseInt(br.readLine());
       for(int i = 1; i < N + 1; i++){
           hashMap.put(br.readLine(), i);
       }

       int arr[] = new int[N];
       for(int i = 0; i < N; i++){
           String name = br.readLine();
           arr[i] = hashMap.get(name);
       }

       int count = 0;
       for(int i = 0; i < N; i++){
           for(int j = i+1; j < N; j++){
               if(arr[i] > arr[j]){
                   count++;
                   break;
               }
           }
       }

       System.out.println(count);
    }
}
