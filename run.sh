#!/bin/sh

echo "Starting The Schedule Front End at " $(date +%d-%m-%H:%M:%S)
echo "____________________________________________________________"
ls -alt
cd /code/client/
npm run start
# This file is used in Docker.
# This file tells the Docker which command to run in the docker
