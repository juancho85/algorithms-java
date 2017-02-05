package jds.algos.bfs;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Breath first search algorithm. is an algorithm for traversing or searching
 * tree or graph data structures. It starts at the tree root (or some arbitrary node
 * of a graph, sometimes referred to as a 'search key'[1]) and explores the neighbor
 * nodes first, before moving to the next level neighbors.
 *
 * BFS was invented in the late 1950s by E. F. Moore,
 * who used it to find the shortest path out of a maze
 */
@Component
public class BreathFirstSearch {

    public void bfs(Vertex root) {
        Queue<Vertex> queue = new LinkedList<>();
        root.setVisited(true);
        queue.add(root);

        while (!queue.isEmpty()) {
            Vertex actualVertex = queue.remove();
            System.out.println(actualVertex + " ");

            for(Vertex v : actualVertex.getNeighbourList()) {
                if(!v.isVisited()) {
                    v.setVisited(true);
                    queue.add(v);
                }
            }
        }
    }
}
