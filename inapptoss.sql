
-- 데이터 베이스 삭제
DROP DATABASE IF EXISTS in_app_toss;


SET FOREIGN_KEY_CHECKS = 0; -- 외래키 무시
DROP TABLE IF EXISTS stage1;
DROP TABLE IF EXISTS chair; 
DROP TABLE IF EXISTS elemeent;

DROP TABLE IF EXISTS stage2;


DROP TABLE IF EXISTS stage3;
SET FOREIGN_KEY_CHECKS = 1; -- 외래키 적용  

-- 데이터 베이스 생성
CREATE DATABASE IF NOT EXISTS in_app_toss
	CHARACTER SET utf8mb4
    COLLATE utf8mb4_general_ci;

USE in_app_toss;

CREATE TABLE IF NOT EXISTS `stage1` (
	id BIGINT AUTO_INCREMENT PRIMARY KEY
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  COMMENT = '스테이지1';

CREATE TABLE IF NOT EXISTS `chairs` (
	id BiGINT AUTO_INCREMENT PRIMARY KEY,
    stage1_id BIGINT NOT NULL,
    chair1 BOOLEAN,
    chair2 BOOLEAN DEFAULT TRUE,
    chair3 BOOLEAN,
    chair4 BOOLEAN,
    chair5 BOOLEAN,
    chair6 BOOLEAN DEFAULT TRUE,
    chair7 BOOLEAN,
    chair8 BOOLEAN,
    CONSTRAINT `fk_chair_stage1_id` FOREIGN KEY (stage1_id) REFERENCES stage1(id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  COMMENT = '의자 퍼즐';
  
  INSERT INTO chairs
  VALUES
	(1, 1, true, true, false, true, false, false, false, true);

CREATE TABLE IF NOT EXISTS `elements` (
	id BiGINT AUTO_INCREMENT PRIMARY KEY,
    stage1_id BIGINT NOT NULL,
    elements VARCHAR(100),
    CONSTRAINT `fk_element_stage1_id` FOREIGN KEY (stage1_id) REFERENCES stage1(id),
    CONSTRAINT `chk_elements` CHECK(elements IN ('Au', 'Ga', 'Ag', 'Br', 'Hg'))
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  COMMENT = '자물쇠 녹이기';
  
CREATE TABLE IF NOT EXISTS `bombs` (
	id BiGINT AUTO_INCREMENT PRIMARY KEY,
    stage1_id BIGINT NOT NULL,
    pencil BOOLEAN,
    bottle_cap BOOLEAN,
    bucket BOOLEAN,
    adapter BOOLEAN,
    battery BOOLEAN,
    snack BOOLEAN,
    plastic BOOLEAN,
    electric_bulb BOOLEAN,
    flask BOOLEAN, 
    CONSTRAINT `fk_element_stage1_id` FOREIGN KEY (stage1_id) REFERENCES stage1(id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  COMMENT = '폭탄만들기';
  
INSERT INTO bombs 
VALUES
	(1, 3, 
  
  
  CREATE TABLE IF NOT EXISTS `stage2` (
	id BIGINT AUTO_INCREMENT PRIMARY KEY
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  COMMENT = '스테이지2';
  
  
  
  CREATE TABLE IF NOT EXISTS `stage3` (
	id BIGINT AUTO_INCREMENT PRIMARY KEY
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  COMMENT = '스테이지3';

-----------------------------------------------
SELECT * FROM chairs;
