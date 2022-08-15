package com.sparta.leanne;
// public - methods you can access
//private - implementation
//abstract Nodes - values

public class BinaryTree implements BinaryTreeInterface {
    private Node rootNode;
    private static int index;

    public BinaryTree(int element) {
        rootNode = new Node(element);
    }

    public void addElementToTree(final int element){
        addNodeToTree(rootNode, element);
    }


    @Override
    public int getRootElement() {

        return rootNode.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return getNumberOfElements(rootNode);

    }
    public int getNumberOfElements(Node rootNode) {
        if(rootNode == null) {
            return 0;
        }
        else {
            return 1 + getNumberOfElements(rootNode.getLeftChild()) +
                    getNumberOfElements(rootNode.getRightChild());
        }

    }

    @Override
    public void addElement(int element) {
        addNodeToTree(rootNode, element);

    }

    @Override
    public void addElements(int[] elements) {
        for(int element: elements){
            addNodeToTree(rootNode,element);
        }

    }

    public boolean findElement(int element){
        Node node = findNode(rootNode,element);
        if (node != null){
            return true;
        }
        else{
            return false;
        }
    }


    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        if (!findElement(element)){
            throw new ChildNotFoundException();
        }
        else{
            return findNode(rootNode,element).getLeftChild().getValue();


        }

    }
    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        if (!findElement(element)){
            throw  new ChildNotFoundException();
        }
        else{
            return findNode(rootNode,element).getRightChild().getValue();


        }

    }

    @Override
    public int[] getSortedTreeAsc(){
        int[] ans = new int[getNumberOfElements(rootNode)];
        index = 0;
        return getSortedTreeAsc(ans, rootNode);

    }

    @Override
    public int[] getSortedTreeDesc() {
        int[] ans = new int[getNumberOfElements(rootNode)];
        index = 0;
        return getSortedTreeDesc(ans, rootNode);
    }

    public static int[] getSortedTreeAsc(int[] ans, Node rootNode) {
        if (!rootNode.isLeftChildEmpty()) {
            getSortedTreeAsc(ans, rootNode.getLeftChild());
        }
        ans[index] = rootNode.getValue();
        index += 1;
        if (!rootNode.isRightChildEmpty()) {
            getSortedTreeAsc(ans, rootNode.getRightChild());
        }
        return ans;
    }

    public static int[] getSortedTreeDesc(int[] ans, Node rootNode) {
        if (!rootNode.isRightChildEmpty()) {
            getSortedTreeDesc(ans, rootNode.getRightChild());
        }
        ans[index] = rootNode.getValue();
        index += 1;
        if (!rootNode.isLeftChildEmpty()) {
            getSortedTreeDesc(ans, rootNode.getLeftChild());
        }
        return ans;
    }
    private  void addNodeToTree(Node node,int element){
        if (element < node.getValue()){
            if (node.isLeftChildEmpty()){
                node.setLeftChild(new Node(element));
            }
            else{
                addNodeToTree(node.getLeftChild(), element);
            }
        }
        else if (element > node.getValue()){
            if (node.isRightChildEmpty()){
                node.setRightChild(new Node(element));
            }
            else{
                addNodeToTree(node.getRightChild(), element);
            }
        }

    }

    private Node findNode(Node rootNode,int element){
        Node node = rootNode;
        while (node != null){
            if (element == node.getValue()){
                return node;
            }
            if (element < node.getValue()){
                node  = node.getLeftChild();
            }
            if (element > node.getValue()){
                node = node.getRightChild();
            }

        }
        return null;
    }


}
