#!/bin/bash

docker run -it --rm -v $(pwd):/app -p 9090:8080 --workdir /app elixir mix run --no-halt
