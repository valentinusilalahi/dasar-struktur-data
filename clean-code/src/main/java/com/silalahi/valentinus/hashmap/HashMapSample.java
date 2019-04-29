package com.silalahi.valentinus.hashmap;

/**
 * Created by IntelliJ IDEA.
 * User: valentinussilalahi
 * Date: 2019-04-29
 * Time: 16:49
 * To change this template use File | Settings | File and Code Templates.
 */
public class HashMapSample {
	private int hashSize;
	private LinkedListSample[] buckets;
	
	public HashMapSample(int hashSize){
		buckets = new LinkedListSample[hashSize];
		for (int i =0; i<hashSize; i++){
			buckets[i] = new LinkedListSample();
		}
		this.hashSize = hashSize;
	}
	
	public int hashing(int key){
		int hash = key % hashSize;
		if(hash < 0)
			hash += hashSize;
		return hash;
	}
	
	public void insertHash(int key){
		int hash = hashing(key);
		buckets[hash].insert(key);
	}

	public void deleteHash(int key) {
		int hash = hashing(key);
		
		buckets[hash].insert(key);
	}
	public void displayHashtable() {
		for (int i = 0;i < hashSize ; i++) {
			System.out.printf("Bucket %d :",i);
			buckets[i].display();
		}
	}
}
