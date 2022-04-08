package com.company;

public class setItem {

    private setItem head;
    private setItem next;
    private setItem tail;

    public setItem() {
        head = this;
        next = null;
        tail = this;
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
