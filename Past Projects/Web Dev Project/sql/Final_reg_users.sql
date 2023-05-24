CREATE TABLE IF NOT EXISTS `Final_reg_users` (
  `firstName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `lastName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `emailAddr` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL UNIQUE,
  `pw` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`emailAddr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
