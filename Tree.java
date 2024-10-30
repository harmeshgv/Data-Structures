public class Tree {
    public static void main( String[] args) {
        Node tree = new Node(10);
        tree.insert(21);
        tree.insert(2);
        tree.insert(10);
        tree.insert(9);
        tree.insert(15);
        tree.insert(19);

        if(tree.contains(9)){
            System.out.println("contains 9");
        }else{
            System.out.println("nooooo");
        }
        System.out.println("                 ");

        tree.printInorder();

        System.out.println("                    ");

        tree.printPreorder();
        
    }
    
}

class Node {
    Node left, right;
    int data;
    public Node(int data) {
        this.data = data;

    }

    public void insert(int value){
        if(value <= data){
            if(left == null){
                left = new Node(value);
            }
            else{
                left.insert(value);
            }
        }
        else{
            if(right == null){
                right = new Node(value);
            }
            else{
                right.insert(value);
            }
        }
    }

    public boolean contains(int value){
        if(value == data){
            return true;
        }
        else if( value < data){
            if(left == null){
                return false;
            }
            else{
                return left.contains(value);
            }
        }
        else{
            if(right == null){
                return false;
            }
            else{
                return right.contains(value);
            }
        }



    }

    public void printInorder() {
        if(left != null) {
            left.printInorder();
        }
        System.out.print(data+" ");
        if(right != null) {
            right.printInorder();
        }

    }

    public void printPreorder() {
        System.out.println(data + " ");

        if(left != null) {
            left.printPreorder();
        }

        if(right != null){
            right.printPreorder();
        }
    }
}
