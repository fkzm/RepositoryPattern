package nuesoft.repositorysample.Repository.base;

import java.util.List;

/**
 * Created by mysterious on 8/15/17.
 */

public abstract class BaseAdapter<T> {

    public abstract void create(T model);

    public abstract void update(T model);

    public abstract List<T> getAll();

    public abstract void remove(T model);


}
