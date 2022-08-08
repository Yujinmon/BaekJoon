import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class dictionary implements Comparable<String>{
    String name;

    public dictionary(String name){
        this.name = name;
    }
    @Override
    public int compareTo(String s){
        return name.compareTo(s);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        HashMap<String, Integer> hashMap = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N+M; i++){
            String name = br.readLine();
            if(!hashMap.containsKey(name)){
                hashMap.put(name, 1);
            }else{
                hashMap.put(name, 2);
            }
        }
        ArrayList<String>arrayList = new ArrayList<>();
        for(String name : hashMap.keySet()){
            if(hashMap.get(name) == 2){
                arrayList.add(name);
            }
        }

        Collections.sort(arrayList);
        sb.append(arrayList.size()).append('\n');
        for(String name : arrayList){
            sb.append(name).append('\n');
        }
        System.out.println(sb);
    }
}
