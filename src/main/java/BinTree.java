import java.util.ArrayList;
import java.util.List;

/**
 * Печать бинарного дерева.
 */
public class BinTree {

    public static void main(String[] arguments){
        Node topNode = new Node("A");
        topNode.leftNode = new Node("B");
        topNode.rightNode = new Node("C");

        topNode.leftNode.leftNode = new Node("D");
        topNode.rightNode.rightNode = new Node("E");

        topNode.rightNode.rightNode.leftNode = new Node("F");
        topNode.leftNode.leftNode.rightNode = new Node("J");
        topNode.leftNode.leftNode.leftNode = new Node("H");

        printTree(topNode);

    }

    public static void printTree(Node node){

         class TreeStructure{
            /**
             * Возвращает содержание дерева после его обхода
             * @param node верхний узел
             * @return список StringBulder c содержанием уровней дерева
             */
            public List<StringBuilder> getTreeStructure(Node node){
                 return scanTreeStructure(new ArrayList<StringBuilder>(), node, 0);
            }

            /**
             * Метод рекурсивного обхода дерева для считывания его структуры
             * @param treeContent - Список содержащий структуру дерева
             * @param node узел дерева
             * @param treeDepth уровень узла
             * @return список содержащий структуру дерева
             */
            private List<StringBuilder> scanTreeStructure(List<StringBuilder> treeContent, Node node, int treeDepth){
                if (node == null) return treeContent;
                if (treeContent.size() == treeDepth) treeContent.add(new StringBuilder());
                treeContent.get(treeDepth).append(node.nodeValue).append(" ");
                scanTreeStructure(treeContent, node.leftNode, treeDepth + 1);
                scanTreeStructure(treeContent, node.rightNode, treeDepth + 1);

                return treeContent;
            }
        }

        TreeStructure tree = new TreeStructure();
         for (StringBuilder s : tree.getTreeStructure(node)){
             System.out.println(s.toString());
         }

    }

    public static class Node{
        public Node leftNode;
        public Node rightNode;
        public String nodeValue;

        public Node(String value){
            this.nodeValue = value;
        }

    }



}
