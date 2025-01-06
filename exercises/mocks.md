# Mocks to the rescue

The classes `SSLSocket`, `TLSProtocol` and `TLSSocketFactory` are included in the `sockets` package of the [`tp3-ssl`](../code/tp3-ssl) project.

The test class `TLSSocketFactoryTest` tests `TLSSocketFactory` and manually builds stubs and mocks for SSLSocket objects.

Rewrite these tests with the help of Mockito.

The initial tests fail to completely test the `TLSSockeetFactory`. In fact, if we *entirely* remove the code inside the body of `prepareSocket` no test case fails.

Propose a solution to this problem in your new Mockito-based test cases.


Je n'ai honnêtement pas compris les tests de ce programme en particulier, je pense avoir compris le concept des mocks mais je ne comprends vraiment pas ce que le code de TLSSocketFactory cherche à faire. Je n'ai écrit que le test pour `preparedSocket_NullProtocols`