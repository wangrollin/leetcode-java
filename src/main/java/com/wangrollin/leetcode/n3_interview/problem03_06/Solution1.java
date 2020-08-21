package com.wangrollin.leetcode.n3_interview.problem03_06;

/**
 * 动物收容所
 *
 * 动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。
 * 在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，
 * 或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。
 * 换言之，收养人不能自由挑选想收养的对象。
 * 请创建适用于这个系统的数据结构，实现各种操作方法，比如enqueue、dequeueAny、dequeueDog和dequeueCat。
 * 允许使用Java内置的LinkedList数据结构。
 *
 * enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
 * dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
 *
 * 示例1:
 *  输入：
 * ["AnimalShelf", "enqueue", "enqueue", "dequeueCat", "dequeueDog", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [], [], []]
 *  输出：
 * [null,null,null,[0,0],[-1,-1],[1,0]]
 *
 * 示例2:
 *  输入：
 * ["AnimalShelf", "enqueue", "enqueue", "enqueue", "dequeueDog", "dequeueCat", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
 *  输出：
 * [null,null,null,null,[2,1],[0,0],[1,0]]
 *
 * 说明:
 * 收纳所的最大容量为20000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/animal-shelter-lcci
 *
 * Solution1
 * 保存两个node，链接head是老的，链接尾部是新的
 */
public class Solution1 {

    /**
     * Your AnimalShelf object will be instantiated and called as such:
     * AnimalShelf obj = new AnimalShelf();
     * obj.enqueue(animal);
     * int[] param_2 = obj.dequeueAny();
     * int[] param_3 = obj.dequeueDog();
     * int[] param_4 = obj.dequeueCat();
     */
    private static class AnimalShelf {

        private AnimalNode oldAnimalHead = null;
        private AnimalNode newAnimalNode = null;
        private int len = 0;

        public AnimalShelf() {

        }

        public void enqueue(int[] animal) {

            if (oldAnimalHead == null) {
                oldAnimalHead = new AnimalNode(animal);
                newAnimalNode = oldAnimalHead;
            } else {
                newAnimalNode.next = new AnimalNode(animal);
                newAnimalNode = newAnimalNode.next;
            }
            len++;
        }

        public int[] dequeueAny() {

            if (len == 0) {
                return new int[]{-1, -1};
            } else if (len == 1) {
                len--;
                int[] result = oldAnimalHead.animal;
                oldAnimalHead = null;
                newAnimalNode = null;
                return result;
            } else {
                len--;
                int[] result = oldAnimalHead.animal;
                oldAnimalHead = oldAnimalHead.next;
                return result;
            }
        }

        public int[] dequeueDog() {

            return dequeueByType(1);
        }

        public int[] dequeueCat() {

            return dequeueByType(0);
        }

        private int[] dequeueByType(int type) {

            if (len == 0) {

                return new int[]{-1, -1};

            } else if (len == 1) {

                if (oldAnimalHead.animal[1] == type) {
                    len--;
                    int[] result = oldAnimalHead.animal;
                    oldAnimalHead = null;
                    newAnimalNode = null;
                    return result;
                } else {
                    return new int[]{-1, -1};
                }

            } else if (oldAnimalHead.animal[1] == type) {

                len--;
                int[] result = oldAnimalHead.animal;
                oldAnimalHead = oldAnimalHead.next;
                return result;

            } else {

                AnimalNode curNode = oldAnimalHead;
                while (curNode.next != null && curNode.next.animal[1] != type) {
                    curNode = curNode.next;
                }
                if (curNode.next == null) {
                    return new int[]{-1, -1};
                } else {
                    len--;
                    if (newAnimalNode == curNode.next) {
                        newAnimalNode = curNode;
                    }
                    int[] result = curNode.next.animal;
                    curNode.next = curNode.next.next;
                    return result;
                }
            }
        }

        private static class AnimalNode {
            int[] animal;
            AnimalNode next;

            public AnimalNode(int[] animal) {
                this.animal = animal;
            }
        }
    }

    public static void main(String[] args) {

        /**
         * 测试用例
         */
        String[] instructs = new String[]{"AnimalShelf", "dequeueDog", "dequeueCat", "dequeueAny", "dequeueAny", "dequeueCat", "dequeueAny", "enqueue", "dequeueAny", "dequeueDog", "dequeueDog", "enqueue", "dequeueCat", "dequeueCat", "dequeueCat", "dequeueAny", "enqueue", "dequeueCat", "dequeueDog", "dequeueCat", "enqueue", "enqueue", "dequeueDog", "dequeueCat", "enqueue", "dequeueAny", "enqueue", "enqueue", "enqueue", "dequeueDog", "enqueue", "dequeueAny", "dequeueCat", "dequeueAny", "dequeueAny", "dequeueAny", "dequeueCat", "dequeueDog", "enqueue", "dequeueCat", "enqueue", "enqueue", "enqueue", "enqueue", "dequeueCat", "enqueue", "dequeueDog", "dequeueCat", "dequeueAny", "dequeueAny", "dequeueAny", "dequeueCat", "enqueue", "dequeueCat", "dequeueCat", "dequeueDog", "dequeueCat", "dequeueDog", "dequeueCat", "dequeueCat", "dequeueAny", "dequeueCat"};
        int[][] input = new int[][]{{}, {}, {}, {}, {}, {}, {}, {0, 1}, {}, {}, {}, {1, 1}, {}, {}, {}, {}, {2, 0}, {}, {}, {}, {3, 0}, {4, 1}, {}, {}, {5, 0}, {}, {6, 0}, {7, 0}, {8, 1}, {}, {9, 0}, {}, {}, {}, {}, {}, {}, {}, {10, 0}, {}, {11, 0}, {12, 1}, {13, 0}, {14, 1}, {}, {15, 0}, {}, {}, {}, {}, {}, {}, {16, 1}, {}, {}, {}, {}, {}, {}, {}, {}, {}};
        AnimalShelf animalShelf = new AnimalShelf();

        for (int i = 1; i < instructs.length; i++) {

            System.out.println("this is No." + i);
            switch (instructs[i]) {
                case "dequeueDog":
                    System.out.println("dequeueDog");
                    animalShelf.dequeueDog();
                    System.out.println(animalShelf.len);
                    break;
                case "dequeueCat":
                    System.out.println("dequeueCat");
                    animalShelf.dequeueCat();
                    System.out.println(animalShelf.len);
                    break;
                case "dequeueAny":
                    System.out.println("dequeueAny");
                    animalShelf.dequeueAny();
                    System.out.println(animalShelf.len);
                    break;
                case "enqueue":
                    System.out.println("enqueue");
                    animalShelf.enqueue(input[i]);
                    System.out.println(animalShelf.len);
                    break;
            }
            System.out.println();
        }
    }
}
