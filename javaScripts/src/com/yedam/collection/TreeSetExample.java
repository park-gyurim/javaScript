package com.yedam.collection;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample {
	public static void main(String[] args) {
		TreeSet<Integer> scores = new TreeSet<>();
		scores.add(new Integer(98));
		scores.add(new Integer(87));
		scores.add(new Integer(75));
		scores.add(new Integer(80));
		for (Integer score : scores) {
			System.out.println(score);
		}
		System.out.println("===============================");
		NavigableSet<Integer> nSet = scores.descendingSet();
		for (Integer score : nSet) {
			System.out.println(score);
		}
		System.out.println("===============================");
		TreeSet<Person> persons = new TreeSet<>();
		persons.add(new Person("Hong", 10));
		persons.add(new Person("Choi", 20));
		persons.add(new Person("yuu", 30));
		for (Person person : persons) {
			System.out.println(person.getName() + "," + person.getAge());
		}
		System.out.println("===============================");
		TreeSet<Fruit> fruits =  new TreeSet<>(new FruitComparator());
		fruits.add(new Fruit("strawberry", 1000));
		fruits.add(new Fruit("watermelon", 2000));
		fruits.add(new Fruit("apple", 3000));
		for (Fruit a : fruits) {
			System.out.println(a.getName() + "," + a.getPrice());
		}
		
	}
}
