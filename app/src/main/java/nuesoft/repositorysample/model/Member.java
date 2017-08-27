package nuesoft.repositorysample.model;

/**
 * Created by mysterious on 8/27/17.
 */

public class Member {


    private String name;
    private int id;

    public Member(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
