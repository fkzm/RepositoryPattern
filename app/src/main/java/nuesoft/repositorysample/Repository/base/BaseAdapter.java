package nuesoft.repositorysample.Repository.base;

import java.util.List;

import nuesoft.repositorysample.Repository.ResponseCallBack;

/**
 * Created by mysterious on 8/15/17.
 */


public interface BaseAdapter {

    <T> void create(T model, ResponseCallBack responseCallBack);

    <T> List<T> getAll(T model);

    <T> T getOne(T model);

    <T> T update(T model);

    <T> T delete(T model);

    <T> String getUrlFromModel(T model);
}
