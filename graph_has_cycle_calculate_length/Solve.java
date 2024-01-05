package graph_has_cycle_calculate_length;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solve {

    public Stack<Integer> currents;
    public int size;
    public Stack<Integer> cycle;

    public Solve(){
        currents = new Stack<>();
        cycle = new Stack<>();
        size = 0;
    }

    public void run(int nodes, int edges, List<Edge> list){
        boolean[][] is_connect = new boolean[nodes][nodes];
        int n1,n2;
        for (int i=0; i<edges; i++){
            n1 = list.get(i).node1;
            n2 = list.get(i).node2;
            is_connect[n1][n2] = true;
            is_connect[n2][n1] = true;
        }

        boolean[] visited = new boolean[nodes];
        boolean foundCycle = false;
        for (int i=0; i<nodes; i++){
            visited[i] = true;
            currents.push(i);
            size++;
            foundCycle = recursion(is_connect, i, visited);
            if (foundCycle) break;
            currents.pop();
            size--;
            visited[i] = false;
        }

        boolean[] in_cycle = new boolean[nodes];
        while (!cycle.isEmpty()){
            in_cycle[cycle.pop()] = true;
        }

        int[] ans = new int[nodes];
        for (int i=0; i<nodes; i++){
            if (in_cycle[i]) ans[i] = 0;
            else ans[i] = Dijkstra(is_connect, nodes, i, in_cycle);
        }

        System.out.println(Arrays.toString(ans));

    }


    public boolean recursion(boolean[][] is_connect, int current, boolean[] visited){
        boolean foundC = false;
        for (int i=0; i < visited.length; i++){
            if (is_connect[current][i]){
                if (size > 2 && visited[i]){
                    while (!currents.isEmpty()){
                        cycle.push(currents.pop());
                    }
                    return true;
                }else if(!visited[i]){
                    visited[i] = true;
                    currents.push(i);
                    size++;
                    foundC = recursion(is_connect, i, visited);
                    if (foundC) break;
                    currents.pop();
                    size--;
                    visited[i] = false;
                }
            }
        }
        return foundC;
    }

    /**
     * @description dis[]: vertex 0 to every vertex； 有問題
     * @param is_connected
     * @param nodes
     * @param from
     * @param in_cycle
     */
    public int Dijkstra(boolean[][] is_connected, int nodes, int from, boolean[] in_cycle){
        int[] dis = new int[nodes];
        int min = nodes;
        for (int i=0; i<nodes; i++){
            if (i != from){
                if (is_connected[from][i]) dis[i] = 1;
                else dis[i] = nodes;
            }
        }
        for (int i=0; i<nodes; i++){
            if (i != from){
                for (int j=i+1; j<nodes; j++){
                    if (is_connected[i][j] && dis[j] > dis[i] + 1) dis[j] = dis[i] + 1;
                }
            }
        }

        for (int i=0; i<nodes; i++){
            if (in_cycle[i] && min > dis[i]) min = dis[i];
        }
        return min;
    }

}