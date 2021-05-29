package com.ljw.tddjavatest.javadoc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@DisplayName("Mockito JavaDoc 3.10.0 API")
class MockitoJavaDocStep05 {
    @Test
    @DisplayName("5. Stubbing void methods with exceptions")
    void step_05_test(){
        //step1
        List mockedList = mock(List.class);

        //step2
        doThrow(new RuntimeException()).when(mockedList).get(anyInt());

        //step3
        assertThatThrownBy(() -> mockedList.get(1))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> mockedList.get(1001))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("5. Stubbing void methods with exceptions")
    void step_05_2_test(){
        //step1
        List mockedList = mock(List.class);

        //step2
        doNothing().when(mockedList).clear();

        //step3
        mockedList.clear();

        //step3
        verify(mockedList).clear();
    }
}

