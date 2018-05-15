CREATE SCHEMA IF NOT EXISTS `fog` DEFAULT CHARACTER SET latin1 ;
USE `fog` ;

Drop table if exists `order`;
Drop table if exists `user`;
Drop table if exists `materials`;
-- -----------------------------------------------------
-- Table `fog`.`user`
-- -----------------------------------------------------
CREATE TABLE `fog`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(90) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;

INSERT INTO `user` VALUES 
(1,'123','123','customer'),
(3,'456','456','employee');


-- -----------------------------------------------------
-- Table `fog`.`order`
-- -----------------------------------------------------
CREATE TABLE `fog`.`order` (
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
('1', 'Planke(10cm*20cm) (meter pris)', '10', '', ''),
('2', 'Spaer(10cm*20cm) (stk)', '30', '', ''),
('3', 'Stolpe (10cm*10cm) (stk)', '50', '', ''),
('4', 'Trapez Plade (fladt tag) (pr m2)', '30', '', ''),
('5', 'Skur doer', '1000', '', '');