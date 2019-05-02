package com.silalahi.valentinus.heap;

/**
 * Created by IntelliJ IDEA.
 * User: valentinussilalahi
 * Date: 2019-04-30
 * Time: 17:10
 * To change this template use File | Settings | File and Code Templates.
 */
public interface Heap {
	HeapElement getElement() throws EmptyHeapException;
	void insertElement(HeapElement element);
	void deleteElement(int elementIndex);
}
