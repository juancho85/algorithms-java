package jds.algos.vertex;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the nodes of a graph.
 */
public class Vertex {

    private String data;

    private boolean visited;

    private List<Vertex> neighbourList;

    public Vertex(String data) {
        this.data = data;
        this.neighbourList = new ArrayList<>();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getNeighbourList() {
        return neighbourList;
    }

    public void setNeighbourList(List<Vertex> neighbourList) {
        this.neighbourList = neighbourList;
    }

    public void addNeighbourVertex(Vertex vertex) {
        this.neighbourList.add(vertex);
    }

    @Override
    public String toString() {
        return this.data;
    }
}
