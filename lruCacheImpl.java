  public static void main(String args[])
    {
        LRUCache ca = new LRUCache(4);
        ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.display();
    }

    public static class LRUCache {
        Deque<Integer> cache = new ArrayDeque<>();
        int capacity;
        Set<Integer> pages = new HashSet<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public void refer(int page) {
            if (!pages.contains(page)) {
                if (cache.size() == capacity) {
                    int last = cache.removeLast();
                    pages.remove(last);
                }
            }
            else {
                cache.remove(page);
            }
            cache.push(page);
            pages.add(page);
        }
        

        public void display() {
            for (int a : cache) {
                System.out.println(a + " ");
            }
        }
    }