package com.mon.test;

import java.util.*;

public class LeaderBoard {

    Map<Integer, Integer> scoreMap;
    public LeaderBoard() {
        scoreMap = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        scoreMap.merge(playerId, score, Integer::sum);
    }

    public int top(int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a->a));
        pq.addAll(scoreMap.values());

        System.out.println(pq);
        return pq.stream().limit(K).mapToInt(a->a).sum();
    }

    public void reset(int playerId) {
        if(scoreMap.get(playerId) != null) scoreMap.put(playerId, 0);
    }

    public static void main(String[] args) {
        LeaderBoard leaderBoard = new LeaderBoard();
        leaderBoard.addScore(1,82);
        leaderBoard.addScore(2,84);
        leaderBoard.addScore(3,47);
        leaderBoard.addScore(4,86);
        leaderBoard.addScore(5,92);
        leaderBoard.addScore(6,74);
        leaderBoard.addScore(7,34);
        leaderBoard.addScore(8,67);
        leaderBoard.addScore(9,76);
        leaderBoard.addScore(10,73);
        System.out.println(leaderBoard.top(4));
        System.out.println(leaderBoard.top(4));
        System.out.println(leaderBoard.top(8));
        leaderBoard.reset(1);
        leaderBoard.reset(2);
    }
}
