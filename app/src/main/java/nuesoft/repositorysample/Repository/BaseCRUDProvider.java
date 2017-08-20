package nuesoft.repositorysample.Repository;

import java.util.List;

import nuesoft.repositorysample.model.base.BaseModel;

/**
 * Created by mysterious on 8/20/17.
 */

public interface BaseCRUDProvider {

    <T extends BaseModel> void save(T model, ResponseCallBack responseCallBack);

    <T extends BaseModel> List<T> getAll(ResponseCallBack responseCallBack);

    <T> T getOne(int id, ResponseCallBack responseCallBack);

    <T> T update(T model, ResponseCallBack responseCallBack);

    <T> T delete(T model, ResponseCallBack responseCallBack);

    <T> String getUrlFromModel(T model);

}
