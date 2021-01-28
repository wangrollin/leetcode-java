package com.wangrollin.leetcode.n4_real_interview;

import java.util.*;

public class ByteDanceInterview {

    /**
     * 2021.01.27
     * 输出有向无环图的拓扑排序
     */
    public static class Node {
        String val;
        List<Node> children;

        public Node(String val) {
            this.val = val;
        }
    }

    public List<String> printTopoSorting(Node root) {

        Map<Node, Set<Node>> parents = new HashMap<>();

        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        parents.put(root, new HashSet<>());
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Node node = queue.poll();
            List<Node> children = node.children;

            if (children != null && !children.isEmpty()) {
                children.forEach(child -> {
                    queue.add(child);
                    parents.compute(child, (k, v) -> {
                        if (v == null) {
                            Set<Node> p = new HashSet<>();
                            p.add(node);
                            return p;
                        } else {
                            v.add(node);
                            return v;
                        }
                    });
                });
            }
        }

        queue.add(root);
        while (!queue.isEmpty()) {

            Node node = queue.poll();
            if (node.children != null) {
                queue.addAll(node.children);
            }
            if (parents.get(node).stream().noneMatch(parents::containsKey)) {
                result.add(node.val);
                parents.remove(node);
            }
        }

        return result;
    }
}
