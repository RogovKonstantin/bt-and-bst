import java.util.List;
import java.util.function.Consumer;

public interface AbstractBinaryTree<E> {
    E getKey();

    void setKey(E key);

    AbstractBinaryTree<E> getLeft();

    AbstractBinaryTree<E> getRight();

    String asIndentedPreOrder(int indent);

    List<AbstractBinaryTree<E>> preOrder();

    List<AbstractBinaryTree<E>> inOrder();

    List<AbstractBinaryTree<E>> postOrder();

    void forEachInOrder(Consumer<E> consumer);

    
    String DFS();

    
    String BFS();



    void dfs(AbstractBinaryTree<E> node,  StringBuilder sb);
}


