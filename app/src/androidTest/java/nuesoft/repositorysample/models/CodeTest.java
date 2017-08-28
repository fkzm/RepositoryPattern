package nuesoft.repositorysample.models;

import android.support.annotation.AnyThread;
import android.support.test.espresso.base.MainThread;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.jdeferred.DoneCallback;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunListener;

import nuesoft.repositorysample.exception.ModelStateError;
import nuesoft.repositorysample.model.Code;
import nuesoft.repositorysample.webService.Response;

/**
 * Created by mysterious on 8/22/17.
 */

@RunWith(AndroidJUnit4.class)

public class CodeTest {
    Code code;
    int status = -1;

    @Test
    public void CRUD() {

        code = new Code();

        try {

            code.save().then(new DoneCallback<Response>() {
                @Override
                public void onDone(Response result) {
                    System.out.println("hi");
                    Log.d("hh", "hhiiii");
                    status = result.getStatus();

                }

            });
        } catch (ModelStateError modelStateError) {
            modelStateError.printStackTrace();
        }

        try {
            Thread.sleep(5000);
            Assert.assertEquals(status, 200);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
        System.out.println("After");
        code.getCode();
//        Assert.assertTrue(false);
    }
}

