package midterm.data_structures;

public class AVLTree<T extends Comparable<T>> {

    Node<T> root;


    public Node<T> insert(T data, Node<T> node) {
        if (node == null) {
            return new Node<>(data);
        }
        if (data.compareTo(node.data) < 0) {
            node.leftChild = insert(data, node.leftChild);
        } else if (data.compareTo(node.data) > 0) {
            node.rightChild = insert(data, node.rightChild);
        } else {
            return node;
        }
        updateHeight(node);
        return applyRotation(node);
    }


    public Node<T> delete(T data, Node<T> node) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.data) < 0) {
            node.leftChild = delete(data, node.leftChild);
        } else if (data.compareTo(node.data) > 0) {
            node.rightChild = delete(data, node.rightChild);
        } else {
            // One Child or Leaf midterm.data_structures.Node (no children)
            if (node.leftChild == null) {
                return node.rightChild;
            } else if (node.rightChild == null) {
                return node.leftChild;
            }
            // Two Children
            node.data = getMax(node.leftChild);
            node.leftChild = delete(node.data, node.leftChild);
        }
        updateHeight(node);
        return applyRotation(node);
    }


    private Node<T> applyRotation(Node<T> node) {
        int balance = balance(node);
        if (balance > 1) {
            if (balance(node.leftChild) < 0) {
                node.leftChild = rotateLeft(node.leftChild);
            }
            return rotateRight(node);
        }
        if (balance < -1) {
            if (balance(node.rightChild) > 0) {
                node.rightChild = rotateRight(node.rightChild);
            }
            return rotateLeft(node);
        }
        return node;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> leftNode = node.leftChild;
        Node<T> centerNode = leftNode.rightChild;
        leftNode.rightChild = node;
        node.leftChild = centerNode;
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> rightNode = node.rightChild;
        Node<T> centerNode = rightNode.leftChild;
        rightNode.leftChild = node;
        node.rightChild = centerNode;
        updateHeight(node);
        updateHeight(rightNode);
        return rightNode;
    }

    private void updateHeight(Node<T> node) {
        int maxHeight = Math.max(
                node.leftChild.height,
                node.rightChild.height
        );
        node.height = maxHeight + 1;
    }

    private int balance(Node<T> node) {
        return node != null ? node.leftChild.height - node.rightChild.height : 0;
    }

    public void traverseInOrder(Node<T> node) {
        if (node != null) {
            traverseInOrder(node.leftChild);
            System.out.println(node);
            traverseInOrder(node.rightChild);
        }
    }


    public T getMax(Node<T> node) {
        if (node.rightChild != null) {
            return getMax(node.rightChild);
        }
        return node.data;
    }

    public T getMin(Node<T> node) {
        if (node.leftChild != null) {
            return getMin(node.leftChild);
        }
        return node.data;
    }

    public boolean isEmpty() {
        return root == null;
    }


}

class Node<T extends Comparable<T>> {

    public int height = 1;

    public Node<T> leftChild;
    public Node<T> rightChild;
    public T data;

    public Node(T data) {
        this.data = data;
    }

}