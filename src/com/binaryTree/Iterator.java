package com.binaryTree;

import java.util.*;

/**
 * Created by major on 16/8/22.
 * <p>
 * 二叉树的几种遍历方式
 */
public class Iterator {

    //递归 先序遍历
    public void preOrderRecursion(ListNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOrderRecursion(root.left);
            preOrderRecursion(root.right);
        }
    }

    //递归 中序遍历
    public List<Integer> inorderTraversal(ListNode root) {
        List<Integer> res = new LinkedList<>();
        if (root != null) {
            inorderTraversal(root.left);
            res.add(root.val);
            inorderTraversal(root.right);
        }
        return res;
    }

    //递归 后序遍历
    public void postOrderRecursion(ListNode root) {
        if (root != null) {
            preOrderRecursion(root.left);
            preOrderRecursion(root.right);
            System.out.println(root.val);
        }
    }

    /**
     * @param root 非递归 先序遍历
     *             先遍历左子树,先读取值然后后压栈,直到遇到null以后,出栈,得到右子树,继续之前的遍历
     */
    public List<Integer> preOrderIteration(ListNode root) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = root;
        List<Integer> res = new LinkedList<>();
        while (node != null || stack.size() > 0) {
            while (node != null) {
                stack.push(node);
                res.add(node.val);
                node = node.left;
            }
            if (stack.size() > 0) {
                node = stack.pop();
                node = node.right;
            }
        }
        return res;
    }
    /**
     * @param root 非递归 中序遍历
     *             类似于先序遍历,调整压栈和打印的位置
     *             先遍历左子树,然后遇到null,出栈,打印值,得到右子树,重复之前的步骤
     */
    public List<Integer> inOrderIteration(ListNode root) {

        List<Integer> res = new LinkedList<>();
        ListNode node = root;
        Stack<ListNode> stack = new Stack<>();
        while (node != null || stack.size() > 0) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (stack.size() > 0) {
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }

    /**
     * @param root 非递归 后序遍历
     *             使用一个结点记录前一个输出
     *             同样先遍历左子树,直到遇到null,打印该结点,取栈顶元素的右节点但该元素不出栈,只有当右节点为空或等于前一个输出时,才打印该节点
     */
    public List<Integer> postOrderIteration(ListNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<ListNode> s = new Stack<>();
        ListNode pre = null;
        while (!s.isEmpty() || root != null) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if (root.right == null || root.right == pre) {
                res.add(root.val);
                pre = root;
                root = null;
            } else {
                s.push(root);
                root = root.right;
            }
        }
        return res;

    }


    public void levelIteration(ListNode root) {
        Queue<ListNode> queue = new LinkedList<>();
        ListNode node = root;
        node = root;
        queue.add(node);
        while (queue.size() > 0) {
            node = queue.poll();
            System.out.println(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public List<Integer> morrisIn(ListNode head) {
        List<Integer> res = new LinkedList<>();
        if (head == null) {
            return res;
        }
        ListNode cur1 = head;
        ListNode cur2;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left; // important
                    continue; // im
                } else {
                    cur2.right = null;
                }
            }
            res.add(cur1.val);
            cur1 = cur1.right;
        }
        return res;
    }

    public List<Integer> morrisPre(ListNode head) {
        List<Integer> res = new LinkedList<>();
        if (head == null) {
            return res;
        }
        ListNode cur1 = head;
        ListNode cur2;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    res.add(cur1.val);
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            } else {
                res.add(cur1.val);
            }
            cur1 = cur1.right;
        }
        return res;
    }

    public List<Integer> morrisPos(ListNode head) {
        List<Integer> res = new LinkedList<>();
        if (head == null) {
            return res;
        }
        ListNode cur1 = head;
        ListNode cur2;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    res.add(cur1.val);
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                    printEdge(cur1.left, res);
                }
            }
            cur1 = cur1.right;
        }
        printEdge(head, res);
        return res;
    }

    public void printEdge(ListNode node, List<Integer> res) {
        ListNode tail = reverseNode(node);
        ListNode cur = tail;
        while (cur != null) {
            res.add(cur.val);
            cur = cur.right;
        }
        reverseNode(tail);
    }

    public ListNode reverseNode(ListNode node) {
        ListNode cur = node;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public void levelTraversalWithLine(ListNode head) {
        Queue<ListNode> q = new LinkedList<>();
        ListNode last = head;
        ListNode nLast = null;
        q.offer(head);
        int line = 1;
        System.out.print("Level " + (line++) + " : ");
        while (!q.isEmpty()) {
            ListNode n = q.poll();
            System.out.print(n.val + " ");
            if (n.left != null) {
                q.offer(n.left);
                nLast = n.left;
            }
            if (n.right != null) {
                q.offer(n.right);
                nLast = n.right;
            }
            if (n == last && !q.isEmpty()) {
                System.out.print("\nLevel " + line++ + " : ");
                last = nLast;
            }
        }
    }

    public void zigzag(ListNode head) {
        Deque<ListNode> dq = new LinkedList<>();
        ListNode last = head;
        ListNode nLast = head.left;
        int level = 1;
        System.out.print("Level " + (level++) + " from left to right: ");
        dq.offer(head);
        while (!dq.isEmpty()) {
            boolean l2r = level % 2 == 1;
            ListNode n = null;
            if (l2r) {
                n = dq.pollFirst();
                nLast = nLast == null ? n.left : nLast;
                if (n.left != null) {
                    dq.offerLast(n.left);
                }
                if (n.right != null) {
                    dq.offerLast(n.right);
                }
            } else {
                n = dq.pollLast();
                nLast = nLast == null ? nLast.right : nLast;
                if (n.right != null) {
                    dq.offerFirst(n.right);
                }
                if (n.left != null) {
                    dq.offerFirst(n.left);
                }
            }
            System.out.print(n.val + " ");
            if (n == last && !dq.isEmpty()) {
                last = nLast;
                nLast = null;
                if (l2r) {
                    System.out.print("\nLevel" + (level++) + " from right to left: ");
                } else {
                    System.out.print("\nLevel " + (level++) + " from left to right: ");
                }
            }

        }
    }
}
