import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GraphSearch {

    public static void DFS(int g[][]) {
        int n = g.length;
        boolean visited[] = new boolean[n];
        BFSUtil(0, g, visited);
    }

    public static void BFSUtil(int vertex, int g[][], boolean visited[] ) {
        visited[vertex] = true;
        System.out.println(vertex + " ");
        for(int i = 0 ; i < g.length; i++) {
            if(g[vertex][i] == 1 && !visited[i]) {
                BFSUtil(i, g, visited);
            }
        }


    }


    public static void BFS(int g[][]) {
        int n = g.length;
        boolean visited[] = new boolean[n];
        System.out.println(Arrays.toString(visited));
        Queue<Integer> q = new LinkedList<>();
        visited[0] = true;
        q.add(0);
        while (!q.isEmpty()) {
            int vertexExplore = q.remove();
            System.out.print(vertexExplore + " ");

            for(int i = 0; i < n ; i++) {
                if(g[vertexExplore][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        
    }
    public static void main(String[] args) {
        int graph[][] = { 
            { 0, 1, 0, 1} ,
            { 1, 0, 1, 0},
            { 0, 1, 0, 1},
            { 1, 0, 1, 0}};
            BFS(graph);
            System.out.println("\n");
            System.out.println("------------------------------------------------- \n");
            DFS(graph);



    }
    
}
