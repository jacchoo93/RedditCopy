package com.example.redditcopy;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.redditclasses.Topic;

public class TopicDetail extends AppCompatActivity {

    Topic topic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_detail);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        TextView title = findViewById(R.id.topicDetailTitle);
        TextView upVote = findViewById(R.id.topicDetailUpVote);
        TextView downVote = findViewById(R.id.topicDetailDownVote);

        Intent intent = getIntent();
        topic = (Topic)intent.getSerializableExtra("topic");

        title.setText(topic.title);
        upVote.setText("Upvotes: " + topic.upVotes);
        downVote.setText("Downvotes: " + topic.downVotes);

        actionBar.setTitle(topic.title);
    }
}
