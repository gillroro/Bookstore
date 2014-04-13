CREATE DATABASE  IF NOT EXISTS `bookstore` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bookstore`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: bookstore
-- ------------------------------------------------------
-- Server version	5.1.50-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `idbook` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`idbook`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'BFG','Roald Dahl',6.56,'Children','http://menstruationresearch.org/wp-content/uploads/2012/11/roald-dahl-the-bfg1.jpg',15),(2,'The Hunger Games','Suzanne Collins',8.99,'Fictional','http://upload.wikimedia.org/wikipedia/en/a/ab/Hunger_games.jpg',35),(3,'Mr Strong','Roger Hargreaves',4.03,'Children','http://www.themistermen.co.uk/images/mrstrong.jpg',5),(4,'The Road','Cormac McCarthy',9.5,'American Classic','http://thegospelcoalition.org/blogs/tgc/files/2012/03/Cormac-McCarthy-The-Road.jpg',15),(5,'Missing You','Harlen Coben',16.15,'Thriller','http://www.harlancoben.com/wp-content/uploads/2013/08/MissingYou_Coben_lg.jpg',40),(6,'Philomena','Martin Sixsmith',12.3,'Biography','http://cdn2-b.examiner.com/sites/default/files/styles/image_content_width/hash/88/d6/88d6b45af6786ed7d9322639cd94e4d4.jpg?itok=tL5LK1da',14),(7,'Twelve Years a Slave','Solomon Northup',11.22,'Biography','http://blog.woodpie.com/wp-content/uploads/2014/03/twelve-years-a-slave-book-cover-01-379x600.jpg',10),(8,'Isn\'t It Well for Ye?','Colm O\'Regan',14.45,'Entertainment','http://irishmammies.ie/wp-content/uploads/wp-checkout/images/isnt-it-well-for-ye-signed-by-the-autho-1393779458.jpg',10),(9,'This Is a Call','Paul Brannigan',13.25,'Entertainment','http://wac.450f.edgecastcdn.net/80450F/loudwire.com/files/2011/11/Grohl1.jpg',10),(11,'The Summer Guest','Emma Hannigan',14.99,'Irish Saga','http://a1.mzstatic.com/us/r30/Publication6/v4/9a/ca/b2/9acab2f1-6e8a-ee8c-099a-bd8de0199519/9781472210005.225x225-75.jpg',12);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-04-13 21:22:57
