package pbru.example.lab324_18.itpbru;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;

public class CalendarActivity extends AppCompatActivity {
    //Explicit
    private CalendarView calendarView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
            //
        calendarView = (CalendarView) findViewById(R.id.calendarView);
            //Active when click calendar
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                confirmDialog(day, month, year);
            }
        });
    }   //Main Method

    public void clickShowGraph(View view) {
        Intent intent = new Intent(CalendarActivity.this, GraphActivity.class);
        intent.putExtra("Login", getIntent().getStringArrayExtra("Login"));
        startActivity(intent);
    }

    private void confirmDialog(int day, int month, int year) {

        final String strDate = Integer.toString(day) +
                "/" + Integer.toString(month + 1) +
                "/" + Integer.toString(year);


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.kon48);
        builder.setTitle(strDate);
        builder.setMessage("OK?");
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("Revenue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(CalendarActivity.this, UploadAccount.class);
                intent.putExtra("Login", getIntent().getStringArrayExtra("Login"));
                intent.putExtra("InOut", 0);
                intent.putExtra("Date", strDate);
                startActivity(intent);

                dialog.dismiss();
            }
        });
        builder.setNeutralButton("Payment", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(CalendarActivity.this, UploadAccount.class);
                intent.putExtra("Login", getIntent().getStringArrayExtra("Login"));
                intent.putExtra("InOut", 1);
                intent.putExtra("Date", strDate);
                startActivity(intent);
                dialog.dismiss();
            }
        });
        builder.show();

    }   // confirmDialog


}   //Main Class
