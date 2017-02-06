package jds.algos.dfs;

import jds.algos.vertex.Vertex;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Stack;

/**
 * Depth-first search (DFS) is an algorithm for traversing or searching tree or graph
 * data structures. One starts at the root (selecting some arbitrary node as the root
 * in the case of a graph) and explores as far as possible along each branch before
 * backtracking.
 */
@Component
public class DepthFirstSearch {

    private Stack<Vertex> stack;

    public DepthFirstSearch() {
        this.stack = new Stack<>();
    }

    public void dfs(List<Vertex> vertexList) {
        //loop needed when we have multiple clusters
        for(Vertex v : vertexList){
            if(!v.isVisited()) {
                v.setVisited(true);
                dfsRecursive(v);
//                dfsWithStack(v);
            }
        }
    }

    private void dfsRecursive(Vertex v) {
        System.out.println(v+ " ");
        for(Vertex vertex : v.getNeighbourList()){
            if(!vertex.isVisited()) {
                vertex.setVisited(true);
                dfsRecursive(vertex);
            }
        }
    }

    private void dfsWithStack(Vertex rootVertex)  {
        rootVertex.setVisited(true);
        this.stack.add(rootVertex);

        while(!stack.isEmpty()) {
            Vertex actualVertex = this.stack.pop();
            System.out.println(actualVertex+ " ");
            for(Vertex v : actualVertex.getNeighbourList()) {
                if(!v.isVisited()) {
                    v.setVisited(true);
                    this.stack.push(v);
                }
            }
        }
    }
}
