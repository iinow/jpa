package com.ha.jpa;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.junit.Test;

import com.google.common.collect.Maps;

public class TestMain {

	@Test
	public void dd() {
		int[] arr = {1,1,3,3,0,1,1};
		List<Integer> list = new ArrayList<>();
		int tmp = 10;
		for(int a: arr) {
			if(tmp != a) {
				tmp = a;
				list.add(tmp);
				
			}else {
				continue;
			}
		}
		
		list.stream().mapToInt(i->i).toArray();
	}
	
	@Test
	public void ¹è¿­() {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		
		Map<String, Integer> map = new TreeMap<>();
		for(String par: participant) {
			if(map.get(par) == null) {
				map.put(par, 1);
			}else {
				map.put(par, map.get(par)+1);
			}
		}
		
		for(String com: completion) {
			if(map.get(com) != null) {
				map.put(com, map.get(com) - 1);
			}
		}
		
		Iterator<String> iter = map.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			if(map.get(key) != 0) {
				System.out.println(key);
			}
		}
	}
	
	@Test
	public void ±æÀÌ() {
		String s = "a";
		char[] chars = s.toCharArray();
		int length = chars.length;
		String res = null;
		if(length % 2 == 0) {
			//Â¦¼ö
			int first = length / 2 - 1;
			int second = first + 1;
			res = String.valueOf(chars[first]) + String.valueOf(chars[second]);
		}else {
			//È¦¼ö
			int mid = length / 2;
			res = String.valueOf(chars[mid]);
		}
		System.out.println(res);
	}
	
	@Test
	public void ÀÎµ¦½º() {
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};
		
		List<Integer> arr = Arrays.stream(array).boxed().collect(Collectors.toList());
		int[] answer = new int[commands.length];
		int i = 0;
		for(int[] command: commands) {
			List<Integer> sublist = new ArrayList<>(arr.subList(command[0]-1, command[1]));
			sublist.sort((a, b)->{
				if(a > b) {
					return 1;
				}else if(a < b) {
					return -1;
				}else {
					return 0;
				}
			});
			answer[i] = sublist.get(command[2]-1);
			System.out.println(answer[i]);
			i++;
		}
		
	}
	
	@Test
	public void strike() {
		int[][] baseball = {{123,1,1}, {356,1,0}, {327,2,0}, {489, 0, 1}};
		for(int[] base: baseball) {
			
		}
	}
	
	@Test
	public void ³Î¶Ù±â() {
		int n = 3;
		
		int d = n / 2;
		if(d * 2 == n) {
			System.out.println("a = 0, b = "+d);
		}
		int e = (n - 1) / 2;
		if(2 * e + 1 == n) {
			System.out.println("a = 1, b = "+d);
		}
		
		for(int a = 2; a <= n; a++) {
			for(int b = 0; b <= a/2; b++) {
				boolean result = a + b * 2 == n ? true : false;
				if(result)
					System.out.println("a = "+a+", b = "+b);
			}
		}
	}
	
	@Test
	public void ¸ðÀÇ°í»ç() {
		int[] answers = {1,3,2,4,2};
		List<Integer> firstlist = Arrays.asList(5,1,2,3,4);
		List<Integer> secondlist = Arrays.asList(5,2,1,2,3,2,4,2);
		List<Integer> thirdlist = Arrays.asList(5,3,3,1,1,2,2,4,4,5);
		Map<Integer, Integer> map = new TreeMap<>();
		map.put(1, 0);
		map.put(2, 0);
		map.put(3, 0);
		for(int i = 1; i <= answers.length; i++) {
			int answer = answers[i - 1];
			
			if(firstlist.get(i % firstlist.size()) == answer) {
				map.put(1, map.get(1)+1);
			}
			
			if(secondlist.get(i % secondlist.size()) == answer) {
				map.put(2, map.get(2)+1);
			}
			
			if(thirdlist.get(i % thirdlist.size()) == answer) {
				map.put(3, map.get(3)+1);
			}
		}
		
		int max = map.values().stream().mapToInt(i->i).max().getAsInt();
		List<Integer> res = new ArrayList<>();
		
		map.forEach((k, v)->{
			if(max == v) {
				res.add(k);
			}
		});
		
		res.forEach(System.out::print);
		res.stream().mapToInt(i->i).toArray();
	}
	
	@Test
	public void calen() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2016);
		cal.set(Calendar.MONTH, 4);
		cal.set(Calendar.DAY_OF_MONTH, 24);
		cal.getTime().toString().split(" ")[0].toUpperCase();
		System.out.println();
	}
	
	@Test
	public void °ø¹é() {
		String s = "1 2 3 4";
		String[] strs = s.split(" ");
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(String str: strs) {
			int v = Integer.parseInt(str);
			
			if(v > max) {
				max = v;
			}
			
			if(v < min) {
				min = v;
			}
		}
		System.out.println("max: "+max);
		System.out.println("min: "+min);
	}
	
	@Test
	public void Çà·Ä°ö¼À() {
		int[][] arr1 = {{1,2,3}, {2,3,4}};
		int[][] arr2 = {{3,4},{5,6},{3,4}};
		
		int[][] res = new int[arr1.length][arr2[0].length];
		int size = 0;
		for(int[] a1: arr1) {
			for(int i = 0; i < arr2[0].length; i++) {
				int sum = 0;
				for(int j = 0; j < arr2.length; j++) {
					sum += a1[j] * arr2[j][i];
					
				}
				res[size][i] = sum;
			}
			size++;
		}
		System.out.println(res);
	}
}
