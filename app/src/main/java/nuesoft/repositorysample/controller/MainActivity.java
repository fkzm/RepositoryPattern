package nuesoft.repositorysample.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.jdeferred.DoneCallback;

import nuesoft.repositorysample.R;
import nuesoft.repositorysample.exception.ModelStateError;
import nuesoft.repositorysample.model.Code;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

//        user.login("hamed@carrene.com", "123456", new ResponseCallBack() {
//            @Override
//            public void onResponse(Response response) {
//
//                String token = (String) response.getField("token");
//                Authenticator.setJwtToken(token);

//                Code.getAll(new ResponseCallBack() {
//                    @Override
//                    public void onResponse(Response response) {
//                        List<Code> codeList = response.getList();
//                        Log.d("", "");
//                        String code = codeList.get(5).getCode();
//                    }
//
//                    @Override
//                    public void onFailure(Throwable t) {
//
//                    }
//                });
//
//                Code.getOne(1, new ResponseCallBack() {
//                    @Override
//                    public void onResponse(Response response) {
//                        Code code = response.getObject();
//                        Log.d("", "");
//                    }
//
//                    @Override
//                    public void onFailure(Throwable t) {
//
//                    }
//                });
//            }

//            @Override
//            public void onFailure(Throwable t) {
//
//            }
//        });
//
//        Code.getOne(1, new ResponseCallBack() {
//            @Override
//            public void onResponse(Response response) {
//                Code code = response.getObject();
//                Log.d("", "");
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//
//            }
//        });


//        Code code = new Code();
//        code.save(new ResponseCallBack() {
//            @Override
//            public void onResponse(Response response) {
//
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//
//            }
//        });


//        final RestAdapter restAdapter = new RestAdapter("https://nc.carrene.com/apiv1/", "token", Authenticator.getAuthenticator());
//        HashMap<String, Object> hashMap = new HashMap<>();
//        hashMap.put("email", "hamed@carrene.com");
//        hashMap.put("password", "123456");
//
//        Deferred deferred = null;
//        try {
//            deferred = restAdapter.login(hashMap);
//        } catch (AlreadyAuthenticatedError alreadyAuthenticatedError) {
//            alreadyAuthenticatedError.printStackTrace();
//        }
//
//        deferred.then(new DoneCallback<Response>() {
//            @Override
//            public void onDone(Response result) {
//                Log.d("", "");
//
//            }
//        });
//
//    }

        Code code = new Code();

        try {
            code.save().then(new DoneCallback() {
                @Override
                public void onDone(Object result) {
                    Log.d("", "");
                }
            });
        } catch (ModelStateError modelStateError) {
            modelStateError.printStackTrace();
        }
    }
}