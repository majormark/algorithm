package com.binaryTree;

/**
 * 在二叉树中找到一个节点的后继节点
 */

class NodeWithParent {
    int value;
    NodeWithParent left;
    NodeWithParent right;
    NodeWithParent parent;

    public NodeWithParent(int v) {
        this.value = v;
    }
}
public class GetNextNode {
    public NodeWithParent getNextNode(NodeWithParent node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return getLeftMost(node.right);
        }
        NodeWithParent p = node.parent;
        while (p != null && node != p.left) {
            node = p;
            p = node.parent;
        }
        return p;
    }

    public NodeWithParent getLeftMost(NodeWithParent n) {
        if (n == null) {
            return null;
        }
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }
}
