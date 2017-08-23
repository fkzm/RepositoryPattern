package nuesoft.repositorysample.repository;

import nuesoft.repositorysample.webService.Response;

/**
 * Created by mysterious on 8/15/17.
 */

public interface ResponseCallBack {

    void onResponse(Response response);

    void onFailure(Throwable t);

}