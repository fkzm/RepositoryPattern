package nuesoft.repositorysample.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import nuesoft.repositorysample.model.base.BaseModel;
import nuesoft.repositorysample.model.base.Metadata;
import nuesoft.repositorysample.model.base.MyField;

/**
 * Created by mysterious on 8/23/17.
 */

public class Session extends BaseModel {


    private String email;
    private String password;

    public Session(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUrl() {
        return "apiv1/sessions";
    }

    @Override
    public String getTableName() {
        return null;
    }

    @Override
    public Metadata getMetadata() {
        Metadata metadata;

        List<MyField> myFieldList = new ArrayList<>();

        for (Field field : this.getClass().getDeclaredFields()) {
            String filedName = field.getName();
            myFieldList.add(new MyField(filedName));
        }
        metadata = new Metadata("SESSION", myFieldList);
        return metadata;
    }
}
