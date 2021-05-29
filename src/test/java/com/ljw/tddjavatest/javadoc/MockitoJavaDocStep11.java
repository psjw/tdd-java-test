package com.ljw.tddjavatest.javadoc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Mockito JavaDoc 3.10.0 API")
class MockitoJavaDocStep11 {

    @Test
    @DisplayName("11. Stubbing with callbacks")
    void step_11_test() {
        //step1
        List<String> mockedList = mock(List.class);

        //step2
        when(mockedList.get(anyInt()))
                .thenAnswer(new Answer<Object>() {
                    @Override
                    public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                        Object[] objects = invocationOnMock.getArguments();
                        Object mock = invocationOnMock.getMock();
                        return  "called with arguments : " + Arrays.toString(objects);
                    }
                });
        /*
        when(mockedList.get(anyInt()))
                .thenAnswer(invocationOnMock -> {
                    Object[] objects = invocationOnMock.getArguments();
                    Object mock = invocationOnMock.getMock();
                    return  "called with arguments : " + Arrays.toString(objects);
                });
        */

        //step3
        assertThat(mockedList.get(0)).isEqualTo("called with arguments : [0]");
    }
}


