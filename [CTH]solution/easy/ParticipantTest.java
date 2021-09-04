package me.asher.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 문제 설명
 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 *
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * completion의 길이는 participant의 길이보다 1 작습니다.
 * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 * 참가자 중에는 동명이인이 있을 수 있습니다.
 */
class ParticipantTest {
    private static final int ONE = 1;
    private static final int MINUS_ONE = -1;

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String key : participant) {
            map.merge(key, ONE, Integer::sum);
        }
        for (String key : completion) {
            map.merge(key, MINUS_ONE, Integer::sum);
        }

        for (String key: map.keySet()) {
            if (map.get(key) != 0) {
                return key;
            }
        }
        throw new IllegalArgumentException("wrong input");
    }

    @Test
    void testSolution() {
        Assertions.assertEquals(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}), "leo");
        Assertions.assertEquals(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}), "vinko");
        Assertions.assertEquals(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}), "mislav");
    }
}
