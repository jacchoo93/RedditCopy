package com.example.redditcopy;
import com.example.redditcopy.R;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TopicAdd extends AppCompatActivity {

    Button submitButton;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_add);

        submitButton = findViewById(R.id.btnSubmitTopic);
        editText = findViewById(R.id.editTextTopicAdd);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().length() > 255){
                    Toast.makeText(getApplicationContext(),"Title must not be more than 255 chars",Toast.LENGTH_LONG).show();
                }else{
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    intent.putExtra("topicTitle",editText.getText().toString());
                    startActivity(intent);
                }
            }
        });

    }
}
