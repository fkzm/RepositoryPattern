package nuesoft.repositorysample.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.realm.Realm;
import nuesoft.repositorysample.R;
import nuesoft.repositorysample.Repository.ResponseCallBack;
import nuesoft.repositorysample.Repository.ResponseResult;
import nuesoft.repositorysample.model.user.User;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Realm.init(this);

        User.getAll(new ResponseCallBack() {
            @Override
            public void onResponse(ResponseResult responseResult) {

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        User user = new User("Ehsan");

        user.save(new ResponseCallBack() {
            @Override
            public void onResponse(ResponseResult responseResult) {

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }
}