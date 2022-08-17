import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int arr[] = new int[N];

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int target = Integer.parseInt(br.readLine());

        for(int i = 1; i < N; i++){
            priorityQueue.add(Integer.parseInt(br.readLine()));
        }

        int count = 0;
        while (N != 1){
            int temp = priorityQueue.remove();
            if(target < temp){
                count++;
                target++;
                temp--;
                priorityQueue.add(temp);
            }else if(target == temp){
                count+=1;
                break;
            }else{
                break;
            }
        }
        if(N == 1){
            System.out.println(0);
        }else{
            System.out.println(count);
        }
    }
}
