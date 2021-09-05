package me.asher.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

class Play implements Comparable<Play> {
    private final int index;
    private final int count;

    public Play(int index, int count) {
        this.index = index;
        this.count = count;
    }

    public static Play of(int index, int count) {
        return new Play(index, count);
    }

    public int getCount() {
        return count;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(Play o) {
        if (this.count > o.count) {
            return 1;
        } else if (this.count < o.count) {
            return -1;
        } else {
            return Integer.compare(o.index, this.index);
        }
    }
}

class BestAlbumTest {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, PriorityQueue<Play>> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            Play play = Play.of(i, plays[i]);

            if (!map.containsKey(genre)) {
                PriorityQueue<Play> pq = new PriorityQueue<>(Comparator.reverseOrder());
                pq.add(play);
                map.put(genre, pq);
            } else {
                PriorityQueue<Play> pq = map.get(genre);
                pq.add(play);
            }
        }

        List<Map.Entry<String, PriorityQueue<Play>>> sortedMap = map.entrySet().stream().sorted((o1, o2) -> {
            Integer selfPlayCountSum = o1.getValue().stream().map(Play::getCount).reduce(0, Integer::sum);
            Integer otherPlayCountSum = o2.getValue().stream().map(Play::getCount).reduce(0, Integer::sum);
            return selfPlayCountSum.compareTo(otherPlayCountSum) * -1;
        }).collect(Collectors.toList());

        List<Integer> answer = new ArrayList<>();

        for (Map.Entry<String, PriorityQueue<Play>> _map : sortedMap) {
            PriorityQueue<Play> pq = _map.getValue();
            for (int i = 0; i < 2; i++) {
                if (!pq.isEmpty()) {
                    Play play = pq.poll();
                    answer.add(play.getIndex());
                }
            }
        }

        return answer.parallelStream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    void testPlay() {
        Play p1 = Play.of(2, 150);
        Play p2 = Play.of(0, 500);
        System.out.println(p1.compareTo(p2) < 0);
    }

    @Test
    void testSolution() {
        int[] res = solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
        Assertions.assertArrayEquals(new int[]{4, 1, 3, 0}, res);
    }
}
