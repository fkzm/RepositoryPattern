package nuesoft.repositorysample;

import android.support.test.runner.AndroidJUnit4;

import org.jdeferred.Deferred;
import org.jdeferred.DoneCallback;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

import nuesoft.repositorysample.exception.AlreadyAuthenticatedError;
import nuesoft.repositorysample.repository.RestAdapter;
import nuesoft.repositorysample.store.Authenticator;
import nuesoft.repositorysample.webService.Response;

/**
 * Created by mysterious on 8/27/17.
 */

@RunWith(AndroidJUnit4.class)
public class AuthenticationTest {

    RestAdapter restAdapter;
    String token;
    boolean authenticated;

    @Test
    public void Authentication() {

        final CountDownLatch signal = new CountDownLatch(2);

        restAdapter = new RestAdapter("https://nc.carrene.com/apiv1/", "token", Authenticator.getAuthenticator());
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("email", "hamed@carrene.com");
        hashMap.put("password", "123456");

        Deferred deferred = null;
        try {
            deferred = restAdapter.login(hashMap);
        } catch (AlreadyAuthenticatedError alreadyAuthenticatedError) {
            alreadyAuthenticatedError.printStackTrace();
        }

        deferred.then(new DoneCallback<Response>() {
            @Override
            public void onDone(Response result) {
                token = result.getField("token");
                authenticated = restAdapter.getAuthenticator().isAuthenticated();
                Assert.assertNotNull(token);
                Assert.assertTrue(authenticated);
                signal.countDown();
            }
        });

        try {
            signal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void logout() {
        restAdapter.logout();
        Assert.assertFalse(restAdapter.getAuthenticator().isAuthenticated());
    }

}
