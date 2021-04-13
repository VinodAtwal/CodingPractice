package com.test.question.binarytree;


import java.util.*;

/*https://pasteboard.co/JWREFMN.jpg*/
public class Q11_ZigzagTraversal {
    public static void zigzagtraversal(Node root){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Integer lvl =1;
        while(!stack.isEmpty()){
            Integer size =stack.size();
            Stack<Node> nextStack = new Stack<>();
            for(int i =1;i<=size;i++){
                Node node = stack.pop();
                System.out.print(node.data+" ");
                if(lvl%2==0){
                    if(node.right!=null){ nextStack.push(node.right);}
                    if(node.left!=null){ nextStack.push(node.left);}
                }else {
                    if(node.left!=null){  nextStack.push(node.left);}
                    if(node.right!=null){ nextStack.push(node.right);}

                }
            }
            stack=nextStack;
            lvl++;
        }
    }
    public static void zigzagDequeue(Node root){
        Deque<Node> deque = new ArrayDeque<>();
        deque.push(root);
        System.out.print(root.data+" ");
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(root.data);
        Integer lvl = 1;
        while(!deque.isEmpty()){
            Integer size = deque.size();
            for (int i = 1; i <=size ; i++) {
                Node node;
                if(lvl%2!=0){
                    node=deque.removeLast();
                    if(node.right!=null){
                        ans.add(node.right.data);
                        System.out.print(node.right.data+" ");
                        deque.addFirst(node.right);
                    }
                    if(node.left!=null) {
                        ans.add(node.left.data);
                        System.out.print(node.left.data + " ");
                        deque.addFirst(node.left);
                    }

                }else{
                    node=deque.removeFirst();
                    if(node.left!=null) {
                        ans.add(node.left.data);
                        System.out.print(node.left.data + " ");
                        deque.addLast((node.left));
                    }
                    if(node.right!=null){
                        ans.add(node.right.data);
                        System.out.print(node.right.data+" ");
                        deque.addLast(node.right);
                    }
                }

            }
            lvl++;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(70, new Node(9,new Node
                (8,new Node(10),new Node(90)),new Node(7)),new Node
                (12,new Node(6),new Node(15)));
        zigzagtraversal(root);
        System.out.println();
        zigzagtraversal(root);

    }

}
