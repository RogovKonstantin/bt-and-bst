import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

public class BinaryTree<E> implements AbstractBinaryTree<E> {
    private E key;
    private AbstractBinaryTree<E> left;
    private AbstractBinaryTree<E> right;

    public BinaryTree(E key, AbstractBinaryTree<E> left, AbstractBinaryTree<E> right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public void printTree() {
        int maxHeight = height(this);
        Queue<AbstractBinaryTree<E>> queue = new LinkedList<>();
        queue.add(this);

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
                AbstractBinaryTree<E> node = queue.poll();
                if (node != null) {
                    System.out.print(node.getKey());
                    queue.add(node.getLeft());
                    queue.add(node.getRight());
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
    private int height(AbstractBinaryTree<E> node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = height(node.getLeft());
            int rightHeight = height(node.getRight());
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }


    public E getKey() {
        return key;
    }


    public void setKey(E key) {
        this.key = key;
    }


    public AbstractBinaryTree<E> getLeft() {
        return left;
    }


    public AbstractBinaryTree<E> getRight() {
        return right;
    }


    public String asIndentedPreOrder(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(indent * 2));
        sb.append(key).append("\n");

        if (left != null) {
            sb.append(left.asIndentedPreOrder(indent + 1));
        }
        if (right != null) {
            sb.append(right.asIndentedPreOrder(indent + 1));
        }

        return sb.toString();
    }


    public List<AbstractBinaryTree<E>> preOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        result.add(this);

        if (left != null) {
            result.addAll(left.preOrder());
        }
        if (right != null) {
            result.addAll(right.preOrder());
        }

        return result;
    }


    public List<AbstractBinaryTree<E>> inOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();

        if (left != null) {
            result.addAll(left.inOrder());
        }
        result.add(this);
        if (right != null) {
            result.addAll(right.inOrder());
        }

        return result;
    }


    public List<AbstractBinaryTree<E>> postOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();

        if (left != null) {
            result.addAll(left.postOrder());
        }
        if (right != null) {
            result.addAll(right.postOrder());
        }
        result.add(this);

        return result;
    }


    public void forEachInOrder(Consumer<E> consumer) {
        if (left != null) {
            left.forEachInOrder(consumer);
        }
        consumer.accept(key);
        if (right != null) {
            right.forEachInOrder(consumer);
        }
    }


    public void dfs(AbstractBinaryTree<E> node, StringBuilder sb) {
        if (node == null)
            return;


        sb.append(node.getKey()).append(" ");

        dfs(node.getLeft(), sb);
        dfs(node.getRight(), sb);
    }


    public String DFS() {
        StringBuilder sb = new StringBuilder();
        dfs(this, sb);
        return sb.toString();
    }


    public String BFS() {
        StringBuilder sb = new StringBuilder();
        Queue<AbstractBinaryTree<E>> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            AbstractBinaryTree<E> node = queue.poll();

            sb.append(node.getKey()).append(" ");

            if (node.getLeft() != null)
                queue.add(node.getLeft());

            if (node.getRight() != null)
                queue.add(node.getRight());
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "key=" + key +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

