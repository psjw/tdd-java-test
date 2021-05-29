package com.ljw.tddjavatest.javadoc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("Mockito JavaDoc 3.10.0 API")
public class MockitoJavaDocStep02 {

    @Test
    @DisplayName("2. How about some stubbing?")
    void step_02_test(){
        //step1
        LinkedList mockedList = mock(LinkedList.class);

        //step2 stubbing
        when(mockedList.get(0)).thenReturn("test2");
        when(mockedList.get(1)).thenThrow(new NoSuchElementException());

        //step3
        assertThat(mockedList.get(0)).isEqualTo("test2");
        assertThatThrownBy(() -> mockedList.get(1))
                .isInstanceOf(NoSuchElementException.class);
        assertThat(mockedList.get(999)).isNull();

        //step4
        verify(mockedList).get(1);
        verify(mockedList).get(999);
        verify(mockedList).get(0);
        //verify(mockedList).get(2);
    }
}
