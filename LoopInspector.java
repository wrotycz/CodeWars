import java.util.HashSet;

public class LoopInspector {
    
    public int loopSize(Node node) {
        Node myNode = node;
        HashSet<Node> setOfNodes = new HashSet<>();
        
        for(int i = 0; i < Integer.MAX_VALUE ; i++) {
            if (!setOfNodes.add(myNode)) {
                Node checkNode = myNode;
                int counter;
                for (counter = 0; myNode.getNext() != checkNode; counter++) {
                    myNode = myNode.getNext();
                }
                return counter;
            }
            myNode = myNode.getNext();
          
        }
      
        return 0;
    }
    
}

class Node {
    public Node getNext() {
        return new Node();
    }
}
