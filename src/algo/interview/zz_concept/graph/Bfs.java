package algo.interview.zz_concept.graph;

import java.util.Arrays;

import java.util.*;
public class Bfs {

    static Map<Integer, List<Integer>> graph = new HashMap<>();

    public static void main(String[] args) {

        /**
         *  Adjacency List
         *  key -> source node
         *  value -> destination node
         */
        graph.put(1, Arrays.asList(2, 3, 4));
        graph.put(2, Arrays.asList(5));
        graph.put(3, Arrays.asList(5));
        graph.put(4, Arrays.asList());
        graph.put(5, Arrays.asList(6, 7));
        graph.put(6, Arrays.asList());
        graph.put(7, Arrays.asList(3));

        System.out.println(iterativeBFS(1)); // [1, 2, 3, 4, 5, 6, 7]


    }

    public static List<Integer> iterativeBFS(int start_v) {
        // 방문 노드 리스트
        List<Integer> discovered = new ArrayList<>();
        // 큐는 인터페이스이며 자료형 선언은 LinkedList 사용
        Queue<Integer> queue = new LinkedList<>();
        // 시작노드 삽입
        discovered.add(start_v);
        queue.add(start_v);
        // 큐가 모두 비워질 때까지 반복
        while(!queue.isEmpty()) {
            // 큐에서 추출
           int v = queue.poll();
           // 현재 노드에서 연결된 모든 주변 노드를 큐에 삽입
            for (Integer w : graph.get(v)) {
                // 이미 방문한 노드가 아니면, 방문 노드에 추가하고 주변 노드르 모두 큐에 삽입
                if(!discovered.contains(w)) {
                    discovered.add(w);
                    queue.add(w);
                }
            }
        }
        // 더 이상 탐색할 노드가 없으면, 방문 노드 리스트 리턴
        return discovered;
    }

}
