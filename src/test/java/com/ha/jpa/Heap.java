package com.ha.jpa;

import java.util.ArrayList;

public class Heap {
    ArrayList<Integer> tree; //배열을 이용한 트리
    int size; //현재 트리 사이즈
    
    public Heap(){
        tree = new ArrayList<>();
        tree.add(-1); //트리 시작을 1부터 하기 위함
        size = 0;
    }
    
    //새로운 숫자노드 추가
    public void insert(int num){
        size++; //트리 사이즈 증가
        if(tree.size() == size) 
        	tree.add(num); //현재 트리 사이즈가 배열 사이즈와 같을때 add(): 배열 크기 늘어남
        else 
        	tree.set(size,  num); //현재 트리 사이즈가 배열 사이즈 보다 작을때 set(): 배열 크기 그대로
        int child = size;
        while(child/2 >= 1){
            if(tree.get(child) >= tree.get(child/2)) 
            	break; //자식 보다 자기가 작거나 같을 경우 종료
            else{ //자식이 자기보다 작을 경우 바꾸기
                int temp = tree.get(child);
                tree.set(child, tree.get(child/2));
                tree.set(child/2, temp);
                child /= 2;
            }
        }
    }
    
    //루트 노트 반환후 트리 재정렬
    public int root(){
        if(size < 1) 
        	return -1; //트리 노드가 하나도 없을 경우
        
        int root = tree.get(1); //루트 노트 저장
        tree.set(1,  tree.get(size--)); //루트 노트에 최말단 노드 삽입 후 트리 사이즈 감소
        int parent = 1;
        int leftChild, rightChild, selectedChild; //왼쪽, 오른쪽, 최종 선택된 자식
        while(true){
            leftChild = parent*2;
            rightChild = parent*2 + 1;
            if(rightChild > size){ //오른쪽 자식이 없을 경우
                if(leftChild > size) 
                	break; //왼쪽 자식도 없을 경우 종료
                selectedChild = leftChild; //왼쪽 자식이 있을 경우 선택
            } else{ //더 값이 작은 자식 선택
                if(tree.get(leftChild) <= tree.get(rightChild)) 
                	selectedChild = leftChild;
                else 
                	selectedChild = rightChild;
            }
            if(tree.get(parent) <= tree.get(selectedChild)) 
            	break; //자기가 선택된 자식보다 값이 작거나 같은 경우 종료
            else{ //자식과 바꾸기
                int temp = tree.get(parent);
                tree.set(parent, tree.get(selectedChild));
                tree.set(selectedChild, temp);
                parent = selectedChild;
            }
        }
        return root;
    }
    
    //트리 출력
    public void printTree(){
        int index = 1; //현재 배열 위치
        int level = 1; //트리 레벨
        while(true){
            if(index > size) 
            	break;
            for(int i=index; i<Math.pow(2, level); i++){
                if(i > size) 
                	break;
                System.out.print(tree.get(i) + " ");
                index++;
            }
            level++;
            System.out.println();
        }
        System.out.println("======================");
        tree.stream().forEach(System.out::println);
    }
    
    public static void main(String[] args) {
		Heap heap = new Heap();
		heap.insert(4);
		heap.insert(2);
		heap.insert(6);
		heap.insert(8);
		heap.insert(1);
		heap.insert(3);
		heap.printTree();
	}
}