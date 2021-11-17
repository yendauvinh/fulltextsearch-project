FROM openjdk:11-jdk

ARG JAR_FILE=fulltextsearch-0.0.1-SNAPSHOT.jar
ARG TARGET=target/${JAR_FILE}
ARG WORK_DIR=/opt/fulltextsearch
ARG WORK_FOLDER=/opt/template
ARG TEMP_FOLDER=/opt/tempory

RUN echo "Asia/Ho_Chi_Minh" > /etc/timezone
CMD  mkdir -p ${WORK_DIR}
COPY ${TARGET} ${WORK_DIR}/fulltextsearch-0.0.1-SNAPSHOT.jar
WORKDIR /opt/fulltextsearch

EXPOSE 8080
CMD java -jar fulltextsearch-0.0.1-SNAPSHOT.jar
