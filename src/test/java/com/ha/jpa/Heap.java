package com.ha.jpa;

import java.util.ArrayList;

public class Heap {
    ArrayList<Integer> tree; //�迭�� �̿��� Ʈ��
    int size; //���� Ʈ�� ������
    
    public Heap(){
        tree = new ArrayList<>();
        tree.add(-1); //Ʈ�� ������ 1���� �ϱ� ����
        size = 0;
    }
    
    //���ο� ���ڳ�� �߰�
    public void insert(int num){
        size++; //Ʈ�� ������ ����
        if(tree.size() == size) 
        	tree.add(num); //���� Ʈ�� ����� �迭 ������� ������ add(): �迭 ũ�� �þ
        else 
        	tree.set(size,  num); //���� Ʈ�� ����� �迭 ������ ���� ������ set(): �迭 ũ�� �״��
        int child = size;
        while(child/2 >= 1){
            if(tree.get(child) >= tree.get(child/2)) 
            	break; //�ڽ� ���� �ڱⰡ �۰ų� ���� ��� ����
            else{ //�ڽ��� �ڱ⺸�� ���� ��� �ٲٱ�
                int temp = tree.get(child);
                tree.set(child, tree.get(child/2));
                tree.set(child/2, temp);
                child /= 2;
            }
        }
    }
    
    //��Ʈ ��Ʈ ��ȯ�� Ʈ�� ������
    public int root(){
        if(size < 1) 
        	return -1; //Ʈ�� ��尡 �ϳ��� ���� ���
        
        int root = tree.get(1); //��Ʈ ��Ʈ ����
        tree.set(1,  tree.get(size--)); //��Ʈ ��Ʈ�� �ָ��� ��� ���� �� Ʈ�� ������ ����
        int parent = 1;
        int leftChild, rightChild, selectedChild; //����, ������, ���� ���õ� �ڽ�
        while(true){
            leftChild = parent*2;
            rightChild = parent*2 + 1;
            if(rightChild > size){ //������ �ڽ��� ���� ���
                if(leftChild > size) 
                	break; //���� �ڽĵ� ���� ��� ����
                selectedChild = leftChild; //���� �ڽ��� ���� ��� ����
            } else{ //�� ���� ���� �ڽ� ����
                if(tree.get(leftChild) <= tree.get(rightChild)) 
                	selectedChild = leftChild;
                else 
                	selectedChild = rightChild;
            }
            if(tree.get(parent) <= tree.get(selectedChild)) 
            	break; //�ڱⰡ ���õ� �ڽĺ��� ���� �۰ų� ���� ��� ����
            else{ //�ڽİ� �ٲٱ�
                int temp = tree.get(parent);
                tree.set(parent, tree.get(selectedChild));
                tree.set(selectedChild, temp);
                parent = selectedChild;
            }
        }
        return root;
    }
    
    //Ʈ�� ���
    public void printTree(){
        int index = 1; //���� �迭 ��ġ
        int level = 1; //Ʈ�� ����
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