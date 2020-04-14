package com.yedam.dev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yedam.Stream.LambdaExpressionExample;

public class Main {
	public static void main(String[] args) {
		LambdaExpressionExample s1  = new LambdaExpressionExample("Hong","s111", 20);
		LambdaExpressionExample s2  = new LambdaExpressionExample("gela","s222", 22);
		LambdaExpressionExample s3  = new LambdaExpressionExample("zimi","s333", 23);
		System.out.println(" ==배열== ");
		LambdaExpressionExample[] studAry = { s1, s2, s3 };
		for(LambdaExpressionExample s : studAry) {
			System.out.println(s.toString());
		}
		System.out.println("== ArrayList ==");
		List<LambdaExpressionExample> list = new ArrayList<LambdaExpressionExample>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		for (LambdaExpressionExample s : list) {
			System.out.println(s);
		}
		System.out.println("==set==");
		Set<LambdaExpressionExample> studSet = new HashSet<LambdaExpressionExample>();
		studSet.add(s1);
		studSet.add(s2);
		studSet.add(s3); studSet.remove(s1);
		Iterator<LambdaExpressionExample> iter = studSet.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println(" == Map == "); //key, value
		Map<Integer, LambdaExpressionExample> studMap = new HashMap<Integer, LambdaExpressionExample>();
		studMap.put(1, s1);
		studMap.put(2, s2);
		studMap.put(3, s3);
		Set<Integer> iSet = studMap.keySet();
		Iterator<Integer> iter2 = iSet.iterator();
		while( iter2.hasNext()) {
			Integer iKey = iter2.next();
			System.out.println("key: " + iKey + ", value: " + studMap.get(iKey).toString());
		}
		System.out.println(" == Map2 == ");
		Set<Map.Entry<Integer, LambdaExpressionExample>> mSet = studMap.entrySet();
		Iterator<Map.Entry<Integer, LambdaExpressionExample>> iter3 = mSet.iterator();
		while(iter3.hasNext()) {
			Map.Entry<Integer, LambdaExpressionExample> rMap = iter3.next();
			System.out.println("key: " + rMap.getKey() + ", value: " + rMap.getValue());
			
		}
	}

}
