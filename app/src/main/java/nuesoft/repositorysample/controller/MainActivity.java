package nuesoft.repositorysample.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import io.realm.Realm;
import nuesoft.repositorysample.R;
import nuesoft.repositorysample.Repository.user.UserAdapter;
import nuesoft.repositorysample.model.user.User;

public class MainActivity extends AppCompatActivity implements UserAdapter.UserCallBack {
    //    ResponseCallBack<User>
    User _user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(this);


        _user = new User("Ehsan", 24, this);
        _user.create();
        _user.getAll();
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
//            if (user.getUserStore().getCurrentUserAdapter() instanceof UserRestAdapter && userAdapter instanceof UserSqlAdapter) {
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

    @Override
    public void createUserResult(boolean result) {
        System.out.println("result" + result);

    }

    @Override
    public void getAllUserResult(List<User> userList) {

        System.out.println("result" + userList.size());
    }

    @Override
    public void deleteUser(boolean result) {

    }


//    @Override
//    public void onResponse(List<User> response) {
//        response.get(0).getUserStore();
//    }
//
//    @Override
//    public void onFailure(Throwable t) {
//
//    }
}