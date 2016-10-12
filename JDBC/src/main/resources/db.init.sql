CREATE TABLE Book (
    id          INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    author      VARCHAR(60),
    name        VARCHAR(100) NOT NUll,
    year        YEAR);

INSERT INTO Book (author, name, year) VALUES ('G. Korn', 'Mathematical handbook', '1968');
INSERT INTO Book (author, name, year) VALUES ('G. Dwight', 'Tables of integrals', '1961');
INSERT INTO Book (author, name, year) VALUES ('N. Belyaev', 'Strength of materials', '1954');