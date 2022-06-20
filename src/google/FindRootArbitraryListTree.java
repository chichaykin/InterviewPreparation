package google;

import leetcode.Node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindRootArbitraryListTree {
    public Node findRoot(List<Node> tree) {
        Map<Node, Node> parent = new HashMap<>();
        for (Node node : tree) {
            if (node.left != null) parent.put(node.left, node);
            if (node.right != null) parent.put(node.right, node);
            parent.putIfAbsent(node, null);
        }
        for (Map.Entry<Node, Node> entry : parent.entrySet()) {
            if (entry.getValue() == null) return entry.getKey();
        }
        return null;
    }

//    public Node findRoot2(List<Node> nodes) { // 176
//        int sum = 0;
//        for (Node node : nodes) {
//            sum ^= node.val;
//            for (Node child : node.children) {
//                sum ^= child.val;
//            }
//        }
//
//        for (Node node : nodes) {
//            if (node.val == sum) {
//                return node;
//            }
//        }
//
//        return null;
//    }
}
