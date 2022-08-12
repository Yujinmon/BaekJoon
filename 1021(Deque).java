import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hororop {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<Integer>();
        for(int i = 1; i < N+1; i++){
            deque.add(i);
        }

        int arr[] = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for(int i = 0; i < M; i++){
            int target = deque.indexOf(arr[i]); //뽑고싶은수가 덱에서 어디에?
            int half = 0;

            if(deque.size() % 2 == 0){
                half = deque.size() / 2 - 1;
            }else{
                half = deque.size() / 2;
            }

            if(target <= half){
                for(int j = 0; j < target; j++){
                    int temp = deque.removeFirst();
                    deque.addLast(temp);
                    count++;
                }
            }else{
               for(int j = deque.size(); j > target; j--){
                   int temp = deque.removeLast();
                   deque.addFirst(temp);
                   count++;
               }
            }
            deque.removeFirst();
        }
        System.out.println(count);
    }
}
