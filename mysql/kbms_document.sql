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
-- Table structure for table `document`
--

DROP TABLE IF EXISTS `document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `document` (
  `doc_id` int(11) NOT NULL AUTO_INCREMENT,
  `doc_name` varchar(50) DEFAULT NULL,
  `doc_path` varchar(250) DEFAULT NULL,
  `doc_size` bigint(64) DEFAULT '0',
  `doc_type` varchar(10) DEFAULT NULL,
  `doc_summary` longtext,
  `num_collect` int(11) DEFAULT '0',
  `num_download` int(11) DEFAULT '0',
  `doc_uid` int(11) DEFAULT NULL,
  `time_modify` bigint(64) DEFAULT '0',
  `time_upload` bigint(64) DEFAULT '0',
  PRIMARY KEY (`doc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=355 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document`
--

LOCK TABLES `document` WRITE;
/*!40000 ALTER TABLE `document` DISABLE KEYS */;
INSERT INTO `document` VALUES (341,'2013级毕业实习报告__刘畅.docx','H:\\KnowledgebaseManagementSystem2.0\\out\\artifacts\\KnowledgebaseManagementSystem2_0_war_exploded\\save/fc065554-6c33-41fc-b069-90d7cca2e08a-2013级毕业实习报告__刘畅.docx',26590,'docx','\n\n\n\n\n毕业实习报告\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n	学院名称\n	计算机科学与工程学院\n\n	专业班级\n	物联网工程2013级1班\n\n	学生姓名\n	刘  畅\n\n	学号\n	201301052108\n\n	指导教师\n	房  胜\n\n\n\n\n二O一七年四月\n\n \n评 定 意 见\n毕业实习成绩：          ',0,0,51,1492064331180,1492064331180),(342,'2013级毕业实习报告__宫晨.docx','H:\\KnowledgebaseManagementSystem2.0\\out\\artifacts\\KnowledgebaseManagementSystem2_0_war_exploded\\save/35700d8d-5536-4706-b1d0-347c5223105c-2013级毕业实习报告__宫晨.docx',36695,'docx','\n\n\n\n\n毕业实习报告\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n	学院名称\n	计算机科学与工程学院\n\n	专业班级\n	物联网工程2013级1班\n\n	学生姓名\n	宫  晨\n\n	学号\n	201301052101\n\n	指导教师\n	房  胜\n\n\n\n\n二O一七年四月\n \n评 定 意 见\n毕业实习成绩：          \n',0,0,51,1492064331176,1492064331176),(343,'2013级毕业实习报告__李振.docx','H:\\KnowledgebaseManagementSystem2.0\\out\\artifacts\\KnowledgebaseManagementSystem2_0_war_exploded\\save/591d5ec4-9d52-4405-9382-67b4a86b5632-2013级毕业实习报告__李振.docx',361594,'docx','\n\n\n\n\n毕业实习报告\n \n\n\n\n\n\n\n\n\n\n\n\n\n\n	学院名称\n	计算机科学与工程学院\n\n	专业班级\n	物联网工程2013级1班\n\n	学生姓名\n	李振\n\n	学号\n	201301052113\n\n	指导教师\n	房胜\n\n\n\n\n二O一七年四月\n\n \n评 定 意 见\n毕业实习成绩：          \n指导',0,0,51,1492064331184,1492064331184),(344,'2013级毕业实习报告__韩书楷.docx','H:\\KnowledgebaseManagementSystem2.0\\out\\artifacts\\KnowledgebaseManagementSystem2_0_war_exploded\\save/8219f2a4-1ff8-471d-bf4f-9a5c3de8e174-2013级毕业实习报告__韩书楷.docx',167387,'docx','\n\n\n\n\n毕业实习报告\n\n\n\n\n\n\n\n\n\n\n\n\n\n	学院名称\n	计算机科学与工程学院\n\n	专业班级\n	物联网工程13-1\n\n	学生姓名\n	韩书楷\n\n	学号\n	201301052103\n\n	指导教师\n	房胜\n\n\n\n\n二O一七年四月\n\n \n评 定 意 见\n毕业实习成绩：          \n指导教师对毕',0,0,51,1492064331180,1492064331180),(345,'2013级毕业实习报告模版.docx','H:\\KnowledgebaseManagementSystem2.0\\out\\artifacts\\KnowledgebaseManagementSystem2_0_war_exploded\\save/aa08738c-4593-4875-bf9e-d975f8fe3947-2013级毕业实习报告模版.docx',20635,'docx','\n\n\n\n\n毕业实习报告\n（用B5打印纸）\n\n\n\n\n\n\n\n\n\n\n\n\n\n	学院名称\n	计算机科学与工程学院\n\n	专业班级\n	全 称\n\n	学生姓名\n	\n\n	学号\n	全 称\n\n	指导教师\n	\n\n\n\n\n二O一七年四月\n\n \n评 定 意 见\n毕业实习成绩：          \n指导教师对毕业实习的评语：\n\n\n\n',0,0,51,1492064393576,1492064393576),(346,'Hadoop_dev_04.pdf','H:\\KnowledgebaseManagementSystem2.0\\out\\artifacts\\KnowledgebaseManagementSystem2_0_war_exploded\\save/015c9553-f500-4ff2-81b9-5c882bf6dd13-Hadoop_dev_04.pdf',2147611,'pdf','\nHadoop应用开发实战案例 讲师  黄俊 \n\nDATAGURU专业数据分析社区 \n\nHadoop应用开发实战案例 第4周 \n\n\n\nHadoop应用开发实战案例 讲师  黄俊 \n\nDATAGURU专业数据分析社区 \n\n法律声明 \n\n【声明】本视频和幻灯片为炼数成金网络课程的教\n\n学资料，所有资料只',0,0,51,1492064552511,1492064552511),(347,'Hadoop_dev_02.pdf','H:\\KnowledgebaseManagementSystem2.0\\out\\artifacts\\KnowledgebaseManagementSystem2_0_war_exploded\\save/f0a46187-7ee6-4165-b58c-445aca6551f4-Hadoop_dev_02.pdf',1485298,'pdf','\nHadoop应用开发实战案例 讲师 黄志洪 张丹 \n\nDATAGURU专业数据分析社区 \n\nHadoop应用开发实战案例 第2周 \n\n\n\nHadoop应用开发实战案例     讲师 黄志洪 张丹 \n\nDATAGURU专业数据分析社区 \n\n法律声明 \n\n【声明】本视频和幻灯片为炼数成金网络课程的教\n',0,0,51,1492064552492,1492064552492),(348,'Hadoop_dev_01.pdf','H:\\KnowledgebaseManagementSystem2.0\\out\\artifacts\\KnowledgebaseManagementSystem2_0_war_exploded\\save/8324a7a3-355a-4ae1-8e97-6b35926a09ef-Hadoop_dev_01.pdf',3049120,'pdf','\nHadoop应用开发实战案例 讲师 黄志洪 \n\nDATAGURU专业数据分析社区 \n\nHadoop应用开发实战案例 第1周 \n\n\n\nHadoop应用开发实战案例     讲师 黄志洪 \n\nDATAGURU专业数据分析社区 \n\n法律声明 \n\n【声明】本视频和幻灯片为炼数成金网络课程的教\n\n学资料，所',0,0,51,1492064552521,1492064552521),(349,'Hadoop_dev_03.pdf','H:\\KnowledgebaseManagementSystem2.0\\out\\artifacts\\KnowledgebaseManagementSystem2_0_war_exploded\\save/19de592b-f4a9-475a-82f4-06a45e2bb5ad-Hadoop_dev_03.pdf',3027268,'pdf','\nHadoop应用开发实战案例 讲师 黄志洪 黄俊 \n\nDATAGURU专业数据分析社区 \n\nHadoop应用开发实战案例 第3周 \n\n\n\nHadoop应用开发实战案例 讲师 黄志洪 黄俊 \n\nDATAGURU专业数据分析社区 \n\n法律声明 \n\n【声明】本视频和幻灯片为炼数成金网络课程的教\n\n学资料',0,0,51,1492064552522,1492064552522),(350,'wlw.doc','H:\\KnowledgebaseManagementSystem2.0\\out\\artifacts\\KnowledgebaseManagementSystem2_0_war_exploded\\save/2cbcf8ee-b816-4731-a46e-25a69e968436-wlw.doc',33792,'doc','    1、物联网的分类：从运营角度分为面向公众提供的物联网服务和面向行业提供的物联网专用服务；从管理架构角度分为三个层次，即国家、行业/区域、企业；从所有权角度分为互联网、内联网、专用网；按其部署方式分为私有物联网、公有物联网、社区物联网、混合物联网。\n\n    2、系统集成实现的关键在于解决系统',0,0,51,1492065054964,1492065054964),(351,'wlw.pdf','H:\\KnowledgebaseManagementSystem2.0\\out\\artifacts\\KnowledgebaseManagementSystem2_0_war_exploded\\save/2da93e24-b1f7-40c0-b28d-dbd02d091b64-wlw.pdf',132420,'pdf','\n1、物联网的分类：从运营角度分为面\n向公众提供的物联网服务和面向行业提\n供的物联网专用服务；从管理架构角度分\n为三个层次，即国家、行业/区域、企业；\n从所有权角度分为互联网、内联网、专用\n网；按其部署方式分为私有物联网、公有\n物联网、社区物联网、混合物联网。\n\n2、系统集成实现的关键在于解决系\n统',0,0,51,1492065054964,1492065054964),(352,'apache_solr_ref_guide_5.4.pdf','H:\\KnowledgebaseManagementSystem2.0\\out\\artifacts\\KnowledgebaseManagementSystem2_0_war_exploded\\save/b11c0563-1525-4b78-8da5-01c7ae9450ed-apache_solr_ref_guide_5.4.pdf',6394110,'pdf','\nApache Solr Reference Guide\n\nCovering Apache Solr 5.4\n\nLicensed to the Apache Software Foundation (ASF) under one\nor more contributor license agreeme',0,0,51,1492065788887,1492065788887),(353,'Solr_cloud_5.0_部署.docx','H:\\KnowledgebaseManagementSystem2.0\\out\\artifacts\\KnowledgebaseManagementSystem2_0_war_exploded\\save/29ba9dcb-a4f3-4443-a3e2-b417eed6f205-Solr_cloud_5.0_部署.docx',1045169,'docx','Solr cloud 5.0 部署\n1. 环境准备\n1.1. 服务器\n3个centos 6.2，2*4 核 2.2 cpu，16G内存，每个节点3块硬盘\n\n1.2. 部署计划\n	\n	solr\n	zookeeper\n\n	172.16.5.1\n	yes\n	no\n\n	172.16.5.2\n	yes\n	ye',0,0,51,1492066054820,1492066054820),(354,'solr相关连接.txt','H:\\KnowledgebaseManagementSystem2.0\\out\\artifacts\\KnowledgebaseManagementSystem2_0_war_exploded\\save/e8111bea-df7a-49c1-973c-fcfc85ded61a-solr相关连接.txt',559,'txt','http://www.ibm.com/developerworks/cn/java/j-solr1/index.html\r\nhttp://lucene.apache.org/solr/5_4_1/solr-solrj/index.html\r\nhttp://wiki.apache.org/solr/S',0,0,51,1492066068178,1492066068178);
/*!40000 ALTER TABLE `document` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-13 14:55:45
