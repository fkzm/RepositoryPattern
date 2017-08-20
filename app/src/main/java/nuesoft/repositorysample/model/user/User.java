package nuesoft.repositorysample.model.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import nuesoft.repositorysample.Repository.ResponseCallBack;
import nuesoft.repositorysample.Repository.base.BaseAdapter;
import nuesoft.repositorysample.model.base.BaseModel;
import nuesoft.repositorysample.model.base.Field;
import nuesoft.repositorysample.model.base.Metadata;

/**
 * Created by mysterious on 8/14/17.
 */

public class User extends BaseModel {

    private String name;


    public User(BaseAdapter baseAdapter) {
        super(baseAdapter);
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void save(ResponseCallBack responseCallBack) {
        this.getAdapter().save(this, responseCallBack);
    }

    public void delete(ResponseCallBack responseCallBack) {
        this.getAdapter().delete(this, responseCallBack);
    }

    public void update(ResponseCallBack responseCallBack) {
        this.getAdapter().update(this, responseCallBack);
    }

    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public Metadata getMetadata() {
        String name = "User";
        List<Field> fields = new ArrayList<>();
        fields.add(new Field("name"));
        return new Metadata(name, fields);
    }

    @Override
    public void sync(Map<String, BaseAdapter> userAdapterMap) {
    }

    @Override
    public void migrate(BaseAdapter destinationAdapter) {

    }
}