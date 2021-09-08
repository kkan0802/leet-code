package me.asher.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

class Truck {
    int weight;
    int elapsedTimeInBridge = 0;

    public Truck(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getElapsedTimeInBridge() {
        return elapsedTimeInBridge;
    }

    public void elapsedTime() {
        this.elapsedTimeInBridge++;
    }
}

class TruckTest {

    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Truck> queue = Arrays.stream(truckWeights)
                .mapToObj(Truck::new)
                .collect(Collectors.toCollection(LinkedList::new));
        Queue<Truck> bridge = new LinkedList<>();

        int elapsedTime = 0;

        while (!queue.isEmpty() || !bridge.isEmpty()) {

            elapsedTime++;
            bridge.forEach(Truck::elapsedTime);

            if (!bridge.isEmpty()) {
                Truck truck = bridge.peek();
                if (truck.getElapsedTimeInBridge() >= bridgeLength) {
                    bridge.poll();
                }
            }

            if (!queue.isEmpty()) {
                Truck truck = queue.peek();
                if (isBridgeAvailable(bridgeLength, weight, bridge, truck)) {
                    bridge.add(queue.poll());
                }
            }
        }

        return elapsedTime;
    }

    private boolean isBridgeAvailable(int bridgeLength, int weight, Queue<Truck> bridge, Truck truck) {
        return bridge.size() < bridgeLength && truck.getWeight() + bridge.stream().mapToInt(Truck::getWeight).sum() <= weight;
    }

    @Test
    void testSolution() {
        Assertions.assertEquals(8, solution(2, 10, new int[]{7, 4, 5, 6}));
        Assertions.assertEquals(101, solution(100, 100, new int[]{10}));
        Assertions.assertEquals(110, solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }

}
