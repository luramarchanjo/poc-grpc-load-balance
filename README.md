# Overview

This is a simple poc using [grpc] and [ha-proxy] as a load balance

# Setup

Open your terminal and go to src/main/resource directory

1. Execute the command `docker build -t grpc-haproxy .`
2. Execute the command  `docker run -d --name=grpc-haproxy --net=host grpc-haproxy`

# Test

1. Execute the command  `mvn compile`
2. Start one server on 8083 port
3. Start one server on 8084 port
4. Start one or more ClientApplication's

[grpc]: https://grpc.io/
[ha-proxy]:http://www.haproxy.org/
