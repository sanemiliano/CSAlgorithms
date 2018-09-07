

import java.util.ArrayList;
import java.util.Scanner;

public class BinaryTreeTest {

    public static Scanner sc = new Scanner(System.in);
    public static BinarySearchTree myTree;

    public static void main(String[] args) {
        int cont = 0;
        int a = 0;
        while (a !=10) {

            System.out.println("1.-Add element to the binary tree");
            System.out.println("2.-Search element in the binary tree");
            System.out.println("3.-Delete element in the binary tree");
            System.out.println("4.-Print binary Tree PreOrder path");
            System.out.println("5.-Print binary Tree Order path");
            System.out.println("6.-Print binary Tree PosOrder path");
            System.out.println("7.-Print binary Tree Breath path");
            System.out.println("8.-Get father");
            System.out.println("9.-Delete Node");
            System.out.println("10.-Finish program");
            a = sc.nextInt();

            switch (a) {
                case 1:
                    cont++;
                    if(cont==1){
                        myTree = new BinarySearchTree(new Node(sc.nextInt()));
                    }
                    else {
                        Node b = new Node(sc.nextInt());
                        myTree.add(b);
                    }
                    break;
                case 2:
                    System.out.println("Introduzca el nodo a buscar");
                    Node c = new Node(sc.nextInt());
                    if(myTree.search(c,myTree.getRoot())!=null)
                        System.out.println("SI ESTA");
                    else 
                        System.out.println("NO ESTA");
                    break;
                case 3:
                    //myTree.delete();
                    break;
                case 4:
                    myTree.preorden(myTree.getRoot());
                    break;
                case 5:
                    myTree.orden(myTree.getRoot());
                    break;
                case 6:
                    myTree.posorden(myTree.getRoot());
                    break;
                case 7:
                    myTree.breath(myTree.getRoot());
                    break;
                case 8:
                    Node y = myTree.getFather(new Node(sc.nextInt()),myTree.getRoot());
                    if(y!=null)
                        System.out.println("Father is "+y.toString());
                    else
                        System.out.println("It has no father");
                    break;
                case 9:
                    myTree.delete(new Node(sc.nextInt()));
            }
        }

    }
}
