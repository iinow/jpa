package com.ha.jpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.junit.Test;

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
	public void array() {
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
	public void length() {
		String s = "a";
		char[] chars = s.toCharArray();
		int length = chars.length;
		String res = null;
		if(length % 2 == 0) {
			//¦��
			int first = length / 2 - 1;
			int second = first + 1;
			res = String.valueOf(chars[first]) + String.valueOf(chars[second]);
		}else {
			//Ȧ��
			int mid = length / 2;
			res = String.valueOf(chars[mid]);
		}
		System.out.println(res);
	}
	
	@Test
	public void index() {
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
	public void jump() {
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
	public void exam() {
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
	public void blank() {
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
	public void arrayMulti() {
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
	
	@Test
	public void prioritySearch() {
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		
		System.out.println(DFS(numbers, target, 0, 0));
		
		Stack<Integer> stack = new Stack<Integer>();
	}
	
	public int DFS(int[] numbers, int target, int index, int num) {
        if(index == numbers.length) {
            return num == target ? 1 : 0;
        } else {
            return DFS(numbers, target, index + 1, num + numbers[index])
                    + DFS(numbers, target, index + 1, num - numbers[index]);
        }
    }
	/*
	 * public int DFS_stack(Stack<Integer> stack, int size, int target) {
	 * if(stack.size() == size) { int sum =
	 * stack.stream().mapToInt(i->i.intValue()).sum(); return sum == target ? 1 : 0;
	 * }
	 * 
	 * }
	 */
	
	@Test
	public void sum() {
		int a = 0, b = 0;
		
		if(a == b) {
//			return a;
		}
		
		int cnt = Math.abs(a - b);
		int sum = (cnt * ( a + b )) / 2;
		
	}
	
	//에라토스테네의 체 알고리즘 아래꺼가 아님 시작점 부터 제곱근으로 루프 돌려서 구함
	@Test
	public void findSosu() {
		long stime = System.currentTimeMillis();
		int n = 10;
		int cnt = 0;
		
		for(int i = 2; i <= n; i++) {
			boolean sosu = true;
			for(int j = 2; j <= (int)Math.sqrt(i); j++) {
				if(i % j == 0) {
					sosu = false;
					break;
				}
			}
			if(sosu) {
				cnt++;
			}
		}
		long etime = System.currentTimeMillis();
		System.out.println((etime - stime));
		System.out.println(cnt);
	}
	
	@Test
	public void spicy() {
		int[] scoville = {1,2,3,9,10,12};
		int K = 7;
		
		//int scofil = 가장 안매운거 + (두번째로 안매운거 * 2);
		//전부다 더 했는데도 k 값을 넘지 못하면 return -1;
		
		List<Integer> list = Arrays.stream(scoville).boxed().collect(Collectors.toList());
		/*
		 * list.sort((a, b)->{ if(a > b) { return -1; }else if(a < b) { return 1; }else
		 * return 0; });
		 */
		list.sort(Comparator.reverseOrder());
		
		list.forEach(System.out::println);
		
		int res = 0;
		int mixcnt = 0;
		for(int i = list.size() - 1; i >= 0; i--) {
			if(i == 0) {
				if(list.get(i) >= K) {
					res = mixcnt;
				}else {
					res = -1;
				}
				break;
			}
			int a = list.get(i);
			if(a >= K) {
				res = mixcnt;
				break;
			}
				
			int b = list.get(i-1);
			int mix = a + b * 2;
			mixcnt++;
			list.set(i-1, mix);
			list.remove(i);
			list.sort(Comparator.reverseOrder());
		}
		System.out.println("res: "+res);
		System.out.println("mixcnt: "+mixcnt);
		list.forEach(System.out::println);
	}
	
	private List<Integer> validate(List<Integer> list, int k){
		int[] scoville = {1,2,3,9,10,12};
		int K = 7;
		Map<Integer, Integer> map = new TreeMap<>();
		for(int i: scoville) {
			map.put(i, 0);
		}
		return null;
	}
	
	@Test
	public void lazer() {
//		String arrangement = "()(((()())(())()))(())";
		String arrangement = "((()))";
		String res = arrangement.replaceAll("\\(\\)", "0");
		System.out.println(res);
		
		int length = 0;
		Stack<String> stack = new Stack<>();
		for(char c: res.toCharArray()) {
			String s = String.valueOf(c);
			
			if(s.equals("(")) {
				stack.push(s);
			}else if(s.equals("0")) {
				length += stack.size();
			}else if(s.equals(")")){
				length += 1;
				stack.pop();
			}
		}
		System.out.println(length);
	}
	
	@Test
	public void print() {
		int loc = 2;
		int[] priorities = {2,1,3,2};
		int value = priorities[loc];
		Queue<Integer> queue = new LinkedBlockingQueue<>();
		for(int i: priorities) {
			queue.add(priorities[i]);
		}
		
		int cnt = 0;
		while(true) {
			if(cnt > priorities.length) {
				cnt = 0;
			}
			//
			
			//
			cnt++;
		}
		
	}
	
	@Test
	public void ddd() {
		System.out.println("Hello");
		assert true;
		System.out.println("world");
	}
	
	@Test
	public void dddd() {
		
		//49 60 57
		//13 89 99
		
		
		int[][] arr = {{26, 40, 83}, {49, 60, 57}, {13, 89, 99}};
		Map<Integer, Integer> map = new TreeMap<>();
		int sum = 0;
		int preindex = 0;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				map.put(arr[i][j], j);
			}
			if(i == 0) {
				int key = map.keySet().iterator().next();
				sum += key;
				preindex = map.get(key);
			}else {
				Iterator<Integer> iter = map.keySet().iterator();
				while(iter.hasNext()) {
					int key = iter.next();
					if(map.get(key) == preindex) {
						continue;
					}
					sum += key;
					preindex = map.get(key);
					break;
				}
			}
			map.clear();
		}
		System.out.println("sum :"+sum);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cnt = scanner.nextInt();
		int[][] arr = new int[cnt][3];
		
		for(int i = 0; i < cnt; i++) {
			for(int j = 0; j < 3; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}
		
		Arrays.stream(arr).forEach(ar -> {
			System.out.println(ar[0]+", "+ar[1]+", "+ar[2]);
		});
//		String[] arr = scanner.nextLine().split(" ");
//		System.out.println("cnt : "+cnt);
//		for(String str: arr) {
//			System.out.println(str);
//		}
	}
}
