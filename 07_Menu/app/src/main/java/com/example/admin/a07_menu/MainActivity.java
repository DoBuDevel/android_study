package com.example.admin.a07_menu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Context 메뉴 등록
        tv = (TextView)findViewById(R.id.TextView);
        registerForContextMenu(tv); // 위젯에 ContextMenu를 등록함

        // 버튼을 context 메뉴에 등록
        btn = (Button) findViewById(R.id.button2);
        registerForContextMenu(btn);
    }

    // 옵션 메뉴를 추가한다. (보통 xml 로 작성한다.)
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);  // res 폴더의 menu_main.xml
        return true;
    }
    // 옵션 메뉴 선택시
    public boolean onOptionsItemSelected(MenuItem item) {

        tv.setText(item.getTitle());

        return super.onOptionsItemSelected(item);
    }

    // context menu
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        Log.d("test", "onCreateContextMenu");
        if(v == tv){
            menu.setHeaderTitle("title");
            menu.add(0,1,100,"one");
            menu.add(0,2,100,"two");
            menu.add(0,3,100,"three");
        }
        if(v == btn){
            menu.setHeaderTitle("button");
            menu.add(0,1,100,"btn_one");
            menu.add(0,2,100,"btn_two");
            menu.add(0,3,100,"btn_three");
        }

    }

    // context menu 선택시
    public boolean onContextItemSelected(MenuItem item) {

        // 선택된 아이디값
        switch (item.getItemId()){
            case 1: tv.setTextColor(Color.RED);
                break;
            case 2: tv.setTextColor(Color.BLUE);
                break;
            case 3: tv.setTextColor(Color.GREEN);
                break;
        }

        Toast.makeText(MainActivity.this, item.getTitle(),Toast.LENGTH_SHORT).show();

        return super.onContextItemSelected(item);
    }
}
