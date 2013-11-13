/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50612
Source Host           : localhost:3306
Source Database       : portal-desenv

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2013-11-13 10:41:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_cliente
-- ----------------------------
DROP TABLE IF EXISTS `tb_cliente`;
CREATE TABLE `tb_cliente` (
  `TB_CD_ID_PK` bigint(20) NOT NULL AUTO_INCREMENT,
  `usuario` tinyblob,
  `NU_CPF` bigint(20) DEFAULT NULL,
  `DT_NASCIMENTO` datetime DEFAULT NULL,
  `DS_EMAIL` varchar(255) DEFAULT NULL,
  `DS_BAIRRO` varchar(255) DEFAULT NULL,
  `DS_CEP` varchar(255) DEFAULT NULL,
  `DS_CIDADE` varchar(255) DEFAULT NULL,
  `DS_COMPLEMENTO` varchar(255) DEFAULT NULL,
  `DS_ESTADO` varchar(255) DEFAULT NULL,
  `DS_LOGRADOURO` varchar(255) DEFAULT NULL,
  `DS_NUMERO` varchar(255) DEFAULT NULL,
  `DS_TP_LOGRADOURO` varchar(255) DEFAULT NULL,
  `DS_NOME` varchar(255) DEFAULT NULL,
  `NU_CELULAR` bigint(20) DEFAULT NULL,
  `numCelularString` varchar(255) DEFAULT NULL,
  `NU_TELEFONE` bigint(20) DEFAULT NULL,
  `numTelefoneString` varchar(255) DEFAULT NULL,
  `USUARIO_FK` bigint(20) NOT NULL,
  PRIMARY KEY (`TB_CD_ID_PK`),
  UNIQUE KEY `NU_CPF` (`NU_CPF`),
  KEY `FK4C647509CB811E40` (`USUARIO_FK`),
  CONSTRAINT `FK4C647509CB811E40` FOREIGN KEY (`USUARIO_FK`) REFERENCES `tb_usuario` (`TB_CD_ID_PK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_cliente
-- ----------------------------

-- ----------------------------
-- Table structure for tb_empresa
-- ----------------------------
DROP TABLE IF EXISTS `tb_empresa`;
CREATE TABLE `tb_empresa` (
  `TB_CD_ID_PK` bigint(20) NOT NULL AUTO_INCREMENT,
  `usuario` tinyblob,
  `NU_CNPJ` bigint(20) DEFAULT NULL,
  `DS_BAIRRO` varchar(255) DEFAULT NULL,
  `DS_CEP` varchar(255) DEFAULT NULL,
  `DS_CIDADE` varchar(255) DEFAULT NULL,
  `DS_COMPLEMENTO` varchar(255) DEFAULT NULL,
  `DS_ESTADO` varchar(255) DEFAULT NULL,
  `DS_LOGRADOURO` varchar(255) DEFAULT NULL,
  `DS_NUMERO` varchar(255) DEFAULT NULL,
  `DS_TP_LOGRADOURO` varchar(255) DEFAULT NULL,
  `DS_RAZAO_SOCIAL` varchar(255) DEFAULT NULL,
  `NU_TELEFONE_1` bigint(20) DEFAULT NULL,
  `NU_TELEFONE_2` bigint(20) DEFAULT NULL,
  `NU_TELEFONE_3` bigint(20) DEFAULT NULL,
  `USUARIO_FK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`TB_CD_ID_PK`),
  UNIQUE KEY `NU_CNPJ` (`NU_CNPJ`),
  KEY `FKB84E2F98CB811E40` (`USUARIO_FK`),
  CONSTRAINT `FKB84E2F98CB811E40` FOREIGN KEY (`USUARIO_FK`) REFERENCES `tb_usuario` (`TB_CD_ID_PK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_empresa
-- ----------------------------

-- ----------------------------
-- Table structure for tb_perfil
-- ----------------------------
DROP TABLE IF EXISTS `tb_perfil`;
CREATE TABLE `tb_perfil` (
  `TB_CD_ID_PK` bigint(20) NOT NULL AUTO_INCREMENT,
  `DS_PERFIL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`TB_CD_ID_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_perfil
-- ----------------------------
INSERT INTO `tb_perfil` VALUES ('1', 'ADMINISTRADOR');

-- ----------------------------
-- Table structure for tb_solicitacao
-- ----------------------------
DROP TABLE IF EXISTS `tb_solicitacao`;
CREATE TABLE `tb_solicitacao` (
  `TB_CD_ID_PK` bigint(20) NOT NULL AUTO_INCREMENT,
  `DT_RESPOSTA_FORNECEDOR` datetime DEFAULT NULL,
  `DT_SOLICITACAO` datetime DEFAULT NULL,
  `DESC_SOLICITACAO` varchar(255) DEFAULT NULL,
  `FL_STATUS` int(11) DEFAULT NULL,
  `CLIENTE_FK` bigint(20) DEFAULT NULL,
  `EMPRESA_FK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`TB_CD_ID_PK`),
  KEY `FK1B625E34C382AAEB` (`CLIENTE_FK`),
  KEY `FK1B625E34A499054B` (`EMPRESA_FK`),
  CONSTRAINT `FK1B625E34A499054B` FOREIGN KEY (`EMPRESA_FK`) REFERENCES `tb_empresa` (`TB_CD_ID_PK`),
  CONSTRAINT `FK1B625E34C382AAEB` FOREIGN KEY (`CLIENTE_FK`) REFERENCES `tb_cliente` (`TB_CD_ID_PK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_solicitacao
-- ----------------------------

-- ----------------------------
-- Table structure for tb_usuario
-- ----------------------------
DROP TABLE IF EXISTS `tb_usuario`;
CREATE TABLE `tb_usuario` (
  `TB_CD_ID_PK` bigint(20) NOT NULL AUTO_INCREMENT,
  `DS_PASSWORD` varchar(255) NOT NULL,
  `DS_USERNAME` varchar(25) NOT NULL,
  `PERFIL_FK` bigint(20) NOT NULL,
  PRIMARY KEY (`TB_CD_ID_PK`),
  UNIQUE KEY `DS_USERNAME` (`DS_USERNAME`),
  KEY `FK112DE23D25901523` (`PERFIL_FK`),
  CONSTRAINT `FK112DE23D25901523` FOREIGN KEY (`PERFIL_FK`) REFERENCES `tb_perfil` (`TB_CD_ID_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_usuario
-- ----------------------------
INSERT INTO `tb_usuario` VALUES ('1', '21232f297a57a5a743894a0e4a801fc3', 'admin', '1');
