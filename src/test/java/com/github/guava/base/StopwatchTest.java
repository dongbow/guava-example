package com.github.guava.base;

import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by wangdongbo on 2017/11/10.
 */
public class StopwatchTest {

    @Test
    public void test() {
        Ticker ticker = mock(Ticker.class);
        when(ticker.read()).thenReturn(0L, 2 * 60 * 60 * 1000L * 1000L * 1000L);
        Stopwatch stopwatch = Stopwatch.createStarted(ticker);

        stopwatch.stop();

        assertEquals(stopwatch.toString(), "2.000 h");
        assertEquals(stopwatch.elapsed(TimeUnit.MINUTES), 120);
        assertEquals(stopwatch.elapsed(TimeUnit.HOURS), 2);
    }

}
