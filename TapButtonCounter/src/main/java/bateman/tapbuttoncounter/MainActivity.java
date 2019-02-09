package bateman.tapbuttoncounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //MODEL
    private Counter count;
    private Button btn;
    
    //VIEW
    private TextView display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count = new Counter();
        display = findViewById(R.id.tv_1);

    }

    public void onClick(View view) {

        count.addCount();
        display.setText(count.getCount().toString());


    }


}
