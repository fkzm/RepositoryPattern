package nuesoft.repositorysample.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import nuesoft.repositorysample.exception.ModelStateError;
import nuesoft.repositorysample.model.base.BaseModel;
import nuesoft.repositorysample.model.base.Metadata;
import nuesoft.repositorysample.model.base.MyField;
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

    public void save() throws ModelStateError {
        this.getAdapter().save(this);
    }


    public User(String email, String password) {
        super(Store.getInstance().getCurrentAdapter());
        this.email = email;
        this.password = password;
    }

    public User(IAdapter iAdapter, String email, String password) {
        super(iAdapter);
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

}