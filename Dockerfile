FROM maven:3-jdk-8
MAINTAINER Vincent Free "vincentfree87@gmail.com"
RUN mkdir -p /usr/src/argentax
RUN apt-get update && apt-get install -y \
git
#COPY . /usr/src/argentax
WORKDIR /usr/src/argentax
RUN git clone https://github.com/vincentfree/Argentax.git /usr/src/argentax
#ONBUILD ADD . /usr/src/argentax
#RUN mvn spring-boot:run
EXPOSE 8080
VOLUME ["/usr/src/argentax"]
RUN mvn clean install
CMD ["mvn spring-boot:run"]
#ONBUILD RUN mvn spring-boot:run
