package com.udacity.gradle.builditbigger;


import android.support.test.InstrumentationRegistry;
import android.util.Log;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertNotNull;

public class AppTest extends TestCase  {

    EndpointsAsyncTask downloader;
    CountDownLatch signal;
    String result = null;


    protected void setUp() throws Exception {
        super.setUp();

        signal = new CountDownLatch(1);


        EndpointsAsyncTask.OnAsyncCompletedListener myListener = new EndpointsAsyncTask.OnAsyncCompletedListener() {
            @Override
            public void onCompleted(String resultStr) {
                Log.i("zzzu", resultStr);
                result = resultStr;
                signal.countDown();

            }
        };

        downloader = new EndpointsAsyncTask(myListener);

    }

    @Test
    public void testGetJoke() throws InterruptedException
    {
        downloader.execute();
        signal.await(100, TimeUnit.SECONDS);

        assertNotNull("result is null", result );
    }
}
