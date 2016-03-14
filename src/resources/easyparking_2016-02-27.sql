# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.6.25)
# Database: easyparking
# Generation Time: 2016-02-27 07:54:10 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table car_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `car_info`;

CREATE TABLE `car_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `car_no` varchar(20) DEFAULT NULL,
  `model` varchar(20) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `created_by` varchar(250) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `updated_by` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table car_parking_mapping
# ------------------------------------------------------------

DROP TABLE IF EXISTS `car_parking_mapping`;

CREATE TABLE `car_parking_mapping` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `car_id` int(11) DEFAULT NULL,
  `parking_id` int(11) DEFAULT NULL,
  `time_in` int(11) DEFAULT NULL,
  `time_out` int(11) DEFAULT NULL,
  `booking_id` int(11) DEFAULT NULL,
  `payment_id` int(11) DEFAULT NULL,
  `status` smallint(2) DEFAULT '0',
  `created_at` timestamp NULL DEFAULT NULL,
  `created_by` varchar(250) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `updated_by` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `car_parking_mapping` WRITE;
/*!40000 ALTER TABLE `car_parking_mapping` DISABLE KEYS */;

INSERT INTO `car_parking_mapping` (`id`, `car_id`, `parking_id`, `time_in`, `time_out`, `booking_id`, `payment_id`, `status`, `created_at`, `created_by`, `updated_at`, `updated_by`)
VALUES
	(2,1,3,7,8,NULL,NULL,0,NULL,NULL,NULL,NULL);

/*!40000 ALTER TABLE `car_parking_mapping` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table parker
# ------------------------------------------------------------

DROP TABLE IF EXISTS `parker`;

CREATE TABLE `parker` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NOT NULL DEFAULT '',
  `email_id` varchar(250) NOT NULL DEFAULT '',
  `mobile_no` varchar(15) NOT NULL DEFAULT '',
  `address` varchar(250) NOT NULL DEFAULT '',
  `city` varchar(20) NOT NULL DEFAULT '',
  `state` varchar(20) DEFAULT NULL,
  `pin` varchar(11) DEFAULT NULL,
  `altitude` varchar(250) DEFAULT NULL,
  `longitude` varchar(250) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `created_by` varchar(250) DEFAULT NULL,
  `updated_by` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table parking_lot
# ------------------------------------------------------------

DROP TABLE IF EXISTS `parking_lot`;

CREATE TABLE `parking_lot` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(250) DEFAULT NULL,
  `altitude` varchar(250) DEFAULT NULL,
  `longitude` varchar(250) DEFAULT NULL,
  `owner_id` int(11) DEFAULT NULL,
  `total_count` int(11) DEFAULT NULL,
  `available_count` int(11) DEFAULT NULL,
  `regular_rate` int(11) DEFAULT NULL,
  `pick_rate` int(11) DEFAULT NULL,
  `pick_time` time DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `created_by` varchar(250) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `updated_by` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(250) DEFAULT NULL,
  `email` varchar(250) DEFAULT NULL,
  `mobile_no` varchar(15) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `created_by` varchar(250) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `updated_by` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` (`id`, `name`, `email`, `mobile_no`, `created_at`, `created_by`, `updated_at`, `updated_by`)
VALUES
	(1,'Manoranjan Mahananda','manu.mahananda@gmail.com','9958630753','2016-01-29 23:28:31','system','2016-01-29 23:28:43','system'),
	(3,'nobody','manoranjan.mahananda@onedirect.in','9980978901','2016-01-31 14:56:31','manoranjan.mahananda@onedirect.in','2016-01-31 14:56:31','manoranjan.mahananda@onedirect.in'),
	(4,'Rajneesh','abc@sfff.cb','9718377212','2016-01-31 15:02:29','abc@sfff.cb','2016-01-31 15:02:29','abc@sfff.cb'),
	(5,'kher','kher.anop@gmail.com','9958630753','2016-01-31 17:28:10','kher.anop@gmail.com','2016-01-31 17:28:10','kher.anop@gmail.com');

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user_car_mapping
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_car_mapping`;

CREATE TABLE `user_car_mapping` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `car_id` int(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `created_by` varchar(250) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `updated_by` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
