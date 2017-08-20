package nuesoft.repositorysample.Repository;

import java.util.List;

import nuesoft.repositorysample.Repository.base.BaseAdapter;

/**
 * Created by mysterious on 8/14/17.
 */

public class SqlAdapter implements BaseAdapter {

    @Override
    public <T> void create(T model, ResponseCallBack responseCallBack) {

    }

    @Override
    public <T> List<T> getAll(T model) {
        return null;
    }

    @Override
    public <T> T getOne(T model) {
        return null;
    }

    @Override
    public <T> T update(T model) {
        return null;
    }

    @Override
    public <T> T delete(T model) {
        return null;
    }

    @Override
    public <T> String getUrlFromModel(T model) {
        return null;
    }


//    public SqlAdapter(UserCallBack userCallBack) {
//        super(userCallBack);
//    }
//

}
