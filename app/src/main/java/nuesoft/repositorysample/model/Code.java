package nuesoft.repositorysample.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import nuesoft.repositorysample.model.base.BaseModel;
import nuesoft.repositorysample.model.base.Metadata;
import nuesoft.repositorysample.repository.ResponseCallBack;
import nuesoft.repositorysample.repository.RestAdapter;
import nuesoft.repositorysample.store.Store;

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


    public Code() {
        super(Store.getInstance().getCurrentAdapter());
    }

    public static void getAll(ResponseCallBack responseCallBack) {

        Store.getInstance().getCurrentAdapter().getAll(responseCallBack);
    }

    @Override
    public String getUrl() {
        return "apiv1/codes?code=%~8064";
    }

    @Override
    public String getTableName() {
        return null;
    }

    @Override
    public Metadata getMetadata() {

        return null;
    }
}
