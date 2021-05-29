package com.ljw.tddjavatest.javadoc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

@DisplayName("Mockito JavaDoc 3.10.0 API")
class MockitoJavaDocStep13 {

    @Test
    @DisplayName("13. Spying on real objects")
    void step_13_test() {
        //step1
        final List mockedList = new ArrayList();
        final List spy = spy(mockedList);

        //step2
        //when(spy.size()).thenReturn(100);
        doReturn("one").when(spy).get(0);

        //step3
        spy.add("one");
        spy.add("two");

        //step4
        assertThat(spy.get(0)).isEqualTo("one");
        assertThatThrownBy(() -> mockedList.get(0))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}


