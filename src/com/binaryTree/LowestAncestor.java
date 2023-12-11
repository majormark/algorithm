package com.binaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 最近公共祖先系列问题 pg.153
 */
public class LowestAncestor {
    public ListNode lowestAncestor(ListNode h, ListNode o1, ListNode o2) {
        if (h == null || h == o1 || h == o2) {
            return h;
        }
        ListNode left = lowestAncestor(h.left, o1, o2);
        ListNode right = lowestAncestor(h.right, o1, o2);
        if (left != null && right != null) {
            return h;
        }
        return left != null ? left : right;
    }
}

class Record1 {
    private HashMap<ListNode, ListNode> m;

    public Record1(ListNode h) {
        m = new HashMap<>();
        setMap(h, m);
    }

    public void setMap(ListNode h, HashMap<ListNode, ListNode> m) {
        if (h == null) {
            return;
        }
        if (h.left != null) {
            m.put(h.left, h);
        }
        if (h.right != null) {
            m.put(h.right, h);
        }
        setMap(h.left, m);
        setMap(h.right, m);
    }

    public ListNode query(ListNode o1, ListNode o2) {
        HashSet<ListNode> path = new HashSet<>();
        while (m.containsKey(o1)) {
            path.add(o1);
            o1 = m.get(o1);
        }
        while (!path.contains(o2)) {
            o2 = m.get(o2);
        }
        return o2;
    }
}

class Record2 {
    private HashMap<ListNode, HashMap<ListNode, ListNode>> m;

    public Record2(ListNode h) {
        m = new HashMap<>();
        initMap(h);
        setMap(h);
    }

    public void initMap(ListNode h) {
        if (h == null) {
            return;
        }
        m.put(h, new HashMap<>());
        initMap(h.left);
        initMap(h.right);
    }

    public void setMap(ListNode h) {
        if (h == null) {
            return;
        }
        headRecord(h.left, h);
        headRecord(h.right, h);
        subRecord(h);

    }

    public void headRecord(ListNode n, ListNode h) {
        if (n == null) {
            return;
        }
        m.get(n).put(h, h);
        headRecord(n.left, h);
        headRecord(n.right, h);
    }

    public void subRecord(ListNode h) {
        if (h == null) {
            return;
        }
        preLeft(h.left, h.right, h);
        subRecord(h.left);
        subRecord(h.right);
    }

    public void preLeft(ListNode l, ListNode r, ListNode h) {
        if (l == null) {
            return;
        }
        preRight(l, r, h);
        preLeft(l.left, r, h);
        preLeft(l.right, r, h);
    }

    public void preRight(ListNode l, ListNode r, ListNode h) {
        if (r == null) {
            return;
        }
        m.get(r).put(l, h);
        preRight(l, r.left, h);
        preLeft(l, r.right, h);
    }

}

class Query {
    ListNode o1;
    ListNode o2;
}

class TarJan {
    private HashMap<ListNode, LinkedList<ListNode>> queryMap;
    private HashMap<ListNode, LinkedList<Integer>> indexMap;
    private HashMap<ListNode, ListNode> ancestorMap;
    private DisJointSets sets;

    public TarJan() {
        queryMap = new HashMap<>();
        indexMap = new HashMap<>();
        ancestorMap = new HashMap<>();
        sets = new DisJointSets();
    }

    public ListNode[] query(ListNode h, Query[] queries) {
        ListNode[] ans = new ListNode[queries.length];
        setQueries(queries, ans);
        sets.makeSets(h);
        setAnswers(h, ans);
        return ans;
    }

    public void setQueries(Query[] queries, ListNode[] ans) {
        ListNode o1;
        ListNode o2;
        for (int i = 0; i < queries.length; i++) {
            o1 = queries[i].o1;
            o2 = queries[i].o2;
            if (o1 == null || o2 == null || o1 == o2) {
                ans[i] = o1 == null ? o2 : o1;
            } else {
                if (!queryMap.containsKey(o1)) {
                    queryMap.put(o1, new LinkedList<>());
                    indexMap.put(o1, new LinkedList<>());
                }
                if (!queryMap.containsKey(o2)) {
                    queryMap.put(o2, new LinkedList<>());
                    indexMap.put(o2, new LinkedList<>());
                }
                queryMap.get(o1).add(o2);
                indexMap.get(o1).add(i);
                queryMap.get(o2).add(o1);
                indexMap.get(o2).add(i);
            }
        }
    }

    public void setAnswers(ListNode h, ListNode[] ans) {
        if (h == null) {
            return;
        }
        setAnswers(h.left, ans);
        sets.union(h.left, h);
        ancestorMap.put(sets.findFather(h), h);
        setAnswers(h.right, ans);
        sets.union(h.right, h);
        ancestorMap.put(sets.findFather(h), h);
        LinkedList<ListNode> nList = queryMap.get(h);
        LinkedList<Integer> iList = indexMap.get(h);
        ListNode n = null;
        ListNode nFather = null;
        int index = 0;
        while (nList != null && !nList.isEmpty()) {
            n = nList.poll();
            index = iList.poll();
            nFather = sets.findFather(n);
            if (ancestorMap.containsKey(nFather)) {
                ans[index] = ancestorMap.get(n);
            }
        }
    }

}

class DisJointSets {
    public HashMap<ListNode, ListNode> fatherMap;
    public HashMap<ListNode, Integer> rankMap;

    public DisJointSets() {
        fatherMap = new HashMap<>();
        rankMap = new HashMap<>();
    }

    public void makeSets(ListNode h) {
        fatherMap.clear();
        rankMap.clear();
        preOrderMake(h);
    }

    public void preOrderMake(ListNode h) {
        if (h == null) {
            return;
        }
        fatherMap.put(h, h);
        rankMap.put(h, 0);
        preOrderMake(h.left);
        preOrderMake(h.right);
    }

    public ListNode findFather(ListNode n) {
        ListNode father = fatherMap.get(n);
        if (n != father) {
            father = findFather(father);
        }
        fatherMap.put(n, father);
        return father;
    }

    public void union(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return;
        }
        ListNode aFather = findFather(a);
        ListNode bFather = findFather(b);
        if (aFather == bFather) {
            return;
        }
        int r1 = rankMap.get(aFather);
        int r2 = rankMap.get(bFather);
        if (r1 > r2) {
            fatherMap.put(bFather, aFather);
        } else if (r1 < r2) {
            fatherMap.put(aFather, bFather);
        } else {
            fatherMap.put(bFather, aFather);
            rankMap.put(aFather, r1 + 1);
        }
    }
}