package nuesoft.repositorysample.model.base;

import java.util.List;

/**
 * Created by mysterious on 8/20/17.
 */

public class Metadata {

    private String name;

    private List<MyField> myFields;

    public Metadata(String name, List<MyField> myFields) {
        this.name = name;
        this.myFields = myFields;
    }

    public String getName() {
        return name;
    }

    public List<MyField> getMyFields() {
        return myFields;
    }
}
