package com.string;

import com.binaryTree.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by major on 16/9/2.
 */
public class IdenticalTreeTest {
    ListNode root = new ListNode(1);
    ListNode subRoot1 = null;
    ListNode subRoot2 = null;
    IdenticalTree idtTree = new IdenticalTree();
    @Before
    public void setUp() throws Exception {
        /**
         *     root
         *        1
         *     /    \
         *    2     3
         *   / \   / \
         *  4  5  6  7
         * /   \
         * 8   9
         */
        root.left = new ListNode(2);
        root.right = new ListNode(3);
        root.left.left = new ListNode(4);
        root.left.right = new ListNode(5);
        root.right.left = new ListNode(6);
        root.right.right = new ListNode(7);
        root.left.left.left = new ListNode(8);
        root.left.right.right = new ListNode(9);

        /**
         *   subRoot1
         *    2
         *   / \
         *  4  5
         * /   \
         * 8   9
         */

        subRoot1 = new ListNode(2);
        subRoot1.left = new ListNode(4);
        subRoot1.right = new ListNode(5);
        subRoot1.left.left = new ListNode(8);
        subRoot1.right.right = new ListNode(9);

        /**
         *   subRoot2
         *    2
         *   / \
         *  4  5
         * /
         * 8
         */

        subRoot2 = new ListNode(2);
        subRoot2.left = new ListNode(4);
        subRoot2.right = new ListNode(5);
        subRoot2.left.left = new ListNode(8);


    }
    @Test
    public void testSerialize() {
        Assert.assertEquals("2!4!8!#!#!#!5!#!#!", idtTree.serialize(subRoot2));
    }

    @Test
    public void testGetNext() {
        String str = idtTree.serialize(subRoot2);
        System.out.println(str);
        int[] next = idtTree.getNext(str);
        System.out.println(Arrays.toString(next));
    }

    @Test
    public void testChkIdentical() {
        Assert.assertEquals(true,idtTree.chkIdentical(root, subRoot1));
        Assert.assertEquals(false,idtTree.chkIdentical(root, subRoot2));

    }
}
