package nuesoft.repositorysample.model.user;

import org.junit.Test;

import nuesoft.repositorysample.model.User;
import nuesoft.repositorysample.repository.ResponseCallBack;
import nuesoft.repositorysample.repository.ResponseResult;
import nuesoft.repositorysample.store.Store;

/**
 * Created by mysterious on 8/22/17.
 */
public class UserTest {

    @Test
    public void saveUser() {

//        User user = new User("hamed@carrene.com", "123456");
//
//        user.save(new ResponseCallBack() {
//            @Override
//            public void onResponse(ResponseResult responseResult) {
//
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//
//            }
//        });

    }


    public void saveUserWithAdapter() {

//        User user = new User(Store.getInstance().getAdapter("rest"), "Ehsan", "1458");
//
//        user.save(new ResponseCallBack() {
//            @Override
//            public void onResponse(ResponseResult responseResult) {
//
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//
//            }
//        });
    }

}