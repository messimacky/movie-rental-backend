DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
                        `user_id` INTEGER PRIMARY KEY AUTO_INCREMENT,
                        `email` VARCHAR(255) UNIQUE,
                        `password` CHAR(60),
                        `first_name` VARCHAR(50),
                        `last_name` VARCHAR(50),
                        `enabled` BOOLEAN,
                        `created_on` DATETIME,
                        `last_login` DATETIME,
                        `reset_token` CHAR(36)
);