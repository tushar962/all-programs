package com.maddy.collections;

/**
 * Created by madhukar.b on 16/10/16.
 */
public class MyLinkedList
{
    private UniDirectionalNode head;
    public MyLinkedList()
    {
        this.head = null;
    }

    /**
     * Add element to list at the end
     * @param data element to be inserted
     */
    public void add(int data)
    {
        if(head == null)
        {
            head = new UniDirectionalNode(data);
            return;
        }

        UniDirectionalNode temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }

        temp.next = new UniDirectionalNode(data);
    }

    public void addAtBeginning(int data)
    {
        UniDirectionalNode temp = new UniDirectionalNode(data);
        temp.next = head;
        head = temp;
    }

    public void print()
    {
        UniDirectionalNode temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    /**
     * Find element in list
     * @param data
     * @return index of element in list if element is present else returns -1
     */
    public int find(int data)
    {
        return findInternal(head,data,0);
    }

    private int findInternal(UniDirectionalNode head, int data, int index)
    {
        if(head == null)
            return -1;

        index++;
        if(head.data == data)
            return index;

        return findInternal(head.next, data, index);
    }

    /**
     * Function to swap node of linked list
     * @param x element to be swapped
     * @param y element to be swapped
     */
    public void swap(int x, int y)
    {
        if(head == null || x==y)
            return;

        UniDirectionalNode prevX = null;
        UniDirectionalNode _x = null;
        UniDirectionalNode prevY = null;
        UniDirectionalNode _y = null;
        UniDirectionalNode temp = head;

        if(head.data == x)
            _x = head;

        if(head.data == y)
            _y = head;

        while(temp.next != null)
        {
            if(_x == null && temp.next.data == x)
            {
                prevX = temp;
                _x = temp.next;
            }

            if(_y == null && temp.next.data == y)
            {
                prevY = temp;
                _y = temp.next;
            }

            if(_x != null && _y != null)
                break;

            temp = temp.next;
        }



        if(_x == null || _y == null)
            return;

        if(prevX == null) // x is at head
        {
            head = _y;
        }
        else
        {
            prevX.next = _y;
        }

        if(prevY == null) // y is at head
        {
            head = _x;
        }
        else
        {
            prevY.next = _x;
        }

        UniDirectionalNode temp1 = _x.next;
        _x.next = _y.next;
        _y.next = temp1;
    }

    public void reverse()
    {
        UniDirectionalNode current = head;
        UniDirectionalNode prev = null;

        while(current != null)
        {
            UniDirectionalNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }
}