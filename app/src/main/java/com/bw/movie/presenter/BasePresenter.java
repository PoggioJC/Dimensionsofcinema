package com.bw.movie.presenter;

public class BasePresenter<V> {
    private V view;

    public V getView() {
        return view;
    }

    public void setView(V view) {
        this.view = view;
    }
    //解绑
    public void detachView(){
        this.view = null;
    }
}
