package com.company;

public class setItem {

    private final int x;
    private final int y;
    private setItem head;
    private setItem next;
    private setItem tail;

    public setItem(int x, int y) {
        this.x = x;
        this.y = y;
        head = this;
        next = null;
        tail = this;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public setItem getHead() {
        return head;
    }

    public void setHead(setItem head) {
        this.head = head;
    }

    public setItem getNext() {
        return next;
    }

    public void setNext(setItem next) {
        this.next = next;
    }

    public setItem getTail() {
        return tail;
    }

    public void setTail(setItem tail) {
        this.tail = tail;
    }
}
