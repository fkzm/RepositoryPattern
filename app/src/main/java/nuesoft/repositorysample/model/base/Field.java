package nuesoft.repositorysample.model.base;

/**
 * Created by mysterious on 8/20/17.
 */

public class Field {

    private String name;
    private String title;

    public Field(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
