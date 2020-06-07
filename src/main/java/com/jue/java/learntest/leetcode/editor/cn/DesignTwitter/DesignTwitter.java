//设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个
//功能： 
//
// 
// postTweet(userId, tweetId): 创建一条新的推文 
// getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
// 
// follow(followerId, followeeId): 关注一个用户 
// unfollow(followerId, followeeId): 取消关注一个用户 
// 
//
// 示例: 
//
// 
//Twitter twitter = new Twitter();
//
//// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
//twitter.postTweet(1, 5);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//twitter.getNewsFeed(1);
//
//// 用户1关注了用户2.
//twitter.follow(1, 2);
//
//// 用户2发送了一个新推文 (推文id = 6).
//twitter.postTweet(2, 6);
//
//// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
//// 推文id6应当在推文id5之前，因为它是在5之后发送的.
//twitter.getNewsFeed(1);
//
//// 用户1取消关注了用户2.
//twitter.unfollow(1, 2);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//// 因为用户1已经不再关注用户2.
//twitter.getNewsFeed(1);
// 
// Related Topics 堆 设计 哈希表


package com.jue.java.learntest.leetcode.editor.cn.DesignTwitter;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author JUE
 * @number 355
 */
public class DesignTwitter {
    public static void main(String[] args) {
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
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
        Twitter.News news = new Twitter.News();
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

        return allNews.stream().filter(news -> users.contains(news.userId)).limit(10).map(Twitter.News::getTweetId).collect(Collectors.toList());
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

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
//leetcode submit region end(Prohibit modification and deletion)
