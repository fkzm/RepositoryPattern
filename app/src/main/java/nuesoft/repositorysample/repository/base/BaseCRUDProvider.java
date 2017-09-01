package nuesoft.repositorysample.repository.base;

import org.jdeferred.Deferred;

import nuesoft.repositorysample.exception.ModelStateError;
import nuesoft.repositorysample.model.base.BaseModel;
import nuesoft.repositorysample.webService.MyRequest;

/**
 * Created by mysterious on 8/20/17.
 */

public interface BaseCRUDProvider {

    <T extends BaseModel> Deferred save(T model) throws ModelStateError;

    <T extends BaseModel> Deferred delete(T model) throws ModelStateError;

    <T extends BaseModel> Deferred reload(T model) throws ModelStateError;


    // public static <T extends BaseModel> void getOne(int id, ResponseCallBack responseCallBack)


}
