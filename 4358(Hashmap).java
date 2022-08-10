import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class dic implements Comparable<String>{
    String name;
    public dic(String name){
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
       StringBuilder sb = new StringBuilder();
    
       HashMap<String , Integer> hashMap = new HashMap<>();

       int count = 0;
       while (true){
           String s = br.readLine();
           if(s == null){
               break;
           }
           if(!hashMap.containsKey(s)){
               hashMap.put(s, 1);
           }else{
               hashMap.put(s, hashMap.get(s) + 1);
           }
           count++;
       }
        ArrayList<String> arrayList = new ArrayList<>(hashMap.keySet());
       Collections.sort(arrayList);

       for(String name : arrayList){
           int num = hashMap.get(name);
           String percent = String.format("%.4f", num/(double)count * 100);
           sb.append(name).append(" ").append(percent).append('\n');
       }
        System.out.println(sb);
    }
}
