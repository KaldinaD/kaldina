package org.example.lab4;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Data
@AllArgsConstructor
public class Node {
    private int id;
    private StatusNode status;
    private List<Node> linked;


    public Node(final int id) {
        this.id = id;
        status = StatusNode.GREEN;
        linked = new ArrayList<>();
    }

    public void addLink(final Node link) {
        linked.add(link);
    }

    public boolean isRed() {
        if (status == StatusNode.RED) {
            return true;
        } else {
            return false;
        }
    }

    public void setStatus(StatusNode status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Node people = (Node) o;
        return id == people.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
