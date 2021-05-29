package com.ljw.tddjavatest.javadoc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import java.util.LinkedList;
import java.util.List;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("Mockito JavaDoc 3.10.0 API")
public class MockitoJavaDocStep03 {


    class IsLengthGreaterThanOneArgument implements ArgumentMatcher<List> {
        @Override
        public boolean matches(List list) {
            return String.valueOf(list.get(anyInt())).length() > 1;
        }
    }

    @Test
    @DisplayName("3. Argument matchers")
    void step_03_test() {
        //step1
        LinkedList mockedList = mock(LinkedList.class);

        //step2
        when(mockedList
                .get(anyInt()))
                .thenReturn("Integer");
        when(mockedList
                .contains(argThat(new IsLengthGreaterThanOneArgument())))
                .thenReturn(true);

        //step3
        mockedList.get(1);
        mockedList.get(999);
        mockedList.get(0);
        mockedList.get(2);

        //step4
        verify(mockedList).get(1);
        verify(mockedList).get(999);
        verify(mockedList).get(0);
        verify(mockedList).get(2);
    }
}
