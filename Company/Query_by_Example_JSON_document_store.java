import java.io.FileReader;
import java.util.Iterator;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class QueryJSON {
    private class Node {
        Map<String, NodeVal> map;

        Node() {
            this.map = new HashMap<>();
        }

        void add(JSONObject o, int index) {
            for (Iterator iterator = o.keySet().iterator(); iterator.hasNext();) {
                String key = (String) iterator.next();

                if (!this.map.containsKey(key)) {
                    this.map.put(key, new NodeVal());
                }
                this.map.get(key).addVal(o.get(key), index);
            }
        }

        List<Integer> get(JSONObject o) {
            List<Integer> res = null;

            for (Iterator iterator = o.keySet().iterator(); iterator.hasNext();) {
                String key = (String) iterator.next();
                if (this.map.containsKey(key)) {
                    NodeVal nodeVal = this.map.get(key);
                    List<Integer> list = nodeVal.get(o.get(key));
                    if (res == null) {
                        res = new ArrayList<>(list);
                    } else {
                        res.retainAll(list);
                    }
                }
            }

            return res != null ? res : new ArrayList<>();
        }
    }

    private class NodeVal {
        Map<Object, List<Integer>> valMap;
        Node nextNode;

        NodeVal() {}

        List<Integer> get(Object o) {
            if (o instanceof JSONObject) {
                return getHelper((JSONObject) o);
            } else if (o instanceof JSONArray) {
                return getHelper((JSONArray) o);
            } else {
                return getHelper(o);
            }
        }

        private List<Integer> getHelper(Object o) {
            if (this.valMap.containsKey(o)) {
                return this.valMap.get(o);
            }
            return new ArrayList<>();
        }

        private List<Integer> getHelper(JSONArray o) {
            JSONArray cur = getMatchArray(o);
            if (cur == null) {
                return new ArrayList<>();
            }

            return this.valMap.get(cur);
        }

        private List<Integer> getHelper(JSONObject o) {
            return this.nextNode.get(o);
        }

        void addVal(Object o, int index) {
            if (o instanceof JSONObject) {
                if (this.nextNode == null) {
                    this.nextNode = new Node();
                }
                addValHelper((JSONObject) o, index);
                return;
            }

            if (this.valMap == null) {
                this.valMap = new HashMap<>();
            }

            if (o instanceof JSONArray) {
                addValHelper((JSONArray) o, index);
            } else {
                addValHelper(o, index);
            }
        }

        private void addValHelper(Object o, int index) {
            if (!this.valMap.containsKey(o)) {
                this.valMap.put(o, new ArrayList<>());
            }

            this.valMap.get(o).add(index);
        }

        private void addValHelper(JSONArray o, int index) {
            JSONArray cur = getMatchArray(o);
            if (cur == null) {
                this.valMap.put(o, new ArrayList<>());
                cur = o;
            }

            this.valMap.get(cur).add(index);
        }

        private void addValHelper(JSONObject o, int index) {
            this.nextNode.add(o, index);
        }

        private JSONArray getMatchArray(JSONArray o) {
            for (Object key : this.valMap.keySet()) {
                JSONArray arr = (JSONArray) key;
                if (arr.size() != o.size()) {
                    return null;
                }
                int i = 0;
                for (; i < o.size(); i++) {
                    if ((int) arr.get(i) != (int) o.get(i)) {
                        break;
                    }
                }
                if (i == o.size()) {
                    return arr;
                }
            }
            return null;
        }
    }

    private Node root;
    private Map<Integer, String> store;
    private int index;

    QueryJSON() {
        this.root = new Node();
        this.store = new HashMap<>();
        this.index = 0;
    }

    void add(JSONObject o, String source) {
        this.store.put(this.index, source);
        this.root.add(o, this.index++);
    }

    List<String> get(JSONObject o) {
        List<String> res = new ArrayList<>();

        List<Integer> indices = this.root.get(o);
        for (int index : indices) {
            if (this.store.containsKey(index)) {
                res.add(this.store.get(index));
            }
        }

        return res;
    }

    void delete(JSONObject o) {
        List<Integer> list = this.root.get(o);
        for (int index : list) {
            this.store.remove(index);
        }
    }

    public static void main(String[] args) throws Exception {
        Object obj = new JSONParser().parse(new FileReader("src/JSONExample.json"));
        JSONObject jo = (JSONObject) obj;

        QueryJSON qj = new QueryJSON();
        qj.add(jo, jo.toString());

        Object objQuery = new JSONParser().parse(new FileReader("src/JSONExample_query.json"));
        JSONObject joQuery = (JSONObject) objQuery;

        for (String s : qj.get(joQuery)) {
            System.out.println(s);
        }

        qj.delete(joQuery);
    }
}
