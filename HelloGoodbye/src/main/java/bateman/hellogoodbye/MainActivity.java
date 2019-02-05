package bateman.hellogoodbye;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView greetingTextView;
    private boolean isHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button exclaimBtn = findViewById(R.id.button);
        greetingTextView =  findViewById(R.id.textView);

        initializeGreeting();

        exclaimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isHello) {
                    isHello = false;
                    greetingTextView.setText(R.string.goodbye);
                } else {
                    isHello = true;
                    greetingTextView.setText(R.string.hello);
                }

            }
        });

    }

    private void initializeGreeting() {
    }
}
