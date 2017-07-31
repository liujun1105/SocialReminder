DROP SCHEMA IF EXISTS cgnuo;

CREATE SCHEMA IF NOT EXISTS cgnuo;

CREATE TABLE cgnuo.`student` (
    `student_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    `student_name` VARCHAR(200) NOT NULL DEFAULT '',
    PRIMARY KEY (`student_id`)
);