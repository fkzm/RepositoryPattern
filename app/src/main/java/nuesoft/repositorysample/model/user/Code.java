package nuesoft.repositorysample.model.user;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import nuesoft.repositorysample.model.base.BaseModel;
import nuesoft.repositorysample.model.base.Metadata;
import nuesoft.repositorysample.model.base.MyField;

/**
 * Created by mysterious on 8/22/17.
 */

public class Code extends BaseModel {
    @Override
    public String getUrl() {
        return "apiv1/collections";
    }

    @Override
    public String getTableName() {
        return null;
    }

    @Override
    public Metadata getMetadata() {

        Metadata metadata;

        List<MyField> myFieldList = new ArrayList<>();

        for (Field field : this.getClass().getDeclaredFields()) {
            String filedName = field.getName();
            myFieldList.add(new MyField(filedName));
        }
        metadata = new Metadata("USER", myFieldList);
        return metadata;
    }
}
