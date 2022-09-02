package hometasks.hw6customlinkedlist;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class CustomLinkedList<T> implements Iterable {
    //Attributes
    private Node<T> first;
    private List<Node> nodeList;
    private Node<T> last;

    //Constructors
    public CustomLinkedList() {
        this.first = null;
        this.last = null;
    }

    public CustomLinkedList(Node<T> node) {
        this.nodeList.add(node);
        this.first = node;
        this.last = node;
    }

    //Setters & Getters


    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> first) {
        if (this.first == null) {
            this.first = first;
        } else {
            this.first.setNextNode(this.first);
            this.first = first;
        }
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    public Node<T> getLast() {
        return last;
    }

    public void setLast(Node lastNode) {
        if (this.last == null) {
            this.last = lastNode;
        } else {
            this.last.setPreviousNode(this.last);
            this.last = lastNode;
        }
    }

    //Methods
    public T getFirstNodeData() {
        return this.getFirst().getData();
    }

    public T getLastNodeData() {
        return this.getLast().getData();
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
