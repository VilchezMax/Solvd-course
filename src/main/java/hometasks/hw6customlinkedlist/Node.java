package com.customlinkedlist.linkedlist;

public class Node<T> {
    //Attributes
    private Node previousNode;
    private T data;
    private Node nextNode;

    //Constructors

    public Node(Node previousNode, T data, Node nextNode) {
        this.previousNode = previousNode;
        this.data = data;
        this.nextNode = nextNode;
    }

    //Setters & Getters

    public Node getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }


    //Methods


}
