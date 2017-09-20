#####################
#version: fast_springboot_project 1.0
#describe fast_springboot_project
#truman create
#
FROM java:8-jre-alpine
MAINTAINER Truman

ENV BASE_DIR /opt/app/fast_springboot_project
WORKDIR ${BASE_DIR}
ADD app ${BASE_DIR}/
CMD ["sh","start.sh"]
