-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: kbms
-- ------------------------------------------------------
-- Server version	5.5.28

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
-- Table structure for table `doc_tag`
--

DROP TABLE IF EXISTS `doc_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doc_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `doc_id` int(11) DEFAULT NULL,
  `tag_name` varchar(45) DEFAULT NULL,
  `tag_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=242 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doc_tag`
--

LOCK TABLES `doc_tag` WRITE;
/*!40000 ALTER TABLE `doc_tag` DISABLE KEYS */;
INSERT INTO `doc_tag` VALUES (202,343,'算法',34),(203,343,'操作系统',53),(204,343,'计算机科学',33),(205,342,'算法',34),(206,342,'计算机科学',33),(207,341,'操作系统',53),(208,341,'计算机科学',33),(209,344,'算法',34),(210,344,'汇编',54),(211,344,'操作系统',53),(212,344,'计算机科学',33),(213,344,'数据结构',51),(214,344,'计算机组成原理',52),(215,345,'计算机科学',33),(216,346,'算法',34),(217,346,'java',36),(218,347,'算法',34),(219,347,'python',38),(220,347,'java',36),(221,347,'操作系统',53),(222,347,'hadoop',42),(223,348,'算法',34),(224,348,'java',36),(225,348,'hadoop',42),(226,349,'算法',34),(227,349,'hadoop',42),(228,350,'算法',34),(229,350,'操作系统',53),(230,351,'算法',34),(231,351,'操作系统',53),(232,352,'java',36),(233,352,'solr',43),(234,352,'html',46),(235,353,'java',36),(236,353,'solr',43),(237,353,'html',46),(238,353,'hadoop',42),(239,354,'java',36),(240,354,'solr',43),(241,354,'html',46);
/*!40000 ALTER TABLE `doc_tag` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-13 14:55:41
