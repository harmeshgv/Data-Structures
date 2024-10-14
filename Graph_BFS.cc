#include <iostream>
#include <vector>
#include <queue>
using namespace std;

vector<int> bfsofGraph(int V, vector<int> adj[]) {
    vector<int> vis(V, 0); // Corrected the size of the vis array
    vis[0] = 1;
    queue<int> q;
    q.push(0);
    vector<int> bfs;
    
    while (!q.empty()) {
        int node = q.front();
        q.pop();
        bfs.push_back(node); // Corrected the push_back method

        for (auto it : adj[node]) {
            if (!vis[it]) {
                vis[it] = 1; // Corrected the assignment operator
                q.push(it);
            }
        }
    }
    return bfs; // Added return statement
}

int main() {
    int V = 5; // Example number of vertices
    vector<int> adj[V]; // Example adjacency list
    // Add edges to the adjacency list
    adj[0].push_back(1);
    adj[0].push_back(2);
    adj[1].push_back(3);
    adj[2].push_back(4);

    vector<int> result = bfsofGraph(V, adj);
    for (int i : result) {
        cout << i << " ";
    }
    return 0;
}
