package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleI {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        for(int i=0; i< numCourses; i++) edges.add(new ArrayList<>());
        for(int[] pre : prerequisites)edges.get(pre[1]).add(pre[0]);

        int[] visited = new int[numCourses];
        for(int i=0; i< numCourses; i++){
            if(!dfs(edges, i, visited)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> edges, int v, int[] visited) {
        visited[v] = 1;
        for(int u : edges.get(v)){
            if(visited[u]==1) return false;
            if(visited[u]==0) if(!dfs(edges, u, visited)) return false;
        }
        visited[v] = 2;
        return true;
    }

}
