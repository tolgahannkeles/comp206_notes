package midterm.data_structures;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

    Node<T> root;
    public BinarySearchTree() {
        super(null);
    }

    public List<T> inorderTraversal() {
        List<T> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(Node<T> node, List<T> result) {
        if (node != null) {
            inorderTraversal(node.getLeft(), result);
            result.add(node.getValue());
            inorderTraversal(node.getRight(), result);
        }
    }

    public void insert(T value) {
        root = insert(root, value);
    }

    private Node<T> insert(Node<T> node, T value) {
        if (node == null) {
            return new Node<>(value);
        }

        int cmp = value.compareTo(node.getValue());
        if (cmp < 0) {
            node.setLeft(insert(node.getLeft(), value));
        } else if (cmp > 0) {
            node.setRight(insert(node.getRight(), value));
        }

        return node;
    }

    public boolean contains(T value) {
        return contains(root, value);
    }

    private boolean contains(Node<T> node, T value) {
        if (node == null) {
            return false;
        }

        int cmp = value.compareTo(node.getValue());
        if (cmp < 0) {
            return contains(node.getLeft(), value);
        } else if (cmp > 0) {
            return contains(node.getRight(), value);
        } else {
            return true;
        }
    }

    public void delete(T value) {
        root = delete(root, value);
    }
    private Node<T> delete(Node<T> node, T value) {
        if (node == null) {
            return null;
        }

        int cmp = value.compareTo(node.getValue());
        if (cmp < 0) {
            node.setLeft(delete(node.getLeft(), value));
        } else if (cmp > 0) {
            node.setRight(delete(node.getRight(), value));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                Node<T> min = findMin(node.getRight());
                node.setValue(min.getValue());
                node.setRight(delete(node.getRight(), min.getValue()));
            }
        }

        return node;
    }

    private Node<T> findMin(Node<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }
}