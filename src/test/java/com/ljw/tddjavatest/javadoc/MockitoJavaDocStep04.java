package com.ljw.tddjavatest.javadoc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@DisplayName("Mockito JavaDoc 3.10.0 API")
class MockitoJavaDocStep04 {
    @Test
    @DisplayName("4. Verifying exact number of invocations / at least x / never")
    void step_04_test(){
        //step1
        LinkedList mockedList = mock(LinkedList.class);

        //step2
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        //step3
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        //step4
        verify(mockedList, atMostOnce()).add("once");
        verify(mockedList, atLeastOnce()).add("three times");
        verify(mockedList, atLeast(2)).add("three times");
        verify(mockedList, atMost(5)).add("three times");
    }
}

