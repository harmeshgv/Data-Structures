

public class Binary_Search_Tree {
    


    public static void main(String[] args) {

        Node tree = new Node(10);


    }
}

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
        left = right = null;
    }

}

class BinarySearchTree {
    TreeNode root;

    BinarySearchTree(){
        root = null;
    }

    void insert(int data){
        root = insertRec(root, data);
    }

    private TreeNode insertRec(TreeNode root, int data) {
        if(root == null) {
            root = new TreeNode(data);
            return root;
        }

        if(root.data > data) {
            root.left = insertRec(root.left, data);

        } else if(root.data < data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

}
