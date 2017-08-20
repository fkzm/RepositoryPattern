package nuesoft.repositorysample.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.realm.Realm;
import nuesoft.repositorysample.R;
import nuesoft.repositorysample.Repository.ResponseResult;
import nuesoft.repositorysample.Repository.ResponseCallBack;
import nuesoft.repositorysample.model.user.User;

public class MainActivity extends AppCompatActivity {

    User _user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Realm.init(this);

        User user = new User("Ehsan", 10);

        user.create(new ResponseCallBack<User>() {

            @Override
            public void onResponse(ResponseResult<User> responseResult) {


                System.out.println(responseResult.getStatus());
                System.out.println(responseResult.getResponseList().size());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

//        User.getAll();
//        arrayOfUser = User.getAll()

//
//        _user = new User("Ehsan", 24, this);
//        _user.save(new new UserAdapter.UserCallBack() {
//            @Override
//            public void createUserResult(boolean result) {
//
//            }
//
//            @Override
//            public void getAllUserResult(List<User> userList) {
//
//            }
//
//            @Override
//            public void deleteUser(boolean result) {
//
//            }
//        });
//        _user.delete()

//        _user.create();

//        Realm realm = Realm.getDefaultInstance();
//
//        realm.beginTransaction();
//
//        User user = realm.createObject(User.class, 2);
//        user.setName("Ali");
//        realm.commitTransaction();
//
//        final RealmResults<User> users = realm.where(User.class).findAll();
//        Log.d("users", "" + users.size());
//
//
//        Appointment appointment = realm.createObject(Appointment.class, 2);
//        appointment.setName("Ehsan");
//        realm.commitTransaction();
//
//        final RealmResults<Appointment> dogs = realm.where(Appointment.class).findAll();
//
//        Log.d("real", "" + dogs.size());
//         User user = realm.createObject(User.class);
        //user.setName("Ehsan");
        //user.setAge(10);
        //realm.commitTransaction();
        //final RealmResults<User> dogs = realm.where(User.class).findAll();
        //dogs.size();
//
//        //user.setName("Ehsan1");
//
//        user.sync(user.getUserStore().getAdapters());
//
//        System.out.println(user.getName());
//
//        user.setAge(25);
//
//        for (Map.Entry<String, UserAdapter> userAdapter : user.getUserStore().getAdapters().entrySet()) {
//
//            if (user.getUserStore().getCurrentAdapter() instanceof RestAdapter && userAdapter instanceof SqlAdapter) {
//
//                HashMap<String, UserAdapter> userAdapterHashMap = new HashMap<>();
//                userAdapterHashMap.put(userAdapter.getKey(), userAdapter.getValue());
//                user.sync(userAdapterHashMap);
//                break;
//            }
//        }
//
//        try {
//            user.delete();
//        } catch (NoRestStore noRestStore) {
//
//        } catch (StoreException e) {
//
//            e.printStackTrace();
//        }
    }

//
//
//    @Override
//    public void onResponse(List<User> response) {
//        response.getAll(0).getUserStore();
//    }
//
//    @Override
//    public void onFailure(Throwable t) {
//
//    }
}