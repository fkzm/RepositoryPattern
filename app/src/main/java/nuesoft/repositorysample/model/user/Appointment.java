package nuesoft.repositorysample.model.user;

import java.util.Map;

import io.realm.annotations.PrimaryKey;
import nuesoft.repositorysample.Repository.base.BaseAdapter;
import nuesoft.repositorysample.model.base.BaseModel;

/**
 * Created by mysterious on 8/16/17.
 */

public class Appointment extends BaseModel {

    @PrimaryKey
    private int _id;

    private String _name;

    public int getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public void setId(int id) {
        this._id = id;
    }

    public void setName(String name) {
        this._name = name;
    }


    @Override
    public void sync(Map<String, BaseAdapter> userAdapterMap) {

    }

    @Override
    public void migrate(BaseAdapter destinationAdapter) {

    }
}
