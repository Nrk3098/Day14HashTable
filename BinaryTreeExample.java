package Hash;


    class MyBinaryNode<K extends Comparable<K>> {
        K key;
        MyBinaryNode<K> left;
        MyBinaryNode<K> right;

        public MyBinaryNode(K key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }

    class MyBinarySearchTree<K extends Comparable<K>> {
        private MyBinaryNode<K> root;

        public void add(K key) {
            this.root = addRecursively(root, key);
        }

        private MyBinaryNode<K> addRecursively(MyBinaryNode<K> currentNode, K key) {
            if (currentNode == null) {
                return new MyBinaryNode<>(key);
            }

            int comparisonResult = key.compareTo(currentNode.key);
            if (comparisonResult < 0) {
                currentNode.left = addRecursively(currentNode.left, key);
            } else if (comparisonResult > 0) {
                currentNode.right = addRecursively(currentNode.right, key);
            }

            return currentNode;
        }

        public int size() {
            return getSize(root);
        }

        private int getSize(MyBinaryNode<K> currentNode) {
            if (currentNode == null) {
                return 0;
            }

            return 1 + getSize(currentNode.left) + getSize(currentNode.right);
        }

        public boolean search(K key) {
            return searchRecursively(root, key);
        }

        private boolean searchRecursively(MyBinaryNode<K> currentNode, K key) {
            if (currentNode == null) {
                return false;
            }

            int comparisonResult = key.compareTo(currentNode.key);
            if (comparisonResult == 0) {
                return true;
            } else if (comparisonResult < 0) {
                return searchRecursively(currentNode.left, key);
            } else {
                return searchRecursively(currentNode.right, key);
            }
        }
    }

    public class BinaryTreeExample {
        public static void main(String[] args) {
            MyBinarySearchTree<Integer> binarySearchTree = new MyBinarySearchTree<>();

            // Adding nodes to the BST
            binarySearchTree.add(56);
            binarySearchTree.add(30);
            binarySearchTree.add(70);
            binarySearchTree.add(60);
            binarySearchTree.add(40);
            binarySearchTree.add(60);
            binarySearchTree.add(56);
            binarySearchTree.add(78);
            binarySearchTree.add(34);

            // Checking the size of the BST
            int size = binarySearchTree.size();
            System.out.println("Size of the Binary Tree: " + size);

            // Searching for a specific key (63) in the BST
            boolean found = binarySearchTree.search(63);
            System.out.println("Key 63 found in the Binary Tree: " + found);
        }
    }


