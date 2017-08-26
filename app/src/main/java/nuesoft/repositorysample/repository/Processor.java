package nuesoft.repositorysample.repository;

import org.jdeferred.Deferred;

import nuesoft.repositorysample.webService.Response;

/**
 * Created by mysterious on 8/26/17.
 */


public interface Processor {
    public void processor(Deferred deferred, Response response);
}