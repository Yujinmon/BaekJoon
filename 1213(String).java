import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        char arr[] = br.readLine().toCharArray();
        int alpa[] = new int[27 + 'A'];

        for (char c : arr) {
            alpa[c]++;
        }

        boolean fail = false;
        if(arr.length % 2 == 0){ //even number
            for(int num : alpa){
                if(num % 2 != 0){
                    fail = true;
                    break;
                }
            }
        }else{ //odd
            boolean flag = false;
            for(int num : alpa){
                if(num % 2 != 0){
                    if(!flag){
                        flag = true;
                    }else{
                        fail = true;
                        break;
                    }
                }
            }
        }

        if(fail){
            System.out.println("I'm Sorry Hansoo");
        }else{
            char answer[] = new char[arr.length];
            int index = 0;

            if(arr.length % 2 != 0){
                char one = 'a';
                for(int i = 'A'; i < 'A' + 27; i++){
                    if(alpa[i] % 2 == 1){
                        one = (char)i;
                        alpa[i]--;
                        break;
                    }
                }
                answer[arr.length / 2] = one;
            }

            for(int i = 'A'; i < 'A' + 27; i++){
                if(alpa[i] % 2 == 0){
                    while (alpa[i] != 0){
                        answer[index] = (char) i;
                        answer[arr.length - index - 1] = (char) i;

                        index++;
                        alpa[i] -= 2;
                    }
                }
            }

            for(char c : answer){
                sb.append(c);
            }

            System.out.println(sb);
        }
    }
}

