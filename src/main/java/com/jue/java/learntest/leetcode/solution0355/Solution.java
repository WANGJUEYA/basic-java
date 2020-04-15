package com.jue.java.learntest.leetcode.solution0355;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
class Twitter {
    class News {
        int userId;
        int tweetId;

        public int getUserId() {
            return userId;
        }

        public int getTweetId() {
            return tweetId;
        }

        @Override
        public String toString() {
            return "News{" +
                    "userId=" + userId +
                    ", tweetId=" + tweetId +
                    '}';
        }
    }

    private List<News> allNews;
    private Map<Integer, Set<Integer>> follow;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        allNews = new ArrayList<>();
        follow = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        News news = new News();
        news.userId = userId;
        news.tweetId = tweetId;
        allNews.add(0, news);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> users = follow.containsKey(userId) ? follow.get(userId) : new HashSet<>();
        users.add(userId);

        System.out.println(users);
        System.out.println(allNews);

        return allNews.stream().filter(news -> users.contains(news.userId)).limit(10).map(News::getTweetId).collect(Collectors.toList());
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (follow.containsKey(followerId)) {
            follow.get(followerId).add(followeeId);
        } else {
            Set<Integer> list = new HashSet<>();
            list.add(followeeId);
            follow.put(followerId, list);
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (follow.containsKey(followerId)) {
            follow.get(followerId).remove(followeeId);
        }
    }
}