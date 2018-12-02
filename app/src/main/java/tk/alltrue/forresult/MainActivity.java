package tk.alltrue.forresult;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final private int CHOOSE_THIEF = 0;
    public static final String ACTION_SECOND_ACTIVITY = "tk.alltrue.ChooseActivity";

    public void onClick(View view) {
//        Intent questionIntent = new Intent(MainActivity.this,
//                ChooseActivity.class);
//        startActivityForResult(questionIntent, CHOOSE_THIEF);
        startActivityForResult(new Intent(ACTION_SECOND_ACTIVITY), CHOOSE_THIEF);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView infoTextView = (TextView) findViewById(R.id.textViewInfo);

        if (requestCode == CHOOSE_THIEF) {
            if (resultCode == RESULT_OK) {
                String thiefName = data.getStringExtra(ChooseActivity.THIEF);
                infoTextView.setText(thiefName);
            } else {
                infoTextView.setText("");
            }
        }
    }

    public void onClickFeed(View view) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.AppCompatAlertDialogStyle);
//        builder.setTitle("Dialog");
//        builder.setMessage("Покормить кота?");
//        builder.setPositiveButton("OK", null);
//        builder.setNegativeButton("Cancel", null);
//        builder.show();
//        LayoutInflater inflater = getLayoutInflater();
//        View layout = inflater.inflate(R.layout.custom_layout,
//                (ViewGroup) findViewById(R.id.toast_layout));
//
//        Toast toast = new Toast(getApplicationContext());
//        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
//        toast.setDuration(Toast.LENGTH_LONG);
//        toast.setText(R.string.catfood);
////      toast.setView(layout);
        Toast toast = Toast.makeText(getApplicationContext(),
                R.string.catfood, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        LinearLayout toastContainer = (LinearLayout) toast.getView();
        ImageView catImageView = new ImageView(getApplicationContext());
        catImageView.setImageResource(R.drawable.cate1);
        toastContainer.addView(catImageView, 0);
//        LinearLayout toastContainer = (LinearLayout) toast.getView();
//        toastContainer.setBackgroundColor(Color.TRANSPARENT);
        toast.show();

    }
}
