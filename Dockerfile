From maven:3-jdk-8
RUN mkdir -p /usr/src/argentax
#COPY . /usr/src/argentax
WORKDIR /usr/src/argentax
ONBUILD ADD . /usr/src/argentax
#RUN mvn spring-boot:run
ONBUILD RUN mvn install
ONBUILD RUN mvn spring-boot:run
