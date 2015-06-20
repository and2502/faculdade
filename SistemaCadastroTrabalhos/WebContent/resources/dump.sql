CREATE DATABASE  IF NOT EXISTS `sistemaCadTrabalhos` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `sistemaCadTrabalhos`;
-- MySQL dump 10.13  Distrib 5.5.32, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: sistemaCadTrabalhos
-- ------------------------------------------------------
-- Server version	5.5.32-0ubuntu0.13.04.1

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
-- Table structure for table `ALUNO`
--

DROP TABLE IF EXISTS `ALUNO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ALUNO` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(255) DEFAULT NULL,
  `RM` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ALUNO`
--

LOCK TABLES `ALUNO` WRITE;
/*!40000 ALTER TABLE `ALUNO` DISABLE KEYS */;
INSERT INTO `ALUNO` VALUES (1,'Adercio Reinan','68689'),(2,'Paulo Santos','12523'),(3,'Joao Macedo','7858'),(4,'Andre Luiz','3045');
/*!40000 ALTER TABLE `ALUNO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CURSO`
--

DROP TABLE IF EXISTS `CURSO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CURSO` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CURSO`
--

LOCK TABLES `CURSO` WRITE;
/*!40000 ALTER TABLE `CURSO` DISABLE KEYS */;
INSERT INTO `CURSO` VALUES (1,'Java'),(2,'Banco de Dados'),(3,'Portugues');
/*!40000 ALTER TABLE `CURSO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CURSO_ALUNO`
--

DROP TABLE IF EXISTS `CURSO_ALUNO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CURSO_ALUNO` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ALUNO_ID` bigint(20) DEFAULT NULL,
  `CURSO_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_8iubcawkddy9vd5kw1auxhtbv` (`ALUNO_ID`),
  KEY `FK_8ijrwbupiiul5qhwnnyg54e9e` (`CURSO_ID`),
  CONSTRAINT `FK_8ijrwbupiiul5qhwnnyg54e9e` FOREIGN KEY (`CURSO_ID`) REFERENCES `CURSO` (`ID`),
  CONSTRAINT `FK_8iubcawkddy9vd5kw1auxhtbv` FOREIGN KEY (`ALUNO_ID`) REFERENCES `ALUNO` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CURSO_ALUNO`
--

LOCK TABLES `CURSO_ALUNO` WRITE;
/*!40000 ALTER TABLE `CURSO_ALUNO` DISABLE KEYS */;
INSERT INTO `CURSO_ALUNO` VALUES (1,1,1),(3,2,3),(4,3,1),(5,3,1),(6,4,2);
/*!40000 ALTER TABLE `CURSO_ALUNO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DISCIPLINA`
--

DROP TABLE IF EXISTS `DISCIPLINA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DISCIPLINA` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CARGA_HORARIA` int(11) DEFAULT NULL,
  `NOME` varchar(255) DEFAULT NULL,
  `curso_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_8c9dmktug36wcoo9iw41xwa0f` (`curso_ID`),
  CONSTRAINT `FK_8c9dmktug36wcoo9iw41xwa0f` FOREIGN KEY (`curso_ID`) REFERENCES `CURSO` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DISCIPLINA`
--

LOCK TABLES `DISCIPLINA` WRITE;
/*!40000 ALTER TABLE `DISCIPLINA` DISABLE KEYS */;
INSERT INTO `DISCIPLINA` VALUES (1,12,'JSTL',1),(2,30,'JSF',1),(3,56,'Oracle',2),(4,30,'Mysql',2),(5,20,'Gramatica',3);
/*!40000 ALTER TABLE `DISCIPLINA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `NOTA`
--

DROP TABLE IF EXISTS `NOTA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `NOTA` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `VALOR` double DEFAULT NULL,
  `aluno_ID` bigint(20) DEFAULT NULL,
  `disciplina_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_lq9olsv8do4ahr20nqcvuu2ki` (`aluno_ID`),
  KEY `FK_6549ce6f1wdjdwtrdrp5ok8lv` (`disciplina_ID`),
  CONSTRAINT `FK_6549ce6f1wdjdwtrdrp5ok8lv` FOREIGN KEY (`disciplina_ID`) REFERENCES `DISCIPLINA` (`ID`),
  CONSTRAINT `FK_lq9olsv8do4ahr20nqcvuu2ki` FOREIGN KEY (`aluno_ID`) REFERENCES `ALUNO` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `NOTA`
--

LOCK TABLES `NOTA` WRITE;
/*!40000 ALTER TABLE `NOTA` DISABLE KEYS */;
/*!40000 ALTER TABLE `NOTA` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-06-20  2:17:04
