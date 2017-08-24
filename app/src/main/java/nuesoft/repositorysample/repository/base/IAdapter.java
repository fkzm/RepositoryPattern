package nuesoft.repositorysample.repository.base;

import nuesoft.repositorysample.model.base.BaseModel;
import nuesoft.repositorysample.repository.ResponseCallBack;

/**
 * Created by mysterious on 8/15/17.
 */


public abstract class IAdapter implements BaseCRUDProvider {


    // static method
    public <T extends BaseModel> void getAll(ResponseCallBack responseCallBack) {

    }

    // static method
    public <T extends BaseModel> void getOne(int id, ResponseCallBack responseCallBack) {

    }


}
