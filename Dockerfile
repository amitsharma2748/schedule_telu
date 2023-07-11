# stage1 as builder
FROM node:alpine as builder
RUN apk update ; apk add npm; apk add --no-cache busybox-extras; apk add tzdata; ln -snf /usr/share/zoneinfo/Asia/Kolkata /etc/localtime && echo "Asia/Kolkata" > /etc/timezone
WORKDIR /code
RUN mkdir code
# copy the package.json to install dependencies
COPY /client/package.json /code/
RUN npm install
COPY /client/. /code/
RUN npm run build
FROM nginx:alpine
#!/bin/sh
COPY ./.nginx/nginx.conf /etc/nginx/nginx.conf
## Remove default nginx index page
RUN rm -rf /usr/share/nginx/html/*
# Copy from the stahg 1
COPY /client/public/favicon.ico /usr/share/nginx/html/
COPY --from=builder /code/build /usr/share/nginx/html/
EXPOSE $DOCKER_LISTEN_PORT
#ENTRYPOINT ["/bin/sh"]
ENTRYPOINT ["nginx", "-g", "daemon off;"]