From java:8
COPY . /usr/src/argentax
WORKDIR /usr/src/argentax
RUN javac Main.java
