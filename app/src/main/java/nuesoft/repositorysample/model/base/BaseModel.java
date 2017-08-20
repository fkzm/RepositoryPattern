package nuesoft.repositorysample.model.base;

import java.util.Map;

import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import nuesoft.repositorysample.Repository.base.BaseAdapter;

/**
 * Created by mysterious on 8/15/17.
 */

public abstract class BaseModel implements RealmModel {

    @PrimaryKey
    int id;

    public abstract void sync(Map<String, BaseAdapter> userAdapterMap);

    public abstract void migrate(BaseAdapter destinationAdapter);


}
