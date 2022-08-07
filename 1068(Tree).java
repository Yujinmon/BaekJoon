import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>arrayList[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int root = -1;
        N = Integer.parseInt(br.readLine());
        arrayList = new ArrayList[N];

        for(int i = 0; i < N; i++){
            arrayList[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num == -1){
                root = i;
            }else{
                arrayList[num].add(i);
            }
        }

        int delete = Integer.parseInt(br.readLine());


    }
}
