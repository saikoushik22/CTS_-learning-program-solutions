package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class MyServiceCaptorAnnotationTest {

    @Mock
    private ExternalApi api;
    @InjectMocks
    private MyService service;
    @Captor
    private ArgumentCaptor<String> captor;

    @Test
    void testCaptorAnnotation() {
        service.save("Mockito Rocks!");
        verify(api).sendData(captor.capture());
        assertEquals("Mockito Rocks!", captor.getValue());
    }
}
