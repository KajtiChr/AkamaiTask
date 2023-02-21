CREATE DATABASE  IF NOT EXISTS `Task`;
USE `Task`;

CREATE TABLE `SocialNetworkPost`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `post_date` DATETIME,
    `author` varchar(40) DEFAULT NULL,
    `content` text DEFAULT NULL,
    `view_count` BIT(25),
    PRIMARY KEY(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;