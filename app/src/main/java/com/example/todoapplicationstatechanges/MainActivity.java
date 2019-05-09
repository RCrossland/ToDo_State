 package com.example.todoapplicationstatechanges;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;

 public class MainActivity extends AppCompatActivity {
    // Placeholder to hold a list of string todos
    private String[] mToDos;
    // Placeholder to hold the index of the to do list items
    private int mToDoIndex = 0;
    // Placeholder for an index to be used when saving the instance state
     private final String TODO_INDEX = "todo_index";


     // onSaveInstanceState is called between onPause and onStop. When the activity has be destroyed
    @Override
    public void onSaveInstanceState(Bundle onSaveInstanceState){
        super.onSaveInstanceState(onSaveInstanceState);
        onSaveInstanceState.putInt(TODO_INDEX, mToDoIndex);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Check whether the state of the application has been saved
        if(savedInstanceState != null){
            mToDoIndex = savedInstanceState.getInt(TODO_INDEX, 0);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to the resources
        Resources res = getResources();
        mToDos = res.getStringArray(R.array.todo_items);

        // Initialise the TextView
        final TextView mTextView = (TextView) findViewById(R.id.todo_title);

        // Display the first item from the string array
        mTextView.setText(mToDos[mToDoIndex]);

        // Get a reference to the Next button
        final Button mNextBtn = (Button) findViewById(R.id.todo_btn_next);
        // Add an onClick event handler to the button
        mNextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(mToDoIndex < mToDos.length - 1){
                    mToDoIndex += 1;
                    mTextView.setText(mToDos[mToDoIndex]);
                }
            }
        });

        // Get a reference to the Previous button
        final Button mPrevBtn = (Button) findViewById(R.id.todo_btn_prev);
        // Add an onClick event handler to the button
        mPrevBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(mToDoIndex > 0){
                    mToDoIndex -= 1;
                    mTextView.setText(mToDos[mToDoIndex]);
                }
            }
        });
    }
}
