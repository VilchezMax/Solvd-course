package hometasks.hw6customlinkedlist;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class CustomLinkedList implements Iterable {
    //Attributes
    private Node firstNode;
    private List<Node> nodeList;
    private Node lastNode;

    //Constructors
    public CustomLinkedList() {
        this.firstNode = null;
        this.lastNode = null;
    }

    public CustomLinkedList(Node node) {
        this.nodeList.add(node);
        this.firstNode = node;
        this.lastNode = node;
    }

    //Setters & Getters

    //Methods
    public Object getFirst() {
        return this.getFirstNode().getData();
    }

    public Object getLast() {
        return this.getLastNode().getData();
    }

    public Node getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(Node firstNode) {
        this.firstNode = firstNode;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    public Node getLastNode() {
        return lastNode;
    }

    public void setLastNode(Node lastNode) {
        this.lastNode = lastNode;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator();
    }

}
