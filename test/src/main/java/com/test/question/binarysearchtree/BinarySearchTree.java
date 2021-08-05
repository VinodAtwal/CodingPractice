package com.test.question.binarysearchtree;

class Node {
    Integer data;
    Integer degree = 0;
    Node left;
    Node right;

    public Node(Integer data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Node(Integer data) {
        this.data = data;
        left = null;
        right = null;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

public class BinarySearchTree {

    public static Node insert(Node root, Integer data) {
        if (root == null) {
            return new Node(data);
        }
        if (root.data > data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public static Node insertIterative(Node root, Integer data) {
        if (root == null) {
            return new Node(data);
        }
        Node node = root;
        while (node != null) {
            if (node.data < data) {
                if (node.right == null) {
                    node.right = new Node(data);
                    break;
                }
                node = node.right;
            } else {
                if (node.left == null) {
                    node.left = new Node(data);
                    break;
                }
                node = node.left;
            }
        }

        return root;
    }

    public static Node searchIterative(Node root, Integer data) {
        Node node = root;
        while (node != null) {
            if (node.data > data) {
                node = node.left;
            } else if (node.data < data) {
                node = node.right;
            } else {
                return node;
            }
        }
        return node;
    }

    public static Node search(Node root, Integer data) {
        if (root == null || root.data == data) {
            return root;
        }
        if (root.data < data) {
            return search(root.right, data);
        } else {
            return search(root.left, data);
        }

    }

    public static Node deleteNode(Node root, Integer k) {
        Node node = root;
        Node prev = null;
        while (node != null) {
            if (node.data > k) {
                prev = node;
                node = node.left;
            } else if (node.data < k) {
                prev = node;
                node = node.right;

            } else {
                if (node.left == null && node.right == null) {
                    if (prev != null) {
                        if (prev.right == node) {
                            prev.right = null;
                        } else {
                            prev.left = null;
                        }
                    } else {
                        return null;
                    }
                    return root;
                } else if (node.left == null) {
                    if (prev != null) {
                        if (prev.right == node) {
                            prev.right = node.right;
                        } else {
                            prev.left = node.right;
                        }
                    } else {
                        root = root.right;
                    }
                    return root;
                } else if (node.right == null) {
                    if (prev != null) {
                        if (prev.right == node) {
                            prev.right = node.right;
                        } else {
                            prev.left = node.right;
                        }
                    } else {
                        root = root.left;
                    }
                    return root;
                } else {
                    Node n1 = node.right;
                    while (n1.left != null) {
                        n1 = n1.left;
                    }
                    Node leftNode = n1;
                    deleteNode(node, n1.data);
                    if (prev != null) {
                        if (prev.right == node) {
                            leftNode.left = node.left;
                            leftNode.right = node.right;
                            prev.right = leftNode;

                        } else {
                            leftNode.left = node.left;
                            leftNode.right = node.right;
                            prev.left = leftNode;
                        }
                    } else {
                        leftNode.left = root.left;
                        leftNode.right = root.right;
                        root = leftNode;
                    }
                    return root;

                }
            }
        }
        return root;
    }


    public static void main(String[] args) {
//        Node root =insert(null,3);
//        insert(root,5);
//        insert(root,4);
//        insert(root,6);
//        insert(root,1);
//        System.out.println(root);
        Node root = insert(null, 60);
        insert(root, 33);
        insert(root, 89);
        insert(root, 90);
        insert(root, 4);
        insert(root, 12);
        insert(root, 41);
        insert(root, 44);
        insert(root, 37);
        insert(root, 38);
        insert(root, 39);
        insert(root, 75);
        insert(root, 64);

        System.out.println("Root after your insertions");
        System.out.println(root);
        System.out.println();

        root = deleteNode(root, 41);
        System.out.println("Root After deletion of your requested node");
        System.out.println(root);

//       Node root1= insertIterative(null,3);
//        insertIterative(root1,5);
//        insertIterative(root1,4);
//        insertIterative(root1,6);
//        insertIterative(root1,1);
//        System.out.println(root1);

//        System.out.println(search(root,5));
//        System.out.println(searchIterative(root1,5));
//        root=deleteNode(root,3);
//        System.out.println(root);


                /*       3
                        /   \
                       1        5
                              /  \
                              4   6

                * */

    }

}
