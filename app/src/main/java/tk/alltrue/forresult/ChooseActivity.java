package tk.alltrue.forresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class ChooseActivity extends AppCompatActivity {

    public final static String THIEF = "tk.alltrue.sherlock.THIEF";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice_layout);
    }

    public void onRadioClick(View view) {

        Intent answerIntent = new Intent();
        switch (view.getId()) {
            case R.id.radioDog:
                answerIntent.putExtra(THIEF, "Pesik");
                break;
            case R.id.radioCrow:
                answerIntent.putExtra(THIEF, "Raven");
                break;
            case R.id.radioCat:
                answerIntent.putExtra(THIEF, "Kot");
                break;
            default:
                break;
        }

        setResult(RESULT_OK, answerIntent);
        finish();
    }


}
