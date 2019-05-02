package com.silalahi.valentinus.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: valentinussilalahi
 * Date: 2019-04-30
 * Time: 17:09
 * To change this template use File | Settings | File and Code Templates.
 */
public class MinHeap implements Heap {
	
	private final List<HeapElement> minHeap;

	public MinHeap(List<HeapElement> listElements) {
		minHeap = new ArrayList<HeapElement>();
		for(HeapElement heapElement : listElements){
			if(heapElement != null) insertElement(heapElement);
			else System.out.println("Null element. No added to heap");
		}
		if(minHeap.size() == 0) System.out.println("No element has been added, empty heap.");
	}

	public void insertElement(HeapElement element) {
		minHeap.add(element);
		toggleUp(minHeap.size());
	}

	private void toggleUp(int elementIndex) {
		double key = minHeap.get(elementIndex - 1).getKey();
		while (getElementKey((int) Math.floor(elementIndex / 2)) > key){
			swap(elementIndex, (int) Math.floor(elementIndex / 2));
			elementIndex = (int) Math.floor(elementIndex / 2);
		}
	}

	private void swap(int elementIndex1, int elementIndex2) {
		HeapElement temporaryElement = minHeap.get(elementIndex1 - 1);
		minHeap.set(elementIndex1 - 1, minHeap.get(elementIndex2 - 1));
		minHeap.set(elementIndex2 - 1, temporaryElement);
	}
	
	private double getElementKey(int elementIndex) {
		return minHeap.get(elementIndex -1).getKey();
	}

	public void deleteElement(int elementIndex) {
		if (minHeap.isEmpty())
			try {
				throw new EmptyHeapException("Attempt to delete an element from an empty heap");
			} catch (EmptyHeapException e) {
				e.printStackTrace();
			}
		if ((elementIndex > minHeap.size()) || (elementIndex <= 0))
			throw new IndexOutOfBoundsException("Index out of heap range");
		minHeap.set(elementIndex - 1, getElement(minHeap.size()));
		minHeap.remove(minHeap.size());
		if (getElementKey(elementIndex) < getElementKey((int) Math.floor(elementIndex / 2))) toggleUp(elementIndex);
		else if (((2 * elementIndex <= minHeap.size()) && (getElementKey(elementIndex) > getElementKey(elementIndex * 2))) ||
						 ((2 * elementIndex < minHeap.size()) && (getElementKey(elementIndex) > getElementKey(elementIndex * 2))))
			toggleDown(elementIndex);
	}

	public HeapElement getElement(int elementIndex) {
		if ((elementIndex <= 0) || (elementIndex > minHeap.size()))
			throw new IndexOutOfBoundsException("Index out of heap range");
		return minHeap.get(elementIndex - 1);
	}

	private void toggleDown(int elementIndex) {
		double key = minHeap.get(elementIndex - 1).getKey();
		boolean wrongOrder = (key > getElementKey(elementIndex * 2)) || (key > getElementKey(Math.min(elementIndex * 2, minHeap.size())));
		while ((2 * elementIndex <= minHeap.size()) && wrongOrder){
			if((2 * elementIndex < minHeap.size()) && (getElementKey(elementIndex * 2 + 1) < getElementKey(elementIndex * 2))){
				swap(elementIndex, 2 * elementIndex + 1);
				elementIndex = 2 * elementIndex + 1;
			} else {
				swap(elementIndex, 2 * elementIndex);
				elementIndex = 2 * elementIndex;
			}
			wrongOrder = (key > getElementKey(elementIndex * 2)) || (key > getElementKey(Math.min(elementIndex * 2, minHeap.size())));
		}
	}

	public HeapElement getElement() throws EmptyHeapException {
		try{
			return extractMin();
		}catch (Exception e){
			throw new EmptyHeapException("Heap is empty. Error retrieving element");
		}
	}

	private HeapElement extractMin() throws EmptyHeapException {
		HeapElement result = minHeap.get(0);
		deleteElement(0);
		return result;
	}
	
}
