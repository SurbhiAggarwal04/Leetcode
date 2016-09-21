package LeetCode;

import java.util.*;
class Tweet
{
    int userId;
    int tweetId;
    public Tweet(int userId,int tweetId)
    {
        this.userId=userId;
        this.tweetId=tweetId;
    }
}
public class Twitter {

    /** Initialize your data structure here. */
    Hashtable<Integer,ArrayList<Integer>> followList;
    LinkedList<Tweet> post;
    
    public Twitter() {
        followList=new Hashtable<>();
        post=new LinkedList<Tweet>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        post.addFirst(new Tweet(userId,tweetId));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
      
        List<Integer> newsFeed=new ArrayList<Integer>();
       LinkedList<Tweet> tempQueue=new LinkedList<Tweet>();
        while(!post.isEmpty() && newsFeed.size()<10)
        {
            Tweet tweet=post.removeFirst();
            tempQueue.addLast(tweet);
            if(tweet.userId==userId)
            {
                newsFeed.add(tweet.tweetId);
            }
            else
            {
                if(followList.containsKey(userId))
                {
                    ArrayList<Integer> list=followList.get(userId);
                    if(list.contains(tweet.userId))
                    newsFeed.add(tweet.tweetId);
                }
            }
        }
        tempQueue.addAll(post);
        post=tempQueue;
        return newsFeed;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followList.containsKey(followerId))
        {
            ArrayList<Integer> list=followList.get(followerId);
            if(!list.contains(followeeId))list.add(followeeId);
            followList.put(followerId,list);
        }
        else
        {
         ArrayList<Integer> list=new ArrayList<Integer>();
         list.add(followeeId);
         followList.put(followerId,list);
        }
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followList.containsKey(followerId))
        {
            ArrayList<Integer> list=followList.get(followerId);
            if(list.contains(followeeId))
            {
                list.remove((Integer)followeeId);
                followList.put(followerId,list);
            }
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
