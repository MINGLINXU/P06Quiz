package sg.edu.rp.soi.p06_quiz;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {




    TextView tvOperation;
    TextView tvResult;
    EditText num1;
    EditText num2;
    Button btnreset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOperation = findViewById(R.id.tvOperation);
        tvResult = findViewById(R.id.result);
        num1 = findViewById(R.id.etNum1);
        num2 = findViewById(R.id.etNum2);
        btnreset = findViewById(R.id.btnReset);


        registerForContextMenu(tvOperation);

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1.setText("");
                num2.setText("");
                tvResult.setText("");
            }
        });
    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"+");
        menu.add(0,1,1,"-");
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {

        String value1 = num1.getText().toString();
        int number1 = Integer.parseInt(value1);
        String value2 = num2.getText().toString();
        int number2 = Integer.parseInt(value2);
        if(item.getItemId()==0) { //check whether the selected menu item ID is 0
            //code for action
            int total = number1+ number2;
            tvResult.setText(String.valueOf(total));


            return true; //menu item successfully handled
        }
        else if(item.getItemId()==1) { //check if the selected menu item ID is 1
            //code for action
            int total = number1- number2;
            tvResult.setText(String.valueOf(total));
            return true;  //menu item successfully handled
        }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }




}
