package me.asher.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Document {
    private final int priority;
    private final boolean isMine;

    public Document(int priority, boolean isMine) {
        this.priority = priority;
        this.isMine = isMine;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isMine() {
        return isMine;
    }
}

class PrinterTest {

    public int solution(int[] priorities, int location) {
        Queue<Document> queue = IntStream.range(0, priorities.length)
                .mapToObj(i -> new Document(priorities[i], i == location))
                .collect(Collectors.toCollection(LinkedList::new));

        int outCount = 0;

        while (!queue.isEmpty()) {
            Document document = queue.poll();

            if (queue.stream().anyMatch(d -> d.getPriority() > document.getPriority())) {
                queue.offer(document);
            } else {
                outCount++;
                if (document.isMine()) {
                    break;
                }
            }
        }

        return outCount;
    }

    @Test
    void testSolution() {
        Assertions.assertEquals(1, solution(new int[]{2, 1, 3, 2}, 2));
        Assertions.assertEquals(5, solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }
}
