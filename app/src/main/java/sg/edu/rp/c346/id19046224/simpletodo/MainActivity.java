package sg.edu.rp.c346.id19046224.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText tdEditText;
    Button btnAdd, btnClear;
    ListView lvStuff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<String> todoList = new ArrayList<>();

        tdEditText = findViewById(R.id.editText);
        btnAdd = findViewById(R.id.button);
        btnClear = findViewById(R.id.button2);
        lvStuff = findViewById(R.id.tdlistview);

        final ArrayAdapter tdList = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,todoList);

        lvStuff.setAdapter(tdList);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTask = tdEditText.getText().toString();
                todoList.add(newTask);
                tdList.notifyDataSetChanged();
                tdEditText.setText(""); //clears the editText field once user submits
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                todoList.clear();
                tdEditText.setText("");
                tdList.notifyDataSetChanged();
            }
        });

    }
}
