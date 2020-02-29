package olgor.fivesteps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button firstStep;
    Button secondStep;
    Button thirdStep;
    Button fourthStep;
    Button fifthStep;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstStep = (Button) findViewById(R.id.firstStep);
        secondStep = (Button) findViewById(R.id.secondStep);
        thirdStep = (Button) findViewById(R.id.thirdStep);
        fourthStep = (Button) findViewById(R.id.fourthStep);
        fifthStep = (Button) findViewById(R.id.fifthStep);

        firstStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FirstStep.class);
                startActivity(intent);
            }
        });

        secondStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondStep.class);
                startActivity(intent);
            }
        });

        thirdStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThirdStep.class);
                startActivity(intent);
            }
        });

        fourthStep.setTextColor(Color.parseColor("#aaaaaa"));
        fourthStep.setClickable(false);

        fifthStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FifthStep.class);
                startActivity(intent);
            }
        });
    }
}
