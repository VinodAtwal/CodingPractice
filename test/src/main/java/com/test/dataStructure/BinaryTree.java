package com.test.dataStructure;

class Node{
    Integer data;
    Node left;
    Node right;
    Node(Integer data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}

public class BinaryTree {
    Node root;

    private Node addRecursive(Node current, Integer data){
        if(current==null){
            return  new Node(data);
        }

        if(data<current.data){
            current.left= addRecursive(current.left, data);
        }else if(data >current.data){
            current.right= addRecursive(current.right,data);
        }else{
            return current;
        }

        return current;
    }

    public void add(Integer data){
        root= addRecursive(root,data);
    }

    private Boolean containNodeRecursive(Node current,Integer data){
        if(current==null) return  false;

        if(data == current.data) return true;

        return data < current.data ? containNodeRecursive(current.left, data) : containNodeRecursive(current.right, data);
    }

    public Boolean containNode(Integer data){
        return containNodeRecursive(root,data);
    }

    private Node deleteRecursive(Node current, Integer data){
            if(current==null) return  null;

            if(data<current.data){
                current.left= deleteRecursive(current.left,data);
                return current;
            }else if(data> current.data){
                current.right= deleteRecursive(current.right,data);
                return current;
            }else{
                    if(current.left==null && current.right== null) { return  null;}

                    if(current.left== null){
                        return current.right;
                    }
                    if(current.right== null){
                        return  current.left;
                    }



            }
    return null;
    }

}
