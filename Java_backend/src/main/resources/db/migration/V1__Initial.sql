SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema todobase
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema todobase
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `todobase` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema todobase
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema todobase
-- -----------------------------------------------------
USE `todobase` ;

-- -----------------------------------------------------
-- Table `todobase`.`todo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `todobase`.`todo` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS `todobase`.`archive` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


