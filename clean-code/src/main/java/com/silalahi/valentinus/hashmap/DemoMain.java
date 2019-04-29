package com.silalahi.valentinus.hashmap;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: valentinussilalahi
 * Date: 2019-04-29
 * Time: 16:43
 * To change this template use File | Settings | File and Code Templates.
 */
public class DemoMain {
	public static void main(String[] args) {
		int choice;
		int key;
		
		HashMapSample hashMap = new HashMapSample(7);
		
		while (true){
			System.out.println("Enter your choice : ");
			System.out.println("1. Add key : ");
			System.out.println("2. Delete key : ");
			System.out.println("3. Print Table : ");
			System.out.println("4. Exit: ");
			
			Scanner in = new Scanner(System.in);
			choice = in.nextInt();
			
			switch (choice){
				case 1 :{
					System.out.println("Enter your choice : ");
					key = in.nextInt();
					hashMap.insertHash(key);
					break;
				}
				case 2:{
					System.out.println("Enter your choice : ");
					key = in.nextInt();
					hashMap.deleteHash(key);
					break;
				}
				case 3:{
					System.out.println("Enter your choice : ");
					key = in.nextInt();
					hashMap.displayHashtable();
					break;
				}
				case 4:{
					return;
				}
			}
		}
	}
}
