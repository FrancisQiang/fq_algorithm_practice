package com.fq.lc.bfs;

import javafx.util.Pair;

import java.util.*;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * @author muXue
 * @date 2020/7/20 11:30
 */
public class 单词接龙 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //  获取单词长度
        int length = beginWord.length();
        // 生成联合字典
        Map<String, List<String>> combinationMap = new HashMap<>(wordList.size());
        wordList.forEach(word -> {
            for (int i = 0; i < length; i++) {
                // 生成带 * 的单词
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, length);
                List<String> list = combinationMap.getOrDefault(newWord, new ArrayList<>());
                list.add(word);
                combinationMap.put(newWord, list);
            }
        });
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));

        Map<String, Boolean> visitedMap = new HashMap<>(wordList.size());
        visitedMap.put(beginWord, true);

        while(!queue.isEmpty()) {
            Pair<String, Integer> poll = queue.poll();
            String key = poll.getKey();
            Integer level = poll.getValue();
            for (int i = 0; i < key.length(); i++) {
                String newWord =  key.substring(0, i) + "*" + key.substring(i + 1, length);
                for (String exactWord: combinationMap.getOrDefault(newWord, new ArrayList<>())) {
                    if (exactWord.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visitedMap.containsKey(exactWord)) {
                        visitedMap.put(exactWord, true);
                        queue.offer(new Pair<>(exactWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }

}
