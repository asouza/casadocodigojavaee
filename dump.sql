-- MySQL dump 10.13  Distrib 5.6.21, for osx10.8 (x86_64)
--
-- Host: localhost    Database: casadocodigo_javaee
-- ------------------------------------------------------
-- Server version	5.6.21

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
-- Table structure for table `Author`
--

DROP TABLE IF EXISTS `Author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Author`
--

LOCK TABLES `Author` WRITE;
/*!40000 ALTER TABLE `Author` DISABLE KEYS */;
INSERT INTO `Author` VALUES (1,'Alberto Souza'),(2,'Mauricio Aniche'),(3,'Adriano Almeida'),(4,'Paulo Silveira'),(5,'Sergio Lopes');
/*!40000 ALTER TABLE `Author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Book`
--

DROP TABLE IF EXISTS `Book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `numberOfPages` int(11) NOT NULL,
  `coverPath` varchar(255) DEFAULT NULL,
  `releaseDate` datetime DEFAULT NULL,
  `summaryPath` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Book`
--

LOCK TABLES `Book` WRITE;
/*!40000 ALTER TABLE `Book` DISABLE KEYS */;
INSERT INTO `Book` VALUES (2,'livro super legal de scala',100.00,'Scala como programar',100,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(3,'esse livro vai ter ensinar tudo sobre testes',90.00,'Testando do inicio ao fim',200,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(4,'aprenda nesse livro top, como sair do zero com o phyton',60.00,'Phyton como programar',150,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(5,'descricao sobre o java pratico',100.00,'Java pratico',200,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(6,'Livro sobre java8',200.00,'Java 8',250,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(7,'descricao sobre photoshop',100.00,'Photoshop',200,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(8,'linguagem muito louca',100.00,'Lua',100,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(9,'coloque seu site nas alturas',50.00,'SEO',100,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(10,'teste e fique feliz',90.00,'TDD',200,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(11,'livro de play para deixar vc produtivo',100.00,'Play',200,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(12,'descricao da descricao',100.00,'SEO',200,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(13,'descricao do livro',40.00,'Livro sobre wildfly',100,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(14,'esse livro é muito legal sobre o tomcat',100.00,'Livro sobre tomcat',200,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(15,'89407598437594578497589475748397',100.00,'livro sobre unity',100,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(16,'descricao',100.00,'teste',100,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(17,'descricao de teste',100.00,'teste',100,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(18,'descriacao de teste',100.00,'teste',100,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(19,'sera? sera? sera?',50.00,'nao eh possivel',100,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(20,'teste de livro bem legal.....kfdfjkhdsfhjdksfhjkdshfjkdhfjkhdskjfhds',50.00,'Javascrupt',100,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(21,'Ã© um livro muito legal!!kfjdklfdsjfjdslkjfdkls',50.00,'livro sobre ios',200,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(22,'lkjdkfjhdsfhkdshfkdsjkfdkshf jkdsfhjkd kfdhsjkfhdjkshf kdhjk dkfdsdfkfhdjkhfjkdshf kdsh',80.00,'Livro sobre ocaml',100,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(27,'analise estÃ¡tica de cÃ³digomdsjlfkdjkfldsjfjdklsjflkdjflksdjfldks',100.00,'infer',200,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(28,'analise estática de códigomdsjlfkdjkfldsjfjdklsjflkdjflksdjfldks',100.00,'infer',200,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(29,'ferramenta para analise de cÃ³digo.mfdslkfjdklsjflkdsjkfdlsjfkldsjf',50.00,'livro sobre gelatto',100,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(30,'kjhjkhgk hjkh jkh hjkhjkhjkhjkh jkhj jkhjkh jkhjkhj hjkhjkhkhj',80.00,'lidando com legado',100,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(31,'kjhjkhgk hjkh jkh hjkhjkhjkhjkh jkhj jkhjkh jkhjkhj hjkhjkhkhj',80.00,'lidando com legado',100,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(32,'aniche vai escrever, top!kjfdlkjfkldsjlfjdslkfjdklsjfkldjsfkldjsklfsd',40.00,'Livro sobre ddd',100,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(33,'ajkfldjflkjds fjdlksjflksd lkfjdskfldksj flkdsj flkjdslkfjdsklf jdjflkdsjf lksd',60.00,'orientacao a objetos em php',200,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(34,'jlhfdkhfd skjdfhj kdsdfksfhjk dsdsjkfdhsjk fhkdjsf dhsfds kf',50.00,'java bÃ¡sico',250,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(35,'kfljdkl sjfdkls flkdjs flkdsjfk dslk fjkdlsjfkdsjkfjdslkfj dskl jfkds',56.78,'livro sobre lua2',170,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(36,'kfjdslfjdslkj fkldjlf jdskljflkds flkjdklfdklsjflkdsklfdjsldsjfkldsj lk',50.00,'Mais um livro de teste',100,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(37,'kfjdslfjdslkj fkldjlf jdskljflkds flkjdklfdklsjflkdsklfdjsldsjfkldsj lk',50.00,'Mais um livro de teste',100,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(38,'lkfdjsflkjds fldskjfkl dslkfjdksl flkdjsfk s',100.00,'teste',350,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(39,'lkfdjsflkjds fldskjfkl dslkfjdksl flkdjsfk s',100.00,'teste',350,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(40,'klfjhdskhfdkshfjkdshfhdsjfhjkdshfkjhsdfhdjsfhjkdshfjkdshfjkdshfjk',50.00,'teste',200,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(41,'lfjdfhsdjfjkdshfkjsdhfkjhdjkfhdsjkhfjkdsh',100.00,'mais um teste',200,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(42,'klfhdkjfhds fdshjkf kdsfhkfhdskjf kjdhkjd dhsfds',67.50,'ocaml',200,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(43,'jdkaljfld lfdjslf ksdjfklsd fjdskfjkdsl fklds jfklds jlfdjklsfjskdl',200.00,'novo livro',350,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(44,'',NULL,'',0,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true',NULL,NULL),(45,'lfjfldlkfjsdkljfkldsj flkjsdklfjdlks jfkldsjkfljdsk lfjdklsjfkldsj fdsj',100.00,'Ilustrator',300,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true','2015-06-26 21:00:00',NULL),(52,'jklfdskljf kdsjfkdkl fksdjfkld jkfljkdsfl dlkfj',100.00,'Novo titulo',200,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true','2015-06-14 21:00:00',NULL),(53,'dkjakfdklfjdskl jfsdljf kldsjfjs d fjkdlsjf',100.00,'Livro com sumário',200,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true','2015-06-25 21:00:00','covers/contaluz.pdf'),(54,'fjdkljfdskljfkldsjfkldsjdksjklfdjfklsd',100.00,'mais um livro',200,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true','2015-06-29 21:00:00','http://localhost:9444/s3/casadocodigo/roteiro.txt?noAuth=true'),(55,'klfjdklfjdsklfjdkljfkldsjflkdjsklfjdslfjdsk',100.00,'livro de css',200,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true','2015-06-23 21:00:00','http://localhost:9444/s3/casadocodigo/roteiro.txt?noAuth=true'),(56,'fdkljflkdjklfsjdklfjdksljfkldjfkldsjkfldjsklfjdskljflkdsjfkldsjfkljdsklj',100.00,'mais um teste',200,'http://localhost:9444/s3/casadocodigo/covers_games-android-featured_medium.png?noAuth=true','2015-06-15 21:00:00','http://localhost:9444/s3/casadocodigo/summaries_games-android-featured_medium.png?noAuth=true'),(57,'jfdksfjdslk',100.00,'teste de invalidacao',100,'http://localhost:9444/s3/casadocodigo/covers_IMG_3766.JPG?noAuth=true','2015-07-24 21:00:00','http://localhost:9444/s3/casadocodigo/summaries_instrutores.txt?noAuth=true'),(58,'descricao do livro de nodejs',100.00,'nodejs',100,'http://localhost:9444/s3/casadocodigo/covers_IMG_3766.JPG?noAuth=true','2015-07-24 21:00:00','http://localhost:9444/s3/casadocodigo/summaries_instrutores.txt?noAuth=true'),(59,'kfjdklfjdsklfds- atualizando- atualizando- atualizando- atualizando- atualizando',100.00,'teste de update',100,'http://localhost:9444/s3/casadocodigo/covers_IMG_3766.JPG?noAuth=true','2015-07-21 21:00:00','http://localhost:9444/s3/casadocodigo/summaries_instrutores.txt?noAuth=true'),(60,'oxi oxi oxi- atualizando',100.00,'heizenberg',100,'http://localhost:9444/s3/casadocodigo/covers_IMG_3766.JPG?noAuth=true','2015-07-21 21:00:00','http://localhost:9444/s3/casadocodigo/summaries_perfis-necesssarios.txt?noAuth=true'),(61,'klfjdsklfjsjklj',100.00,'mais um teste',200,'http://localhost:9444/s3/casadocodigo/covers_IMG_3766.JPG?noAuth=true','2015-08-18 21:00:00','http://localhost:9444/s3/casadocodigo/summaries_IMG_3766.JPG?noAuth=true'),(62,'descricao do livro',100.00,'Nodejs',100,'http://localhost:9444/s3/casadocodigo/covers_IMG_3766.JPG?noAuth=true','2015-11-25 22:00:00','http://localhost:9444/s3/casadocodigo/summaries_IMG_3766.JPG?noAuth=true');
/*!40000 ALTER TABLE `Book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Book_Author`
--

DROP TABLE IF EXISTS `Book_Author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Book_Author` (
  `Book_id` int(11) NOT NULL,
  `authors_id` int(11) NOT NULL,
  KEY `FK_7eh8vdpvmuq00lsf7ysuyqkji` (`authors_id`),
  KEY `FK_4qw8at30wfg1sg7r80oho6a42` (`Book_id`),
  CONSTRAINT `FK_4qw8at30wfg1sg7r80oho6a42` FOREIGN KEY (`Book_id`) REFERENCES `Book` (`id`),
  CONSTRAINT `FK_7eh8vdpvmuq00lsf7ysuyqkji` FOREIGN KEY (`authors_id`) REFERENCES `Author` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Book_Author`
--

LOCK TABLES `Book_Author` WRITE;
/*!40000 ALTER TABLE `Book_Author` DISABLE KEYS */;
INSERT INTO `Book_Author` VALUES (2,3),(2,1),(3,2),(4,4),(4,5),(5,3),(5,1),(6,3),(6,1),(7,2),(7,4),(8,4),(8,5),(9,3),(10,2),(11,1),(11,2),(12,3),(13,3),(13,1),(14,1),(14,2),(14,4),(20,3),(20,1),(20,2),(21,3),(21,1),(21,2),(22,2),(22,4),(22,5),(27,2),(28,2),(29,3),(29,1),(29,2),(30,3),(30,1),(30,2),(31,3),(31,1),(31,2),(32,3),(32,1),(32,2),(32,4),(32,5),(33,1),(33,2),(34,3),(34,1),(34,2),(35,3),(35,1),(35,2),(36,3),(36,1),(36,2),(37,3),(37,1),(37,2),(38,3),(38,1),(38,2),(38,4),(39,3),(39,1),(39,2),(39,4),(40,4),(40,5),(41,3),(41,1),(42,3),(42,1),(43,3),(43,1),(43,2),(45,3),(45,1),(45,2),(52,3),(52,1),(52,2),(53,3),(53,1),(54,3),(54,1),(55,3),(55,1),(55,2),(56,3),(56,1),(56,2),(57,3),(57,1),(57,2),(58,3),(58,1),(58,2),(59,3),(59,1),(59,2),(59,4),(60,4),(60,5),(61,1),(61,2),(62,3),(62,1),(62,2);
/*!40000 ALTER TABLE `Book_Author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Checkout`
--

DROP TABLE IF EXISTS `Checkout`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Checkout` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jsonCart` varchar(255) DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  `value` decimal(19,2) DEFAULT NULL,
  `buyer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_4njucqhufxedeqhcykkq5x4i2` (`buyer_id`),
  CONSTRAINT `FK_4njucqhufxedeqhcykkq5x4i2` FOREIGN KEY (`buyer_id`) REFERENCES `SystemUser` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Checkout`
--

LOCK TABLES `Checkout` WRITE;
/*!40000 ALTER TABLE `Checkout` DISABLE KEYS */;
INSERT INTO `Checkout` VALUES (1,'[{\"title\":\"mais um teste\",\"price\":100.00,\"quantity\":1,\"sum\":100.00}]','85f6e0a5-0282-4651-91d2-dd801bfcd652',100.00,1),(2,'[{\"title\":\"mais um teste\",\"price\":100.00,\"quantity\":1,\"sum\":100.00}]','79416091-18f0-4177-81ee-c89168802550',100.00,3),(3,'[{\"title\":\"mais um teste\",\"price\":100.00,\"quantity\":1,\"sum\":100.00}]','383c4a30-b6b7-493c-85dd-f1097cf175c4',100.00,4),(4,'[{\"title\":\"mais um teste\",\"price\":100.00,\"quantity\":1,\"sum\":100.00}]','67e0a4a1-16e3-4009-bb67-f498752809a5',100.00,5),(5,'[{\"title\":\"mais um teste\",\"price\":100.00,\"quantity\":1,\"sum\":100.00}]','34ae640c-aef5-4cb2-94ff-3a66695d40f3',100.00,6),(6,'[{\"title\":\"mais um teste\",\"price\":100.00,\"quantity\":1,\"sum\":100.00}]','53144aa2-8b84-469e-a30c-52cea2e3d430',100.00,7),(7,'[{\"title\":\"mais um teste\",\"price\":100.00,\"quantity\":1,\"sum\":100.00}]','b85144d5-4c41-4184-9500-b6188aaf372d',100.00,8),(8,'[{\"title\":\"mais um teste\",\"price\":100.00,\"quantity\":1,\"sum\":100.00}]','e4dc67dd-9f80-4e6d-97e8-0bd24010d0aa',100.00,9),(9,'[{\"title\":\"mais um teste\",\"price\":100.00,\"quantity\":1,\"sum\":100.00}]','de74b4ab-67e9-42dc-b71c-ded3b4d6f578',100.00,10),(10,'[{\"title\":\"Java 8\",\"price\":200.00,\"quantity\":1,\"sum\":200.00}]','8965e6c1-836e-43a7-bd6c-0124184cd2fb',200.00,11),(11,'[{\"title\":\"mais um teste\",\"price\":100.00,\"quantity\":6,\"sum\":600.00}]','c673cadd-de35-404b-a900-bade4d01bf23',600.00,12),(12,'[{\"title\":\"heizenberg\",\"price\":100.00,\"quantity\":1,\"sum\":100.00}]','ccac2a29-b4c0-495a-b600-6964ab2e6c75',100.00,13),(13,'[{\"title\":\"heizenberg\",\"price\":100.00,\"quantity\":1,\"sum\":100.00}]','1e7fa05a-6c8f-498d-a549-a8dcf5e9d179',100.00,14),(14,'[{\"title\":\"heizenberg\",\"price\":100.00,\"quantity\":1,\"sum\":100.00},{\"title\":\"nodejs\",\"price\":100.00,\"quantity\":1,\"sum\":100.00}]','f3fe7210-cedc-4c69-903b-8942741105e1',200.00,15),(15,'[{\"title\":\"mais um teste\",\"price\":100.00,\"quantity\":1,\"sum\":100.00}]','64a04680-4871-456e-a9c6-fa79634e708a',100.00,16),(16,'[{\"title\":\"heizenberg\",\"price\":100.00,\"quantity\":1,\"sum\":100.00}]','67b2d0f8-fe39-422a-b823-8d38af5d17d0',100.00,17),(17,'[{\"title\":\"teste de update\",\"price\":100.00,\"quantity\":1,\"sum\":100.00}]','3bb04cc0-ec14-4711-bfa1-85046bd1e7e3',100.00,18);
/*!40000 ALTER TABLE `Checkout` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SystemRole`
--

DROP TABLE IF EXISTS `SystemRole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SystemRole` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SystemRole`
--

LOCK TABLES `SystemRole` WRITE;
/*!40000 ALTER TABLE `SystemRole` DISABLE KEYS */;
INSERT INTO `SystemRole` VALUES ('ADMIN'),('ROLE_ADMIN'),('ROLE_COMPRADOR');
/*!40000 ALTER TABLE `SystemRole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SystemUser`
--

DROP TABLE IF EXISTS `SystemUser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SystemUser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `postalCode` varchar(255) DEFAULT NULL,
  `socialId` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_g0wn8uulhr2dyjo956v9pd56q` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SystemUser`
--

LOCK TABLES `SystemUser` WRITE;
/*!40000 ALTER TABLE `SystemUser` DISABLE KEYS */;
INSERT INTO `SystemUser` VALUES (1,'Rua Calixto da mota, No 36','Sao Paulo','Brasil','teste1@gmail.com','Alberto','Souza','jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=','90578309574534','04117100','95749057454','SP'),(2,NULL,NULL,NULL,'admin@casadocodigo.com.br',NULL,NULL,'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=',NULL,NULL,NULL,NULL),(3,'vila mariana','Sao Paulo','Brasil','teste15@gmail.com','Alberto','Souza','$2a$10$PsfF8AWrzHSunxJ9yPeL2e3QM/QIjaZJS5fmfck.zNSVp9t54qAmK','89048534','954873','75489037504379','9075409875'),(4,'Rua Calixto da mota, No 36','Sao Paulo','Brasil','teste14@gmail.com','Alberto','Souza','$2a$10$FeeT0HlY7x0.xvcTWd4xXemk0T.xPhxtPcGdaFMUb9pBfLuhu2D9y','54354543','04117100','9584905435','SP'),(5,'Rua Calixto da mota, No 36','Sao Paulo','Brasil','teste10@gmail.com','Alberto','Souza','$2a$10$iS.rCX7ZGNN8IRR5pQ4oLuSbprFg.jifxorLsa9eRT6zbMHCgMD0m','54543543534','04117100','90584390543','SP'),(6,'Rua Calixto da mota, No 36','Sao Paulo','Brasil','teste8@gmail.com','Alberto','Souza','$2a$10$AZQ6WcFjdLOHukbgkByNpOTmEH74jwLOTWuMIpu.whi.6xJKUX.Ee','543534534543','04117100','57489574354','SP'),(7,'Rua Calixto da mota, No 36','Sao Paulo','Brasil','teste30@gmail.com','Alberto','Souza','$2a$10$I9H5iOu2uAjcRNX.NeMIU.32Ef6lPEeoxU1sQV7.9JW2EvGSMqa.2','56645654476','04117100','90854039578934','SP'),(8,'Rua Calixto da mota, No 36','Sao Paulo','Brasil','teste31@gmail.com','Alberto','Souza','$2a$10$qdsyNgbEbglnzygMMAl0XeHasKZ4RELGYlgrsFgjeS9//g6VVzhyq','64565757567','04117100','7865868469854','SP'),(9,'Rua Calixto da mota, No 36','Sao Paulo','Brasil','teste32@gmail.com','Alberto','Souza','$2a$10$P6tU90N4k3oANGoD.lVM2.xMdUGurtUntNYQ/.jIIXUe3VOOhdrpG','89754986746','04117100','98765974698576','SP'),(10,'Rua Calixto da mota, No 36','Sao Paulo','Brasil','teste33@gmail.com','Alberto','Souza','$2a$10$VB2uGIdH5t9muBZaxYQpc.lhgJg4m2z2hwuWApAVHCEpaiKBW9WGe','89756498674','04117100','90754985749','SP'),(11,'aaaa','aaa','Brasil','slopes@gmail.com','S','S','$2a$10$CTRd.x1XTRp6KWlE/o/XMu/o9CWvTjG6aaPlCJxi.sz9Mwp1ACxmu','87687687','576576567','1111111','aaa'),(12,'Rua Calixto da mota, No 36','Sao Paulo','Brasil','teste40@gmail.com','Alberto','Souza','$2a$10$n859SZ2HTOD9/DrkGfE4gO8xqDbEIGZ5aqEZktv4ydbnVBTe4PPG2','8574389543','04117100','908754309574938743','SP'),(13,'Rua Calixto da mota, No 36','Sao Paulo','Brasil','teste41@gmail.com','Alberto','Souza','$2a$10$9LAyUH3163vSr9ovYfx0t.d0JR9Tsz54wIUkuVqfFIfG9FnQu.nFa','8574389543','04117100','56748964465465','SP'),(14,'Rua Calixto da mota, No 36','Sao Paulo','Brasil','teste42@gmail.com','Alberto','Souza','$2a$10$gQjmF4Z.OZish2O794YdpuHEmQTNd38RjypGSSQeaj5zYJAOyWSqq','8574389543','04117100','8409583543354','SP'),(15,'Rua Calixto da mota, No 36','Sao Paulo','Brasil','teste43@gmail.com','Alberto','Souza','$2a$10$i5INzkqKlZPRfmjBkhk48uvc718PYVR39Z1Z9S0nJ/u7.EKokvN4W','8574389543','04117100','98907853454','SP'),(16,'Rua Calixto da mota, No 36','Sao Paulo','Brasil','teste44@gmail.com','Alberto','Souza','$2a$10$6bCAOhdS50RzwTMtSX/8OufgxdYJ33VZR0SG1jc3H8AdhXjrahWGa','8574389543','04117100','05894095830954','SP'),(17,'Rua Calixto da mota, No 36','Sao Paulo','Brasil','teste45@gmail.com','Alberto','Souza','$2a$10$ar82PyYkmvnKble4/CVsLOjdQ943YaOCJjw5qA8lenKETdMaqiMfW','8574389543','04117100','59437598437543354','SP'),(18,'Rua Calixto da mota, No 36','Sao Paulo','Brasil','teste46@gmail.com','Alberto','Souza','$2a$10$CXWxEfY26X1PToB6vOmrUOdp//MJzALCtayzG58vVA947yvtAEpvW','8574389543','04117100','59437598437543354','SP');
/*!40000 ALTER TABLE `SystemUser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SystemUser_SystemRole`
--

DROP TABLE IF EXISTS `SystemUser_SystemRole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SystemUser_SystemRole` (
  `SystemUser_id` int(11) NOT NULL,
  `roles_name` varchar(255) NOT NULL,
  KEY `FK_lagio4887nghbr306im636gl8` (`roles_name`),
  KEY `FK_jblql6bqxcvoh8trys10nkqix` (`SystemUser_id`),
  CONSTRAINT `FK_jblql6bqxcvoh8trys10nkqix` FOREIGN KEY (`SystemUser_id`) REFERENCES `SystemUser` (`id`),
  CONSTRAINT `FK_lagio4887nghbr306im636gl8` FOREIGN KEY (`roles_name`) REFERENCES `SystemRole` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SystemUser_SystemRole`
--

LOCK TABLES `SystemUser_SystemRole` WRITE;
/*!40000 ALTER TABLE `SystemUser_SystemRole` DISABLE KEYS */;
INSERT INTO `SystemUser_SystemRole` VALUES (1,'ROLE_COMPRADOR'),(2,'ADMIN'),(3,'ROLE_COMPRADOR'),(4,'ROLE_COMPRADOR'),(5,'ROLE_COMPRADOR'),(6,'ROLE_COMPRADOR'),(7,'ROLE_COMPRADOR'),(8,'ROLE_COMPRADOR'),(9,'ROLE_COMPRADOR'),(10,'ROLE_COMPRADOR'),(11,'ROLE_COMPRADOR'),(12,'ROLE_COMPRADOR'),(13,'ROLE_COMPRADOR'),(14,'ROLE_COMPRADOR'),(15,'ROLE_COMPRADOR'),(16,'ROLE_COMPRADOR'),(17,'ROLE_COMPRADOR'),(18,'ROLE_COMPRADOR');
/*!40000 ALTER TABLE `SystemUser_SystemRole` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-26 19:32:59
