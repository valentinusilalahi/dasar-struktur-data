package com.silalahi.valentinus.hashmap;

/**
 * Created by IntelliJ IDEA.
 * User: valentinussilalahi
 * Date: 2019-04-29
 * Time: 17:03
 * To change this template use File | Settings | File and Code Templates.
 */
public class LinkedListSample {
	private NodeSample Head;
	private int size;
	
	public LinkedListSample() {
		Head = null;
		size = 0;
	}
	
	public void insert(int data) {
		
		NodeSample temp = Head;
		NodeSample newnode = new NodeSample(data);
		
		size++;
		
		if(Head == null) {
			Head = newnode;
		}
		else {
			newnode.next = Head;
			Head = newnode;
		}
	}
	
	public void delete(int data) {
		if(size == 0) {
			System.out.println("UnderFlow!");
			return;
		}
		
		else {
			NodeSample curr = Head;
			if (curr.data == data) {
				Head = curr.next;
				size--;
				return;
			}
			else {
				
				while(curr.next.next != null) {
					if(curr.next.data == data){
						curr.next = curr.next.next;
						return;
					}
				}
				
				System.out.println("Key not Found");
			}
		}
	}
	
	public void display() {
		NodeSample temp = Head;
		while(temp != null) {
			System.out.printf("%d ",temp.data);
			temp = temp.next;
		}
		System.out.println();
	}
}
