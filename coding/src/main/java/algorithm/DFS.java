package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class DFS {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("A", asList("B","C"));
        map.put("B", asList("A","D"));
        map.put("C",asList("A","G","H","I"));
        map.put("D",asList("B","E","F"));
        map.put("E", List.of("D"));
        map.put("F", List.of("D"));
        map.put("G",List.of("C"));
        map.put("H",List.of("C"));
        map.put("I",asList("C","J"));
        map.put("J",List.of("I"));

        System.out.println(new DFS().dfs(map,"A"));
    }

    public List<String> dfs(Map<String,List<String>> map,String startNode){
        List<String> visited = new ArrayList<>();
        List<String> needVisit = new ArrayList<>();

        needVisit.add(startNode);

        while(needVisit.size()>0){
            String node = needVisit.remove(needVisit.size()-1); //bfs와 다른곳 queue->stack 변경

            if(!visited.contains(node)){
                visited.add(node);
                needVisit.addAll(map.get(node));
            }
        }//while

        return visited;
    }
}
