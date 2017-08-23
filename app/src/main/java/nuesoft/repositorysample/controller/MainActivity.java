package nuesoft.repositorysample.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import nuesoft.repositorysample.R;
import nuesoft.repositorysample.model.Code;
import nuesoft.repositorysample.repository.ResponseCallBack;
import nuesoft.repositorysample.model.User;
import nuesoft.repositorysample.store.JWTTokenHelper;
import nuesoft.repositorysample.webService.Response;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        User user = new User("hamed@carrene.com", "123456");

        user.login("hamed@carrene.com", "123456", new ResponseCallBack() {
            @Override
            public void onResponse(Response response) {

                String token = (String) response.getField("token");
                JWTTokenHelper.setJwtToken(token);

                Code.getAll(new ResponseCallBack() {
                    @Override
                    public void onResponse(Response response) {
                        List<Code> codeList = response.getList();
                        Log.d("", "");
                        String code = codeList.get(5).getCode();
                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

//        user.save(new ResponseCallBack() {
//            @Override
//            public void onResponse(ResponseResult responseResult) {
//
//                Log.d("", "");
//
//                Gson gson = new Gson();
//                Token token = gson.fromJson(responseResult.getResponseBody(), Token.class);
//                Log.d("token", token.getToken());
//
//                Code.getAll(new ResponseCallBack() {
//                    @Override
//                    public void onResponse(ResponseResult responseResult) {
//                        Log.d("", "");
//                    }
//
//                    @Override
//                    public void onFailure(Throwable t) {
//
//                    }
//                });
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//
//            }
//        });


    }
}