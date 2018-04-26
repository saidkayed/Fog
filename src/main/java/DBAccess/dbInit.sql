CREATE SCHEMA IF NOT EXISTS `fog` DEFAULT CHARACTER SET latin1 ;
USE `fog` ;

Drop table if exists `order`;
Drop table if exists `user`;
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


-- -----------------------------------------------------
-- Table `fog`.`order`
-- -----------------------------------------------------
CREATE TABLE `fog`.`order` (
  `orderid` INT(11) NOT NULL AUTO_INCREMENT,
  `id` INT(11) NOT NULL,
  `width` INT(11) NOT NULL,
  `length` INT(11) NOT NULL,
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

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES 
(1,'123','123','customer'),
(3,'456','456','employee');
UNLOCK TABLES;
