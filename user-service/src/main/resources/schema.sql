drop table if exists USERS;

CREATE TABLE USERS
(
    ID        NUMBER PRIMARY KEY NOT NULL,
    NAME      VARCHAR2           NOT NULL,
    USER_NAME VARCHAR2           NOT NULL,
    EMAIL     VARCHAR2           NOT NULL,
    PHONE     VARCHAR2           NOT NULL,
    WEBSITE   VARCHAR2
);