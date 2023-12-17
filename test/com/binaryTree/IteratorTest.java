package com.binaryTree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by major on 16/10/2.
 */
public class IteratorTest {
    Iterator itr = new Iterator();
    TreeNode root = new TreeNode(1);

    @Test
    public void postOrderIteration() throws Exception {

        itr.postOrderIteration(root);

    }

}