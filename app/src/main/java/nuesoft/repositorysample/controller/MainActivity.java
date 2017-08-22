package nuesoft.repositorysample.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.realm.Realm;
import nuesoft.repositorysample.R;
import nuesoft.repositorysample.repository.ResponseCallBack;
import nuesoft.repositorysample.repository.ResponseResult;
import nuesoft.repositorysample.model.user.User;
import nuesoft.repositorysample.store.Store;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        User user = new User("hamed@carrene.com", "123456");

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