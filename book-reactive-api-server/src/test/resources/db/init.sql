CREATE TABLE `author` (
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255) DEFAULT NULL,
    `email` VARCHAR(255) DEFAULT NULL
);

CREATE TABLE `book` (
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `title` VARCHAR(255) DEFAULT NULL,
    `author_id` INT DEFAULT NULL,
    CONSTRAINT fk_book_author_id FOREIGN KEY (author_id)
        REFERENCES author (id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO `book` (`title`) VALUES ('Lion\'s eye');
INSERT INTO `book` (`title`) VALUES ('Pig\'s eye');
INSERT INTO `book` (`title`) VALUES ('Snake\'s eye');