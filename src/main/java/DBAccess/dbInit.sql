CREATE SCHEMA IF NOT EXISTS `fog` DEFAULT CHARACTER SET latin1 ;
USE `fog` ;

SET foreign_key_checks = 0;
Drop table if exists `fog`.`order`;
Drop table if exists `fog`.`user`;
Drop table if exists `fog`.`materials`;
SET foreign_key_checks = 1;
-- -----------------------------------------------------
-- Table `fog`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(90) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `phone` INT(11) NOT NULL,
  `role` VARCHAR(45) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;

INSERT INTO `user` VALUES 
(1,'123','123',12341234,'customer'),
(2,'456','456',23452345,'employee'),
(3, 'SystemTester', 'SystemTester', 12345678, 'tester');


-- -----------------------------------------------------
-- Table `fog`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog`.`order` (
  `orderid` INT(11) NOT NULL AUTO_INCREMENT,
  `id` INT(11) NOT NULL,
  `width` INT(11) NOT NULL,
  `length` INT(11) NOT NULL,
  `height` INT(11) NOT NULL,
  `roof` VARCHAR(90) NOT NULL,
  `shed` VARCHAR(90) NOT NULL,
  `date` VARCHAR(90) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`orderid`),
  INDEX `id` (`id` ASC),
  CONSTRAINT `order_ibfk_1`
    FOREIGN KEY (`id`)
    REFERENCES `fog`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `fog`.`materials`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `fog`.`materials` (
  `materialid` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` INT(11) NOT NULL,
  `length` VARCHAR(45)NULL,
  `description` VARCHAR(45)NULL,
  PRIMARY KEY (`materialid`));

INSERT INTO `materials` VALUES 
('1', 'Plank(20x10x5)', '20', '5 meters', 'Plank, 5 meters long used for frame'),
('2', 'Rafter(20x10x5)', '20', '5 meters', 'Rafter is used to support'),
('3', 'Pillar', '30', 'arbitrary', 'Pillar with arbitrary length'),
('4', 'Trapezoidal plate', '30', 'm2', 'Trapezoidal plate used for roof price pr m2'),
('5', 'Roof Plank(20x10x5)', '20', 'meter', 'Roof Plank used for roof support'),
('6', 'Roof Plank(20x10x2)', '10', 'meter', 'Roof Plank used for roof support'),
('7', 'Shed Plank(20x10x2)', '10', 'meter', 'Shed planks used for shed'),
('8', 'Shed door', '1000', '210cm x 70cm', 'Shed door for the shed'),
('9', 'Screws', '1', '5cm', 'Screws for the planks'),
('10', 'Top Screws', '1', '5cm', 'Screws for roof plates');

//Test db


Drop table if exists `fogdbtest`.`user`;

CREATE TABLE `fogdbtest`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(90) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `phone` INT(11) NOT NULL,
  `role` VARCHAR(45) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;

INSERT INTO `user` VALUES 
(1,'123','123',12341234,'customer'),
(3,'456','456',23452345,'employee');


CREATE TABLE IF NOT EXISTS `fogdbtest`.`materials` (
  `materialid` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` INT(11) NOT NULL,
  `length` VARCHAR(45)NULL,
  `description` VARCHAR(45)NULL,
  PRIMARY KEY (`materialid`));

INSERT INTO `materials` VALUES 
('1', 'Plank(20x10x5)', '20', '5 meters', 'Plank, 5 meters long used for frame'),
('2', 'Rafter(20x10x5)', '20', '5 meters', 'Rafter is used to support'),
('3', 'Pillar', '30', 'arbitrary', 'Pillar with arbitrary length'),
('4', 'Trapezoidal plate', '30', 'm2', 'Trapezoidal plate used for roof price pr m2'),
('5', 'Roof Plank(20x10x5)', '20', 'meter', 'Roof Plank used for roof support'),
('6', 'Roof Plank(20x10x2)', '10', 'meter', 'Roof Plank used for roof support'),
('7', 'Shed Plank(20x10x2)', '10', 'meter', 'Shed planks used for shed'),
('8', 'Shed door', '1000', '210cm x 70cm', 'Shed door for the shed'),
('9', 'Screws', '1', '5cm', 'Screws for the planks'),
('10', 'Top Screws', '1', '5cm', 'Screws for roof plates');

CREATE TABLE `fogdbtest`.`order` (
  `orderid` INT(11) NOT NULL AUTO_INCREMENT,
  `id` INT(11) NOT NULL,
  `width` INT(11) NOT NULL,
  `length` INT(11) NOT NULL,
  `height` INT(11) NOT NULL,
  `roof` VARCHAR(90) NOT NULL,
  `shed` VARCHAR(90) NOT NULL,
  `date` VARCHAR(90) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`orderid`),
  INDEX `id` (`id` ASC),
  CONSTRAINT `order_ibfk_1`
    FOREIGN KEY (`id`)
    REFERENCES `fog`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;

INSERT INTO `ORDER` VALUES
('1', '1', '300', '300', '500', 'rejsning', 'widthshed2x2', 'bla', 'pending');