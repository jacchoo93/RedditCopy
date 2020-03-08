package com.example.redditclasses;

import java.io.Serializable;

public class Topic implements  Serializable,Comparable<Topic> {
    public String title;
    public int upVotes;
    public int downVotes;

    public Topic(String title,int upVotes,int downVotes){
        this.title = title;
        this.upVotes = upVotes;
        this.downVotes = downVotes;
    }

    public void SetTitle(String title){
        this.title = title;
    }

    public String GetTitle(){
        return this.title;
    }

    public void SetUpVotes(int upVotes){
        this.upVotes = upVotes;
    }
    public int GetUpVotes(){
        return this.upVotes;
    }
    public void SetDownVotes(int downVotes){
        this.downVotes = downVotes;
    }
    public int GetDownVotes(){
        return this.downVotes;
    }

    @Override
    public String toString(){
        return "Title:" + title + ", Upvotes = " + upVotes + ", Downvotes = " + downVotes;
    }

    @Override
    public int compareTo(Topic o) {
        return o.upVotes - this.upVotes;
    }
}
