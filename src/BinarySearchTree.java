import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {


    private Node<E> root;

    public BinarySearchTree() {

    }

    public BinarySearchTree(Node<E> root) {
        this.root = root;
    }

    public void insert(E element) {
        root = insertRecursive(root, element);
    }

    private Node<E> insertRecursive(Node<E> node, E element) {
        if (node == null) {
            return new Node<>(element);
        }

        int compareResult = element.compareTo(node.value);

        if (compareResult < 0) {
            node.leftChild = insertRecursive(node.leftChild, element);
        } else if (compareResult > 0) {
            node.rightChild = insertRecursive(node.rightChild, element);
        }

        return node;
    }

    public boolean contains(E element) {
        return containsRecursive(root, element);
    }

    private boolean containsRecursive(Node<E> node, E element) {
        if (node == null) {
            return false;
        }

        int compareResult = element.compareTo(node.value);

        if (compareResult == 0) {
            return true;
        } else if (compareResult < 0) {
            return containsRecursive(node.leftChild, element);
        } else {
            return containsRecursive(node.rightChild, element);
        }
    }

    public AbstractBinarySearchTree<E> search(E element) {
        Node<E> node = searchRecursive(root, element);
        return new BinarySearchTree<>(node);
    }

    private Node<E> searchRecursive(Node<E> node, E element) {
        if (node == null || element.equals(node.value)) {
            return node;
        }

        int compareResult = element.compareTo(node.value);

        if (compareResult < 0) {
            return searchRecursive(node.leftChild, element);
        } else {
            return searchRecursive(node.rightChild, element);
        }
    }

    public Node<E> getRoot() {
        return root;
    }

    public Node<E> getLeft() {
        if (root != null) {
            return root.leftChild;
        } else {
            return null;
        }
    }

    public Node<E> getRight() {
        if (root != null) {
            return root.rightChild;
        } else {
            return null;
        }
    }

    public E getValue() {
        if (root != null) {
            return root.value;
        } else {
            return null;
        }
    }

    public void deleteLeavesAndPrintTree() {
        root = deleteLeavesRecursive(root);
        this.printTree();
    }

    private Node<E> deleteLeavesRecursive(Node<E> node) {
        if (node == null) {
            return null;
        }

        if (node.leftChild == null && node.rightChild == null) {
            return null;
        }

        node.leftChild = deleteLeavesRecursive(node.leftChild);
        node.rightChild = deleteLeavesRecursive(node.rightChild);

        return node;
    }

    public void printTree() {
        int maxHeight = height(this.root);
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(this.root);

        int level = 1;
        int nodesInLevel = 1;

        while (!queue.isEmpty()) {
            int nodesInNextLevel = 0;
            int spacesBefore = (int) (Math.pow(2, maxHeight - level) - 1);
            int spacesBetween = (int) (Math.pow(2, maxHeight - level + 1) - 1);

            for (int i = 0; i < spacesBefore; i++) {
                System.out.print(" ");
            }

            for (int i = 0; i < nodesInLevel; i++) {
                Node<E> node = queue.poll();
                if (node != null) {
                    System.out.print(node.value);
                    queue.add(node.leftChild);
                    queue.add(node.rightChild);
                    nodesInNextLevel += 2;
                } else {
                    System.out.print(" ");
                    queue.add(null);
                    queue.add(null);
                }

                for (int j = 0; j < spacesBetween; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            level++;
            nodesInLevel = nodesInNextLevel;

            if (level > maxHeight) {
                break;
            }
        }
    }

    private int height(Node<E> node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = height(node.leftChild);
            int rightHeight = height(node.rightChild);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }


    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }
}