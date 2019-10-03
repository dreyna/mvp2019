package com.example.mvpsqlite.Presenter;

import com.example.mvpsqlite.Model.IModel;
import com.example.mvpsqlite.Model.Model;
import com.example.mvpsqlite.View.IView;

import java.util.List;

public class Presenter implements IPresenter{
    private IView iView;
    private IModel iModel;
    public Presenter(IView iView) {
        this.iView = iView;
        iModel = new Model(iView);
    }
    @Override
    public void listarAlumnos() {
        List<String> list = iModel.getListFromDatabase();
        iView.listarAlumnos(list);
    }
}
