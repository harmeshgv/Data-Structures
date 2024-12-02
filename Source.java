/* 2. Check Whether the Graph Is Bipartite
Coding
Accepted
You are given an adjacency matrix representation of an undirected graph, and you need to check whether the graph is a bipartite graph or not. If it is a bipartite graph, print ‘Yes’; otherwise, print ‘No’.
Note: The graph might be disconnected too.

Input: The input will be in the following format:
The first line will be an integer N representing the size of the adjacency matrix.
The next N lines will represent the adjacency matrix.
Each line denotes the row of the adjacency matrix, and each element in the line is separated by a space.



Output: The output should be in the following format:
If the graph represented by the given adjacency matrix is a bipartite graph, print ‘Yes’; otherwise, print ‘No’.



Sample test case 1
Input:
4
0 1 1 0
1 0 0 1
1 0 0 1
0 1 1 0

Output:
Yes

Sample test case 2
Input:
3
0 1 1
1 0 1
1 1 0

Output:
No


Execution time limit */


import java.util.*;

public class Source {

    public static boolean isBipartite(int[][] adjMatrix, int noOfNodes) {
        int[] colors = new int[noOfNodes];
        Arrays.fill(colors, -1); // -1 means uncolored

        for (int startNode = 0; startNode < noOfNodes; startNode++) {
            if (colors[startNode] == -1) { // Unvisited node
                if (!bfsCheck(adjMatrix, startNode, colors)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean bfsCheck(int[][] adjMatrix, int startNode, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        colors[startNode] = 0; // Start coloring with 0

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor = 0; neighbor < adjMatrix.length; neighbor++) {
                if (adjMatrix[node][neighbor] == 1) { // There is an edge
                    if (colors[neighbor] == -1) { // Not colored yet
                        colors[neighbor] = 1 - colors[node]; // Alternate color
                        queue.add(neighbor);
                    } else if (colors[neighbor] == colors[node]) { // Same color conflict
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Get the number of nodes in the graph
        int noOfNodes = in.nextInt();

        // Adjacency matrix used to represent the graph
        int[][] adjMatrix = new int[noOfNodes][noOfNodes];
        for (int i = 0; i < noOfNodes; i++) {
            for (int j = 0; j < noOfNodes; j++) {
                adjMatrix[i][j] = in.nextInt();
            }
        }

        // Check if the graph is bipartite
        if (isBipartite(adjMatrix, noOfNodes)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
