package com.tridu33.mineOJ.Problems;


import java.util.LinkedList;
import java.util.Queue;

public class QuickFindUnion {
    // 并查集
    public static void main(String[] args) {
        QuickFindUnion.Sol sol = new QuickFindUnion().new Sol();
        System.out.println(sol.method(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
        System.out.println(sol.method(new int[][]{{1,0,0},{0,1,0},{0,0,1}}));
    }
    class Sol {
        public int method(int[][] provinces) {
            int res = findCircleNum(provinces);
            return res;
        }
        public int findCircleNum1(int[][] isConnected){
            int cities = isConnected.length;
            boolean[] visited = new boolean[cities];
            int provinces = 0;
            for(int from =0;from<cities;from++){
                if(!visited[from]){
                    dfs(isConnected,visited,cities,from);
                    provinces++;
                }
            }
            return provinces;
        }
        private void dfs(int[][] isConnected, boolean[] visited, int cities, int from){
            for(int to=0; to<cities;to++){
                if(!visited[to] && isConnected[from][to]==1){
                    visited[to] = true;
                    dfs(isConnected,visited,cities,to);
                }
            }
        }
        public int findCircleNum2(int[][] isConnected){
            int provinces = 0;
            int cities = isConnected.length;
            boolean[] visited = new boolean[cities];
            Queue<Integer> q = new LinkedList<>();
            for(int from=0;from<cities;from++){
                // BFS
                if(!visited[from]){
                    q.offer(from);
                    while(!q.isEmpty()){
                        int cur = q.poll();
                        visited[cur] = true;
                        for(int next=0;next<cities;next++){
                            if(!visited[next] && isConnected[cur][next] == 1){
                                q.offer(next);
                            }
                        }
                    }
                    provinces++;
                }
            }
            return provinces;
        }
        public int findCircleNum(int[][] isConnected){
            int cities = isConnected.length;
            int[] parents = new int[cities];
            for(int i =0;i<cities;i++){
                parents[i] = i;
            }
            for(int i =0;i<cities;i++){
                for(int j =0;j<cities;j++){
                    if(isConnected[i][j] == 1){
                        union(parents,i,j);
                    }
                }
            }
            int provinces = 0;
            for(int i =0;i<cities;i++){
                if(parents[i] == i){
                    provinces++;
                }
            }
            return provinces;
        }
        public int getFather(int[]parents,int i) {
            if(parents[i] !=i){
                parents[i] = getFather(parents,parents[i]);
            };
            return parents[i];
        }

        public int union(int[]parents,int idx1,int idx2) {
            parents[getFather(parents,idx1)] = getFather(parents,idx2);
            return 0;
        }
    }

}
