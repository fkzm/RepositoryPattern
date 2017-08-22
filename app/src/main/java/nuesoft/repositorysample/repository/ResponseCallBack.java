package nuesoft.repositorysample.repository;

/**
 * Created by mysterious on 8/15/17.
 */

public interface ResponseCallBack<T> {

    void onResponse(ResponseResult<T> responseResult);

    void onFailure(Throwable t);

}