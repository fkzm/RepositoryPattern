package nuesoft.repositorysample.repository.base;

import nuesoft.repositorysample.model.base.BaseModel;

/**
 * Created by mysterious on 8/15/17.
 */


public abstract class IAdapter implements BaseCRUDProvider {


    // static method
    public <T extends BaseModel> void getAll() {

    }

    // static method
    public <T extends BaseModel> void getOne(int id) {

    }


}
