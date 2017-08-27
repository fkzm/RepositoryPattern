package nuesoft.repositorysample.model;

import com.google.gson.annotations.SerializedName;

import org.jdeferred.Deferred;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import nuesoft.repositorysample.exception.ModelStateError;
import nuesoft.repositorysample.model.base.BaseModel;
import nuesoft.repositorysample.model.base.Metadata;
import nuesoft.repositorysample.model.base.MyField;
import nuesoft.repositorysample.store.Store;
import nuesoft.repositorysample.webService.MyRequest;

/**
 * Created by mysterious on 8/22/17.
 */

public class Code extends BaseModel {


    boolean billable;
    @SerializedName("code")
    String code;
    @SerializedName("id")
    int id;
    String type;
    int specialityId;
    int sectionId;
    String description;
    String builtin;

    static {
        BaseModel.url = "apiv1/codes";
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getSpecialityId() {
        return specialityId;
    }

    public int getSectionId() {
        return sectionId;
    }

    public String getDescription() {
        return description;
    }

    public boolean isBillable() {
        return billable;
    }

    public void setBillable(boolean billable) {
        this.billable = billable;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public Code(boolean billable, String code) {
        this.billable = billable;
        this.code = code;
    }


    public <T extends BaseModel> Deferred save() throws ModelStateError {
        return super.save(this);
    }

    public Code() {
        super(Store.getInstance().getCurrentAdapter());
        super.status = "new";
    }

    public static void getAll() {

        Store.getInstance().getCurrentAdapter().getAll();
    }

    public static void getOne(int id) {

        Store.getInstance().getCurrentAdapter().getOne(id);
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
        metadata = new Metadata("CODE", myFieldList);
        return metadata;
    }
}
