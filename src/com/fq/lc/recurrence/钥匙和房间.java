package com.fq.lc.recurrence;

import java.util.List;

/**
 * @author lgq
 * @date 2020/8/31
 */
public class 钥匙和房间 {

    private boolean[] visited;

    private int count = 0;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        dfs(rooms, 0);
        return count == rooms.size();
    }

    private void dfs(List<List<Integer>> rooms, int index) {
        visited[index] = true;
        count++;
        for (int i = 0; i < rooms.get(index).size(); i++) {
            if (!visited[rooms.get(index).get(i)]) {
                dfs(rooms, rooms.get(index).get(i));
            }
        }
    }


}
