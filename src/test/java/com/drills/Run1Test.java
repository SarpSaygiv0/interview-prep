package com.drills;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class Run1Test {

    @Nested
    class Maps {
        @Test
        void charFrequencyWithGetOrDefault() {
            Map<Character, Integer> freq = new HashMap<>();
            String example = "banana";
            for (char c : example.toCharArray()) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
            assertThat(freq.get('a')).isEqualTo(3);
        }

        @Test
        void charFrequencyWithMerge() {
            Map<Character, Integer> freq = new HashMap<>();
            String example = "banana";
            for (char c : example.toCharArray()) {
                freq.merge(c, 1, Integer::sum);
            }
            assertThat(freq.get('a')).isEqualTo(3);
        }

        @Test
        void groupWordsByLength() {
            List<String> words = new ArrayList<>(List.of("cat", "dog", "tree", "apple", "sun", "stone"));
            Map<Integer, List<String>> groupedWords = new HashMap<>();

            for (String word : words) {
                groupedWords.computeIfAbsent(word.length(), k -> new ArrayList<>()).add(word);
            }
            assertThat(groupedWords.get(3)).isEqualTo(List.of("cat", "dog", "sun"));
        }

        @Test
        void iterateMapWithEntrySet() {
            Map<Integer, List<String>> groupedWords = Map.of(
                    3, List.of("cat", "dog", "sun"),
                    4, List.of("tree"),
                    5, List.of("apple", "stone")
            );

            int totalWords = 0;
            for (Map.Entry<Integer, List<String>> group : groupedWords.entrySet()) {
                totalWords += group.getValue().size();
            }

            assertEquals(6, totalWords);
            assertThat(groupedWords).containsEntry(4, List.of("tree"));
        }

        @Test
        void treeMapExercise() {
            TreeMap<Integer, String> treeMap = new TreeMap<>(Map.of(
                    10, "ten",
                    20, "twenty",
                    30, "thirty")
            );

            // 1. floorKey: Greatest key less than or equal to the given key
            assertEquals(20, treeMap.floorKey(25));

            // 2. ceilingKey: Least key greater than or equal to given key
            assertEquals(30, treeMap.ceilingKey(25));

            // 3. floorKey with an exact match
            assertEquals(20, treeMap.floorKey(20));

            // 4. firstEntry: returns the Map.Entry with the absolute lowest key
            assertEquals(10, treeMap.firstEntry().getKey());
        }
    }

    @Nested
    class PriorityQueues {

        @Test
        void minHeapOfInts() {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            minHeap.addAll(List.of(5, 1, 4, 2, 3));

            List<Integer> result = new ArrayList<>();
            while (!minHeap.isEmpty()) {
                result.add(minHeap.poll());
            }

            assertEquals(List.of(1, 2, 3, 4, 5), result);
        }

        @Test
        void maxHeapOfInts() {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            maxHeap.addAll(List.of(5, 1, 4, 2, 3));

            List<Integer> result = new ArrayList<>();
            while (!maxHeap.isEmpty()) {
                result.add(maxHeap.poll());
            }

            assertEquals(List.of(5, 4, 3, 2, 1), result);
        }

        @Test
        void minHeapOfIntPairsOrderedBySecondElement() {
            PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

            minHeap.add(new int[]{1, 9});
            minHeap.add(new int[]{2, 3});
            minHeap.add(new int[]{3, 6});

            List<int[]> result = new ArrayList<>();
            while (!minHeap.isEmpty()) {
                result.add(minHeap.poll());
            }

            assertArrayEquals(new int[]{2, 3}, result.get(0));
            assertArrayEquals(new int[]{3, 6}, result.get(1));
            assertArrayEquals(new int[]{1, 9}, result.get(2));
        }

        @Test
        void topKFreqElements() {
            int k = 2;
            Map<Integer, Integer> freq = new HashMap<>();
            List<Integer> numbers = new ArrayList<>(List.of(1,1,1,2,2,3));

            for (Integer num : numbers) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }

            PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(freq::get));

            for (int num: freq.keySet()) {
                minHeap.add(num);
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }

            int[] topK = new int[k];
            for (int i = 0; i < k; i++) {
                topK[i] = minHeap.poll();
            }

            // Expected: The two most frequent are 1 and 2.
            // Because it's a min-heap by frequency, '2' (freq 2) is polled before '1' (freq 3).
            assertArrayEquals(new int[]{2, 1}, topK);
        }
    }

    @Nested
    class Deques {

        @Test
        void dequeAsStack() {
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(1);
            stack.push(2);
            stack.push(3);
            assertThat(stack.pop()).isEqualTo(3);
            assertThat(stack.peek()).isEqualTo(2);
        }

        @Test
        void dequeAsQueue() {
            Deque<Integer> queue = new ArrayDeque<>();
            queue.offer(1);
            queue.offer(2);
            queue.offer(3);
            assertThat(queue.poll()).isEqualTo(1);
            assertThat(queue.peek()).isEqualTo(2);
        }

        @Test
        void dequeWithBfsSkeleton() {
            List<List<Integer>> adj = List.of(
                    List.of(1, 2),
                    List.of(3),
                    List.of(3),
                    List.of()
            );
            Queue<Integer> queue = new ArrayDeque<>();
            Set<Integer> visited = new HashSet<>();
            List<Integer> traversalOrder = new ArrayList<>();

            int startNode = 0;
            queue.offer(startNode);
            visited.add(startNode);

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                traversalOrder.add(curr);

                for (int neighbor : adj.get(curr)) {
                    if (visited.add(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
            }

            assertEquals(List.of(0, 1, 2, 3), traversalOrder);
        }
    }

    @Nested
    class SortingAndComparators {

        @Test
        void sortIntArray() {
            int[] arr = {5, 2, 8, 1};
            Arrays.sort(arr);
            assertArrayEquals(new int[]{1, 2, 5, 8}, arr);

            int[] desc = Arrays.stream(arr)
                    .boxed()
                    .sorted(Collections.reverseOrder())
                    .mapToInt(Integer::intValue)
                    .toArray();

            assertArrayEquals(new int[]{8, 5, 2, 1}, desc);
        }

        @Test
        void sort2DofIntervals() {
            int[][] intervals = new int[][] {{5,7},{1,3},{2,6}};
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            assertThat(intervals).isDeepEqualTo(new int[][]{{1,3}, {2,6}, {5,7}});
        }

        static class Person {
            String name;
            int age;

            public Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            int age() {
                return age;
            }
            String name() {
                return name;
            }
        }

        @Test
        void compareWithObjects() {
            Person person1 = new Person("Ada", 30);
            Person person2 = new Person("Bob", 25);
            Person person3 = new Person("Al", 30);

            List<Person> people = new ArrayList<>(List.of(person1, person2, person3));

            people.sort(Comparator.comparing(Person::age).thenComparing(Person::name));

            List<String> sortedNames = people.stream().map(Person::name).toList();
            assertEquals(List.of("Bob", "Ada", "Al"), sortedNames);
        }

        @Test
        void sortListByLengthDesc() {
            List<String> arr = new ArrayList<>(List.of("sun", "banana", "tree"));

            arr.sort(Comparator.comparing(String::length).reversed());

            assertEquals(List.of("banana", "tree", "sun"), arr);
        }
    }

    @Nested
    class StringsAndStringBuilder {

        @Test
        void reverseStringWithSb() {
            String ex = "interview";
            StringBuilder sb = new StringBuilder(ex);
            sb.reverse();

            assertEquals("weivretni", sb.toString());
        }

        @Test
        void charMath() {
            String s = "anagram";
            int[] freq = new int[26];
            for (char c: s.toCharArray())
                freq[c - 'a']++;

            assertEquals(3, freq['a' - 'a']);
            assertEquals(1, freq['n' - 'a']);
            assertEquals(1, freq['g' - 'a']);
        }

        @Test
        void buildStringInALoopWithSb() {
            StringBuilder sb = new StringBuilder();
            int[] nums = {1, 2, 3};
            for (int n: nums)
                sb.append(n).append(",");

            if (sb.length() > 0)
                sb.deleteCharAt(sb.length()-1);

            assertEquals("1,2,3", sb.toString());
        }

        @Test
        void stringJoinAndSplit() {
            List<String> words = List.of("apple", "banana", "cherry");
            String csv = String.join(",", words);

            assertEquals("apple,banana,cherry", csv);

            String[] splitArray = csv.split(",");
            assertArrayEquals(new String[]{"apple", "banana", "cherry"}, splitArray);
        }

        @Test
        void characterUtilMethods() {
            assertTrue(Character.isDigit('7'));
            assertTrue(Character.isLetter('s'));
            assertTrue(Character.toLowerCase('K') == 'k');
        }
    }

    @Nested
    class ArraysListsConversions {

        @Test
        void intArrayToListAndBack() {
            int[] arr = new int[]{1,2,3};
            ArrayList<Integer> list = Arrays.stream(arr)
                    .boxed()
                    .collect(Collectors.toCollection(ArrayList::new));

            assertEquals(List.of(1, 2, 3), list);

            ArrayList<Integer> newList = new ArrayList<>(List.of(4,5,6));
            int[] array = newList.stream().mapToInt(Integer::intValue).toArray();

            assertArrayEquals(new int[]{4, 5, 6}, array);
        }

        @Test
        void listOfBeingImmutable() {
            assertThrows(UnsupportedOperationException.class, () -> List.of(1,2,3).add(2));
            List<Integer> list = new ArrayList<>(List.of(1,2,3));
            list.add(4);
            assertThat(list.size()).isEqualTo(4);
        }

        @Test
        void fillArray() {
            int[] dp = new int[5];

            Arrays.fill(dp, -1);
            int[] expected = {-1, -1, -1, -1, -1};
            assertArrayEquals(expected, dp);
        }

        @Test
        void testArraysCopyOfRange() {
            int[] original = {10, 20, 30, 40, 50, 60};

            // Copies indices 1, 2, and 3 (stops before index 4)
            int[] subArray = Arrays.copyOfRange(original, 1, 4);

            int[] expected = {20, 30, 40};
            assertArrayEquals(expected, subArray);
        }
    }

    @Nested
    class Pitfalls {
        @Test
        void integerEquality() {
            Integer a = 128;
            Integer b = 128;
            assertFalse(a == b);
            assertTrue(a.equals(b));
            assertTrue(a.intValue() == b.intValue());
        }

        @Test
        void midpointOverflow() {
            int low = 1;
            int high = Integer.MAX_VALUE; // 2,147,483,647

            int buggyMid = (low + high) / 2;
            assertTrue(buggyMid < 0); // Becomes -1,073,741,824

            int safeMid = low + (high - low) / 2;
            assertEquals(1073741824, safeMid);
        }

        @Test
        void testRecordAsPair() {
            record Pair(int first, int second) {}
            Pair pair = new Pair(5, 10);
            assertEquals(5, pair.first());
            assertEquals(10, pair.second());
            assertEquals("Pair[first=5, second=10]", pair.toString());
        }
    }
}