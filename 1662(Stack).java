import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        Stack<String>stack = new Stack<>();

        String s = br.readLine();

        for(int i = s.length()-1; i >= 0; i--){
            String temp = String.valueOf(s.charAt(i));
            if(temp.equals(")")){
                stack.add(temp);
            }else if(temp.equals("(")){
                //StringBuilder sb = new StringBuilder();
                //StringBuilder add = new StringBuilder();
                int leng = 0;
                while (!stack.peek().equals(")")){
                    String pop = stack.pop();
                    if(pop.equals("---")){
                        leng += (Integer.parseInt(stack.pop()));
                    }else{
                        leng++;
                    }
                }

                String num = String.valueOf(s.charAt(i-1));
                stack.pop();

                int sum = Integer.parseInt(num) * leng;

                stack.push(Integer.toString(sum));
                stack.push("---");

                i--;
            }else{
                stack.push(temp);
            }
        }

        while (!stack.isEmpty()){
            String temp = stack.pop();
            if(temp.equals("---")){
                temp = stack.pop();
                answer += Integer.parseInt(temp);
            }else {
                answer += temp.length();
            }
        }
        System.out.println(answer);
    }
}
