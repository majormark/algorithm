package com.string;

import com.binaryTree.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by major on 16/9/2.
 */
public class IdenticalTreeTest {
    TreeNode root = new TreeNode(1);
    TreeNode subRoot1 = null;
    TreeNode subRoot2 = null;
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
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        /**
         *   subRoot1
         *    2
         *   / \
         *  4  5
         * /   \
         * 8   9
         */

        subRoot1 = new TreeNode(2);
        subRoot1.left = new TreeNode(4);
        subRoot1.right = new TreeNode(5);
        subRoot1.left.left = new TreeNode(8);
        subRoot1.right.right = new TreeNode(9);

        /**
         *   subRoot2
         *    2
         *   / \
         *  4  5
         * /
         * 8
         */

        subRoot2 = new TreeNode(2);
        subRoot2.left = new TreeNode(4);
        subRoot2.right = new TreeNode(5);
        subRoot2.left.left = new TreeNode(8);


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
