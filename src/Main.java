public class Main {
    public static void main(String[] args) {
        bstTest();
    }

    public static void btTest() {

        BinaryTree<Integer> bt = new BinaryTree<>(4, new BinaryTree<>(2, new BinaryTree<>(1, null, null), new BinaryTree<>(3, null, null)),
                new BinaryTree<>(6, new BinaryTree<>(5, null, null), new BinaryTree<>(7, null, null)));

        bt.printTree();


        System.out.println("\n" + "key: " + bt.getKey());
        System.out.println("left: " + bt.getLeft());
        System.out.println("right: " + bt.getRight());


        System.out.println("\n" + "Pre order:");
        for (AbstractBinaryTree<Integer> node : bt.preOrder()) {
            System.out.print(node.getKey() + " ");
        }
        System.out.println();

        System.out.println("\n" + "In order:");
        for (AbstractBinaryTree<Integer> node : bt.inOrder()) {
            System.out.print(node.getKey() + " ");
        }
        System.out.println();

        System.out.println("\n" + "Post order:");
        for (AbstractBinaryTree<Integer> node : bt.postOrder()) {
            System.out.print(node.getKey() + " ");
        }
        System.out.println();

        System.out.println("\n" + "forEachInOrder:");
        bt.forEachInOrder(node -> System.out.print(node + " "));
        System.out.println();


        System.out.println("\n" + "DFS:");
        System.out.println(bt.DFS());

        System.out.println("\n" + "BFS:");
        System.out.println(bt.BFS());


    }

    public static void bstTest() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(8);
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(9);

        bst.printTree();

        System.out.println("\n" + bst.contains(1));
        System.out.println(bst.contains(3) + "\n");


        BinarySearchTree.Node<Integer> rootNode = bst.getRoot();
        BinarySearchTree.Node<Integer> leftChild = bst.getLeft();
        BinarySearchTree.Node<Integer> rightChild = bst.getRight();

        System.out.println("root: " + rootNode);//rootNode.value
        System.out.println("left: " + leftChild);//leftChild.value
        System.out.println("tight: " + rightChild);//rightChild.value


        AbstractBinarySearchTree<Integer> treeByRootElement = bst.search(3);
        System.out.println("\n" + treeByRootElement + "\n");

        bst.deleteLeavesAndPrintTree();
        System.out.println("\n" + bst + "\n");

        bst.deleteLeavesAndPrintTree();
        System.out.println("\n" + bst + "\n");

        bst.deleteLeavesAndPrintTree();
        System.out.println("\n" + bst + "\n");

        bst.deleteLeavesAndPrintTree();
        System.out.println("\n" + bst + "\n");
    }
}


