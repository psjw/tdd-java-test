package com.ljw.tddjavatest.javadoc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@DisplayName("Mockito JavaDoc 3.10.0 API")
class MockitoJavaDocStep08 {
    @Test
    @DisplayName("8. Finding redundant invocations")
    void step_08_test(){
        //step1
        List mockList = mock(List.class);

        //step2 stubbing
        mockList.add("one");
        mockList.add("two");

        //step3
        verify(mockList).add("one");
        //verify(mockList).add("two");

        //step4
        verifyNoMoreInteractions(mockList);
    }
}


