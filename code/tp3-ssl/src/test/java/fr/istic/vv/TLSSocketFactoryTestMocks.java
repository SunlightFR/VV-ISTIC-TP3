package fr.istic.vv;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TLSSocketFactoryTestMocks {

    @Test
    public void preparedSocket_NullProtocols(){
        TLSSocketFactory f = new TLSSocketFactory();
        SSLSocket socket = mock(SSLSocket.class);
        when(socket.getEnabledProtocols()).thenReturn(null);
        when(socket.getSupportedProtocols()).thenReturn(null);
        f.prepareSocket(mock(SSLSocket.class));
        fail();
    }

    private String[] shuffle(String[] in) {
        List<String> list = new ArrayList<String>(Arrays.asList(in));
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }
}