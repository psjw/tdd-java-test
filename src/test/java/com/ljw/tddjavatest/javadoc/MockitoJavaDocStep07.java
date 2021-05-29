package com.ljw.tddjavatest.javadoc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

@DisplayName("Mockito JavaDoc 3.10.0 API")
class MockitoJavaDocStep07 {
    @Test
    @DisplayName("7. Making sure interaction(s) never happened on mock")
    void step_07_test(){
        //step1
        List mockListOne = mock(List.class);
        List mockListTwo = mock(List.class);

        //step2
        //verifyZeroInteractions(mockListOne,mockListTwo);
        verifyNoInteractions(mockListOne, mockListTwo);
    }
}


