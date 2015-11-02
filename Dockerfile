FROM ubuntu
MAINTAINER Vincent Free "vincentfree87@gmail.com"
# Update Ubuntu
#RUN apt-get update && apt-get -y upgrade
# Add oracle java 8 repository
RUN apt-get -y install software-properties-common
RUN add-apt-repository ppa:webupd8team/java
RUN apt-get -y update
# Accept the Oracle Java license
RUN echo "oracle-java8-installer shared/accepted-oracle-license-v1-1 boolean true" | debconf-set-selections
# Install Oracle Java
RUN apt-get -y install \
oracle-java8-installer\
maven
RUN mkdir /usr/src/argentax
EXPOSE 8080
VOLUME "/usr/src/argentax"
ADD . /usr/src/argentax/
CMD ["mvn","-f","/usr/src/argentax/","clean install"]
#ADD ./target/NewArgentaxWebsite-1.0-SNAPSHOT.jar /usr/src/argentax/
#ADD target/NewArgentaxWebsite-1.0-SNAPSHOT.jar /usr/src/argentax/
CMD ["java", "-jar", "/usr/src/argentax/target/NewArgentaxWebsite-1.0-SNAPSHOT.jar"]
#CMD ["java", "-jar", "/usr/src/argentax/NewArgentaxWebsite-1.0-SNAPSHOT.jar"]

#FROM maven:3-jdk-8
#MAINTAINER Vincent Free "vincentfree87@gmail.com"
#RUN mkdir -p /usr/src/argentax
#RUN apt-get update && apt-get install -y
#COPY . /usr/src/argentax
#WORKDIR /usr/src/argentax
#COPY . /usr/src/argentax
#RUN git clone https://github.com/vincentfree/Argentax.git /usr/src/argentax
#ONBUILD ADD . /usr/src/argentax
#RUN mvn spring-boot:run
#EXPOSE 8080
#VOLUME "/usr/src/argentax"
#ONBUILD RUN mvn clean install
#CMD "java -jar /usr/src/argentax/target/NewArgentaxWebsite-1.0-SNAPSHOT.jar"
#CMD ["java -jar /usr/src/argentax/target/NewArgentaxWebsite-1.0-SNAPSHOT.jar"]
#ONBUILD RUN mvn spring-boot:run
