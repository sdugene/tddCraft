package com.sdugene.render_tree;

import java.util.*;

public class Render {

    private Render() {
        throw new IllegalStateException("Utility class");
    }

    public static String render(String[] list) {

        LinkedHashMap<String, LinkedHashMap> finalTree = new LinkedHashMap<>();
        Arrays.sort(list);
        for (String string : list) {
            String[] tree = string.split("/");
            if (tree[0].isEmpty()){
                tree = remove(tree,0);
            }
            treeify(tree, finalTree);
        }
        return stringify(finalTree, 0);

    }

    private static LinkedHashMap<String, LinkedHashMap> treeify(String[] tree, LinkedHashMap<String, LinkedHashMap> finalTree) {
        int curs = 0;
        while(curs < tree.length) {
            if (curs == 0 && !finalTree.containsKey(tree[curs])) {
                finalTree.put(tree[curs], new LinkedHashMap<>());
            } else if (curs != 0) {
                treeify(remove(tree, 0), finalTree.get(tree[curs-1]));
                curs+=tree.length;
            }
            curs++;
        }
        return finalTree;
    }

    private static String stringify(LinkedHashMap<String, LinkedHashMap> tree, int level) {
        StringBuilder result = new StringBuilder();
        int line = 0;
        for (Map.Entry<String,LinkedHashMap> entry : tree.entrySet()) {
            String key = entry.getKey();
            LinkedHashMap<String,LinkedHashMap> value = entry.getValue();

            if (line > 0) {
                result.append("\n");
            }

            if (level > 0) {
                for (int iter = 0 ; iter < level ; iter++) {
                    result.append("\t");
                }
            }

            result.append(key);
            if (!tree.get(key).isEmpty()) {
                result.append("\n");

                result.append(stringify(value, level+1));
            }
            line++;
        }

        return result.toString();
    }

    private static String[] remove(String[] strings, int pos) {
        List<String> list = new ArrayList<>(Arrays.asList(strings));
        list.remove(pos);
        return list.toArray(new String[0]);
    }
}
