package nuesoft.repositorysample;

import java.util.List;

/**
 * Created by mysterious on 8/15/17.
 */

public interface ResponseCallBack<T> {

    void onResponse(List<T> response);

    void onFailure(Throwable t);

}