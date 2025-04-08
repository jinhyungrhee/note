package algo.interview.zz_concept.graph;

import java.util.*;
public class Dfs {

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

        List<Integer> r = new ArrayList<>();
        System.out.println(recursiveDFS(1, r)); // [1, 2, 5, 6, 7, 3, 4] (사전식 순서 방문)
        System.out.println(iterativeDFS(1)); // [1, 4, 3, 5, 7, 6, 2] (역순 방문)

    }

    // 1.재귀 사용 DFS
    public static List<Integer> recursiveDFS(int v, List<Integer> discovered) {
        // 현재 노드 저장
        discovered.add(v);

        // 주변 노드 반복
        for (Integer w : graph.get(v)) {
            // 아직 처리되지 않은 노드라면 깊이 기반 탐색 진행
            if(!discovered.contains(w)) {
                // *방문했던 정점(discovered)을 계속 누적된 결과로 만들기 위해 리턴하는 형태*
                discovered = recursiveDFS(w, discovered);
            }
        }
        // 모든 깊이를 탐색하면 리턴
        return discovered;
    }

    // 2.반복 사용 DFS (+Stack)
    public static List<Integer> iterativeDFS(int v) {
        // 방문 노드 리스트
        List<Integer> discovered = new ArrayList<>();
        // 효율적인 스택 자료 구조 : ArrayDeque
        Deque<Integer> stack = new ArrayDeque<>();
        // 현재 노드 스택에 삽입
        stack.push(v);
        // 스택이 모두 비워질 때까지 반복
        while(!stack.isEmpty()) {
            v = stack.pop();
            // 이미 방문한 노드가 아니면, 방문 노드에 추가하고
            if (!discovered.contains(v)) {
                discovered.add(v);
                // 현재 노드에서 연결된 모든 주변 노드를 스택에 삽입
                for (Integer w : graph.get(v)) {
                    stack.push(w);
                }
            }
        }
        // 더 이상 탐색할 노드가 없으면 방문 노드 리스트 리턴
        return discovered;
    }
}
