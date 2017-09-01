package nuesoft.repositorysample.models;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.jdeferred.DoneCallback;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import nuesoft.repositorysample.MockUpRestAdapter;
import nuesoft.repositorysample.exception.ModelStateError;
import nuesoft.repositorysample.model.Code;
import nuesoft.repositorysample.webService.Response;

/**
 * Created by mysterious on 8/22/17.
 */

@RunWith(AndroidJUnit4.class)

public class CodeTest {

    private MockUpRestAdapter mockUpRestAdapter;


    @Before
    public void createMockUpRestAdapter(){
        mockUpRestAdapter = new MockUpRestAdapter();
    }

    @Test
    public void CRUD() {

        Code code = new Code();

        try {

            code.save().then(new DoneCallback<Response>() {
                @Override
                public void onDone(Response result) {
                    int status = result.getStatus();

                }

            });
        } catch (ModelStateError modelStateError) {
            modelStateError.printStackTrace();
        }
    }

    @Test
    public void getAll() {

        Code.getAll().then(new DoneCallback<Response>() {
            @Override
            public void onDone(Response result) {

                Log.d("", "" + result.getStatus());
            }
        });
    }

    @After
    public void after() {

    }
}

