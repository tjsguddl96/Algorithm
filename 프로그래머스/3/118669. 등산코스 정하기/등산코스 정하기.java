import java.util.*;

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        // 그래프 초기화
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            int from = path[0], to = path[1], weight = path[2];
            graph.get(from).add(new Edge(to, weight));
            graph.get(to).add(new Edge(from, weight));
        }

        // 출입구와 산봉우리를 HashSet으로 저장
        Set<Integer> gateSet = new HashSet<>();
        for (int gate : gates) {
            gateSet.add(gate);
        }

        Set<Integer> summitSet = new HashSet<>();
        for (int summit : summits) {
            summitSet.add(summit);
        }

        // intensity 배열 초기화
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);

        // 우선순위 큐 초기화
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        // 모든 출입구(gates)에서 시작
        for (int gate : gates) {
            pq.add(new Edge(gate, 0));
            intensity[gate] = 0;
        }

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int now = current.to, nowWeight = current.weight;

            // 현재 경로가 기존 intensity보다 큰 경우 무시
            if (nowWeight > intensity[now]) continue;

            for (Edge edge : graph.get(now)) {
                int next = edge.to, weight = edge.weight;
                int maxIntensity = Math.max(intensity[now], weight);

                // 출입구로 되돌아가는 경우 방지
                if (gateSet.contains(next)) continue;

                // 산봉우리를 지나갈 수 없도록 설정
                if (intensity[next] > maxIntensity) {
                    intensity[next] = maxIntensity;

                    // 산봉우리는 목적지로만 간주하므로 큐에 넣지 않음
                    if (!summitSet.contains(next)) {
                        pq.add(new Edge(next, maxIntensity));
                    }
                }
            }
        }

        // 결과 처리
        int minIntensity = Integer.MAX_VALUE;
        int bestSummit = -1;

        Arrays.sort(summits); // 낮은 번호의 산봉우리를 우선 선택
        for (int summit : summits) {
            if (intensity[summit] < minIntensity) {
                minIntensity = intensity[summit];
                bestSummit = summit;
            }
        }

        return new int[]{bestSummit, minIntensity};
    }

    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
