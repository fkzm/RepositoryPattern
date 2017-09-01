package nuesoft.repositorysample.repository;

import org.jdeferred.Deferred;
import org.jdeferred.DoneCallback;
import org.jdeferred.FailCallback;

import java.util.Map;

import nuesoft.repositorysample.exception.AlreadyAuthenticatedError;
import nuesoft.repositorysample.exception.AuthenticationRequiredError;
import nuesoft.repositorysample.exception.ModelStateError;
import nuesoft.repositorysample.model.base.BaseModel;
import nuesoft.repositorysample.repository.base.IAdapter;
import nuesoft.repositorysample.store.Authenticator;
import nuesoft.repositorysample.webService.MyRequest;
import nuesoft.repositorysample.webService.Response;

/**
 * Created by mysterious on 8/14/17.
 */

public class RestAdapter extends IAdapter {

    private String baseUrl;
    private String tokenLocalStorageKey;
    public static Authenticator authenticator;

    /*
   * +----------------+----------------+--------+--------+---------+
   * | state / ACTION | CHANGE         | SAVE   | RELOAD | DELETE  |
   * +----------------+----------------+--------+--------+---------+
   * | new            | new            | loaded | error  | error   |
   * +----------------+----------------+--------+--------+---------+
   * | loaded         | dirty          | error  | loaded | deleted |
   * +----------------+----------------+--------+--------+---------+
   * | dirty          | dirty / loaded | loaded | loaded | deleted |
   * +----------------+----------------+--------+--------+---------+
   * | deleted        | error          | error  | error  | error   |
   * +----------------+----------------+--------+--------+---------+
   */

    public RestAdapter(String baseUrl, String tokenLocalStorageKey, Authenticator authenticator1) {
        this.baseUrl = baseUrl;
        this.tokenLocalStorageKey = tokenLocalStorageKey;
        authenticator = authenticator1;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public Authenticator getAuthenticator() {
        if (authenticator == null) {
            authenticator = new Authenticator();
        }
        return authenticator;
    }

    public Deferred login(Map<String, Object> credentials) throws AlreadyAuthenticatedError {

        if (authenticator.isAuthenticated()) {
            throw new AlreadyAuthenticatedError();
        }

        final Deferred deferred = this.request("sessions", "POST").addParameters(credentials).send();
        deferred.then(new DoneCallback<Response>() {
            @Override
            public void onDone(Response response) {
                getAuthenticator().setToken(response.getField("token"));
                deferred.resolve(response);
            }
        }).fail(new FailCallback<Response>() {
            @Override
            public void onFail(Response result) {
                deferred.reject(result);
            }
        });

        return deferred;
    }

    public void logout() {
        authenticator.deleteJwtToken();
    }

    public MyRequest request(String resources, String verb) {
        try {
            return new MyRequest(this, resources, verb).addAuthenticationHeaders(false);
        } catch (AuthenticationRequiredError authenticationRequiredError) {
            authenticationRequiredError.printStackTrace();
        }

        return null;
    }


    @Override
    public <T extends BaseModel> Deferred save(final T model) throws ModelStateError {

        String verb = "";
        String resourceUrl = "";

        switch (model.getStatus()) {

            case "loaded": {
                throw new ModelStateError("Object is not changed.");
            }

            case "deleted": {
                throw new ModelStateError("Object is deleted.");
            }

            case "new": {
                verb = "POST";
                resourceUrl = T.url;
                break;
            }

            default: {
                verb = "PUT";
                resourceUrl = model.getResourcePath();
                break;
            }
        }

        Deferred deferred = this.request(resourceUrl, verb).addParameters(model.toHashMap()).ifMatch(model.geteTag()).send();
        return deferred;
    }

    @Override
    public <T extends BaseModel> Deferred delete(T model) throws ModelStateError {

        switch (model.getStatus()) {
            case "new": {
                throw new ModelStateError("Cannot delete unsaved objects.");
            }

            case "deleted": {
                throw new ModelStateError("Object is already deleted.");
            }
        }

        return this.request(model.getResourcePath(), "DELETE").ifMatch(model.geteTag()).send();

    }

    @Override
    public <T extends BaseModel> Deferred reload(T model) throws ModelStateError {
        
        switch (model.getStatus()) {
            case "new": {
                throw new ModelStateError("Save object before reload.");
            }

            case "deleted": {
                throw new ModelStateError("Object is deleted");
            }
        }

        return this.request(model.getResourcePath(), "GET").ifNoneMatch(model.geteTag()).send();
    }

    public <T extends BaseModel> void updateFromResponse(T model, Response response) {

        model.updateProperties(response.getMap());
    }

    @Override
    public <T extends BaseModel> void getOne(int id) {
//        r.setPostProcessor(new ResponseCallBack()).send()
    }

    @Override
    public <T extends BaseModel> Deferred getAll() {
        String verb = "GET";
        String resourceUrl = T.url;

        try {
            final Deferred deferred = this.request(resourceUrl, verb).addAuthenticationHeaders(true).send();
            return deferred;
        } catch (AuthenticationRequiredError authenticationRequiredError) {
            authenticationRequiredError.printStackTrace();
        }

        return null;

    }
}





