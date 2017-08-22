package nuesoft.repositorysample.repository.base;

import java.util.List;

import nuesoft.repositorysample.model.base.BaseModel;
import nuesoft.repositorysample.repository.ResponseCallBack;

/**
 * Created by mysterious on 8/20/17.
 */

public interface BaseCRUDProvider {

    <T extends BaseModel> void save(T model, ResponseCallBack responseCallBack);

    // public static <T extends BaseModel> void getOne(int id, ResponseCallBack responseCallBack)


}
