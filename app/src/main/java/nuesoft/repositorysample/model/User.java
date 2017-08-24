package nuesoft.repositorysample.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import nuesoft.repositorysample.model.base.BaseModel;
import nuesoft.repositorysample.model.base.Metadata;
import nuesoft.repositorysample.model.base.MyField;
import nuesoft.repositorysample.repository.ResponseCallBack;
import nuesoft.repositorysample.repository.base.IAdapter;
import nuesoft.repositorysample.store.Store;

/**
 * Created by mysterious on 8/14/17.
 */

public class User extends BaseModel {

    private String email;
    private String password;




    @Override
    public String getTableName() {
        return "USER";
    }

    @Override
    public Metadata getMetadata() {

        Metadata metadata;

        List<MyField> myFieldList = new ArrayList<>();

        for (Field field : this.getClass().getDeclaredFields()) {
            String filedName = field.getName();
            myFieldList.add(new MyField(filedName));
        }
        metadata = new Metadata("USER", myFieldList);
        return metadata;
    }

    public void save(ResponseCallBack responseCallBack) {
        this.getAdapter().save(this, responseCallBack);
    }


    public User(String email, String password) {
        super(Store.getInstance().getCurrentAdapter(), "test");
        this.email = email;
        this.password = password;
    }

    public User(IAdapter iAdapter, String email, String password) {
        super(iAdapter,"test");
        this.email = email;
        this.password = password;
    }

    public void login(String email, String password, ResponseCallBack responseCallBack) {
        Session session = new Session(email, password);
        this.getAdapter().save(session, responseCallBack);
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

}