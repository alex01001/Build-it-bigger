package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AppTest  {

    @Test
    public void iTest() throws Exception {
        EndpointsAsyncTaskTest test =  new EndpointsAsyncTaskTest();
        test.execute(InstrumentationRegistry.getContext());
        String joke = test.get(120, TimeUnit.SECONDS);

        Assert.assertEquals(14,joke.length());    }
}
