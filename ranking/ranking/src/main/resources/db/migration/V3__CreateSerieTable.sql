CREATE TABLE IF NOT EXISTS `ranking`.`Serie` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `streaming_platform` VARCHAR(45) NOT NULL,
  `cover` VARCHAR(45) NOT NULL,
  `sinopsis` VARCHAR(245) NOT NULL,
  `average_score` FLOAT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;