import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Double arr[] = new Double[100];

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int a = 65;
        for(int i = 0; i < N; i++){
            arr[a] = Double.parseDouble(br.readLine());
            a++;
        }

        Stack<Double>stack = new Stack<>();
        int length = s.length();

        for(int i = 0; i < length; i++){
            if(s.charAt(i) >= 65 && s.charAt(i) <= 90){
                stack.push(arr[s.charAt(i)]);
            }else{
                if(s.charAt(i) == '+'){
                    double second = stack.pop();
                    double first = stack.pop();
                    stack.push(second+first);
                }else if(s.charAt(i) == '*'){
                    double second = stack.pop();
                    double first = stack.pop();
                    stack.push(second*first);
                }else if(s.charAt(i) == '-'){
                    double second = stack.pop();
                    double first = stack.pop();
                    stack.push(first - second);
                }else if(s.charAt(i) == '/'){
                    double second = stack.pop();
                    double first = stack.pop();
                    stack.push(first/second);
                }
            }
        }
        double answer = stack.pop();
        System.out.println(String.format("%.2f", answer));
    }
}
//stack에 뒤에서 부터 차례로 넣는다
//
