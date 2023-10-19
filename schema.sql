CREATE TABLE users (
    id CHAR(36) NOT NULL,
    name VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    created TIMESTAMP,
    modified TIMESTAMP,
    lastLogin TIMESTAMP,
    isActive BOOLEAN,
    PRIMARY KEY (id)
);

CREATE TABLE phone (
    id BIGINT AUTO_INCREMENT,
    number VARCHAR(255),
    citycode VARCHAR(255),
    countrycode VARCHAR(255),
    user_id CHAR(36) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);