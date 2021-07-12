import java.util.*;
class test{
    public static void main(String args[]){
        AVLT t = new AVLT(1);
        for (int i=-2; i<2; i++){
            t.insert(i);
        }
        t.preorder(t.root);
        System.out.println();
        t.postorder(t.root);
        t.remove(1);
        System.out.println();
        t.preorder(t.root);
        System.out.println(t.root.height);
        t.postorder(t.root);
    }
}