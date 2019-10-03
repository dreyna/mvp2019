package com.example.mvpsqlite.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mvpsqlite.Presenter.IPresenter;
import com.example.mvpsqlite.Presenter.Presenter;
import com.example.mvpsqlite.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IView{
    private IPresenter iPresenter;
    private ListView mListview1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVista();

        iPresenter = new Presenter(this);
        iPresenter.listarAlumnos();
    }
    private void initVista(){
        mListview1 = (ListView) findViewById(R.id.listview1);
    }
    @Override
    public void listarAlumnos(List<String> datos) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datos);
        mListview1.setAdapter(arrayAdapter);
    }
}
