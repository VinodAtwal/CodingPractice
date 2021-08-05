package com.test.question.binarysearchtree;

public class Q8_BalanceBST {

    public static Node rotateRight(Node root) {
        Node node = root.left;
        root.left = node.right;
        node.right = root;
        root.degree -= 1;
        node.degree += 1;
        return node;
    }

    public static Node rotateLeft(Node root) {
        Node node = root.right;
        root.right = node.left;
        node.left = root;
        root.degree -= 1;
        node.degree += 1;
        return node;
    }

    /*  public static Node balanceBT(Node root) {
          if (root == null) {
              return null;
          }
          balanceBT(root.left);
          balanceBT(root.right);
          if (root.left == null && root.right == null) {
              root.degree = 0;
          } else if (root.right == null) {
              root.degree = root.left.degree;
          } else if (root.left == null) {
              root.degree = root.left.degree;
          } else {
              root.degree = Math.abs(root.left.degree - root.right.degree);
          }
          if (root.degree > 1) {
              if ()
          }
  
      }*/
    public static Node insertAVL(Integer data, Node node) {
        if (node.data < data) {
            if (node.right == null) {
                node.right = new Node(data);
            } else {
                insertAVL(data, node.right);
            }
        } else {
            if (node.left == null) {
                node.left = new Node(data);
            } else {
                insertAVL(data, node.left);
            }
        }
        int leftDegree = 0, rightDegree = 0;

        if (node.left != null) {
            leftDegree = node.left.degree;
        }
        if (node.right != null) {
            rightDegree = node.right.degree;
        }
        node.degree = Math.abs(leftDegree - rightDegree);
        if (node.degree > 1) {
            return balanceDegree(node);
        }
        return node;

    }

    private static Node balanceDegree(Node node) {
        return null;
    }

}
