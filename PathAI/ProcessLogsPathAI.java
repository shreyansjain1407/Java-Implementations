import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Node{
    int id;
    int signin;
    int signout;
    public Node(int id){
        this.id = id;
        signin = -1;
        signout = -1;
    }
}
class ProcessLogsPathAI {

    /*
     * Complete the 'processLogs' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY logs
     *  2. INTEGER maxSpan
     */

    public static List<String> processLogs(List<String> logs, int maxSpan) {
    // Write your code here
        HashMap<Integer, Node> userMap = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>();
        for(String log: logs){
            String[] curLog = log.split(" ");
            int id = Integer.parseInt(curLog[0]);
            Node cur;
            if(userMap.containsKey(id)){
                cur = userMap.get(id);
            }else{
                cur = new Node(id);
                userMap.put(id, cur);
            }
            if(curLog[2].equals("sign-in")){
                cur.signin = Integer.parseInt(curLog[1]);
            }else{
                cur.signout = Integer.parseInt(curLog[1]);
            }
            if(cur.signin != -1 && cur.signout != -1 && cur.signout - cur.signin <= maxSpan){
                queue.add(id);
            }
        }
        List<String> output = new ArrayList<>();
        while(!queue.isEmpty())
            output.add(String.valueOf(queue.poll()));
        return output;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int logsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> logs = IntStream.range(0, logsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int maxSpan = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> result = Result.processLogs(logs, maxSpan);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
