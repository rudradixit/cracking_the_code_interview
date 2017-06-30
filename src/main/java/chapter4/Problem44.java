package chapter4;

import chapter4.aux.BinaryNode;

import java.util.ArrayList;
import java.util.List;

public class Problem44 {
    public static <T> List<List<BinaryNode<T>>> listify(BinaryNode<T> root) {
        List<List<BinaryNode<T>>> list = new ArrayList<>();
        _listify(root, 0, list);
        return list;
    }

    private static <T> void _listify(BinaryNode<T> root, int level, List<List<BinaryNode<T>>> list) {
        if (list.size() < (level + 1)) {
            list.add(new ArrayList<>());
        }

        list.get(level).add(root);

        if (root.getLeft() != null) {
            _listify(root.getLeft(), level + 1, list);
        }

        if (root.getRight() != null) {
            _listify(root.getRight(), level + 1, list);
        }
    }
}