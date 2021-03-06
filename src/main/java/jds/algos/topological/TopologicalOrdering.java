package jds.algos.topological;

import jds.algos.vertex.Vertex;
import org.springframework.stereotype.Component;

import java.util.Stack;

/*In the field of computer science, a topological sort or topological ordering
of a directed graph is a linear ordering of its vertices such that for every
directed edge uv from vertex u to vertex v, u comes before v in the ordering.
For instance, the vertices of the graph may represent tasks to be performed,
and the edges may represent constraints that one task must be performed before
another; in this application, a topological ordering is just a valid sequence
for the tasks. A topological ordering is possible if and only if the graph has
no directed cycles, that is, if it is a directed acyclic graph (DAG). Any DAG has
at least one topological ordering, and algorithms are known for constructing a
topological ordering of any DAG in linear time.*/
@Component
public class TopologicalOrdering {

    private Stack<Vertex> stack;

    public TopologicalOrdering() {
        this.stack = new Stack<>();
    }

    public void dfs(Vertex vertex) {
        vertex.setVisited(true);

        for(Vertex v : vertex.getNeighbourList()) {
            if(!v.isVisited()) {
                dfs(v);
            }
        }

        stack.push(vertex);
    }

    public Stack<Vertex> getStack() {
        return this.stack;
    }
}
