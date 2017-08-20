package nuesoft.repositorysample.Repository.base;

import java.util.List;

import nuesoft.repositorysample.Repository.ResponseCallBack;
import nuesoft.repositorysample.model.base.BaseModel;

/**
 * Created by mysterious on 8/15/17.
 */


public interface BaseAdapter {

    <T extends BaseModel> void save(T model, ResponseCallBack responseCallBack);

    <T> List<T> getAll(ResponseCallBack responseCallBack);

    <T> T getOne(int id, ResponseCallBack responseCallBack);

    <T> T update(T model, ResponseCallBack responseCallBack);

    <T> T delete(T model, ResponseCallBack responseCallBack);

    <T> String getUrlFromModel(T model);
}
