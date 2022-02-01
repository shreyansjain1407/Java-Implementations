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
    int capacity;
    int start;
    int end;
    public Node(int start, int capacity){
        this.capacity = capacity;
        this.start = start;
        this.end = start;
    }
    public String getSlot(){
        StringBuilder sb = new StringBuilder();
        int stHr = start/4;
        int stMin = (start%4)*15;
        int enHr = (end+1)/4;
        int enMin = (((end+1)%96)%4)*15;
        if(stHr < 10){
            sb.append("0");
        }sb.append(stHr).append(":");
        if(stMin == 0){
            sb.append("0");
        }sb.append(stMin).append("-");
        if(enHr < 10){
            sb.append("0");
        }sb.append(enHr).append(":");
        if(enMin == 0){
            sb.append("0");
        }sb.append("0");
        
        return sb.toString();
    }
}
class FindMeetingSlotsPathAI {

    /*
     * Complete the 'find_meeting_slots' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER num_slots
     *  2. 2D_STRING_ARRAY employee_schedules
     */

    public static List<String> find_meeting_slots(int num_slots, List<List<String>> employee_schedules) {
    // Write your code here
        System.err.println(num_slots);
        int[] time = new int[96];
        Set<Integer> available = new HashSet<>();
        setTime(time, employee_schedules, available);
        Map<Integer, List<Node>> map = new HashMap<>();
        
        System.err.println(Arrays.toString(time));
        
        addNodesToMap(time, map);
        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>(){
            public int compare(Node n1, Node n2){
                if(n1.capacity != n2.capacity){
                    return n2.capacity - n1.capacity;
                }else{
                    return n1.start - n2.start;
                }
            }
        });
        for(int key : map.keySet()){
            queue.addAll(map.get(key));
        }
        if(queue.size() < num_slots){
            return new ArrayList<String>();
        }
        List<String> finalSlots = new ArrayList<>();
        
        while(!queue.isEmpty() && num_slots > 0){
            System.err.println(queue.peek().capacity);
            finalSlots.add(queue.poll().getSlot());
            num_slots--;
        }
        return finalSlots;
    }
    
    //Function to add time slots to the map
    public static void addNodesToMap(int[] time, Map<Integer, List<Node>> map){
        for(int i = 0; i < 96; i++){
            if(time[i] >= 2){
                if(map.containsKey(time[i])){
                    List<Node> tempList = map.get(time[i]);
                    if(tempList.get(tempList.size()-1).end == i-1){
                        tempList.get(tempList.size()-1).end = i;
                    }else{
                        tempList.add(new Node(i, time[i]));
                    }
                }else{
                    Node temp = new Node(i, time[i]);
                    map.put(time[i], new ArrayList<Node>(){{add(temp);}});
                }
            }
        }
    }
    
    //Function to mark the time slots of when employees are available for meetings
    public static void setTime(int[] time, List<List<String>> employee_schedules, Set<Integer> available){
        for(List<String> employee : employee_schedules){
            System.err.println("EXE");
            for(String meeting: employee){
                System.err.println(meeting);
                String[] cur = meeting.split("-");
                String[] start = cur[0].split(":");
                String[] end = cur[1].split(":");
                int stHr = Integer.parseInt(start[0]);
                int stMin = Integer.parseInt(start[1]);
                int stIndex = stHr*4 + stMin/15;
                int endHr = Integer.parseInt(end[0]);
                int endMin = Integer.parseInt(end[1]);
                int endIndex = endHr*4 + endMin/15;
                System.err.println("Start: " + stIndex + " End: " + endIndex);
                
                // System.err.println(stIndex + " " + endIndex);
                time[stIndex]++;
                if(endIndex < 96){
                    // System.err.println("EXE");
                    time[endIndex]--;
                }
            }
        }
        System.err.println(Arrays.toString(time));
        int carry = 0;
        int totalEmployees = employee_schedules.size();
        for(int i = 0; i < time.length; i++){
            carry += time[i];
            time[i] = carry;
            time[i] = totalEmployees - time[i];
            if(time[i] != 0)available.add(time[i]);
        }
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int num_slots = Integer.parseInt(bufferedReader.readLine().trim());

        int employee_schedulesRows = Integer.parseInt(bufferedReader.readLine().trim());
        int employee_schedulesColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> employee_schedules = new ArrayList<>();

        IntStream.range(0, employee_schedulesRows).forEach(i -> {
            try {
                employee_schedules.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<String> result = Result.find_meeting_slots(num_slots, employee_schedules);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
