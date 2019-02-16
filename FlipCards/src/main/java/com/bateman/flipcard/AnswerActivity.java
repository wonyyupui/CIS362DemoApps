package com.bateman.flipcard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class AnswerActivity  extends Activity {

    protected void onCreate (Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_answer);

        Button questionBtn = findViewById(R.id.button);
        questionBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent showQuestion = new Intent(AnswerActivity.this, QuestionActivity.class);
                startActivity(showQuestion);
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        overridePendingTransition(R.anim.answer_out, R.anim.question_in);
    }

}
