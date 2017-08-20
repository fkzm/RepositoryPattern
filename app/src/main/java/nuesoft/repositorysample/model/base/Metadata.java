package nuesoft.repositorysample.model.base;

import java.util.List;

/**
 * Created by mysterious on 8/20/17.
 */

public class Metadata {

    private String name;

    private List<Field> fields;

    public Metadata(String name, List<Field> fields) {
        this.name = name;
        this.fields = fields;
    }

    public String getName() {
        return name;
    }

    public List<Field> getFields() {
        return fields;
    }
}
