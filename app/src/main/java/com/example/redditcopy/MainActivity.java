package com.example.redditcopy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.redditclasses.Topic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ListView topicListView;
    ArrayList<Topic> topics;
    Button btnAddTopic;
    TopicAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //populate default data
        populateDefaultTopic();

        //Get ListView ID
        topicListView = findViewById(R.id.topicListView);
        Collections.sort(topics);
        adapter = new TopicAdapter(this,topics);
        topicListView.setAdapter(adapter);
        //Set Listener for rows
        topicListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Clciked?!",Toast.LENGTH_SHORT).show();
                Topic topic = topics.get(position);

                Intent intent = new Intent(getApplicationContext(),TopicDetail.class);
                intent.putExtra("topic",topic);
                startActivity(intent);
            }
        });



    }

    private void populateDefaultTopic() {
        this.topics = new ArrayList<Topic>();
        topics.add(new Topic("How bad is corona virus?",999,2));
        topics.add(new Topic("How good is facebook to younger generation?",5,1));
        topics.add(new Topic("Is a programmer a coffee addict?",50,0));
        topics.add(new Topic("Why am I always hungry?",100,10));
    }

    class TopicAdapter extends ArrayAdapter<Topic>{
        Context context;
        ArrayList<Topic> topics;

        TopicAdapter(Context c,ArrayList<Topic> topics){
            super(c,R.layout.topicrow,R.id.topicTitle,topics);
            this.context = c;
            this.topics = topics;
        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View topicRow = inflater.inflate(R.layout.topicrow,parent,false);
            TextView title = topicRow.findViewById(R.id.topicTitle);
            TextView upVote = topicRow.findViewById(R.id.upvoteNo);
            TextView downVote = topicRow.findViewById(R.id.downvoteNo);

            final Topic topic = topics.get(position);
            title.setText(topic.title);
            upVote.setText("Upvotes: " + topic.upVotes);
            downVote.setText("Downvotes: " + topic.downVotes);

            ImageButton btnUpVote = topicRow.findViewById(R.id.btnUpVote);
            ImageButton btnDownVote = topicRow.findViewById(R.id.btnDownVote);

            btnUpVote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int newVote = topic.GetUpVotes() + 1;
                    topic.SetUpVotes(newVote);
                    Collections.sort(topics);
                    adapter.notifyDataSetChanged();
                }
            });

            btnDownVote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int newVote = topic.GetDownVotes() + 1;
                    topic.SetDownVotes(newVote);
                    Collections.sort(topics);
                    adapter.notifyDataSetChanged();
                }
            });

            return topicRow;
        }
    }
}
