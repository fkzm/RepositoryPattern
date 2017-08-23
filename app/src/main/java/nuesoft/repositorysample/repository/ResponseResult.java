package nuesoft.repositorysample.repository;

import java.util.List;

/**
 * Created by mysterious on 8/20/17.
 */

public class ResponseResult<T> {

    private int status;
    private String description;
    private List<T> responseList;
    private String responseBody;

    public ResponseResult() {

    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public ResponseResult(int status, String description) {
        this.status = status;
        this.description = description;
    }

    public ResponseResult(int status, List<T> responseList) {
        this.status = status;
        this.responseList = responseList;
    }

    public ResponseResult(int status, String description, List<T> responseList) {
        this.status = status;
        this.description = description;
        this.responseList = responseList;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setResponseList(List<T> responseList) {
        this.responseList = responseList;
    }

    public int getStatus() {
        return status;
    }

    public List<T> getResponseList() {
        return responseList;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
