public class BST {

    private TreeNode root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private TreeNode insert(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        } // Duplicate values are ignored
        return node;
    }

    public boolean search(int value) {
        return search(root, value);
    }

    private boolean search(TreeNode node, int value) {
        if (node == null) {
            return false;
        }
        if (node.value == value) {
            return true;
        }
        return value < node.value ? search(node.left, value) : search(node.right, value);
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private TreeNode delete(TreeNode node, int value) {
        if (node == null) return null;

        if (value < node.value) {
            node.left = delete(node.left, value);
        } else if (value > node.value) {
            node.right = delete(node.right, value);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            TreeNode successor = findMin(node.right);
            node.value = successor.value;
            node.right = delete(node.right, successor.value);
        }
        return node;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        }
    }

    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    private void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.value + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {8,5,7,9,32,4,2,1};
        BST bst = new BST();
        for (int i : arr) {
            bst.insert(i);
        }

        System.out.println("搜索 5: " + bst.search(5));

        System.out.print("中序遍历: ");
        bst.inOrder();

        System.out.print("前序遍历: ");
        bst.preOrder();

        System.out.print("后序遍历: ");
        bst.postOrder();

        System.out.println("删除 5");
        bst.delete(5);

        System.out.print("中序遍历（删除后）: ");
        bst.inOrder();
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }
}
