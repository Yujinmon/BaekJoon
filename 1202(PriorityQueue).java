import java.util.*;
import java.io.*;

public class Main{
    static Pair arr[];
    static int N, K;
    static int bag[];
    static PriorityQueue<Integer> priorityQueue;

    public static int binarySearch(int start, int target){
        int s = start;
        int end = N;
        int mid = 0;

        while (s < end){
            mid = s + end >> 1;
            if(target >= arr[mid].weight){
                s = mid + 1;
            }else{
                end = mid;
            }
        }

        return end;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new Pair[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[i] = new Pair(w, v);
        }

        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.weight - o2.weight;
            }
        });

        bag = new int[K];
        for(int i = 0; i < K; i++){
            bag[i] = Integer.parseInt(br.readLine());
        }

        priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Arrays.sort(bag);

        long sum = 0;
        int s = 0;

        for(int i = 0; i < K; i++){
            int current = bag[i];

            int e = binarySearch(s, current);

            for(int j = s; j < e; j++){
                priorityQueue.add(arr[j].value);
            }

            if(!priorityQueue.isEmpty()){
                sum += priorityQueue.remove();
            }

            s = e;
        }

        System.out.println(sum);
    }
}
class Pair{
    int weight;
    int value;
    Pair(int w, int v){
        weight = w;
        value = v;
    }
}
