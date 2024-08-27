DROP TABLE IF EXISTS USER_INFORMATION;
CREATE TABLE USER_INFORMATION (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    birth_date VARCHAR(255),
    birth_place VARCHAR(255),
    sex VARCHAR(50),
    current_address VARCHAR(255)
);

DROP TABLE IF EXISTS EXTERNAL_SERVICE_URL;
CREATE TABLE EXTERNAL_SERVICE_URL (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    service_provider_name VARCHAR(255) NOT NULL UNIQUE,
    service_url VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS MANDATORY_FIELD;
CREATE TABLE MANDATORY_FIELD (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    field_name VARCHAR(255)
);

-- Insert records into the 'user_information' table with uppercase column names
INSERT INTO USER_INFORMATION (first_name, last_name)
VALUES
    ('John', 'Doe'),
    ('Jane', 'Smith'),
    ('Emily', 'Johnson');

INSERT INTO MANDATORY_FIELD (field_name) VALUES
('firstName'),
('lastName'),
('birthDate'),
('birthPlace'),
('sex'),
('currentAddress');

INSERT INTO EXTERNAL_SERVICE_URL (service_provider_name, service_url) VALUES
('Test', 'https://jsonplaceholder.typicode.com/');