package ee.ttu.algoritmid.subtreedifference;

public class SubtreeDifference {
    /**
     * Calculate difference between sum of all left children and sum of all right children for every node
     * @param rootNode root node of the tree. Use it to traverse the tree.
     * @return root node of the tree where for every node is computed difference of sums of it's left and right children
     */
    public Node calculateDifferences(Node rootNode) {
        Node leftChild = rootNode.getLeft();
        Node rightChild = rootNode.getRight();

        if(rightChild!=null && leftChild!= null) {
            calculateDifferences(leftChild);
            calculateDifferences(rightChild);

            long leftChildrenSum = leftChild.getSumOfAllChildren() + leftChild.getValue();
            long rightChildrenSum = rightChild.getSumOfAllChildren() + rightChild.getValue();

            rootNode.setSumOfAllChildren(leftChildrenSum+ rightChildrenSum);
            rootNode.setDifferenceOfLeftAndRight(leftChildrenSum-rightChildrenSum);
        }

        else if(rightChild == null && leftChild !=null){
            calculateDifferences(leftChild);
            long leftChildrenSum = leftChild.getSumOfAllChildren() + leftChild.getValue();
            rootNode.setSumOfAllChildren(leftChildrenSum);
            rootNode.setDifferenceOfLeftAndRight(leftChildrenSum - 0);
        }

        else if(rightChild != null){
            calculateDifferences(rightChild);
            long rightChildrenSum = rightChild.getSumOfAllChildren() + rightChild.getValue();

            rootNode.setSumOfAllChildren(rightChildrenSum);
            rootNode.setDifferenceOfLeftAndRight(0 - rightChildrenSum);
        }
        return rootNode;
    }

    public static void main(String[] args) throws Exception {
        /**
         *  Use this example to test your solution
         *                  Tree:
         *                   15
         *               /       \
         *             10         17
         *           /   \       /  \
         *         3     13     5    25
         */
        Node rootNode = new Node(15);
        Node a = new Node(10);
        Node b = new Node(17);
        Node c = new Node(3);
        Node d = new Node(13);
        Node g = new Node(2);
        Node e = new Node(5);
        Node f = new Node(25);

        rootNode.setLeft(a);
        //rootNode.setRight(b);
        a.setLeft(c);
        a.setRight(d);
        b.setLeft(e);
        b.setRight(f);
        //c.setRight(g);

        SubtreeDifference solution = new SubtreeDifference();
        solution.calculateDifferences(rootNode);

        System.out.println(a.getSumOfAllChildren());
        System.out.println(b.getSumOfAllChildren());
        System.out.println(rootNode.getSumOfAllChildren());
        System.out.println(rootNode.getDifferenceOfLeftAndRight());

//        if (rootNode.getDifferenceOfLeftAndRight() != -21 ||
//                a.getDifferenceOfLeftAndRight() != -10 ||
//                b.getDifferenceOfLeftAndRight() != -20 ||
//                c.getDifferenceOfLeftAndRight() != 0) {
//            throw new Exception("There is a mistake in your solution.");
//        }
//
//        System.out.println("Your solution should be working fine in basic cases, try to push.");

    }
}
