-- -----------------------------------------------------
-- Table `ranking`.`Group`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `ranking`.`Group` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ranking`.`User`
-- -----------------------------------------------------

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

CREATE TABLE IF NOT EXISTS `ranking`.`Serie` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `streaming_platform` VARCHAR(45) NOT NULL,
  `cover` VARCHAR(45) NULL,
  `sinopsis` VARCHAR(245) NULL,
  `average_score` FLOAT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `ranking`.`Score` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `score` FLOAT NOT NULL,
  `serie_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Valoracion_Serie_idx` (`serie_id` ASC) VISIBLE,
  INDEX `fk_Valoracion_Usuario1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_Valoracion_Serie`
    FOREIGN KEY (`serie_id`)
    REFERENCES `ranking`.`Serie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Valoracion_Usuario1`
    FOREIGN KEY (`user_id`)
    REFERENCES `ranking`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

ALTER TABLE `ranking`.`Score`
  ADD CONSTRAINT uq_user_and_serie UNIQUE(user_id, serie_id);

