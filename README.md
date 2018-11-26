# Overview

This is a simple poc using [grpc] and [ha-proxy] as a load balance

# Setup

Enter in src/main/resource

1. Execute `docker build -t grpc-haproxy .`
2. Execute `docker run -d --name=grpc-haproxy --net=host grpc-haproxy`

# Test

1. Execute `mvn compile`
2. Start on server on 8083 port
3. Start on server on 8084 port
4. Start your ClientApplication

[grpc]: https://grpc.io/
[ha-proxy]:http://www.haproxy.org/
