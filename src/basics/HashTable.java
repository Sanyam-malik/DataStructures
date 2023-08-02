package basics;

public class HashTable<K, V> {

    public class Node {
        K key;
        V value;

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node() {

        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public String toString(){
            return "{"+key+":"+value+"}";
        }
    }

    private LinkedList<Node> buckets[];
    // Buckets Size
    private int N;
    // No of Nodes
    private int n;
    // Threshhold constant
    private double K = 0.75;

    public HashTable() {
        this.prepareBuckets(4);
    }

    public HashTable(double threshhold) {
        this.prepareBuckets(4);
        this.K = threshhold;
    }

    public void put(K key, V value) {
        int bi = hashFunction(key);
        int ki = searchInLL(key, bi);
        if(ki > -1){
            Node node = this.buckets[bi].get(ki);
            node.setValue(value);
        } else {
            Node node = new Node(key, value);
            this.buckets[bi].add(node);
            this.n = this.n + 1;
            rehashing();
        }
    }

    public boolean containsKey(K key) {
        int bi = hashFunction(key);
        int ki = searchInLL(key, bi);
        if(ki > -1){
            return true;
        } else {
            return false;
        }
    }

    public V get(K key) {
        int bi = hashFunction(key);
        int ki = searchInLL(key, bi);
        if(ki > -1){
            Node node = this.buckets[bi].get(ki);
            return node.getValue();
        } else {
            return null;
        }
    }

    public Node remove(K key) {
        int bi = hashFunction(key);
        int ki = searchInLL(key, bi);
        if(ki > -1){
            Node node = this.buckets[bi].get(ki);
            this.buckets[bi].remove(ki);
            this.n = this.n - 1;
            return node;
        } else {
            return null;
        }
    }

    public ArrayList<K> keySet() {
        return getKeys();
    }

    public ArrayList<V> valuesSet() {
        return getValues();
    }

    public ArrayList<Node> entrySet() {
        return getNodes();
    }

    public boolean isEmpty() {
        return n == 0? true: false;
    }

    @SuppressWarnings("unchecked")
    private void prepareBuckets(int size){
        this.buckets = new LinkedList[size];
        this.N = buckets.length;
        for (int outterIndex = 0; outterIndex < N; outterIndex ++) {
            buckets[outterIndex] = new LinkedList<Node>();
        }
    }

    private int hashFunction(K key){
        int hash = Math.abs(key.hashCode())%N;
        return hash;
    }

    private int searchInLL(K key, int bi){
        LinkedList<Node> nodes = buckets[bi];
        for(int index = 0; index < nodes.size(); index++) {
            Node node = nodes.get(index);
            if(node.getKey().equals(key)) {
                return index;
            }
        }

        return -1;
    }

    private void rehashing(){
        // caluculating threshhold
        double k = n/N;
        // If calculated threshhold is greator than/equal to permitted threshhold
        if(k >= K){
            LinkedList<Node> oldBuckets[] = this.buckets;
            prepareBuckets(N%2);
            for (int outterIndex = 0; outterIndex < oldBuckets.length; outterIndex ++) {
                LinkedList<Node> nodes = oldBuckets[outterIndex];
                for(int innerIndex = 0; innerIndex < nodes.size(); innerIndex++) {
                    Node node = nodes.get(innerIndex);
                    this.put(node.getKey(), node.getValue());
                }
            }
        }
    }

    private ArrayList<Node> getNodes(){
        ArrayList<Node> list = new ArrayList<>();
        for (int outterIndex = 0; outterIndex < N; outterIndex ++) {
            LinkedList<Node> nodes = buckets[outterIndex];
            for(int innerIndex = 0; innerIndex < nodes.size(); innerIndex++) {
                Node node = nodes.get(innerIndex);
                list.add(node);
            }
        }
        return list;
    }

    private ArrayList<K> getKeys(){
        ArrayList<K> list = new ArrayList<>();
        for (int outterIndex = 0; outterIndex < N; outterIndex ++) {
            LinkedList<Node> nodes = buckets[outterIndex];
            for(int innerIndex = 0; innerIndex < nodes.size(); innerIndex++) {
                Node node = nodes.get(innerIndex);
                list.add(node.getKey());
            }
        }
        return list;
    }

    private ArrayList<V> getValues(){
        ArrayList<V> list = new ArrayList<>();
        for (int outterIndex = 0; outterIndex < N; outterIndex ++) {
            LinkedList<Node> nodes = buckets[outterIndex];
            for(int innerIndex = 0; innerIndex < nodes.size(); innerIndex++) {
                Node node = nodes.get(innerIndex);
                list.add(node.getValue());
            }
        }
        return list;
    }
    
}
