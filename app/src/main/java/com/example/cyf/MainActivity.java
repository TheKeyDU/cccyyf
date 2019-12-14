package com.example.cyf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button button = null;
    private RecyclerView recylerView = null;
    private SelectAdapter selectAdapter = null;
    private List<SelectBean> list = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        InitView();
    }

    private void InitRecylerView() {
        recylerView = findViewById(R.id.rec);
        list = new ArrayList();
        for (int i = 0; i < 9; i++) {
            list.add(new SelectBean("测试", "测试", "测试", false));
        }

        selectAdapter = new SelectAdapter(list);
        recylerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));
        selectAdapter.setMyOnClickListener(new SelectAdapter.MyOnClickListener() {
            @Override
            public void OnClickIng(View view, int pos) {
                Toast.makeText(MainActivity.this,pos+"---"+view.getId(),Toast.LENGTH_LONG).show();
                switch (view.getId())
                {
                    case R.id.cb_item_likes:{
                        selectAdapter.arrayList.get(pos).isSelect=!selectAdapter.arrayList.get(pos).isSelect;
                        selectAdapter.notifyDataSetChanged();
                    }
                }

            }
        });
        recylerView.addItemDecoration(new LinearDecoration(15,15,20,20));
        recylerView.setAdapter(selectAdapter);
    }

    private void InitView() {
        button = findViewById(R.id.btn_open_dialog);
        InitRecylerView();

    }

    public void OpenDialog(View view) {
    UserDetailsDialogFragment userDetailsDialogFragment=new UserDetailsDialogFragment();
    userDetailsDialogFragment.show(getSupportFragmentManager(),"陈一凡萨比");
    }
}
