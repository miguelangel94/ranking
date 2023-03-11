-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ranking
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ranking
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ranking` DEFAULT CHARACTER SET utf8 ;
USE `ranking` ;
-- -----------------------------------------------------
-- Table `ranking`.`Group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ranking`.`Group` ;

CREATE TABLE IF NOT EXISTS `ranking`.`Group` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ranking`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ranking`.`User` ;

CREATE TABLE IF NOT EXISTS `ranking`.`User` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `group_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Usuario_Grupo1_idx` (`group_id` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_Grupo1`
    FOREIGN KEY (`group_id`)
    REFERENCES `ranking`.`Group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;