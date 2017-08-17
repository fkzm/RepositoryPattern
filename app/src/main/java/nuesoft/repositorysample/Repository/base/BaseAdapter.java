package nuesoft.repositorysample.Repository.base;

import java.util.List;

/**
 * Created by mysterious on 8/15/17.
 */

// TODO: interface?

public interface BaseAdapter {

    <T> void create(T model);

    <T> List<T> get(T model);

    <T> T getOne(T model);

    <T> void update(T model);

    <T> void delete(T model);

    <T> String getUrlFromModel(T model);


}
