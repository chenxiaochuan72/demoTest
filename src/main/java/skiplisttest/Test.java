package skiplisttest;

import java.util.Random;

public class Test {
    public class SkipList {
        private static final double PROMOTE_RATE = 0.5;
        private static final int MAX_LEVEL = 16;
        private int levelCount = 1;
        private Node head = new Node();
        private Random random = new Random();

        public Node find(int value) {
            Node p = head;
            for (int i = levelCount - 1; i >= 0; --i) {
                while (p.forwards[i] != null && p.forwards[i].data < value) {
                    p = p.forwards[i];
                }
            }

            if (p.forwards[0] != null && p.forwards[0].data == value) {
                return p.forwards[0];
            } else {
                return null;
            }
        }

        public void insert(int value) {
            int level = randomLevel();
            Node newNode = new Node();
            newNode.data = value;
            newNode.maxLevel = level;
            Node[] update = new Node[level];
            for (int i = 0; i < level; ++i) {
                update[i] = head;
            }

            Node p = head;
            for (int i = level - 1; i >= 0; --i) {
                while (p.forwards[i] != null && p.forwards[i].data < value) {
                    p = p.forwards[i];
                }
                update[i] = p;
            }

            for (int i = 0; i < level; ++i) {
                newNode.forwards[i] = update[i].forwards[i];
                update[i].forwards[i] = newNode;
            }

            if (levelCount < level) levelCount = level;
        }

        public void delete(int value) {
            Node[] update = new Node[levelCount];
            Node p = head;
            for (int i = levelCount - 1; i >= 0; --i) {
                while (p.forwards[i] != null && p.forwards[i].data < value) {
                    p = p.forwards[i];
                }
                update[i] = p;
            }

            if (p.forwards[0] != null && p.forwards[0].data == value) {
                for (int i = levelCount - 1; i >= 0; --i) {
                    if (update[i].forwards[i] == p.forwards[0]) {
                        update[i].forwards[i] = p.forwards[i].forwards[i];
                    }
                }
                while (levelCount > 1 && head.forwards[levelCount] == null) {
                    levelCount--;
                }
            }
        }

        private int randomLevel() {
            int level = 1;
            while (Math.random() < PROMOTE_RATE && level < MAX_LEVEL)
                level++;
            return level;
        }

        public void printAll() {
            Node p = head;
            while (p.forwards[0] != null) {
                System.out.print(p.forwards[0] + " ");
                p = p.forwards[0];
            }
            System.out.println();
        }

        public class Node {
            private int data = -1;
            private Node forwards[] = new Node[MAX_LEVEL];
            private int maxLevel = 0;

            @Override
            public String toString() {
                StringBuilder builder = new StringBuilder();
                builder.append("{ data: ");
                builder.append(data);
                builder.append("; levels: ");
                builder.append(maxLevel);
                builder.append(" }");

                return builder.toString();
            }
        }
    }

}
