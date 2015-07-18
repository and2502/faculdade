CREATE DATABASE  IF NOT EXISTS `sistemaReservaAerea` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `sistemaReservaAerea`;
-- MySQL dump 10.13  Distrib 5.5.32, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: sistemaReservaAerea
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
-- Table structure for table `CLASSE`
--

DROP TABLE IF EXISTS `CLASSE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CLASSE` (
  `ID_CLASSE` int(5) NOT NULL AUTO_INCREMENT,
  `DESCRICAO` varchar(45) DEFAULT NULL,
  `TAXA` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_CLASSE`),
  UNIQUE KEY `ID_CLASSE_UNIQUE` (`ID_CLASSE`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CLASSE`
--

LOCK TABLES `CLASSE` WRITE;
/*!40000 ALTER TABLE `CLASSE` DISABLE KEYS */;
INSERT INTO `CLASSE` VALUES (1,'Econômica',0),(2,'Executiva',10);
/*!40000 ALTER TABLE `CLASSE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `AEROPORTO`
--

DROP TABLE IF EXISTS `AEROPORTO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AEROPORTO` (
  `ID_AEROPORTO` int(10) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(100) NOT NULL,
  `LOCALIZACAO` varchar(100) NOT NULL,
  `LATITUDE` varchar(45) DEFAULT NULL,
  `LONGITUDE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_AEROPORTO`),
  UNIQUE KEY `ID_AEROPORTO_UNIQUE` (`ID_AEROPORTO`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AEROPORTO`
--

LOCK TABLES `AEROPORTO` WRITE;
/*!40000 ALTER TABLE `AEROPORTO` DISABLE KEYS */;
INSERT INTO `AEROPORTO` VALUES (1,'Aeroporto Luis Eduardo Magalhaes','Salvador','-12.910002','-38.331187'),(2,'Aeroporto Internacional Guarulhos','São Paulo','-23.434826','-46.475221'),(3,'Aeroporto Internacional Congonhas','São Paulo','-23.627163','-46.655726'),(4,'Aeroporto Guararapes Intl','Recife','-8.125251','-34.923501'),(5,'Aeroporto Santa Maria','Aracaju','-29.710797','-53.685411'),(6,'Aeroporto Presidente Juscelino Kubitschek','Brasília','-15.869734','-47.916892'),(7,'Aeroporto Salgado Filho','Porto Alegre','-29.994360','-51.175038'),(8,'Aeroporto Santos Dumont','Rio de Janeiro','-22.910665','-43.164877'),(9,'Aeroporto Hercilio Luz','Florianópolis','-27.669961','-48.546482'),(10,'Aeroporto Pinto Martins','Fortaleza','-3.776983','-38.532754');
/*!40000 ALTER TABLE `AEROPORTO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `VOO`
--

DROP TABLE IF EXISTS `VOO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `VOO` (
  `ID_VOO` int(10) NOT NULL AUTO_INCREMENT,
  `NR_VOO` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_VOO`),
  UNIQUE KEY `idVoo_UNIQUE` (`ID_VOO`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `VOO`
--

LOCK TABLES `VOO` WRITE;
/*!40000 ALTER TABLE `VOO` DISABLE KEYS */;
INSERT INTO `VOO` VALUES (1,'G2354'),(2,'G2355');
/*!40000 ALTER TABLE `VOO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CAPACIDADE_VOO`
--

DROP TABLE IF EXISTS `CAPACIDADE_VOO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CAPACIDADE_VOO` (
  `ID_CAPACIDADE_VOO` int(10) NOT NULL AUTO_INCREMENT,
  `QTDE_ASSENTO` int(11) NOT NULL,
  `ID_VOO` int(10) NOT NULL,
  `ID_CLASSE` int(5) NOT NULL,
  PRIMARY KEY (`ID_CAPACIDADE_VOO`),
  UNIQUE KEY `ID_CAPACIDADE_VOO_UNIQUE` (`ID_CAPACIDADE_VOO`),
  KEY `fk_CAPACIDADE_VOO_Voo1` (`ID_VOO`),
  KEY `fk_CAPACIDADE_VOO_Classe1` (`ID_CLASSE`),
  CONSTRAINT `fk_CAPACIDADE_VOO_Classe1` FOREIGN KEY (`ID_CLASSE`) REFERENCES `CLASSE` (`ID_CLASSE`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_CAPACIDADE_VOO_Voo1` FOREIGN KEY (`ID_VOO`) REFERENCES `VOO` (`ID_VOO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CAPACIDADE_VOO`
--

LOCK TABLES `CAPACIDADE_VOO` WRITE;
/*!40000 ALTER TABLE `CAPACIDADE_VOO` DISABLE KEYS */;
INSERT INTO `CAPACIDADE_VOO` VALUES (1,30,1,2),(2,90,1,1),(4,15,2,2),(5,60,2,1);
/*!40000 ALTER TABLE `CAPACIDADE_VOO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TRECHO`
--

DROP TABLE IF EXISTS `TRECHO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TRECHO` (
  `ID_TRECHO` int(15) NOT NULL AUTO_INCREMENT,
  `HORARIO_PARTIDA` datetime NOT NULL,
  `HORARIO_CHEGADA` datetime NOT NULL,
  `PRECO` double NOT NULL,
  `ID_AEROPORTO_ORIGEM` int(10) NOT NULL,
  `ID_AEROPORTO_DESTINO` int(10) NOT NULL,
  `ID_VOO` int(10) NOT NULL,
  PRIMARY KEY (`ID_TRECHO`),
  UNIQUE KEY `idTrecho_UNIQUE` (`ID_TRECHO`),
  KEY `fk_Trecho_Aeroporto1` (`ID_AEROPORTO_ORIGEM`),
  KEY `fk_Trecho_Aeroporto2` (`ID_AEROPORTO_DESTINO`),
  KEY `fk_Trecho_Voo1` (`ID_VOO`),
  CONSTRAINT `fk_Trecho_Aeroporto1` FOREIGN KEY (`ID_AEROPORTO_ORIGEM`) REFERENCES `AEROPORTO` (`ID_AEROPORTO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Trecho_Aeroporto2` FOREIGN KEY (`ID_AEROPORTO_DESTINO`) REFERENCES `AEROPORTO` (`ID_AEROPORTO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Trecho_Voo1` FOREIGN KEY (`ID_VOO`) REFERENCES `VOO` (`ID_VOO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TRECHO`
--

LOCK TABLES `TRECHO` WRITE;
/*!40000 ALTER TABLE `TRECHO` DISABLE KEYS */;
/*!40000 ALTER TABLE `TRECHO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ASSENTO`
--

DROP TABLE IF EXISTS `ASSENTO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ASSENTO` (
  `ID_ASSENTO` int(10) NOT NULL AUTO_INCREMENT,
  `ID_CLASSE` int(5) NOT NULL,
  `NR_ASSENTO` varchar(45) NOT NULL,
  `POSICAO` varchar(1) NOT NULL,
  PRIMARY KEY (`ID_ASSENTO`),
  UNIQUE KEY `idAssento_UNIQUE` (`ID_ASSENTO`),
  KEY `fk_Assento_Classe1` (`ID_CLASSE`),
  CONSTRAINT `fk_Assento_Classe1` FOREIGN KEY (`ID_CLASSE`) REFERENCES `CLASSE` (`ID_CLASSE`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ASSENTO`
--

LOCK TABLES `ASSENTO` WRITE;
/*!40000 ALTER TABLE `ASSENTO` DISABLE KEYS */;
INSERT INTO `ASSENTO` VALUES (1,2,'1','A'),(2,2,'2','A'),(3,2,'3','A'),(4,2,'4','A'),(5,2,'5','A'),(6,2,'1','B'),(7,2,'2','B'),(8,2,'3','B'),(9,2,'4','B'),(10,2,'5','B'),(11,2,'1','C'),(12,2,'2','C'),(13,2,'3','C'),(14,2,'4','C'),(15,2,'5','C'),(16,2,'1','D'),(17,2,'2','D'),(18,2,'3','D'),(19,2,'4','D'),(20,2,'5','D'),(21,2,'1','F'),(22,2,'2','F'),(23,2,'3','F'),(24,2,'4','F'),(25,2,'5','F'),(26,2,'1','G'),(27,2,'2','G'),(28,2,'3','G'),(29,2,'4','G'),(30,2,'5','G'),(31,1,'6','A'),(32,1,'7','A'),(33,1,'8','A'),(34,1,'9','A'),(35,1,'10','A'),(36,1,'11','A'),(37,1,'12','A'),(38,1,'13','A'),(39,1,'14','A'),(40,1,'15','A'),(41,1,'16','A'),(42,1,'17','A'),(43,1,'18','A'),(44,1,'19','A'),(45,1,'20','A'),(46,1,'6','B'),(47,1,'7','B'),(48,1,'8','B'),(49,1,'9','B'),(50,1,'10','B'),(51,1,'11','B'),(52,1,'12','B'),(53,1,'13','B'),(54,1,'14','B'),(55,1,'15','B'),(56,1,'16','B'),(57,1,'17','B'),(58,1,'18','B'),(59,1,'19','B'),(60,1,'20','B'),(61,1,'6','C'),(62,1,'7','C'),(63,1,'8','C'),(64,1,'9','C'),(65,1,'10','C'),(66,1,'11','C'),(67,1,'12','C'),(68,1,'13','C'),(69,1,'14','C'),(70,1,'15','C'),(71,1,'16','C'),(72,1,'17','C'),(73,1,'18','C'),(74,1,'19','C'),(75,1,'20','C'),(76,1,'6','D'),(77,1,'7','D'),(78,1,'8','D'),(79,1,'9','D'),(80,1,'10','D'),(81,1,'11','D'),(82,1,'12','D'),(83,1,'13','D'),(84,1,'14','D'),(85,1,'15','D'),(86,1,'16','D'),(87,1,'17','D'),(88,1,'18','D'),(89,1,'19','D'),(90,1,'20','D'),(91,1,'6','F'),(92,1,'7','F'),(93,1,'8','F'),(94,1,'9','F'),(95,1,'10','F'),(96,1,'11','F'),(97,1,'12','F'),(98,1,'13','F'),(99,1,'14','F'),(100,1,'15','F'),(101,1,'16','F'),(102,1,'17','F'),(103,1,'18','F'),(104,1,'19','F'),(105,1,'20','F'),(106,1,'6','G'),(107,1,'7','G'),(108,1,'8','G'),(109,1,'9','G'),(110,1,'10','G'),(111,1,'11','G'),(112,1,'12','G'),(113,1,'13','G'),(114,1,'14','G'),(115,1,'15','G'),(116,1,'16','G'),(117,1,'17','G'),(118,1,'18','G'),(119,1,'19','G'),(120,1,'20','G');
/*!40000 ALTER TABLE `ASSENTO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LOGIN`
--

DROP TABLE IF EXISTS `LOGIN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LOGIN` (
  `ID_LOGIN` int(15) NOT NULL AUTO_INCREMENT,
  `USUARIO` varchar(45) NOT NULL,
  `SENHA` varchar(45) NOT NULL,
  `ADMIN` char(1) NOT NULL,
  `ID_CLIENTE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_LOGIN`),
  UNIQUE KEY `ID_LOGIN_UNIQUE` (`ID_LOGIN`),
  UNIQUE KEY `USUARIO_UNIQUE` (`USUARIO`),
  KEY `FK_gpwg14bs3pqvdorq0f6t81nl8` (`ID_CLIENTE`),
  CONSTRAINT `FK_gpwg14bs3pqvdorq0f6t81nl8` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `CLIENTE` (`ID_CLIENTE`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LOGIN`
--

LOCK TABLES `LOGIN` WRITE;
/*!40000 ALTER TABLE `LOGIN` DISABLE KEYS */;
INSERT INTO `LOGIN` VALUES (1,'adercio@gmail.com','adercio','N',1),(2,'cristiano@gmail.com','cristiano','N',2),(3,'anderson@gmail.com','anderson','N',3),(4,'admin@gmail.com','admin','S',4);
/*!40000 ALTER TABLE `LOGIN` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RESERVA`
--

DROP TABLE IF EXISTS `RESERVA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RESERVA` (
  `ID_RESERVA` int(15) NOT NULL AUTO_INCREMENT,
  `ID_CLIENTE` int(15) NOT NULL,
  `ID_ASSENTO` int(10) NOT NULL,
  `ID_VOO` int(10) NOT NULL,
  PRIMARY KEY (`ID_RESERVA`),
  UNIQUE KEY `ID_RESERVA_UNIQUE` (`ID_RESERVA`),
  KEY `fk_Reserva_Cliente1` (`ID_CLIENTE`),
  KEY `fk_Reserva_Assento1` (`ID_ASSENTO`),
  KEY `fk_Reserva_Voo1` (`ID_VOO`),
  CONSTRAINT `fk_Reserva_Assento1` FOREIGN KEY (`ID_ASSENTO`) REFERENCES `ASSENTO` (`ID_ASSENTO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Cliente1` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `CLIENTE` (`ID_CLIENTE`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Voo1` FOREIGN KEY (`ID_VOO`) REFERENCES `VOO` (`ID_VOO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RESERVA`
--

LOCK TABLES `RESERVA` WRITE;
/*!40000 ALTER TABLE `RESERVA` DISABLE KEYS */;
/*!40000 ALTER TABLE `RESERVA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CLIENTE`
--

DROP TABLE IF EXISTS `CLIENTE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CLIENTE` (
  `ID_CLIENTE` int(15) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(45) NOT NULL,
  `ID_LOGIN` int(15) NOT NULL,
  PRIMARY KEY (`ID_CLIENTE`,`ID_LOGIN`),
  UNIQUE KEY `ID_CLIENTE_UNIQUE` (`ID_CLIENTE`),
  KEY `fk_Cliente_Login1` (`ID_LOGIN`),
  CONSTRAINT `fk_Cliente_Login1` FOREIGN KEY (`ID_LOGIN`) REFERENCES `LOGIN` (`ID_LOGIN`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CLIENTE`
--

LOCK TABLES `CLIENTE` WRITE;
/*!40000 ALTER TABLE `CLIENTE` DISABLE KEYS */;
INSERT INTO `CLIENTE` VALUES (1,'Adercio Reinan',1),(2,'Cristiano',2),(3,'Anderson',3),(4,'Administrador',4);
/*!40000 ALTER TABLE `CLIENTE` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-17 22:27:38
