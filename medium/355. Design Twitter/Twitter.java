package Java.leetcodeSolution.medium;

import java.util.*;

//https://leetcode.com/problems/design-twitter/
class Twitter {
    private static int timeCount;
    private Map<Integer, User> users;

    private class Tweet {
        private int time;
        private int id;
        public Tweet next;

        public Tweet(int id) {
            this.time = ++timeCount;
            this.id = id;
            this.next = null;
        }
    }

    private class User {
        private int id;
        public Set<Integer> followed;
        public Tweet head;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id);
            this.head = null;
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unfollow(int id) {
            followed.remove(id);
        }

        public void postTweet(int id) {
            Tweet tweet = new Tweet(id);
            tweet.next = head;
            head = tweet;
        }
    }

    public Twitter() {
        users = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) {
            User user = new User(userId);
            users.put(userId, user);
        }
        users.get(userId).postTweet(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new LinkedList<>();
        if (!users.containsKey(userId)) return ans;
        Set<Integer> follows = users.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>(follows.size(), (a, b) -> (b.time - a.time));
        for (int user : follows) {
            Tweet tweet = users.get(user).head;
            if (tweet != null) {
                pq.add(tweet);
            }
        }
        int n = 0;
        while (!pq.isEmpty() && n < 10) {
            Tweet tweet = pq.poll();
            ans.add(tweet.id);
            n++;
            if (tweet.next != null)
                pq.add(tweet.next);
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            User user = new User(followerId);
            users.put(followerId, user);
        }
        if (!users.containsKey(followeeId)) {
            User user = new User(followeeId);
            users.put(followeeId, user);
        }
        users.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!users.containsKey(followerId) || followerId == followeeId) return;
        users.get(followerId).unfollow(followeeId);
    }
}