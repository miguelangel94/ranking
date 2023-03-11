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