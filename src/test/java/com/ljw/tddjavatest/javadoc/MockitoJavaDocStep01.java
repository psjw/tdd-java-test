package com.ljw.tddjavatest.javadoc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@DisplayName("Mockito JavaDoc 3.10.0 API")
class MockitoJavaDocStep01 {
    @Test
    @DisplayName("1. Let's verify some behaviour!")
    void step_01_test(){
        //mock 생성
        List mockedList = mock(List.class);

        //mock 객체 사용
        mockedList.add("test1");
        mockedList.clear();

        //verification(확인)
        verify(mockedList).add("test1");
        mockedList.clear();
    }

}

