/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : utmanager

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2014-01-27 16:59:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_categoria_jogador
-- ----------------------------
DROP TABLE IF EXISTS `tb_categoria_jogador`;
CREATE TABLE `tb_categoria_jogador` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DS_CATEGORIA` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_categoria_jogador
-- ----------------------------
INSERT INTO `tb_categoria_jogador` VALUES ('1', 'Golden Premium');
INSERT INTO `tb_categoria_jogador` VALUES ('2', 'Golden');
INSERT INTO `tb_categoria_jogador` VALUES ('3', 'Silver Premium');
INSERT INTO `tb_categoria_jogador` VALUES ('4', 'Silver');
INSERT INTO `tb_categoria_jogador` VALUES ('5', 'Bronze Premium');
INSERT INTO `tb_categoria_jogador` VALUES ('6', 'Bronze');

-- ----------------------------
-- Table structure for tb_clube
-- ----------------------------
DROP TABLE IF EXISTS `tb_clube`;
CREATE TABLE `tb_clube` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DS_NOME` varchar(255) DEFAULT NULL,
  `LIGA_FK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK5F2E5D3EA53662E` (`LIGA_FK`),
  CONSTRAINT `FK5F2E5D3EA53662E` FOREIGN KEY (`LIGA_FK`) REFERENCES `tb_liga` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=588 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_clube
-- ----------------------------
INSERT INTO `tb_clube` VALUES ('1', 'América', '1');
INSERT INTO `tb_clube` VALUES ('2', 'Atlante', '1');
INSERT INTO `tb_clube` VALUES ('3', 'Atlas', '1');
INSERT INTO `tb_clube` VALUES ('4', 'Chiapas', '1');
INSERT INTO `tb_clube` VALUES ('5', 'Club León', '1');
INSERT INTO `tb_clube` VALUES ('6', 'Cruz Azul', '1');
INSERT INTO `tb_clube` VALUES ('7', 'Guadalajara', '1');
INSERT INTO `tb_clube` VALUES ('8', 'Monarcas', '1');
INSERT INTO `tb_clube` VALUES ('9', 'Monterrey', '1');
INSERT INTO `tb_clube` VALUES ('10', 'Pachuca', '1');
INSERT INTO `tb_clube` VALUES ('11', 'Puebla', '1');
INSERT INTO `tb_clube` VALUES ('12', 'Querétaro', '1');
INSERT INTO `tb_clube` VALUES ('13', 'Santos Laguna', '1');
INSERT INTO `tb_clube` VALUES ('14', 'Tigres', '1');
INSERT INTO `tb_clube` VALUES ('15', 'Tijuana', '1');
INSERT INTO `tb_clube` VALUES ('16', 'Toluca', '1');
INSERT INTO `tb_clube` VALUES ('17', 'TR Veracruz', '1');
INSERT INTO `tb_clube` VALUES ('18', 'U.N.A.M.', '1');
INSERT INTO `tb_clube` VALUES ('19', 'Chicago Fire', '2');
INSERT INTO `tb_clube` VALUES ('20', 'Chivas USA', '2');
INSERT INTO `tb_clube` VALUES ('21', 'Colorado Rapids', '2');
INSERT INTO `tb_clube` VALUES ('22', 'Columbus Crew', '2');
INSERT INTO `tb_clube` VALUES ('23', 'D.C. United', '2');
INSERT INTO `tb_clube` VALUES ('24', 'FC Dallas', '2');
INSERT INTO `tb_clube` VALUES ('25', 'Houston Dynamo', '2');
INSERT INTO `tb_clube` VALUES ('26', 'L.A. Galaxy', '2');
INSERT INTO `tb_clube` VALUES ('27', 'Montreal Impact', '2');
INSERT INTO `tb_clube` VALUES ('28', 'New England', '2');
INSERT INTO `tb_clube` VALUES ('29', 'NY Red Bulls', '2');
INSERT INTO `tb_clube` VALUES ('30', 'Philadelphia', '2');
INSERT INTO `tb_clube` VALUES ('31', 'Portland', '2');
INSERT INTO `tb_clube` VALUES ('32', 'Real Salt Lake', '2');
INSERT INTO `tb_clube` VALUES ('33', 'SJ Eartquakes', '2');
INSERT INTO `tb_clube` VALUES ('34', 'Sounders FC', '2');
INSERT INTO `tb_clube` VALUES ('35', 'Sporting KC', '2');
INSERT INTO `tb_clube` VALUES ('36', 'Toronto FC', '2');
INSERT INTO `tb_clube` VALUES ('37', 'Whitecaps FC', '2');
INSERT INTO `tb_clube` VALUES ('38', 'All Boys', '3');
INSERT INTO `tb_clube` VALUES ('39', 'Argentinos Jrs.', '3');
INSERT INTO `tb_clube` VALUES ('40', 'Arsenal', '3');
INSERT INTO `tb_clube` VALUES ('41', 'Atlético Rafaela', '3');
INSERT INTO `tb_clube` VALUES ('42', 'Belgrano', '3');
INSERT INTO `tb_clube` VALUES ('43', 'Boca Juniors', '3');
INSERT INTO `tb_clube` VALUES ('44', 'Colón', '3');
INSERT INTO `tb_clube` VALUES ('45', 'Estudiantes', '3');
INSERT INTO `tb_clube` VALUES ('46', 'Gimnasia', '3');
INSERT INTO `tb_clube` VALUES ('47', 'Godoy Cruz', '3');
INSERT INTO `tb_clube` VALUES ('48', 'Lanús', '3');
INSERT INTO `tb_clube` VALUES ('49', 'Newell’s', '3');
INSERT INTO `tb_clube` VALUES ('50', 'Olimpo', '3');
INSERT INTO `tb_clube` VALUES ('51', 'Quilmes', '3');
INSERT INTO `tb_clube` VALUES ('52', 'Racing Club', '3');
INSERT INTO `tb_clube` VALUES ('53', 'River Plate', '3');
INSERT INTO `tb_clube` VALUES ('54', 'Rosario Ctral.', '3');
INSERT INTO `tb_clube` VALUES ('55', 'San Lorenzo', '3');
INSERT INTO `tb_clube` VALUES ('56', 'Tigr', '3');
INSERT INTO `tb_clube` VALUES ('57', 'Vélez Sarsfield', '3');
INSERT INTO `tb_clube` VALUES ('58', 'Atlético Mineiro', '4');
INSERT INTO `tb_clube` VALUES ('59', 'Atlético Paranaense', '4');
INSERT INTO `tb_clube` VALUES ('60', 'Bahia', '4');
INSERT INTO `tb_clube` VALUES ('61', 'Botafogo', '4');
INSERT INTO `tb_clube` VALUES ('62', 'Corinthians', '4');
INSERT INTO `tb_clube` VALUES ('63', 'Coritiba', '4');
INSERT INTO `tb_clube` VALUES ('64', 'Criciúma', '4');
INSERT INTO `tb_clube` VALUES ('65', 'Cruzeiro', '4');
INSERT INTO `tb_clube` VALUES ('66', 'Flamengo', '4');
INSERT INTO `tb_clube` VALUES ('67', 'Fluminense', '4');
INSERT INTO `tb_clube` VALUES ('68', 'Goiás', '4');
INSERT INTO `tb_clube` VALUES ('69', 'Grêmio', '4');
INSERT INTO `tb_clube` VALUES ('70', 'Internacional', '4');
INSERT INTO `tb_clube` VALUES ('71', 'Náutico', '4');
INSERT INTO `tb_clube` VALUES ('72', 'Ponte Preta', '4');
INSERT INTO `tb_clube` VALUES ('73', 'Portuguesa', '4');
INSERT INTO `tb_clube` VALUES ('74', 'Santos', '4');
INSERT INTO `tb_clube` VALUES ('75', 'São Paulo', '4');
INSERT INTO `tb_clube` VALUES ('76', 'Vasco da Gama', '4');
INSERT INTO `tb_clube` VALUES ('77', 'Vitória', '4');
INSERT INTO `tb_clube` VALUES ('78', 'Audax Italiano', '5');
INSERT INTO `tb_clube` VALUES ('79', 'CD Antofagasta', '5');
INSERT INTO `tb_clube` VALUES ('80', 'CD Cobreloa', '5');
INSERT INTO `tb_clube` VALUES ('81', 'CD Cobresal', '5');
INSERT INTO `tb_clube` VALUES ('82', 'CD Everton', '5');
INSERT INTO `tb_clube` VALUES ('83', 'CD Huachipato', '5');
INSERT INTO `tb_clube` VALUES ('84', 'CD O’Higgins', '5');
INSERT INTO `tb_clube` VALUES ('85', 'CD Palestino', '5');
INSERT INTO `tb_clube` VALUES ('86', 'Colo-Colo', '5');
INSERT INTO `tb_clube` VALUES ('87', 'Depor. Iquique', '5');
INSERT INTO `tb_clube` VALUES ('88', 'Ñublense', '5');
INSERT INTO `tb_clube` VALUES ('89', 'Rangers Talca', '5');
INSERT INTO `tb_clube` VALUES ('90', 'Uni. Católica', '5');
INSERT INTO `tb_clube` VALUES ('91', 'Uni. Concepción', '5');
INSERT INTO `tb_clube` VALUES ('92', 'Uni. De Chile', '5');
INSERT INTO `tb_clube` VALUES ('93', 'Unión Española', '5');
INSERT INTO `tb_clube` VALUES ('94', 'Unión La Calera', '5');
INSERT INTO `tb_clube` VALUES ('95', 'Wanderers', '5');
INSERT INTO `tb_clube` VALUES ('96', 'Al. Petrolera', '6');
INSERT INTO `tb_clube` VALUES ('97', 'Atl. Nacional', '6');
INSERT INTO `tb_clube` VALUES ('98', 'Atlético Huila', '6');
INSERT INTO `tb_clube` VALUES ('99', 'Boyacá Chicó', '6');
INSERT INTO `tb_clube` VALUES ('100', 'Cúcuta Depor.', '6');
INSERT INTO `tb_clube` VALUES ('101', 'Depor. Quindió', '6');
INSERT INTO `tb_clube` VALUES ('102', 'Deportes Tolima', '6');
INSERT INTO `tb_clube` VALUES ('103', 'Deportivo Cali', '6');
INSERT INTO `tb_clube` VALUES ('104', 'Deportivo Pasto', '6');
INSERT INTO `tb_clube` VALUES ('105', 'Envigato', '6');
INSERT INTO `tb_clube` VALUES ('106', 'Ind. Santa Fe', '6');
INSERT INTO `tb_clube` VALUES ('107', 'Indep. Medellín', '6');
INSERT INTO `tb_clube` VALUES ('108', 'Itagüí', '6');
INSERT INTO `tb_clube` VALUES ('109', 'Junior FC', '6');
INSERT INTO `tb_clube` VALUES ('110', 'La Equidad', '6');
INSERT INTO `tb_clube` VALUES ('111', 'Millonarios FC', '6');
INSERT INTO `tb_clube` VALUES ('112', 'Once Caldas', '6');
INSERT INTO `tb_clube` VALUES ('113', 'Patriotas FC', '6');
INSERT INTO `tb_clube` VALUES ('114', 'Admira', '7');
INSERT INTO `tb_clube` VALUES ('115', 'FK Austria', '7');
INSERT INTO `tb_clube` VALUES ('116', 'Innsbruck', '7');
INSERT INTO `tb_clube` VALUES ('117', 'RB Salzburg', '7');
INSERT INTO `tb_clube` VALUES ('118', 'SK Rapid Wien', '7');
INSERT INTO `tb_clube` VALUES ('119', 'SK Sturm Graz', '7');
INSERT INTO `tb_clube` VALUES ('120', 'SV Grödig', '7');
INSERT INTO `tb_clube` VALUES ('121', 'SV Ried', '7');
INSERT INTO `tb_clube` VALUES ('122', 'Wiener Neustadt', '7');
INSERT INTO `tb_clube` VALUES ('123', 'Wolfsberger AC', '7');
INSERT INTO `tb_clube` VALUES ('124', 'Cercle Brugge', '8');
INSERT INTO `tb_clube` VALUES ('125', 'Club Brugge', '8');
INSERT INTO `tb_clube` VALUES ('126', 'KAA Gent', '8');
INSERT INTO `tb_clube` VALUES ('127', 'KRC Genk', '8');
INSERT INTO `tb_clube` VALUES ('128', 'KV Kortrijk', '8');
INSERT INTO `tb_clube` VALUES ('129', 'KV Mechelen', '8');
INSERT INTO `tb_clube` VALUES ('130', 'KV Oostende', '8');
INSERT INTO `tb_clube` VALUES ('131', 'Lierse SK', '8');
INSERT INTO `tb_clube` VALUES ('132', 'OHL', '8');
INSERT INTO `tb_clube` VALUES ('133', 'RAEC Mons', '8');
INSERT INTO `tb_clube` VALUES ('134', 'RSC Anderlecht', '8');
INSERT INTO `tb_clube` VALUES ('135', 'Sp. Charleroi', '8');
INSERT INTO `tb_clube` VALUES ('136', 'Sport. Lokeren', '8');
INSERT INTO `tb_clube` VALUES ('137', 'Standard Liège', '8');
INSERT INTO `tb_clube` VALUES ('138', 'Waasl.-Beveren', '8');
INSERT INTO `tb_clube` VALUES ('139', 'Zulte-Waregem', '8');
INSERT INTO `tb_clube` VALUES ('140', 'Aalborg BK', '9');
INSERT INTO `tb_clube` VALUES ('141', 'Aarhus GF', '9');
INSERT INTO `tb_clube` VALUES ('142', 'Brøndby IF', '9');
INSERT INTO `tb_clube` VALUES ('143', 'Esbjerg fB', '9');
INSERT INTO `tb_clube` VALUES ('144', 'FC København', '9');
INSERT INTO `tb_clube` VALUES ('145', 'FC Midtjylland', '9');
INSERT INTO `tb_clube` VALUES ('146', 'FC Nordsjælland', '9');
INSERT INTO `tb_clube` VALUES ('147', 'FC Vestsjælland', '9');
INSERT INTO `tb_clube` VALUES ('148', 'Odense Boldklub', '9');
INSERT INTO `tb_clube` VALUES ('149', 'Randers FC', '9');
INSERT INTO `tb_clube` VALUES ('150', 'SønderjyskE', '9');
INSERT INTO `tb_clube` VALUES ('151', 'Viborg FF', '9');
INSERT INTO `tb_clube` VALUES ('152', 'Arsenal', '10');
INSERT INTO `tb_clube` VALUES ('153', 'Aston Villa', '10');
INSERT INTO `tb_clube` VALUES ('154', 'Cardiff City', '10');
INSERT INTO `tb_clube` VALUES ('155', 'Chelsea', '10');
INSERT INTO `tb_clube` VALUES ('156', 'Crystal Palace', '10');
INSERT INTO `tb_clube` VALUES ('157', 'Everton', '10');
INSERT INTO `tb_clube` VALUES ('158', 'Fulham', '10');
INSERT INTO `tb_clube` VALUES ('159', 'Hull City', '10');
INSERT INTO `tb_clube` VALUES ('160', 'Liverpool', '10');
INSERT INTO `tb_clube` VALUES ('161', 'Manchester City', '10');
INSERT INTO `tb_clube` VALUES ('162', 'Manchester Utd', '10');
INSERT INTO `tb_clube` VALUES ('163', 'Newcastle Utd', '10');
INSERT INTO `tb_clube` VALUES ('164', 'Norwich City', '10');
INSERT INTO `tb_clube` VALUES ('165', 'Southampton', '10');
INSERT INTO `tb_clube` VALUES ('166', 'Spurs', '10');
INSERT INTO `tb_clube` VALUES ('167', 'Stoke City', '10');
INSERT INTO `tb_clube` VALUES ('168', 'Sunderland', '10');
INSERT INTO `tb_clube` VALUES ('169', 'Swansea City', '10');
INSERT INTO `tb_clube` VALUES ('170', 'West Brom', '10');
INSERT INTO `tb_clube` VALUES ('171', 'West Ham', '10');
INSERT INTO `tb_clube` VALUES ('172', 'Barnsley', '11');
INSERT INTO `tb_clube` VALUES ('173', 'Birmingham City', '11');
INSERT INTO `tb_clube` VALUES ('174', 'Blackburn Rvrs', '11');
INSERT INTO `tb_clube` VALUES ('175', 'Blackpool', '11');
INSERT INTO `tb_clube` VALUES ('176', 'Bolton', '11');
INSERT INTO `tb_clube` VALUES ('177', 'Bournemouth', '11');
INSERT INTO `tb_clube` VALUES ('178', 'Brighton', '11');
INSERT INTO `tb_clube` VALUES ('179', 'Burnley', '11');
INSERT INTO `tb_clube` VALUES ('180', 'Charlton Ath', '11');
INSERT INTO `tb_clube` VALUES ('181', 'Derby County', '11');
INSERT INTO `tb_clube` VALUES ('182', 'Doncaster', '11');
INSERT INTO `tb_clube` VALUES ('183', 'Huddersfield', '11');
INSERT INTO `tb_clube` VALUES ('184', 'Ipswich Town', '11');
INSERT INTO `tb_clube` VALUES ('185', 'Leeds United', '11');
INSERT INTO `tb_clube` VALUES ('186', 'Leicester City', '11');
INSERT INTO `tb_clube` VALUES ('187', 'Middlesbrough', '11');
INSERT INTO `tb_clube` VALUES ('188', 'Millwall', '11');
INSERT INTO `tb_clube` VALUES ('189', 'Nott’m Gorest', '11');
INSERT INTO `tb_clube` VALUES ('190', 'QPR', '11');
INSERT INTO `tb_clube` VALUES ('191', 'Reading', '11');
INSERT INTO `tb_clube` VALUES ('192', 'Sheffield Wed', '11');
INSERT INTO `tb_clube` VALUES ('193', 'Watford', '11');
INSERT INTO `tb_clube` VALUES ('194', 'Wigan Athletic', '11');
INSERT INTO `tb_clube` VALUES ('195', 'Yeovil Town', '11');
INSERT INTO `tb_clube` VALUES ('196', 'Bradford City', '12');
INSERT INTO `tb_clube` VALUES ('197', 'Brentford', '12');
INSERT INTO `tb_clube` VALUES ('198', 'Bristol City', '12');
INSERT INTO `tb_clube` VALUES ('199', 'Carlisle United', '12');
INSERT INTO `tb_clube` VALUES ('200', 'Colchester', '12');
INSERT INTO `tb_clube` VALUES ('201', 'Coventry City', '12');
INSERT INTO `tb_clube` VALUES ('202', 'Crawley Town', '12');
INSERT INTO `tb_clube` VALUES ('203', 'Crewe Alexandra', '12');
INSERT INTO `tb_clube` VALUES ('204', 'Gillingham', '12');
INSERT INTO `tb_clube` VALUES ('205', 'Leyton Orient', '12');
INSERT INTO `tb_clube` VALUES ('206', 'MK Dons', '12');
INSERT INTO `tb_clube` VALUES ('207', 'Notts Country', '12');
INSERT INTO `tb_clube` VALUES ('208', 'Oldham Athletic', '12');
INSERT INTO `tb_clube` VALUES ('209', 'Peterborough', '12');
INSERT INTO `tb_clube` VALUES ('210', 'Port Vale', '12');
INSERT INTO `tb_clube` VALUES ('211', 'Preston', '12');
INSERT INTO `tb_clube` VALUES ('212', 'Rotherham Utd', '12');
INSERT INTO `tb_clube` VALUES ('213', 'Sheffield Utd', '12');
INSERT INTO `tb_clube` VALUES ('214', 'Shrewsbury', '12');
INSERT INTO `tb_clube` VALUES ('215', 'Stevenage', '12');
INSERT INTO `tb_clube` VALUES ('216', 'Swindon Town', '12');
INSERT INTO `tb_clube` VALUES ('217', 'Tranmere Rovers', '12');
INSERT INTO `tb_clube` VALUES ('218', 'Walsall', '12');
INSERT INTO `tb_clube` VALUES ('219', 'Wolverhampton', '12');
INSERT INTO `tb_clube` VALUES ('220', 'Accrington', '13');
INSERT INTO `tb_clube` VALUES ('221', 'AFC Wimbledon', '13');
INSERT INTO `tb_clube` VALUES ('222', 'Bristol Rovers', '13');
INSERT INTO `tb_clube` VALUES ('223', 'Burton Albion', '13');
INSERT INTO `tb_clube` VALUES ('224', 'Bury', '13');
INSERT INTO `tb_clube` VALUES ('225', 'Cheltenham Towm', '13');
INSERT INTO `tb_clube` VALUES ('226', 'Chesterfield', '13');
INSERT INTO `tb_clube` VALUES ('227', 'Dagenham', '13');
INSERT INTO `tb_clube` VALUES ('228', 'Exeter City', '13');
INSERT INTO `tb_clube` VALUES ('229', 'Feelwood Town', '13');
INSERT INTO `tb_clube` VALUES ('230', 'Hartlepool', '13');
INSERT INTO `tb_clube` VALUES ('231', 'Mansfield Town', '13');
INSERT INTO `tb_clube` VALUES ('232', 'Morecambe', '13');
INSERT INTO `tb_clube` VALUES ('233', 'Newport County', '13');
INSERT INTO `tb_clube` VALUES ('234', 'Northampton', '13');
INSERT INTO `tb_clube` VALUES ('235', 'Oxford United', '13');
INSERT INTO `tb_clube` VALUES ('236', 'Plymouth Argyle', '13');
INSERT INTO `tb_clube` VALUES ('237', 'Portsmouth', '13');
INSERT INTO `tb_clube` VALUES ('238', 'Rochdale', '13');
INSERT INTO `tb_clube` VALUES ('239', 'Scunthorpe Utd', '13');
INSERT INTO `tb_clube` VALUES ('240', 'Southend United', '13');
INSERT INTO `tb_clube` VALUES ('241', 'Torquay United', '13');
INSERT INTO `tb_clube` VALUES ('242', 'Wycombe', '13');
INSERT INTO `tb_clube` VALUES ('243', 'York City', '13');
INSERT INTO `tb_clube` VALUES ('244', 'AC Ajaccio', '14');
INSERT INTO `tb_clube` VALUES ('245', 'AS Monaco', '14');
INSERT INTO `tb_clube` VALUES ('246', 'Bordeaux', '14');
INSERT INTO `tb_clube` VALUES ('247', 'EA Guingamp', '14');
INSERT INTO `tb_clube` VALUES ('248', 'Evian Thonon FC', '14');
INSERT INTO `tb_clube` VALUES ('249', 'FC Lorient', '14');
INSERT INTO `tb_clube` VALUES ('250', 'FC Nantes', '14');
INSERT INTO `tb_clube` VALUES ('251', 'FC Sochaux', '14');
INSERT INTO `tb_clube` VALUES ('252', 'LOSC Lille', '14');
INSERT INTO `tb_clube` VALUES ('253', 'Marseille', '14');
INSERT INTO `tb_clube` VALUES ('254', 'Montpellier HSC', '14');
INSERT INTO `tb_clube` VALUES ('255', 'OGC Nice', '14');
INSERT INTO `tb_clube` VALUES ('256', 'Olympique Lyon', '14');
INSERT INTO `tb_clube` VALUES ('257', 'PSG', '14');
INSERT INTO `tb_clube` VALUES ('258', 'Saint-Etienne', '14');
INSERT INTO `tb_clube` VALUES ('259', 'SC Bastia', '14');
INSERT INTO `tb_clube` VALUES ('260', 'Stade Reims', '14');
INSERT INTO `tb_clube` VALUES ('261', 'Stade Rennais', '14');
INSERT INTO `tb_clube` VALUES ('262', 'Toulouse FC', '14');
INSERT INTO `tb_clube` VALUES ('263', 'Valenciennes FC', '14');
INSERT INTO `tb_clube` VALUES ('264', 'AC Arles', '15');
INSERT INTO `tb_clube` VALUES ('265', 'AJ Auxerre', '15');
INSERT INTO `tb_clube` VALUES ('266', 'Angers SCO', '15');
INSERT INTO `tb_clube` VALUES ('267', 'AS Nancy', '15');
INSERT INTO `tb_clube` VALUES ('268', 'CA Bastia', '15');
INSERT INTO `tb_clube` VALUES ('269', 'Cham, Niortais', '15');
INSERT INTO `tb_clube` VALUES ('270', 'Clermont Foot', '15');
INSERT INTO `tb_clube` VALUES ('271', 'Dijon FCO', '15');
INSERT INTO `tb_clube` VALUES ('272', 'ES Troyes', '15');
INSERT INTO `tb_clube` VALUES ('273', 'FC Istres', '15');
INSERT INTO `tb_clube` VALUES ('274', 'FC Metz', '15');
INSERT INTO `tb_clube` VALUES ('275', 'LB Chateauroux', '15');
INSERT INTO `tb_clube` VALUES ('276', 'Le Havre AC', '15');
INSERT INTO `tb_clube` VALUES ('277', 'Nîmes Olympique', '15');
INSERT INTO `tb_clube` VALUES ('278', 'RC Lens', '15');
INSERT INTO `tb_clube` VALUES ('279', 'SM Caen', '15');
INSERT INTO `tb_clube` VALUES ('280', 'Stade Brest', '15');
INSERT INTO `tb_clube` VALUES ('281', 'Stade Lavallois', '15');
INSERT INTO `tb_clube` VALUES ('282', 'Tours FC', '15');
INSERT INTO `tb_clube` VALUES ('283', 'US Créteil', '15');
INSERT INTO `tb_clube` VALUES ('284', '1899 Hoffenheim', '16');
INSERT INTO `tb_clube` VALUES ('285', 'Bayer 04', '16');
INSERT INTO `tb_clube` VALUES ('286', 'Bor. Dortmund', '16');
INSERT INTO `tb_clube` VALUES ('287', 'Bor. M’gladbach', '16');
INSERT INTO `tb_clube` VALUES ('288', 'Braunschweig', '16');
INSERT INTO `tb_clube` VALUES ('289', 'Eint. Frankfurt', '16');
INSERT INTO `tb_clube` VALUES ('290', 'FC Augsburg', '16');
INSERT INTO `tb_clube` VALUES ('291', 'FC Bayern', '16');
INSERT INTO `tb_clube` VALUES ('292', 'FC Nuremberg', '16');
INSERT INTO `tb_clube` VALUES ('293', 'FC Schalke 04', '16');
INSERT INTO `tb_clube` VALUES ('294', 'FCV Mainz 05', '16');
INSERT INTO `tb_clube` VALUES ('295', 'Hamburger SV', '16');
INSERT INTO `tb_clube` VALUES ('296', 'Hannover 96', '16');
INSERT INTO `tb_clube` VALUES ('297', 'Hertha BSC', '16');
INSERT INTO `tb_clube` VALUES ('298', 'SC Freiburg', '16');
INSERT INTO `tb_clube` VALUES ('299', 'VfB Stuttgart', '16');
INSERT INTO `tb_clube` VALUES ('300', 'VfL Wolfsburg', '16');
INSERT INTO `tb_clube` VALUES ('301', 'Werder Bremen', '16');
INSERT INTO `tb_clube` VALUES ('302', '1860 Munich', '17');
INSERT INTO `tb_clube` VALUES ('303', 'Arm. Bielefeld', '17');
INSERT INTO `tb_clube` VALUES ('304', 'Dynamo Dresden', '17');
INSERT INTO `tb_clube` VALUES ('305', 'Energie Cottbus', '17');
INSERT INTO `tb_clube` VALUES ('306', 'Erzgebirge Aue', '17');
INSERT INTO `tb_clube` VALUES ('307', 'F. Düsseldorf', '17');
INSERT INTO `tb_clube` VALUES ('308', 'FC Ingolstadt', '17');
INSERT INTO `tb_clube` VALUES ('309', 'FC K’lautern', '17');
INSERT INTO `tb_clube` VALUES ('310', 'FC Köln', '17');
INSERT INTO `tb_clube` VALUES ('311', 'FC St. Pauli', '17');
INSERT INTO `tb_clube` VALUES ('312', 'FSV Frankfurt', '17');
INSERT INTO `tb_clube` VALUES ('313', 'Greuther Fürth', '17');
INSERT INTO `tb_clube` VALUES ('314', 'Karlsruher SC', '17');
INSERT INTO `tb_clube` VALUES ('315', 'SC Paderborn', '17');
INSERT INTO `tb_clube` VALUES ('316', 'SV Sandhausen', '17');
INSERT INTO `tb_clube` VALUES ('317', 'Union Berlin', '17');
INSERT INTO `tb_clube` VALUES ('318', 'VfL Bochum', '17');
INSERT INTO `tb_clube` VALUES ('319', 'VfR Aalen', '17');
INSERT INTO `tb_clube` VALUES ('320', 'ADO Den Haag', '18');
INSERT INTO `tb_clube` VALUES ('321', 'Ajax', '18');
INSERT INTO `tb_clube` VALUES ('322', 'AZ', '18');
INSERT INTO `tb_clube` VALUES ('323', 'FC Groningen', '18');
INSERT INTO `tb_clube` VALUES ('324', 'FC Twente', '18');
INSERT INTO `tb_clube` VALUES ('325', 'FC Utrecht', '18');
INSERT INTO `tb_clube` VALUES ('326', 'Feyenoord', '18');
INSERT INTO `tb_clube` VALUES ('327', 'Go Ahead Eagles', '18');
INSERT INTO `tb_clube` VALUES ('328', 'Heracles Almelo', '18');
INSERT INTO `tb_clube` VALUES ('329', 'N.E.C.', '18');
INSERT INTO `tb_clube` VALUES ('330', 'NAC Breda', '18');
INSERT INTO `tb_clube` VALUES ('331', 'PEC Zwolle', '18');
INSERT INTO `tb_clube` VALUES ('332', 'PSV', '18');
INSERT INTO `tb_clube` VALUES ('333', 'RKC Waalwijk', '18');
INSERT INTO `tb_clube` VALUES ('334', 'Roda JC', '18');
INSERT INTO `tb_clube` VALUES ('335', 'SC Cambuur', '18');
INSERT INTO `tb_clube` VALUES ('336', 'Sc Heerenveen', '18');
INSERT INTO `tb_clube` VALUES ('337', 'Vitesse', '18');
INSERT INTO `tb_clube` VALUES ('338', 'Atalanta', '19');
INSERT INTO `tb_clube` VALUES ('339', 'Bologna', '19');
INSERT INTO `tb_clube` VALUES ('340', 'Cagliari', '19');
INSERT INTO `tb_clube` VALUES ('341', 'Catania', '19');
INSERT INTO `tb_clube` VALUES ('342', 'Chievo Verona', '19');
INSERT INTO `tb_clube` VALUES ('343', 'Fiorentina', '19');
INSERT INTO `tb_clube` VALUES ('344', 'Genoa', '19');
INSERT INTO `tb_clube` VALUES ('345', 'Hellas Verona', '19');
INSERT INTO `tb_clube` VALUES ('346', 'Inter', '19');
INSERT INTO `tb_clube` VALUES ('347', 'Juventus', '19');
INSERT INTO `tb_clube` VALUES ('348', 'Lazio', '19');
INSERT INTO `tb_clube` VALUES ('349', 'Livorno', '19');
INSERT INTO `tb_clube` VALUES ('350', 'Milan', '19');
INSERT INTO `tb_clube` VALUES ('351', 'Napoli', '19');
INSERT INTO `tb_clube` VALUES ('352', 'Parma', '19');
INSERT INTO `tb_clube` VALUES ('353', 'Roma', '19');
INSERT INTO `tb_clube` VALUES ('354', 'Sampdoria', '19');
INSERT INTO `tb_clube` VALUES ('355', 'Sassuolo', '19');
INSERT INTO `tb_clube` VALUES ('356', 'Torino', '19');
INSERT INTO `tb_clube` VALUES ('357', 'Udinese', '19');
INSERT INTO `tb_clube` VALUES ('358', 'Avellino', '20');
INSERT INTO `tb_clube` VALUES ('359', 'Bari', '20');
INSERT INTO `tb_clube` VALUES ('360', 'Brescia', '20');
INSERT INTO `tb_clube` VALUES ('361', 'C. Stabia', '20');
INSERT INTO `tb_clube` VALUES ('362', 'Carpi', '20');
INSERT INTO `tb_clube` VALUES ('363', 'Cesena', '20');
INSERT INTO `tb_clube` VALUES ('364', 'Cittadella', '20');
INSERT INTO `tb_clube` VALUES ('365', 'Crotone', '20');
INSERT INTO `tb_clube` VALUES ('366', 'Empoli', '20');
INSERT INTO `tb_clube` VALUES ('367', 'La Spezia', '20');
INSERT INTO `tb_clube` VALUES ('368', 'Lanciano', '20');
INSERT INTO `tb_clube` VALUES ('369', 'Latina', '20');
INSERT INTO `tb_clube` VALUES ('370', 'Modena', '20');
INSERT INTO `tb_clube` VALUES ('371', 'Novara', '20');
INSERT INTO `tb_clube` VALUES ('372', 'Padua', '20');
INSERT INTO `tb_clube` VALUES ('373', 'Palermo', '20');
INSERT INTO `tb_clube` VALUES ('374', 'Pescara', '20');
INSERT INTO `tb_clube` VALUES ('375', 'Reggio Calabria', '20');
INSERT INTO `tb_clube` VALUES ('376', 'Siena', '20');
INSERT INTO `tb_clube` VALUES ('377', 'Terni', '20');
INSERT INTO `tb_clube` VALUES ('378', 'Trapani', '20');
INSERT INTO `tb_clube` VALUES ('379', 'Varese', '20');
INSERT INTO `tb_clube` VALUES ('380', 'Aalesunds FK', '21');
INSERT INTO `tb_clube` VALUES ('381', 'FK Haugesund', '21');
INSERT INTO `tb_clube` VALUES ('382', 'Hønefoss BK', '21');
INSERT INTO `tb_clube` VALUES ('383', 'Lillestrøm SK', '21');
INSERT INTO `tb_clube` VALUES ('384', 'Molde FK', '21');
INSERT INTO `tb_clube` VALUES ('385', 'ODD', '21');
INSERT INTO `tb_clube` VALUES ('386', 'Rosenborg BK', '21');
INSERT INTO `tb_clube` VALUES ('387', 'Sandnes Ulf', '21');
INSERT INTO `tb_clube` VALUES ('388', 'Sarpsborg', '21');
INSERT INTO `tb_clube` VALUES ('389', 'SK Brann', '21');
INSERT INTO `tb_clube` VALUES ('390', 'Sogndal', '21');
INSERT INTO `tb_clube` VALUES ('391', 'Start', '21');
INSERT INTO `tb_clube` VALUES ('392', 'Strømsgodset IF', '21');
INSERT INTO `tb_clube` VALUES ('393', 'Tromsø IL', '21');
INSERT INTO `tb_clube` VALUES ('394', 'Vålerenga', '21');
INSERT INTO `tb_clube` VALUES ('395', 'Viking FK', '21');
INSERT INTO `tb_clube` VALUES ('396', 'Cracovia Kraków', '22');
INSERT INTO `tb_clube` VALUES ('397', 'Górnik Zabrze', '22');
INSERT INTO `tb_clube` VALUES ('398', 'Jag. Bialystok', '22');
INSERT INTO `tb_clube` VALUES ('399', 'Korona Kielce', '22');
INSERT INTO `tb_clube` VALUES ('400', 'Lech Poznan', '22');
INSERT INTO `tb_clube` VALUES ('401', 'Lechia Gdansk', '22');
INSERT INTO `tb_clube` VALUES ('402', 'Legia Warszawa', '22');
INSERT INTO `tb_clube` VALUES ('403', 'Piast Gliwice', '22');
INSERT INTO `tb_clube` VALUES ('404', 'Podbeskidzie', '22');
INSERT INTO `tb_clube` VALUES ('405', 'Pogon Szczecin', '22');
INSERT INTO `tb_clube` VALUES ('406', 'Ruch Chorzów', '22');
INSERT INTO `tb_clube` VALUES ('407', 'Slask Wroclaw', '22');
INSERT INTO `tb_clube` VALUES ('408', 'Widzew Lódz', '22');
INSERT INTO `tb_clube` VALUES ('409', 'Wisla Kraków', '22');
INSERT INTO `tb_clube` VALUES ('410', 'Zaglebie Lubin', '22');
INSERT INTO `tb_clube` VALUES ('411', 'Zaw. Bydgoszcz', '22');
INSERT INTO `tb_clube` VALUES ('412', 'Académica', '23');
INSERT INTO `tb_clube` VALUES ('413', 'Belenenses (Belém)', '23');
INSERT INTO `tb_clube` VALUES ('414', 'CD Nacional', '23');
INSERT INTO `tb_clube` VALUES ('415', 'CS Marítimo (C. Funchal)', '23');
INSERT INTO `tb_clube` VALUES ('416', 'Estoril-Praia (Estoril)', '23');
INSERT INTO `tb_clube` VALUES ('417', 'FC Arouca (Arouca)', '23');
INSERT INTO `tb_clube` VALUES ('418', 'FC Porto', '23');
INSERT INTO `tb_clube` VALUES ('419', 'Gil-Vicente (V. Barcelos)', '23');
INSERT INTO `tb_clube` VALUES ('420', 'Paços Ferreira', '23');
INSERT INTO `tb_clube` VALUES ('421', 'Rio Ave FC', '23');
INSERT INTO `tb_clube` VALUES ('422', 'S.C. Olhanense', '23');
INSERT INTO `tb_clube` VALUES ('423', 'SC Braga', '23');
INSERT INTO `tb_clube` VALUES ('424', 'SL Benfica', '23');
INSERT INTO `tb_clube` VALUES ('425', 'Sporting CP', '23');
INSERT INTO `tb_clube` VALUES ('426', 'Vit. Guimarães', '23');
INSERT INTO `tb_clube` VALUES ('427', 'Vitória FC', '23');
INSERT INTO `tb_clube` VALUES ('428', 'Bohemians FC', '24');
INSERT INTO `tb_clube` VALUES ('429', 'Bray Wanderers', '24');
INSERT INTO `tb_clube` VALUES ('430', 'Cork City', '24');
INSERT INTO `tb_clube` VALUES ('431', 'Derry City', '24');
INSERT INTO `tb_clube` VALUES ('432', 'Drogheda Utd', '24');
INSERT INTO `tb_clube` VALUES ('433', 'Dundalk', '24');
INSERT INTO `tb_clube` VALUES ('434', 'Limerick', '24');
INSERT INTO `tb_clube` VALUES ('435', 'Shamrock Rovers', '24');
INSERT INTO `tb_clube` VALUES ('436', 'Shelbourne', '24');
INSERT INTO `tb_clube` VALUES ('437', 'Sligo Rovers', '24');
INSERT INTO `tb_clube` VALUES ('438', 'St. Pats', '24');
INSERT INTO `tb_clube` VALUES ('439', 'UCD AFC', '24');
INSERT INTO `tb_clube` VALUES ('440', 'Amkar Perm', '25');
INSERT INTO `tb_clube` VALUES ('441', 'CSKA Moskva', '25');
INSERT INTO `tb_clube` VALUES ('442', 'FC Krasnodar', '25');
INSERT INTO `tb_clube` VALUES ('443', 'FC Rostov', '25');
INSERT INTO `tb_clube` VALUES ('444', 'FC Tom Tomsk', '25');
INSERT INTO `tb_clube` VALUES ('445', 'FC Ural', '25');
INSERT INTO `tb_clube` VALUES ('446', 'Krylya Sovetov', '25');
INSERT INTO `tb_clube` VALUES ('447', 'Kuban Krasnodar', '25');
INSERT INTO `tb_clube` VALUES ('448', 'Lokomotiv', '25');
INSERT INTO `tb_clube` VALUES ('449', 'Makharchkala', '25');
INSERT INTO `tb_clube` VALUES ('450', 'Rubin Kazan', '25');
INSERT INTO `tb_clube` VALUES ('451', 'Spartak Moskva', '25');
INSERT INTO `tb_clube` VALUES ('452', 'Terek Grozny', '25');
INSERT INTO `tb_clube` VALUES ('453', 'Volga', '25');
INSERT INTO `tb_clube` VALUES ('454', 'Zenit', '25');
INSERT INTO `tb_clube` VALUES ('455', 'Aberdeen', '26');
INSERT INTO `tb_clube` VALUES ('456', 'Celtic', '26');
INSERT INTO `tb_clube` VALUES ('457', 'Dundee United', '26');
INSERT INTO `tb_clube` VALUES ('458', 'Hearts', '26');
INSERT INTO `tb_clube` VALUES ('459', 'Hibernian', '26');
INSERT INTO `tb_clube` VALUES ('460', 'Inverness CT', '26');
INSERT INTO `tb_clube` VALUES ('461', 'Kilmarnock', '26');
INSERT INTO `tb_clube` VALUES ('462', 'Motherwell', '26');
INSERT INTO `tb_clube` VALUES ('463', 'Partick Thistle', '26');
INSERT INTO `tb_clube` VALUES ('464', 'Ross County', '26');
INSERT INTO `tb_clube` VALUES ('465', 'St. Johnstone', '26');
INSERT INTO `tb_clube` VALUES ('466', 'St. Mirren', '26');
INSERT INTO `tb_clube` VALUES ('467', 'Athletic Bilbao', '27');
INSERT INTO `tb_clube` VALUES ('468', 'Atlético Madrid', '27');
INSERT INTO `tb_clube` VALUES ('469', 'CA Osasuna', '27');
INSERT INTO `tb_clube` VALUES ('470', 'Celta Vigo', '27');
INSERT INTO `tb_clube` VALUES ('471', 'Elche CF', '27');
INSERT INTO `tb_clube` VALUES ('472', 'FC Barcelona', '27');
INSERT INTO `tb_clube` VALUES ('473', 'Getafe CF', '27');
INSERT INTO `tb_clube` VALUES ('474', 'Grabada CF', '27');
INSERT INTO `tb_clube` VALUES ('475', 'Levante UD', '27');
INSERT INTO `tb_clube` VALUES ('476', 'Málaga CF', '27');
INSERT INTO `tb_clube` VALUES ('477', 'Rayo Vallecano', '27');
INSERT INTO `tb_clube` VALUES ('478', 'RCD Espanyol', '27');
INSERT INTO `tb_clube` VALUES ('479', 'Real Betis', '27');
INSERT INTO `tb_clube` VALUES ('480', 'Real Madrid', '27');
INSERT INTO `tb_clube` VALUES ('481', 'Real Sociedad', '27');
INSERT INTO `tb_clube` VALUES ('482', 'Real Valladolid', '27');
INSERT INTO `tb_clube` VALUES ('483', 'Sevilla FC', '27');
INSERT INTO `tb_clube` VALUES ('484', 'UD Almería', '27');
INSERT INTO `tb_clube` VALUES ('485', 'Valencia CF', '27');
INSERT INTO `tb_clube` VALUES ('486', 'Villarreal CF', '27');
INSERT INTO `tb_clube` VALUES ('487', 'AD Alcorcón', '28');
INSERT INTO `tb_clube` VALUES ('488', 'CD Lugo', '28');
INSERT INTO `tb_clube` VALUES ('489', 'CD Mirandés', '28');
INSERT INTO `tb_clube` VALUES ('490', 'CD Numancia', '28');
INSERT INTO `tb_clube` VALUES ('491', 'CD Tenerife', '28');
INSERT INTO `tb_clube` VALUES ('492', 'Córdoba CF', '28');
INSERT INTO `tb_clube` VALUES ('493', 'Deport. Alavés', '28');
INSERT INTO `tb_clube` VALUES ('494', 'FC Barcelona B', '28');
INSERT INTO `tb_clube` VALUES ('495', 'Girnoa CF', '28');
INSERT INTO `tb_clube` VALUES ('496', 'Hércules CF', '28');
INSERT INTO `tb_clube` VALUES ('497', 'RC Deportivo', '28');
INSERT INTO `tb_clube` VALUES ('498', 'RC Recreativo', '28');
INSERT INTO `tb_clube` VALUES ('499', 'RCD Mallorca', '28');
INSERT INTO `tb_clube` VALUES ('500', 'Real Jaén CF', '28');
INSERT INTO `tb_clube` VALUES ('501', 'Real Murcia CF', '28');
INSERT INTO `tb_clube` VALUES ('502', 'Real Zaragoza', '28');
INSERT INTO `tb_clube` VALUES ('503', 'RM Castilla', '28');
INSERT INTO `tb_clube` VALUES ('504', 'Sabadell FC', '28');
INSERT INTO `tb_clube` VALUES ('505', 'SD Eibar', '28');
INSERT INTO `tb_clube` VALUES ('506', 'SD Ponferradina', '28');
INSERT INTO `tb_clube` VALUES ('507', 'Sporting Gijón', '28');
INSERT INTO `tb_clube` VALUES ('508', 'UD Las Palmas', '28');
INSERT INTO `tb_clube` VALUES ('509', 'AIK Fotboll', '29');
INSERT INTO `tb_clube` VALUES ('510', 'Åtvidabergs FF', '29');
INSERT INTO `tb_clube` VALUES ('511', 'BK Häcken', '29');
INSERT INTO `tb_clube` VALUES ('512', 'Brommapojkarna', '29');
INSERT INTO `tb_clube` VALUES ('513', 'Djurgårdens IF', '29');
INSERT INTO `tb_clube` VALUES ('514', 'Gefle IF', '29');
INSERT INTO `tb_clube` VALUES ('515', 'Halmstads BK', '29');
INSERT INTO `tb_clube` VALUES ('516', 'Helsinborgs IF', '29');
INSERT INTO `tb_clube` VALUES ('517', 'IF Elfsborg', '29');
INSERT INTO `tb_clube` VALUES ('518', 'IFK Göteborg', '29');
INSERT INTO `tb_clube` VALUES ('519', 'IFK Norrköping', '29');
INSERT INTO `tb_clube` VALUES ('520', 'Kalmar FF', '29');
INSERT INTO `tb_clube` VALUES ('521', 'Malmö FF', '29');
INSERT INTO `tb_clube` VALUES ('522', 'Mjällby AIF', '29');
INSERT INTO `tb_clube` VALUES ('523', 'Östers IF', '29');
INSERT INTO `tb_clube` VALUES ('524', 'Syrianska', '29');
INSERT INTO `tb_clube` VALUES ('525', 'BSC Young Boys', '30');
INSERT INTO `tb_clube` VALUES ('526', 'FC Aarau', '30');
INSERT INTO `tb_clube` VALUES ('527', 'FC Basel', '30');
INSERT INTO `tb_clube` VALUES ('528', 'FC Lausanne', '30');
INSERT INTO `tb_clube` VALUES ('529', 'FC Luzern', '30');
INSERT INTO `tb_clube` VALUES ('530', 'FC Sion', '30');
INSERT INTO `tb_clube` VALUES ('531', 'FC St. Gallen', '30');
INSERT INTO `tb_clube` VALUES ('532', 'FC Thun', '30');
INSERT INTO `tb_clube` VALUES ('533', 'FC Zürich', '30');
INSERT INTO `tb_clube` VALUES ('534', 'Grasshopper', '30');
INSERT INTO `tb_clube` VALUES ('535', 'Adelaide United', '31');
INSERT INTO `tb_clube` VALUES ('536', 'Brisbane Roar', '31');
INSERT INTO `tb_clube` VALUES ('537', 'Central Coast', '31');
INSERT INTO `tb_clube` VALUES ('538', 'Melb. Victory', '31');
INSERT INTO `tb_clube` VALUES ('539', 'Melbourne Heart', '31');
INSERT INTO `tb_clube` VALUES ('540', 'Newcastle Jets', '31');
INSERT INTO `tb_clube` VALUES ('541', 'Perth Glory', '31');
INSERT INTO `tb_clube` VALUES ('542', 'Sydney FC', '31');
INSERT INTO `tb_clube` VALUES ('543', 'Wanderers FC', '31');
INSERT INTO `tb_clube` VALUES ('544', 'Well. Phoenix', '31');
INSERT INTO `tb_clube` VALUES ('545', 'Busan I\'Park', '32');
INSERT INTO `tb_clube` VALUES ('546', 'Chunnam Dragons', '32');
INSERT INTO `tb_clube` VALUES ('547', 'Daegu FC', '32');
INSERT INTO `tb_clube` VALUES ('548', 'Daejeon Citizen', '32');
INSERT INTO `tb_clube` VALUES ('549', 'FC Seoul', '32');
INSERT INTO `tb_clube` VALUES ('550', 'Gangwon FC', '32');
INSERT INTO `tb_clube` VALUES ('551', 'GyeongNam FC', '32');
INSERT INTO `tb_clube` VALUES ('552', 'Incheon United', '32');
INSERT INTO `tb_clube` VALUES ('553', 'Jeju United FC', '32');
INSERT INTO `tb_clube` VALUES ('554', 'Jeonbuk FC', '32');
INSERT INTO `tb_clube` VALUES ('555', 'Pohang Steelers', '32');
INSERT INTO `tb_clube` VALUES ('556', 'Seongnam Ilhwa', '32');
INSERT INTO `tb_clube` VALUES ('557', 'Suwon Bluewings', '32');
INSERT INTO `tb_clube` VALUES ('558', 'Ulsan Hyundai', '32');
INSERT INTO `tb_clube` VALUES ('559', 'Al-Ahli', '33');
INSERT INTO `tb_clube` VALUES ('560', 'Al-Ettifaq', '33');
INSERT INTO `tb_clube` VALUES ('561', 'Al-Faisaly', '33');
INSERT INTO `tb_clube` VALUES ('562', 'Al-Fateh', '33');
INSERT INTO `tb_clube` VALUES ('563', 'Al-Hilal', '33');
INSERT INTO `tb_clube` VALUES ('564', 'Al-Ittihad', '33');
INSERT INTO `tb_clube` VALUES ('565', 'Al-Nahdha', '33');
INSERT INTO `tb_clube` VALUES ('566', 'Al-Nassr', '33');
INSERT INTO `tb_clube` VALUES ('567', 'Al-Orubah FC', '33');
INSERT INTO `tb_clube` VALUES ('568', 'Al-Raed', '33');
INSERT INTO `tb_clube` VALUES ('569', 'Al-Shabab', '33');
INSERT INTO `tb_clube` VALUES ('570', 'Alshoulla', '33');
INSERT INTO `tb_clube` VALUES ('571', 'Al-Taawoun', '33');
INSERT INTO `tb_clube` VALUES ('572', 'Najran', '33');
INSERT INTO `tb_clube` VALUES ('573', 'Adidas All-Star', '34');
INSERT INTO `tb_clube` VALUES ('574', 'AEK Athens', '34');
INSERT INTO `tb_clube` VALUES ('575', 'Classic XI', '34');
INSERT INTO `tb_clube` VALUES ('576', 'FC Shakhtar', '34');
INSERT INTO `tb_clube` VALUES ('577', 'Galatasaray SK', '34');
INSERT INTO `tb_clube` VALUES ('578', 'Independiente', '34');
INSERT INTO `tb_clube` VALUES ('579', 'Kaizer Chiefs', '34');
INSERT INTO `tb_clube` VALUES ('580', 'MLS All Stars', '34');
INSERT INTO `tb_clube` VALUES ('581', 'Olympiakos CFP', '34');
INSERT INTO `tb_clube` VALUES ('582', 'Orlando Pirates', '34');
INSERT INTO `tb_clube` VALUES ('583', 'Palmeiras', '34');
INSERT INTO `tb_clube` VALUES ('584', 'Panathinaikos', '34');
INSERT INTO `tb_clube` VALUES ('585', 'PAOK', '34');
INSERT INTO `tb_clube` VALUES ('586', 'Rangers', '34');
INSERT INTO `tb_clube` VALUES ('587', 'World XI', '34');

-- ----------------------------
-- Table structure for tb_financa
-- ----------------------------
DROP TABLE IF EXISTS `tb_financa`;
CREATE TABLE `tb_financa` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TP_MOVIMENTACAO` varchar(255) DEFAULT NULL,
  `VL_SALDO` decimal(19,2) DEFAULT NULL,
  `VL_MOVIMENTADO` decimal(19,2) DEFAULT NULL,
  `DT_MOVIMENTACAO` datetime DEFAULT NULL,
  `DS_DESCRICAO` varchar(255) DEFAULT NULL,
  `JOGADOR_FK` bigint(20) DEFAULT NULL,
  `PARTIDA_FK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKE63D3EE5676B2B4` (`JOGADOR_FK`),
  KEY `FKE63D3EE5363F5AD4` (`PARTIDA_FK`),
  CONSTRAINT `FKE63D3EE5363F5AD4` FOREIGN KEY (`PARTIDA_FK`) REFERENCES `tb_partida` (`ID`),
  CONSTRAINT `FKE63D3EE5676B2B4` FOREIGN KEY (`JOGADOR_FK`) REFERENCES `tb_jogadores_plantel` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=191 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tb_financa
-- ----------------------------
INSERT INTO `tb_financa` VALUES ('1', null, '16690.00', '16690.00', '2014-01-19 21:56:16', null, null, null);
INSERT INTO `tb_financa` VALUES ('2', 'GANHO_PARTIDA', '17026.00', '336.00', '2014-01-19 22:30:05', null, null, null);
INSERT INTO `tb_financa` VALUES ('3', 'GANHO_PARTIDA', '17537.00', '511.00', '2014-01-19 22:55:34', null, null, null);
INSERT INTO `tb_financa` VALUES ('4', 'GANHO_PARTIDA', '17987.00', '450.00', '2014-01-19 23:17:26', null, null, null);
INSERT INTO `tb_financa` VALUES ('5', 'GANHO_PARTIDA', '18486.00', '499.00', '2014-01-19 23:40:42', null, null, null);
INSERT INTO `tb_financa` VALUES ('6', 'GANHO_PARTIDA', '18665.00', '179.00', '2014-01-19 23:47:37', null, null, null);
INSERT INTO `tb_financa` VALUES ('7', 'GANHO_PARTIDA', '19155.00', '490.00', '2014-01-20 00:07:21', null, null, null);
INSERT INTO `tb_financa` VALUES ('11', 'VENDA_JOGADOR', '20960.00', '1805.00', '2014-01-20 00:20:08', 'Venda do jogador null - Sterling - null - null', '70', null);
INSERT INTO `tb_financa` VALUES ('12', 'GANHO_PARTIDA', '21435.00', '475.00', '2014-01-20 00:51:20', null, null, null);
INSERT INTO `tb_financa` VALUES ('13', 'GANHO_TORNEIO', '26435.00', '5000.00', '2014-01-20 00:53:11', null, null, null);
INSERT INTO `tb_financa` VALUES ('14', 'GANHO_PARTIDA', '26854.00', '419.00', '2014-01-20 22:05:01', 'Herkot FC 2 X 0 Scoroz United A  em 20/01/2014 - 22:05', null, '8');
INSERT INTO `tb_financa` VALUES ('15', 'GANHO_PARTIDA', '27297.00', '443.00', '2014-01-20 22:27:15', 'Haliyuu 3 X 1 Scoroz United A  em 20/01/2014 - 22:27', null, '9');
INSERT INTO `tb_financa` VALUES ('16', 'COMPRA_JOGADOR', '24797.00', '2500.00', '2014-01-21 13:32:05', 'Compra do jogador null - Diego Costa - null - null', '129', null);
INSERT INTO `tb_financa` VALUES ('20', 'VENDA_JOGADOR', '25129.50', '332.50', '2014-01-21 16:30:41', 'Venda do jogador null - Chambers - null - null', '71', null);
INSERT INTO `tb_financa` VALUES ('21', 'VENDA_JOGADOR', '26032.00', '902.50', '2014-01-21 16:35:58', 'Venda do jogador null - Luiz Gustavo - null - null', '37', null);
INSERT INTO `tb_financa` VALUES ('22', 'VENDA_JOGADOR', '27552.00', '1520.00', '2014-01-21 16:40:00', 'Venda do jogador null - Luiz Gustavo - null - null', '92', null);
INSERT INTO `tb_financa` VALUES ('23', 'VENDA_JOGADOR', '28454.50', '902.50', '2014-01-21 16:40:46', 'Venda do jogador null - Cáceres - null - null', '111', null);
INSERT INTO `tb_financa` VALUES ('24', 'VENDA_JOGADOR', '29309.50', '855.00', '2014-01-21 16:41:10', 'Venda do jogador null - Radu - null - null', '115', null);
INSERT INTO `tb_financa` VALUES ('25', 'VENDA_JOGADOR', '32064.50', '2755.00', '2014-01-21 16:41:36', 'Venda do jogador null - Diego Costa - null - null', '129', null);
INSERT INTO `tb_financa` VALUES ('26', 'COMPRA_JOGADOR', '28664.50', '3400.00', '2014-01-21 16:56:23', 'Compra do jogador null - Sturridge - null - null', '130', null);
INSERT INTO `tb_financa` VALUES ('27', 'COMPRA_JOGADOR', '27464.50', '1200.00', '2014-01-21 17:53:32', 'Compra do jogador null - Fernando Torres - null - null', '131', null);
INSERT INTO `tb_financa` VALUES ('28', 'COMPRA_JOGADOR', '26464.50', '1000.00', '2014-01-21 17:54:45', 'Compra do jogador null - Benteke - null - null', '132', null);
INSERT INTO `tb_financa` VALUES ('29', 'COMPRA_JOGADOR', '25364.50', '1100.00', '2014-01-21 17:55:15', 'Compra do jogador null - Benteke - null - null', '133', null);
INSERT INTO `tb_financa` VALUES ('30', 'COMPRA_JOGADOR', '24514.50', '850.00', '2014-01-21 17:56:36', 'Compra do jogador null - Coutinho - null - null', '134', null);
INSERT INTO `tb_financa` VALUES ('31', 'VENDA_JOGADOR', '25274.50', '760.00', '2014-01-21 18:00:39', 'Venda do jogador null - Pastore - null - null', '65', null);
INSERT INTO `tb_financa` VALUES ('32', 'VENDA_JOGADOR', '26319.50', '1045.00', '2014-01-21 18:01:01', 'Venda do jogador null - Mandzukic - null - null', '96', null);
INSERT INTO `tb_financa` VALUES ('33', 'GANHO_PARTIDA', '26865.50', '546.00', '2014-01-22 09:21:37', 'Scoroz United  4 X 1 Campinho FC  em 22/01/2014 - 09:21', null, '10');
INSERT INTO `tb_financa` VALUES ('34', 'GANHO_PARTIDA', '27296.50', '431.00', '2014-01-22 09:22:10', 'Scoroz United 1 X 2 craques   em 22/01/2014 - 09:22', null, '11');
INSERT INTO `tb_financa` VALUES ('35', 'VENDA_JOGADOR', '28246.50', '950.00', '2014-01-22 09:22:55', 'Venda do jogador null - Klose - null - null', '95', null);
INSERT INTO `tb_financa` VALUES ('36', 'VENDA_JOGADOR', '29006.50', '760.00', '2014-01-22 09:23:11', 'Venda do jogador null - Sokratis - null - null', '108', null);
INSERT INTO `tb_financa` VALUES ('37', 'GANHO_PARTIDA', '29440.50', '434.00', '2014-01-22 09:24:12', 'Scoroz United 0 X 1 Bonsucesso FC  em 22/01/2014 - 09:24', null, '12');
INSERT INTO `tb_financa` VALUES ('38', 'GANHO_PARTIDA', '29953.50', '513.00', '2014-01-22 09:24:34', 'Scoroz United 1 X 0 Jockos FC  em 22/01/2014 - 09:24', null, '13');
INSERT INTO `tb_financa` VALUES ('39', 'GANHO_PARTIDA', '30474.00', '521.00', '2014-01-22 09:25:00', 'SCOROZ 3 x 1 CACIQUE FC', null, null);
INSERT INTO `tb_financa` VALUES ('40', 'GANHO_PARTIDA', '30987.50', '513.00', '2014-01-22 09:25:10', 'Scoroz United 4 X 4 LSCRDYT   em 22/01/2014 - 09:25', null, '15');
INSERT INTO `tb_financa` VALUES ('42', 'COMPRA_OUTROS', '30787.50', '200.00', '2014-01-22 10:00:00', 'Compra de Emblema do Boca Juniors', null, null);
INSERT INTO `tb_financa` VALUES ('43', 'VENDA_JOGADOR', '31642.50', '855.00', '2014-01-22 10:03:59', 'Venda do jogador null - Ospina - null - null', '6', null);
INSERT INTO `tb_financa` VALUES ('44', 'VENDA_JOGADOR', '34492.50', '2850.00', '2014-01-22 10:04:24', 'Venda do jogador null - Dante - null - null', '93', null);
INSERT INTO `tb_financa` VALUES ('45', 'VENDA_JOGADOR', '35632.50', '1140.00', '2014-01-22 10:06:22', 'Venda do jogador null - Howedes - null - null', '100', null);
INSERT INTO `tb_financa` VALUES ('46', 'VENDA_JOGADOR', '36060.00', '427.50', '2014-01-22 10:06:47', 'Venda do jogador null - Rolfes - null - null', '122', null);
INSERT INTO `tb_financa` VALUES ('47', 'VENDA_JOGADOR', '36915.00', '855.00', '2014-01-22 11:35:00', 'Venda do jogador null - Samuel - null - null', '98', null);
INSERT INTO `tb_financa` VALUES ('48', 'VENDA_JOGADOR', '38625.00', '1710.00', '2014-01-22 11:36:25', 'Venda do jogador null - Fernando Torres - null - null', '131', null);
INSERT INTO `tb_financa` VALUES ('49', 'COMPRA_JOGADOR', '34925.00', '3700.00', '2014-01-22 12:11:53', 'Compra do jogador null - Walker - null - null', '135', null);
INSERT INTO `tb_financa` VALUES ('50', 'COMPRA_JOGADOR', '33825.00', '1100.00', '2014-01-22 14:42:24', 'Compra do jogador null - Coutinho - null - null', '136', null);
INSERT INTO `tb_financa` VALUES ('51', 'VENDA_JOGADOR', '34727.50', '902.50', '2014-01-22 15:36:19', 'Venda do jogador CAM - K. P. Boateng - Ganês - Germany 1. Bundesliga', '57', null);
INSERT INTO `tb_financa` VALUES ('52', 'VENDA_JOGADOR', '35962.50', '1235.00', '2014-01-22 15:50:23', 'Venda do jogador CAM - Coutinho - Brasileiro - England Premier League', '136', null);
INSERT INTO `tb_financa` VALUES ('53', 'COMPRA_JOGADOR', '34662.50', '1300.00', '2014-01-22 21:53:18', 'Compra do jogador CAM - Diego - Brasileiro - Germany 1. Bundesliga', '137', null);
INSERT INTO `tb_financa` VALUES ('54', 'COMPRA_JOGADOR', '33362.50', '1300.00', '2014-01-22 21:54:06', 'Compra do jogador CAM - Diego - Brasileiro - Germany 1. Bundesliga', '138', null);
INSERT INTO `tb_financa` VALUES ('55', 'COMPRA_JOGADOR', '30262.50', '3100.00', '2014-01-23 00:03:52', 'Compra do jogador ST - Diego Costa - Brasileiro - Spain Primera Division', '139', null);
INSERT INTO `tb_financa` VALUES ('56', 'COMPRA_JOGADOR', '29162.50', '1100.00', '2014-01-23 00:10:31', 'Compra do jogador CAM - Coutinho - Brasileiro - England Premier League', '140', null);
INSERT INTO `tb_financa` VALUES ('57', 'COMPRA_JOGADOR', '28062.50', '1100.00', '2014-01-23 00:14:10', 'Compra do jogador CAM - Coutinho - Brasileiro - England Premier League', '141', null);
INSERT INTO `tb_financa` VALUES ('58', 'VENDA_JOGADOR', '31102.50', '3040.00', '2014-01-23 09:23:52', 'Venda do jogador ST - Diego Costa - Brasileiro - Spain Primera Division', '139', null);
INSERT INTO `tb_financa` VALUES ('59', 'VENDA_JOGADOR', '31815.00', '712.50', '2014-01-23 09:24:33', 'Venda do jogador GK  - Costil - Francês - France Ligue 1', '123', null);
INSERT INTO `tb_financa` VALUES ('68', 'VENDA_JOGADOR', '33050.00', '1235.00', '2014-01-23 10:58:56', 'Venda do jogador CAM - Diego - Brasileiro - Germany 1. Bundesliga', '138', null);
INSERT INTO `tb_financa` VALUES ('69', 'VENDA_JOGADOR', '36565.00', '3515.00', '2014-01-23 11:00:23', 'Venda do jogador RB - Walker - Inglês - England Premier League', '135', null);
INSERT INTO `tb_financa` VALUES ('70', 'VENDA_JOGADOR', '37182.50', '617.50', '2014-01-23 11:01:03', 'Venda do jogador CF - Donovan - Americano - USA Major League Soccer', '87', null);
INSERT INTO `tb_financa` VALUES ('71', 'VENDA_JOGADOR', '37752.50', '570.00', '2014-01-23 11:01:37', 'Venda do jogador ST - Pellé - Italiano - Holland Eredivisie', '84', null);
INSERT INTO `tb_financa` VALUES ('72', 'VENDA_JOGADOR', '38465.00', '712.50', '2014-01-23 11:01:53', 'Venda do jogador CB  - F. Santana - Brasileiro - Germany 1. Bundesliga', '20', null);
INSERT INTO `tb_financa` VALUES ('73', 'COMPRA_JOGADOR', '33965.00', '4500.00', '2014-01-23 11:02:41', 'Compra do jogador ST - Cavani - Uruguaio - France Ligue 1', '143', null);
INSERT INTO `tb_financa` VALUES ('74', 'COMPRA_JOGADOR', '29565.00', '4400.00', '2014-01-23 11:18:21', 'Compra do jogador ST - Cavani - Uruguaio - France Ligue 1', '144', null);
INSERT INTO `tb_financa` VALUES ('75', 'COMPRA_JOGADOR', '27165.00', '2400.00', '2014-01-23 11:50:01', 'Compra do jogador RW - Walcott - Inglês - England Premier League', '145', null);
INSERT INTO `tb_financa` VALUES ('76', 'COMPRA_JOGADOR', '24765.00', '2400.00', '2014-01-23 11:50:47', 'Compra do jogador RW - Walcott - Inglês - England Premier League', '146', null);
INSERT INTO `tb_financa` VALUES ('77', 'COMPRA_JOGADOR', '22465.00', '2300.00', '2014-01-23 11:51:17', 'Compra do jogador RW - Walcott - Inglês - England Premier League', '147', null);
INSERT INTO `tb_financa` VALUES ('78', 'VENDA_JOGADOR', '26835.00', '4370.00', '2014-01-23 12:08:58', 'Venda do jogador ST - Cavani - Uruguaio - France Ligue 1', '144', null);
INSERT INTO `tb_financa` VALUES ('79', 'VENDA_JOGADOR', '28165.00', '1330.00', '2014-01-23 12:09:29', 'Venda do jogador CAM - Diego - Brasileiro - Germany 1. Bundesliga', '137', null);
INSERT INTO `tb_financa` VALUES ('80', 'VENDA_JOGADOR', '31395.00', '3230.00', '2014-01-23 12:10:02', 'Venda do jogador ST - Sturridge - Inglês - England Premier League', '130', null);
INSERT INTO `tb_financa` VALUES ('81', 'VENDA_JOGADOR', '32440.00', '1045.00', '2014-01-23 12:10:30', 'Venda do jogador CAM - Coutinho - Brasileiro - England Premier League', '141', null);
INSERT INTO `tb_financa` VALUES ('82', 'VENDA_JOGADOR', '36715.00', '4275.00', '2014-01-23 12:19:25', 'Venda do jogador ST - Cavani - Uruguaio - France Ligue 1', '143', null);
INSERT INTO `tb_financa` VALUES ('83', 'VENDA_JOGADOR', '38900.00', '2185.00', '2014-01-23 15:01:12', 'Venda do jogador RW - Walcott - Inglês - England Premier League', '147', null);
INSERT INTO `tb_financa` VALUES ('84', 'VENDA_JOGADOR', '41180.00', '2280.00', '2014-01-23 15:01:23', 'Venda do jogador RW - Walcott - Inglês - England Premier League', '146', null);
INSERT INTO `tb_financa` VALUES ('85', 'VENDA_JOGADOR', '42225.00', '1045.00', '2014-01-23 16:15:17', 'Venda do jogador ST - Benteke - Belga - England Premier League', '132', null);
INSERT INTO `tb_financa` VALUES ('86', 'VENDA_JOGADOR', '42557.50', '332.50', '2014-01-23 16:15:42', 'Venda do jogador CB  - Henrique - Brasileiro - Liga do Brasil', '19', null);
INSERT INTO `tb_financa` VALUES ('87', 'COMPRA_JOGADOR', '20057.50', '22500.00', '2014-01-24 09:14:32', 'Compra do jogador ST - Eto\'o - Camaronês - England Premier League', '148', null);
INSERT INTO `tb_financa` VALUES ('88', 'GANHO_PARTIDA', '20610.50', '553.00', '2014-01-24 09:15:25', 'Scoroz United 2 X 0 Kingdons FC  em 24/01/2014 - 09:15', null, '16');
INSERT INTO `tb_financa` VALUES ('89', 'GANHO_PARTIDA', '21074.50', '464.00', '2014-01-24 09:15:47', 'SANTOS FTBC 1 X 1 Scoroz United  em 24/01/2014 - 09:15', null, '17');
INSERT INTO `tb_financa` VALUES ('90', 'GANHO_TORNEIO', '24474.50', '3400.00', '2014-01-24 09:19:18', 'Premiação permanencia na 6° divisão do Temp. Online', null, null);
INSERT INTO `tb_financa` VALUES ('91', 'VENDA_JOGADOR', '24949.50', '475.00', '2014-01-24 09:19:41', 'Venda do jogador CB  - Zebina - Francês - France Ligue 1', '127', null);
INSERT INTO `tb_financa` VALUES ('92', 'VENDA_JOGADOR', '25899.50', '950.00', '2014-01-24 09:20:56', 'Venda do jogador CAM - Coutinho - Brasileiro - England Premier League', '140', null);
INSERT INTO `tb_financa` VALUES ('93', 'COMPRA_JOGADOR', '24699.50', '1200.00', '2014-01-24 09:21:41', 'Compra do jogador ST - Fernando Torres - Espanhol - England Premier League', '149', null);
INSERT INTO `tb_financa` VALUES ('94', 'COMPRA_JOGADOR', '23599.50', '1100.00', '2014-01-24 09:22:10', 'Compra do jogador ST - Fernando Torres - Espanhol - England Premier League', '150', null);
INSERT INTO `tb_financa` VALUES ('95', 'COMPRA_JOGADOR', '22399.50', '1200.00', '2014-01-24 09:22:44', 'Compra do jogador ST - Fernando Torres - Espanhol - England Premier League', '151', null);
INSERT INTO `tb_financa` VALUES ('96', 'VENDA_JOGADOR', '43537.00', '21137.50', '2014-01-24 09:23:17', 'Venda do jogador ST - Eto\'o - Camaronês - England Premier League', '148', null);
INSERT INTO `tb_financa` VALUES ('97', 'VENDA_JOGADOR', '44487.00', '950.00', '2014-01-24 09:32:49', 'Venda do jogador ST - Benteke - Belga - England Premier League', '133', null);
INSERT INTO `tb_financa` VALUES ('98', 'VENDA_JOGADOR', '45009.50', '522.50', '2014-01-24 09:40:41', 'Venda do jogador CM - Cahill - Australiano - USA Major League Soccer', '44', null);
INSERT INTO `tb_financa` VALUES ('99', 'COMPRA_JOGADOR', '42609.50', '2400.00', '2014-01-24 09:41:37', 'Compra do jogador CB  - Dante - Brasileiro - Germany 1. Bundesliga', '152', null);
INSERT INTO `tb_financa` VALUES ('100', 'COMPRA_JOGADOR', '40209.50', '2400.00', '2014-01-24 09:42:31', 'Compra do jogador CB  - Dante - Brasileiro - Germany 1. Bundesliga', '153', null);
INSERT INTO `tb_financa` VALUES ('101', 'COMPRA_JOGADOR', '37809.50', '2400.00', '2014-01-24 09:43:47', 'Compra do jogador CB  - Dante - Brasileiro - Germany 1. Bundesliga', '154', null);
INSERT INTO `tb_financa` VALUES ('102', 'COMPRA_JOGADOR', '35409.50', '2400.00', '2014-01-24 09:44:17', 'Compra do jogador CB  - Dante - Brasileiro - Germany 1. Bundesliga', '155', null);
INSERT INTO `tb_financa` VALUES ('103', 'COMPRA_JOGADOR', '28509.50', '6900.00', '2014-01-24 09:45:40', 'Compra do jogador RM - Hulk - Brasileiro - Russia Premier League', '156', null);
INSERT INTO `tb_financa` VALUES ('104', 'COMPRA_JOGADOR', '21709.50', '6800.00', '2014-01-24 09:48:17', 'Compra do jogador RM - Hulk - Brasileiro - Russia Premier League', '157', null);
INSERT INTO `tb_financa` VALUES ('105', 'COMPRA_JOGADOR', '8959.50', '12750.00', '2014-01-24 09:49:05', 'Compra do jogador CM - Tevez - Argentino - Italy Serie A', '158', null);
INSERT INTO `tb_financa` VALUES ('106', 'VENDA_JOGADOR', '22259.50', '13300.00', '2014-01-24 09:49:19', 'Venda do jogador CM - Tevez - Argentino - Italy Serie A', '158', null);
INSERT INTO `tb_financa` VALUES ('107', 'VENDA_JOGADOR', '24824.50', '2565.00', '2014-01-24 10:26:15', 'Venda do jogador CB  - Dante - Brasileiro - Germany 1. Bundesliga', '155', null);
INSERT INTO `tb_financa` VALUES ('108', 'VENDA_JOGADOR', '27389.50', '2565.00', '2014-01-24 10:26:40', 'Venda do jogador CB  - Dante - Brasileiro - Germany 1. Bundesliga', '154', null);
INSERT INTO `tb_financa` VALUES ('109', 'VENDA_JOGADOR', '28814.50', '1425.00', '2014-01-24 10:28:39', 'Venda do jogador ST - Fernando Torres - Espanhol - England Premier League', '151', null);
INSERT INTO `tb_financa` VALUES ('110', 'VENDA_JOGADOR', '30619.50', '1805.00', '2014-01-24 10:29:38', 'Venda do jogador ST - Fernando Torres - Espanhol - England Premier League', '149', null);
INSERT INTO `tb_financa` VALUES ('111', 'VENDA_JOGADOR', '32139.50', '1520.00', '2014-01-24 10:29:51', 'Venda do jogador ST - Fernando Torres - Espanhol - England Premier League', '150', null);
INSERT INTO `tb_financa` VALUES ('112', 'VENDA_JOGADOR', '34704.50', '2565.00', '2014-01-24 11:43:35', 'Venda do jogador CB  - Dante - Brasileiro - Germany 1. Bundesliga', '153', null);
INSERT INTO `tb_financa` VALUES ('113', 'VENDA_JOGADOR', '37554.50', '2850.00', '2014-01-24 13:06:32', 'Venda do jogador CB  - Dante - Brasileiro - Germany 1. Bundesliga', '152', null);
INSERT INTO `tb_financa` VALUES ('114', 'VENDA_JOGADOR', '38194.50', '640.00', '2014-01-24 18:49:53', 'Venda do jogador CM - Lucho Gonzalez - Argentino - Portugal Liga ZON SAGRES', '110', null);
INSERT INTO `tb_financa` VALUES ('115', 'VENDA_JOGADOR', '38818.50', '624.00', '2014-01-24 18:55:48', 'Venda do jogador CB  - Déde - Brasileiro - Liga do Brasil', '114', null);
INSERT INTO `tb_financa` VALUES ('116', 'COMPRA_OUTROS', '38668.50', '150.00', '2014-01-24 19:20:07', 'Uniforme 1 Boca Jrs. ', null, null);
INSERT INTO `tb_financa` VALUES ('117', 'COMPRA_OUTROS', '38468.50', '200.00', '2014-01-24 19:20:28', 'Uniforme 2 Boca Jrs. ', null, null);
INSERT INTO `tb_financa` VALUES ('118', 'COMPRA_OUTROS', '38118.50', '350.00', '2014-01-24 19:21:16', 'Fisioterapeuta - Perna 15% - Y. Blais', null, null);
INSERT INTO `tb_financa` VALUES ('119', 'COMPRA_OUTROS', '37768.50', '350.00', '2014-01-24 19:21:41', 'Fisioterapeuta - Costas 15% - D. Schneider', null, null);
INSERT INTO `tb_financa` VALUES ('120', 'COMPRA_OUTROS', '37468.50', '300.00', '2014-01-24 19:22:21', 'Fisioterapeuta - Joelho 15% - M. Cree', null, null);
INSERT INTO `tb_financa` VALUES ('121', 'GANHO_PARTIDA', '37868.50', '400.00', '2014-01-24 20:02:58', 'Scoroz United 0 X 4 MARTINS FC  em 24/01/2014 - 20:02', null, '18');
INSERT INTO `tb_financa` VALUES ('122', 'VENDA_JOGADOR', '38533.50', '665.00', '2014-01-24 20:04:21', 'Venda do jogador LW - Atsu - Ganês - Holland Eredivisie', '121', null);
INSERT INTO `tb_financa` VALUES ('123', 'GANHO_PARTIDA', '39036.50', '503.00', '2014-01-24 20:26:51', 'Scoroz United 3 X 2 Malok12 FC  em 24/01/2014 - 20:26', null, '19');
INSERT INTO `tb_financa` VALUES ('124', 'GANHO_PARTIDA', '39291.50', '255.00', '2014-01-24 20:37:08', 'Pipoca Doce FC 0 X 1 Scoroz United  em 24/01/2014 - 20:37', null, '20');
INSERT INTO `tb_financa` VALUES ('125', 'GANHO_PARTIDA', '39750.00', '458.50', '2014-01-24 20:58:28', 'Scoroz United 1 X 1 S FURRENTS  em 24/01/2014 - 20:58', null, '21');
INSERT INTO `tb_financa` VALUES ('126', 'COMPRA_JOGADOR', '16250.00', '23500.00', '2014-01-24 22:06:57', 'Compra do jogador ST - Eto\'o - Camaronês - England Premier League', '159', null);
INSERT INTO `tb_financa` VALUES ('127', 'VENDA_JOGADOR', '16582.50', '332.50', '2014-01-24 23:22:22', 'Venda do jogador LW - Mounier - Francês - France Ligue 1', '69', null);
INSERT INTO `tb_financa` VALUES ('128', 'GANHO_PARTIDA', '16965.50', '383.00', '2014-01-24 23:51:15', 'Scoroz United 0 X 4 Rock n Roll Utd  em 24/01/2014 - 23:51', null, '22');
INSERT INTO `tb_financa` VALUES ('129', 'GANHO_PARTIDA', '17467.50', '502.00', '2014-01-25 00:20:54', 'Scoroz United 2 X 0 ASTROS FC  em 25/01/2014 - 00:20', null, '23');
INSERT INTO `tb_financa` VALUES ('130', 'GANHO_PARTIDA', '18057.50', '590.00', '2014-01-25 00:46:30', 'corta pa nois 0 X 6 Scoroz United  em 25/01/2014 - 00:46', null, '24');
INSERT INTO `tb_financa` VALUES ('131', 'GANHO_PARTIDA', '18471.50', '414.00', '2014-01-25 01:06:18', 'Scoroz United 1 X 2 JOGA 10 FC  em 25/01/2014 - 01:06', null, '25');
INSERT INTO `tb_financa` VALUES ('132', 'GANHO_PARTIDA', '18931.50', '460.00', '2014-01-25 01:26:53', 'Scoroz United 2 X 1 Corinthians FC  em 25/01/2014 - 01:26', null, '26');
INSERT INTO `tb_financa` VALUES ('133', 'GANHO_TORNEIO', '23731.50', '4800.00', '2014-01-25 01:28:00', 'Premiação Tem. 6 Online', null, null);
INSERT INTO `tb_financa` VALUES ('134', 'GANHO_PARTIDA', '24210.50', '479.00', '2014-01-25 01:52:36', 'Scoroz United 3 X 1 GLORIOUS FC  em 25/01/2014 - 01:52', null, '27');
INSERT INTO `tb_financa` VALUES ('135', 'GANHO_PARTIDA', '24649.50', '439.00', '2014-01-25 02:12:26', 'Scoroz United 1 X 1 foo fighters   em 25/01/2014 - 02:12', null, '28');
INSERT INTO `tb_financa` VALUES ('136', 'GANHO_PARTIDA', '25090.50', '441.00', '2014-01-25 02:34:54', 'Scoroz United 1 X 1 EC Carmosina  em 25/01/2014 - 02:34', null, '29');
INSERT INTO `tb_financa` VALUES ('137', 'GANHO_PARTIDA', '25631.50', '541.00', '2014-01-25 02:54:10', 'Scoroz United 5 X 1 Gidaro FC  em 25/01/2014 - 02:54', null, '30');
INSERT INTO `tb_financa` VALUES ('138', 'GANHO_PARTIDA', '26132.50', '501.00', '2014-01-25 03:14:45', 'galaticos cf 1 X 3 Scoroz United  em 25/01/2014 - 03:14', null, '31');
INSERT INTO `tb_financa` VALUES ('139', 'GANHO_PARTIDA', '26540.50', '408.00', '2014-01-25 03:36:12', 'Scoroz United 0 X 1 vovo FC  em 25/01/2014 - 03:36', null, '32');
INSERT INTO `tb_financa` VALUES ('140', 'GANHO_PARTIDA', '27102.50', '562.00', '2014-01-25 04:00:19', 'Scoroz United 9 X 2 Schmeat FC  em 25/01/2014 - 04:00', null, '33');
INSERT INTO `tb_financa` VALUES ('141', 'GANHO_PARTIDA', '27725.50', '623.00', '2014-01-25 04:25:04', 'GUILHERME FC 0 X 9 Scoroz United  em 25/01/2014 - 04:25', null, '34');
INSERT INTO `tb_financa` VALUES ('142', 'VENDA_JOGADOR', '34850.50', '7125.00', '2014-01-25 09:33:39', 'Venda do jogador RM - Hulk - Brasileiro - Russia Premier League', '157', null);
INSERT INTO `tb_financa` VALUES ('143', 'COMPRA_JOGADOR', '24100.50', '10750.00', '2014-01-25 09:55:30', 'Compra do jogador CAM - Nasri - Francês - England Premier League', '160', null);
INSERT INTO `tb_financa` VALUES ('144', 'GANHO_PARTIDA', '24543.50', '443.00', '2014-01-25 11:55:04', 'Scoroz United 1 X 1 Atletico Garcia  em 25/01/2014 - 11:55', null, '35');
INSERT INTO `tb_financa` VALUES ('145', 'GANHO_PARTIDA', '24969.50', '426.00', '2014-01-25 12:14:45', 'Scoroz United 0 X 1 Tiguez FC  em 25/01/2014 - 12:14', null, '36');
INSERT INTO `tb_financa` VALUES ('146', 'GANHO_TORNEIO', '30569.50', '5600.00', '2014-01-25 12:16:10', 'Premiação Tem. 5 Online', null, null);
INSERT INTO `tb_financa` VALUES ('147', 'GANHO_PARTIDA', '30995.50', '426.00', '2014-01-25 12:37:08', 'Timao FC 2 X 1 Scoroz United  em 25/01/2014 - 12:37', null, '37');
INSERT INTO `tb_financa` VALUES ('148', 'GANHO_PARTIDA', '31524.50', '529.00', '2014-01-25 12:59:13', 'Scoroz United 1 X 0 IPIAU FUTEBOL  em 25/01/2014 - 12:59', null, '38');
INSERT INTO `tb_financa` VALUES ('149', 'GANHO_PARTIDA', '31945.50', '421.00', '2014-01-25 13:18:14', 'Scoroz United 2 X 4 spirit  em 25/01/2014 - 13:18', null, '39');
INSERT INTO `tb_financa` VALUES ('150', 'GANHO_PARTIDA', '32566.50', '621.00', '2014-01-25 13:37:35', 'Yolo FC 0 X 4 Scoroz United  em 25/01/2014 - 13:37', null, '40');
INSERT INTO `tb_financa` VALUES ('151', 'VENDA_JOGADOR', '40071.50', '7505.00', '2014-01-25 17:34:47', 'Venda do jogador RM - Hulk - Brasileiro - Russia Premier League', '156', null);
INSERT INTO `tb_financa` VALUES ('152', 'VENDA_JOGADOR', '40784.00', '712.50', '2014-01-25 17:35:11', 'Venda do jogador CM - Witsel - Belga - Russia Premier League', '109', null);
INSERT INTO `tb_financa` VALUES ('153', 'VENDA_JOGADOR', '42494.00', '1710.00', '2014-01-25 17:46:05', 'Venda do jogador ST - Negredo - Espanhol - England Premier League', '97', null);
INSERT INTO `tb_financa` VALUES ('154', 'VENDA_JOGADOR', '43539.00', '1045.00', '2014-01-25 17:46:39', 'Venda do jogador LB  - Evra - Francês - England Premier League', '99', null);
INSERT INTO `tb_financa` VALUES ('155', 'COMPRA_JOGADOR', '43539.00', '0.00', '2014-01-25 17:48:31', 'Compra do jogador RW - Sanchez - Chileno - Spain Primera Division', '161', null);
INSERT INTO `tb_financa` VALUES ('156', 'VENDA_JOGADOR', '44964.00', '1425.00', '2014-01-25 17:48:52', 'Venda do jogador RW - Sanchez - Chileno - Spain Primera Division', '161', null);
INSERT INTO `tb_financa` VALUES ('157', 'VENDA_JOGADOR', '45629.00', '665.00', '2014-01-25 17:49:16', 'Venda do jogador GK  - Vorn - Holandês - England Premier League', '103', null);
INSERT INTO `tb_financa` VALUES ('158', 'VENDA_JOGADOR', '46389.00', '760.00', '2014-01-25 17:49:38', 'Venda do jogador CB  - Mangala - Francês - Portugal Liga ZON SAGRES', '106', null);
INSERT INTO `tb_financa` VALUES ('159', 'COMPRA_JOGADOR', '44889.00', '1500.00', '2014-01-25 17:55:15', 'Compra do jogador CM - Paulinho - Brasileiro - England Premier League', '162', null);
INSERT INTO `tb_financa` VALUES ('160', 'COMPRA_JOGADOR', '4139.00', '40750.00', '2014-01-25 18:01:35', 'Compra do jogador CF - Rooney - Inglês - England Premier League', '163', null);
INSERT INTO `tb_financa` VALUES ('161', 'GANHO_PARTIDA', '4683.00', '544.00', '2014-01-25 18:31:07', 'Scoroz United 4 X 0 tri mundial  em 25/01/2014 - 18:31', null, '41');
INSERT INTO `tb_financa` VALUES ('162', 'GANHO_PARTIDA', '5141.00', '458.00', '2014-01-25 19:03:53', 'Scoroz United 2 X 1 GRANDES FAMOSOS  em 25/01/2014 - 19:03', null, '42');
INSERT INTO `tb_financa` VALUES ('163', 'GANHO_PARTIDA', '5470.00', '329.00', '2014-01-25 19:16:11', 'Scoroz United 3 X 0 Parque Orlanda1  em 25/01/2014 - 19:16', null, '43');
INSERT INTO `tb_financa` VALUES ('164', 'GANHO_PARTIDA', '5871.00', '401.00', '2014-01-25 19:34:57', 'Adelaide FC 2 X 1 Scoroz United  em 25/01/2014 - 19:34', null, '44');
INSERT INTO `tb_financa` VALUES ('165', 'GANHO_PARTIDA', '6340.00', '469.00', '2014-01-25 19:58:21', 'Scoroz United 3 X 2 Quase Perdi FC  em 25/01/2014 - 19:58', null, '45');
INSERT INTO `tb_financa` VALUES ('166', 'GANHO_TORNEIO', '13540.00', '7200.00', '2014-01-25 19:59:04', 'Premiação Tem. 3 Online', null, null);
INSERT INTO `tb_financa` VALUES ('167', 'VENDA_JOGADOR', '37527.50', '23987.50', '2014-01-25 20:00:50', 'Venda do jogador ST - Eto\'o - Camaronês - England Premier League', '159', null);
INSERT INTO `tb_financa` VALUES ('168', 'VENDA_JOGADOR', '38192.50', '665.00', '2014-01-25 20:01:28', 'Venda do jogador ST - Doumbia - Alemão - Russia Premier League', '107', null);
INSERT INTO `tb_financa` VALUES ('169', 'VENDA_JOGADOR', '38857.50', '665.00', '2014-01-25 20:01:51', 'Venda do jogador CB  - Diatike - Francês - England Premier League', '120', null);
INSERT INTO `tb_financa` VALUES ('170', 'GANHO_PARTIDA', '39503.00', '646.00', '2014-01-25 20:27:10', 'Scoroz United 7 X 1 Maniadeser FC  em 25/01/2014 - 20:27', null, '46');
INSERT INTO `tb_financa` VALUES ('171', 'GANHO_PARTIDA', '39969.00', '466.00', '2014-01-26 12:04:24', 'Scoroz United 0 X 0 ESTRAGA DOMINGO  em 26/01/2014 - 12:04', null, '47');
INSERT INTO `tb_financa` VALUES ('172', 'GANHO_PARTIDA', '40466.00', '497.00', '2014-01-26 12:28:24', 'Scoroz United 1 X 0 Annihilation  em 26/01/2014 - 12:28', null, '48');
INSERT INTO `tb_financa` VALUES ('173', 'GANHO_PARTIDA', '40910.00', '444.00', '2014-01-26 13:46:23', 'Scoroz United 1 X 1 Dragons FC  em 26/01/2014 - 13:46', null, '49');
INSERT INTO `tb_financa` VALUES ('174', 'GANHO_PARTIDA', '41399.00', '489.00', '2014-01-26 14:06:07', 'Vista Alegre 2 X 3 Scoroz United  em 26/01/2014 - 14:06', null, '50');
INSERT INTO `tb_financa` VALUES ('175', 'GANHO_PARTIDA', '41866.00', '467.00', '2014-01-26 14:25:20', 'Scoroz United 2 X 2 PASQUALI FBPA  em 26/01/2014 - 14:25', null, '51');
INSERT INTO `tb_financa` VALUES ('176', 'COMPRA_JOGADOR', '32866.00', '9000.00', '2014-01-26 14:38:26', 'Compra do jogador CB  - David Luiz - Brasileiro - England Premier League', '164', null);
INSERT INTO `tb_financa` VALUES ('177', 'GANHO_PARTIDA', '33271.00', '405.00', '2014-01-26 15:05:21', 'W13 1 X 0 Scoroz United  em 26/01/2014 - 15:05', null, '52');
INSERT INTO `tb_financa` VALUES ('178', 'GANHO_PARTIDA', '33665.00', '394.00', '2014-01-26 15:24:28', 'Scoroz United 0 X 3 PANICO NA LIVE  em 26/01/2014 - 15:24', null, '53');
INSERT INTO `tb_financa` VALUES ('179', 'GANHO_PARTIDA', '34181.00', '516.00', '2014-01-26 15:43:51', 'Scoroz United 3 X 2 letzgettricky  em 26/01/2014 - 15:43', null, '54');
INSERT INTO `tb_financa` VALUES ('180', 'GANHO_PARTIDA', '34604.00', '423.00', '2014-01-26 16:03:03', 'nalim united 1 X 0 Scoroz United  em 26/01/2014 - 16:03', null, '55');
INSERT INTO `tb_financa` VALUES ('181', 'GANHO_TORNEIO', '40804.00', '6200.00', '2014-01-26 16:03:50', 'Premiação Tem. 3 Online', null, null);
INSERT INTO `tb_financa` VALUES ('182', 'VENDA_JOGADOR', '41469.00', '665.00', '2014-01-26 16:04:36', 'Venda do jogador ST - Crouch - Inglês - England Premier League', '118', null);
INSERT INTO `tb_financa` VALUES ('183', 'GANHO_PARTIDA', '41928.00', '459.00', '2014-01-26 16:50:38', 'Real Favela FC 1 X 1 Scoroz United  em 26/01/2014 - 16:50', null, '56');
INSERT INTO `tb_financa` VALUES ('184', 'GANHO_PARTIDA', '42363.00', '435.00', '2014-01-26 17:11:27', 'Chaanuz FC 3 X 1 Scoroz United  em 26/01/2014 - 17:11', null, '57');
INSERT INTO `tb_financa` VALUES ('185', 'GANHO_PARTIDA', '42969.00', '606.00', '2014-01-26 17:32:59', 'GLORIOUS FC 0 X 4 Scoroz United  em 26/01/2014 - 17:32', null, '58');
INSERT INTO `tb_financa` VALUES ('186', 'GANHO_PARTIDA', '43542.00', '573.00', '2014-01-26 17:54:12', 'Scoroz United 6 X 2 AmigosDoMessi  em 26/01/2014 - 17:54', null, '59');
INSERT INTO `tb_financa` VALUES ('187', 'GANHO_PARTIDA', '43998.00', '456.00', '2014-01-26 18:24:33', 'Gladiadores 1 X 1 Scoroz United  em 26/01/2014 - 18:24', null, '60');
INSERT INTO `tb_financa` VALUES ('188', 'GANHO_PARTIDA', '44439.00', '441.00', '2014-01-26 18:44:00', 'coXa DoiDo FC 1 X 1 Scoroz United  em 26/01/2014 - 18:44', null, '61');
INSERT INTO `tb_financa` VALUES ('189', 'VENDA_JOGADOR', '45056.50', '617.50', '2014-01-26 22:29:20', 'Venda do jogador ST - Cissé - Senegalês - England Premier League', '86', null);
INSERT INTO `tb_financa` VALUES ('190', 'VENDA_JOGADOR', '45674.00', '617.50', '2014-01-26 23:30:22', 'Venda do jogador CAM - Dempsey - Americano - USA Major League Soccer', '105', null);

-- ----------------------------
-- Table structure for tb_jogadores_plantel
-- ----------------------------
DROP TABLE IF EXISTS `tb_jogadores_plantel`;
CREATE TABLE `tb_jogadores_plantel` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DT_ALTERACAO` datetime DEFAULT NULL,
  `DT_ENTRADA` datetime DEFAULT NULL,
  `DT_SAIDA` datetime DEFAULT NULL,
  `VLR_LUCRO` decimal(19,2) DEFAULT NULL,
  `DS_NOME` varchar(255) DEFAULT NULL,
  `NU_RATING` int(11) DEFAULT NULL,
  `VLR_SUG_VENDA` decimal(19,2) DEFAULT NULL,
  `VLR_PAGO` decimal(19,2) DEFAULT NULL,
  `VLR_VENDA` decimal(19,2) DEFAULT NULL,
  `CATEGORIA_FK` bigint(20) DEFAULT NULL,
  `CLUBE_FK` bigint(20) DEFAULT NULL,
  `LIGA_FK` bigint(20) DEFAULT NULL,
  `NACIONALIDADE_FK` bigint(20) DEFAULT NULL,
  `DS_POSICAO` bigint(20) DEFAULT NULL,
  `STATUS_FK` bigint(20) DEFAULT NULL,
  `FL_VENDIDO` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKB41BF3286C31934` (`NACIONALIDADE_FK`),
  KEY `FKB41BF3230330468` (`DS_POSICAO`),
  KEY `FKB41BF32A53662E` (`LIGA_FK`),
  KEY `FKB41BF321700EADE` (`CLUBE_FK`),
  KEY `FKB41BF32615AAA56` (`CATEGORIA_FK`),
  KEY `FKB41BF324B25C238` (`STATUS_FK`),
  CONSTRAINT `FKB41BF321700EADE` FOREIGN KEY (`CLUBE_FK`) REFERENCES `tb_clube` (`ID`),
  CONSTRAINT `FKB41BF3230330468` FOREIGN KEY (`DS_POSICAO`) REFERENCES `tb_pos_jogador` (`ID`),
  CONSTRAINT `FKB41BF324B25C238` FOREIGN KEY (`STATUS_FK`) REFERENCES `tb_status_jogador` (`ID`),
  CONSTRAINT `FKB41BF32615AAA56` FOREIGN KEY (`CATEGORIA_FK`) REFERENCES `tb_categoria_jogador` (`ID`),
  CONSTRAINT `FKB41BF3286C31934` FOREIGN KEY (`NACIONALIDADE_FK`) REFERENCES `tb_nacionalidade_jogador` (`ID`),
  CONSTRAINT `FKB41BF32A53662E` FOREIGN KEY (`LIGA_FK`) REFERENCES `tb_liga` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=165 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_jogadores_plantel
-- ----------------------------
INSERT INTO `tb_jogadores_plantel` VALUES ('1', null, '2014-01-15 00:00:00', null, '0.00', 'Rensing', '76', '0.00', '0.00', '0.00', '2', '307', '17', '9', '1', '2', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('2', null, '2014-01-15 00:00:00', null, '0.00', 'Mignolet', '80', '0.00', '0.00', '0.00', '1', '160', '10', '6', '1', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('3', null, '2014-01-15 00:00:00', null, '0.00', 'Begovic', '81', '0.00', '0.00', '0.00', '1', '167', '10', '18', '1', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('4', '2014-01-21 16:04:39', '2014-01-15 00:00:00', '2014-01-19 11:36:03', '0.00', 'Jefferson', '82', '0.00', '0.00', '650.00', '1', '61', '4', '1', '1', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('5', null, '2014-01-15 00:00:00', null, '0.00', 'Rafael', '77', '0.00', '0.00', '450.00', '2', '351', '19', '1', '1', '3', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('6', '2014-01-22 10:03:59', '2014-01-15 00:00:00', '2014-01-22 10:03:59', '855.00', 'Ospina', '75', '650.00', '0.00', '900.00', '2', '255', '14', '22', '1', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('7', null, '2014-01-15 00:00:00', null, '0.00', 'Lee Chang Keun', '57', '0.00', '0.00', '0.00', '6', '545', '32', '7', '1', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('8', null, '2014-01-15 00:00:00', null, '0.00', 'Jourdren', '76', '0.00', '0.00', '304.00', '2', '254', '14', '2', '1', '3', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('9', '2014-01-20 11:55:43', '2014-01-15 00:00:00', null, '0.00', 'Lloris', '84', '0.00', '0.00', '0.00', '1', '166', '10', '2', '1', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('10', null, '2014-01-15 00:00:00', null, '0.00', 'Fabiansky', '76', '0.00', '0.00', '450.00', '2', '152', '10', '17', '1', '3', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('11', null, '2014-01-15 00:00:00', null, '0.00', 'Sorto', '58', '0.00', '0.00', '0.00', '6', '26', '2', '13', '2', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('12', null, '2014-01-15 00:00:00', null, '0.00', 'Hugo Mallo', '75', '0.00', '0.00', '250.00', '2', '470', '27', '4', '2', '3', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('13', null, '2014-01-15 00:00:00', null, '0.00', 'Kelly', '75', '0.00', '0.00', '0.00', '2', '160', '10', '3', '2', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('14', null, '2014-01-15 00:00:00', null, '0.00', 'Johnson', '79', '0.00', '0.00', '0.00', '1', '160', '10', '3', '2', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('15', null, '2014-01-15 00:00:00', null, '0.00', 'Abate', '78', '0.00', '0.00', '0.00', '1', '350', '19', '5', '2', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('16', null, '2014-01-15 00:00:00', null, '0.00', 'Vermaelen', '81', '0.00', '0.00', '0.00', '1', '152', '10', '6', '3', '4', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('17', null, '2014-01-15 00:00:00', null, '0.00', 'Manoel', '75', '0.00', '0.00', '450.00', '2', '59', '4', '1', '3', '3', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('18', null, '2014-01-15 00:00:00', null, '0.00', 'Rodholfo', '76', '0.00', '0.00', '0.00', '2', '69', '4', '1', '3', '2', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('19', '2014-01-23 16:15:42', '2014-01-15 00:00:00', '2014-01-23 16:15:42', '332.50', 'Henrique', '76', '0.00', '0.00', '350.00', '2', '58', '4', '1', '3', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('20', '2014-01-23 11:01:53', '2014-01-15 00:00:00', '2014-01-23 11:01:53', '712.50', 'F. Santana', '77', '0.00', '0.00', '750.00', '1', '293', '16', '1', '3', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('21', null, '2014-01-15 00:00:00', null, '0.00', 'Kim Tae Yoon', '60', '0.00', '0.00', '0.00', '6', '552', '32', '7', '3', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('22', null, '2014-01-15 00:00:00', null, '0.00', 'Koscielny', '81', '0.00', '0.00', '0.00', '1', '152', '10', '2', '3', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('23', null, '2014-01-15 00:00:00', null, '0.00', 'Koscielny', '81', '0.00', '0.00', '0.00', '1', '152', '10', '2', '3', '3', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('24', null, '2014-01-15 00:00:00', null, '0.00', 'Kaboul', '80', '0.00', '0.00', '0.00', '1', '166', '10', '2', '3', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('25', null, '2014-01-15 00:00:00', null, '0.00', 'Smalling', '78', '0.00', '0.00', '0.00', '1', '162', '10', '3', '3', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('26', null, '2014-01-15 00:00:00', null, '0.00', 'Chiriches', '75', '0.00', '0.00', '0.00', '2', '166', '10', '25', '3', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('27', null, '2014-01-15 00:00:00', null, '0.00', 'Marcelo', '83', '0.00', '0.00', '0.00', '1', '480', '27', '1', '4', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('28', null, '2014-01-15 00:00:00', null, '0.00', 'Balenziaga', '75', '0.00', '0.00', '0.00', '2', '467', '27', '4', '4', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('29', null, '2014-01-15 00:00:00', null, '0.00', 'Clichy', '81', '0.00', '0.00', '0.00', '1', '161', '10', '2', '4', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('30', null, '2014-01-15 00:00:00', null, '0.00', 'A. Cole', '85', '0.00', '0.00', '2200.00', '1', '155', '10', '3', '4', '3', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('31', '2014-01-18 20:36:25', '2014-01-15 00:00:00', '2014-01-18 20:36:25', '0.00', 'A. Cole', '85', '2090.00', '1900.00', '2100.00', '1', '155', '10', '3', '4', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('32', null, '2014-01-15 00:00:00', null, '0.00', 'Horwood', '60', '0.00', '0.00', '0.00', '6', '217', '12', '3', '4', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('33', '2014-01-21 11:56:27', '2014-01-15 00:00:00', null, '0.00', 'Crescenzi', '61', '0.00', '0.00', '0.00', '6', '244', '14', '5', '4', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('34', null, '2014-01-15 00:00:00', null, '0.00', 'Garofalo', '63', '0.00', '0.00', '0.00', '6', '370', '20', '5', '4', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('35', null, '2014-01-15 00:00:00', null, '0.00', 'Grillo', '63', '0.00', '0.00', '0.00', '6', '376', '20', '5', '4', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('36', null, '2014-01-15 00:00:00', null, '0.00', 'Gustafsson', '62', '0.00', '0.00', '0.00', '6', '513', '29', '28', '4', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('37', '2014-01-21 16:35:58', '2014-01-15 00:00:00', '2014-01-21 16:35:58', '202.50', 'Luiz Gustavo', '81', '770.00', '700.00', '950.00', '1', '300', '16', '1', '8', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('38', null, '2014-01-15 00:00:00', null, '0.00', 'Mario Suarez', '79', '0.00', '0.00', '450.00', '2', '468', '27', '4', '8', '3', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('39', null, '2014-01-15 00:00:00', null, '0.00', 'Beobide', '63', '0.00', '0.00', '0.00', '6', '493', '28', '4', '8', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('40', null, '2014-01-15 00:00:00', null, '0.00', 'Sergi Guilló', '60', '0.00', '0.00', '0.00', '6', '471', '27', '4', '8', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('41', '2014-01-19 11:34:43', '2014-01-15 00:00:00', '2014-01-19 11:34:43', '0.00', 'Cañas', '77', '0.00', '0.00', '350.00', '2', '169', '10', '4', '8', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('42', null, '2014-01-15 00:00:00', null, '0.00', 'Toulalan', '82', '0.00', '0.00', '0.00', '1', '245', '14', '2', '8', '3', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('43', '2014-01-20 12:01:55', '2014-01-15 00:00:00', null, '0.00', 'Saihi', '76', '0.00', '0.00', '0.00', '2', '254', '14', '24', '8', '2', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('44', '2014-01-24 09:40:41', '2014-01-15 00:00:00', '2014-01-24 09:40:41', '522.50', 'Cahill', '75', '0.00', '0.00', '550.00', '1', '29', '2', '8', '9', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('45', null, '2014-01-15 00:00:00', null, '0.00', 'Fellaini', '81', '0.00', '0.00', '0.00', '1', '162', '10', '6', '9', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('46', null, '2014-01-15 00:00:00', null, '0.00', 'Ramires', '80', '0.00', '0.00', '0.00', '1', '155', '10', '1', '9', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('47', null, '2014-01-15 00:00:00', null, '0.00', 'Fernandinho', '81', '0.00', '0.00', '0.00', '2', '161', '10', '1', '9', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('48', '2014-01-20 12:02:11', '2014-01-15 00:00:00', null, '0.00', 'Hetemaj', '75', '0.00', '0.00', '0.00', '2', '342', '19', '23', '9', '2', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('49', null, '2014-01-15 00:00:00', null, '0.00', 'Bodmer', '75', '0.00', '0.00', '250.00', '2', '257', '14', '2', '9', '3', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('50', null, '2014-01-15 00:00:00', null, '0.00', 'Strootman', '79', '0.00', '0.00', '400.00', '2', '353', '19', '12', '9', '3', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('51', null, '2014-01-15 00:00:00', null, '0.00', 'Rodwell', '77', '0.00', '0.00', '500.00', '2', '161', '10', '3', '9', '3', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('52', null, '2014-01-15 00:00:00', null, '0.00', 'Baselli', '61', '0.00', '0.00', '0.00', '6', '338', '19', '5', '9', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('53', null, '2014-01-15 00:00:00', null, '0.00', 'Verre', '59', '0.00', '0.00', '0.00', '6', '373', '20', '5', '9', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('54', null, '2014-01-15 00:00:00', null, '0.00', 'Cruzado', '73', '0.00', '0.00', '300.00', '4', '49', '3', '29', '9', '3', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('55', null, '2014-01-15 00:00:00', null, '0.00', 'D. Tardelli', '76', '0.00', '0.00', '550.00', '2', '58', '4', '1', '10', '3', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('56', null, '2014-01-15 00:00:00', null, '0.00', 'Koo', '76', '0.00', '0.00', '0.00', '2', '300', '16', '7', '10', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('57', '2014-01-22 15:36:19', '2014-01-15 00:00:00', '2014-01-22 15:36:19', '902.50', 'K. P. Boateng', '81', '0.00', '0.00', '950.00', '1', '293', '16', '14', '10', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('58', null, '2014-01-15 00:00:00', null, '0.00', 'Kone', '75', '0.00', '0.00', '500.00', '2', '339', '19', '20', '10', '3', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('59', '2014-01-18 20:33:33', '2014-01-15 00:00:00', '2014-01-18 20:33:33', '0.00', 'Rosicky', '80', '0.00', '0.00', '1000.00', '1', '152', '10', '19', '10', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('60', null, '2014-01-15 00:00:00', null, '0.00', 'Schurrle', '80', '0.00', '0.00', '0.00', '1', '155', '10', '9', '14', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('61', '2014-01-19 11:35:37', '2014-01-15 00:00:00', '2014-01-19 11:35:37', '0.00', 'John', '77', '0.00', '0.00', '400.00', '2', '425', '23', '12', '14', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('62', null, '2014-01-15 00:00:00', null, '0.00', 'Evans', '57', '0.00', '0.00', '0.00', '6', '460', '26', '27', '14', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('63', null, '2014-01-15 00:00:00', null, '0.00', 'Yaschuk', '55', '0.00', '0.00', '0.00', '6', '454', '25', '26', '14', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('64', null, '2014-01-15 00:00:00', null, '0.00', 'Mirallas', '80', '0.00', '0.00', '0.00', '2', '157', '10', '6', '15', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('65', '2014-01-21 18:00:39', '2014-01-15 00:00:00', '2014-01-21 18:00:39', '760.00', 'Pastore', '79', '0.00', '0.00', '800.00', '1', '257', '14', '2', '15', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('66', null, '2014-01-15 00:00:00', null, '0.00', 'Isla', '77', '0.00', '0.00', '0.00', '2', '347', '19', '5', '15', '3', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('67', '2014-01-20 11:58:01', '2014-01-15 00:00:00', null, '0.00', 'Nani', '83', '0.00', '0.00', '0.00', '1', '162', '10', '15', '15', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('68', '2014-01-20 12:14:35', '2014-01-15 00:00:00', null, '0.00', 'Pedro', '85', '4500.00', '0.00', '0.00', '1', '472', '27', '4', '18', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('69', '2014-01-24 23:22:22', '2014-01-15 00:00:00', '2014-01-24 23:22:22', '332.50', 'Mounier', '77', '0.00', '0.00', '350.00', '2', '254', '14', '2', '19', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('70', '2014-01-20 00:20:08', '2014-01-15 00:00:00', '2014-01-20 00:20:08', '1805.00', 'Sterling', '76', '0.00', '0.00', '1900.00', '1', '160', '10', '3', '19', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('71', '2014-01-21 16:30:41', '2014-01-15 00:00:00', '2014-01-21 16:30:41', '332.50', 'Chambers', '60', '0.00', '0.00', '350.00', '6', '243', '13', '3', '19', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('72', null, '2014-01-15 00:00:00', null, '0.00', 'Ngankam', '57', '0.00', '0.00', '0.00', '6', '292', '16', '9', '22', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('73', null, '2014-01-15 00:00:00', null, '0.00', 'Belfodil', '75', '0.00', '0.00', '0.00', '2', '346', '19', '21', '22', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('74', '2014-01-20 11:55:17', '2014-01-15 00:00:00', null, '0.00', 'Ruben', '75', '0.00', '0.00', '0.00', '2', '248', '14', '10', '22', '2', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('75', null, '2014-01-15 00:00:00', null, '0.00', 'Higuain', '84', '0.00', '0.00', '0.00', '1', '351', '19', '10', '22', '3', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('76', null, '2014-01-15 00:00:00', null, '0.00', 'Stella', '54', '0.00', '0.00', '0.00', '6', '538', '31', '8', '22', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('77', null, '2014-01-15 00:00:00', null, '0.00', 'Gameiro', '62', '0.00', '0.00', '0.00', '6', '542', '31', '8', '22', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('78', '2014-01-19 11:32:49', '2014-01-15 00:00:00', '2014-01-19 11:32:55', '0.00', 'Benteke', '79', '1100.00', '1000.00', '1600.00', '1', '153', '10', '6', '22', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('79', null, '2014-01-15 00:00:00', null, '0.00', 'A. Pato', '80', '0.00', '0.00', '0.00', '1', '62', '4', '1', '22', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('80', null, '2014-01-15 00:00:00', null, '0.00', 'Leandro', '75', '0.00', '0.00', '250.00', '2', '583', '4', '1', '22', '3', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('81', null, '2014-01-15 00:00:00', null, '0.00', 'Suazo', '76', '0.00', '0.00', '400.00', '2', '9', '1', '16', '22', '3', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('82', null, '2014-01-15 00:00:00', null, '0.00', 'Lucas Segovia', '62', '0.00', '0.00', '0.00', '6', '7', '7', '4', '22', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('83', null, '2014-01-15 00:00:00', null, '0.00', 'F. Torres', '82', '0.00', '0.00', '0.00', '1', '155', '10', '4', '22', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('84', '2014-01-23 11:01:37', '2014-01-15 00:00:00', '2014-01-23 11:01:37', '570.00', 'Pellé', '78', '0.00', '0.00', '600.00', '1', '326', '18', '5', '22', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('85', null, '2014-01-15 00:00:00', null, '0.00', 'N\'Doye', '76', '0.00', '0.00', '304.00', '2', '448', '25', '11', '22', '3', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('86', '2014-01-26 22:29:20', '2014-01-15 00:00:00', '2014-01-26 22:29:20', '617.50', 'Cissé', '79', '0.00', '0.00', '650.00', '1', '163', '10', '11', '22', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('87', '2014-01-23 11:01:03', '2014-01-15 00:00:00', '2014-01-23 11:01:03', '617.50', 'Donovan', '78', '0.00', '0.00', '650.00', '1', '26', '2', '13', '23', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('88', null, '2014-01-15 00:00:00', null, '0.00', 'Carroll', '77', '0.00', '0.00', '0.00', '1', '171', '10', '3', '23', '3', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('92', '2014-01-21 16:40:00', '2014-01-15 00:00:00', '2014-01-21 16:40:00', '820.00', 'Luiz Gustavo', '81', '0.00', '700.00', '1600.00', '1', '300', '16', '1', '10', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('93', '2014-01-22 10:04:24', '2014-01-19 15:14:22', '2014-01-22 10:04:24', '2850.00', 'Dante', '84', '3000.00', '0.00', '3000.00', '1', '291', '16', '1', '3', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('94', null, '2014-01-19 15:15:47', null, '0.00', 'Balotelli', '84', '0.00', '0.00', '0.00', '1', '350', '19', '5', '22', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('95', '2014-01-22 09:22:54', '2014-01-19 15:17:56', '2014-01-22 09:22:54', '950.00', 'Klose', '83', '1000.00', '0.00', '1000.00', '1', '348', '19', '9', '22', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('96', '2014-01-21 18:01:01', '2014-01-19 15:20:03', '2014-01-21 18:01:01', '1045.00', 'Mandzukic', '83', '1000.00', '0.00', '1100.00', '1', '291', '16', '9', '22', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('97', '2014-01-25 17:46:05', '2014-01-19 15:21:01', '2014-01-25 17:46:05', '1710.00', 'Negredo', '83', '2000.00', '0.00', '1800.00', '1', '161', '10', '4', '22', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('98', '2014-01-22 11:35:00', '2014-01-19 15:21:53', '2014-01-22 11:35:00', '855.00', 'Samuel', '82', '900.00', '0.00', '900.00', '1', '346', '19', '10', '3', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('99', '2014-01-25 17:46:39', '2014-01-19 15:23:17', '2014-01-25 17:46:39', '1045.00', 'Evra', '82', '0.00', '0.00', '1100.00', '1', '162', '10', '2', '4', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('100', '2014-01-22 10:06:22', '2014-01-19 15:27:37', '2014-01-22 10:06:22', '1140.00', 'Howedes', '82', '900.00', '0.00', '1200.00', '1', '293', '16', '9', '3', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('101', null, '2014-01-19 15:34:51', null, '0.00', 'Vertonghen', '82', '0.00', '0.00', '0.00', '1', '166', '10', '6', '3', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('102', null, '2014-01-19 15:36:25', null, '0.00', 'Sánchez', '82', '0.00', '0.00', '0.00', '1', '472', '27', '16', '18', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('103', '2014-01-25 17:49:16', '2014-01-19 15:37:46', '2014-01-25 17:49:16', '665.00', 'Vorn', '81', '0.00', '0.00', '700.00', '1', '169', '10', '12', '1', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('104', null, '2014-01-19 15:38:33', null, '0.00', 'Sandro', '81', '0.00', '0.00', '0.00', '1', '166', '10', '1', '8', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('105', '2014-01-26 23:30:21', '2014-01-19 15:40:11', '2014-01-26 23:30:21', '617.50', 'Dempsey', '81', '800.00', '0.00', '650.00', '1', '34', '2', '13', '10', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('106', '2014-01-25 17:49:37', '2014-01-19 15:43:42', '2014-01-25 17:49:37', '760.00', 'Mangala', '81', '700.00', '0.00', '800.00', '1', '418', '23', '2', '3', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('107', '2014-01-25 20:01:28', '2014-01-19 15:45:00', '2014-01-25 20:01:28', '665.00', 'Doumbia', '80', '900.00', '0.00', '700.00', '1', '441', '25', '9', '22', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('108', '2014-01-22 09:23:11', '2014-01-19 15:45:46', '2014-01-22 09:23:11', '760.00', 'Sokratis', '80', '800.00', '0.00', '800.00', '1', '286', '16', '20', '3', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('109', '2014-01-25 17:35:11', '2014-01-19 15:46:45', '2014-01-25 17:35:11', '712.50', 'Witsel', '80', '1200.00', '0.00', '750.00', '1', '454', '25', '6', '9', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('110', '2014-01-24 18:49:53', '2014-01-19 15:48:19', '2014-01-24 18:49:53', '640.00', 'Lucho Gonzalez', '80', '900.00', '0.00', '640.00', '1', '418', '23', '10', '9', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('111', '2014-01-21 16:40:46', '2014-01-19 15:54:24', '2014-01-21 16:40:46', '902.50', 'Cáceres', '80', '1000.00', '0.00', '950.00', '1', '347', '19', '12', '3', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('112', '2014-01-24 11:54:57', '2014-01-19 15:55:07', null, '0.00', 'Chivu', '78', '0.00', '0.00', '0.00', '1', '346', '19', '9', '3', '2', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('113', '2014-01-24 11:55:17', '2014-01-19 20:34:53', null, '0.00', 'Alex', '78', '0.00', '0.00', '0.00', '1', '70', '4', '1', '10', '2', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('114', '2014-01-24 18:55:48', '2014-01-19 20:35:27', '2014-01-24 18:55:48', '624.00', 'Déde', '78', '0.00', '0.00', '624.00', '1', '65', '4', '1', '3', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('115', '2014-01-21 16:41:10', '2014-01-19 20:36:13', '2014-01-21 16:41:10', '855.00', 'Radu', '78', '900.00', '0.00', '900.00', '1', '348', '19', '18', '4', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('116', null, '2014-01-19 20:36:56', null, '0.00', 'Fazio', '78', '0.00', '0.00', '0.00', '1', '483', '27', '10', '3', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('117', '2014-01-21 11:45:41', '2014-01-19 20:38:22', null, '0.00', 'Wollscheid', '78', '750.00', '0.00', '0.00', '1', '285', '16', '9', '3', '2', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('118', '2014-01-26 16:04:36', '2014-01-19 20:39:00', '2014-01-26 16:04:36', '665.00', 'Crouch', '77', '0.00', '0.00', '700.00', '1', '167', '10', '3', '22', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('119', null, '2014-01-19 20:40:02', null, '0.00', 'Kucka', '77', '0.00', '0.00', '0.00', '1', '344', '19', '9', '9', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('120', '2014-01-25 20:01:51', '2014-01-19 20:40:43', '2014-01-25 20:01:51', '665.00', 'Diatike', '76', '0.00', '0.00', '700.00', '1', '168', '10', '2', '3', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('121', '2014-01-24 20:04:21', '2014-01-19 20:41:39', '2014-01-24 20:04:21', '665.00', 'Atsu', '76', '750.00', '0.00', '700.00', '1', '337', '18', '14', '19', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('122', '2014-01-22 10:06:47', '2014-01-19 20:46:50', '2014-01-22 10:06:47', '427.50', 'Rolfes', '79', '450.00', '0.00', '450.00', '2', '285', '16', '9', '8', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('123', '2014-01-23 09:24:33', '2014-01-19 20:47:32', '2014-01-23 09:24:33', '712.50', 'Costil', '78', '450.00', '0.00', '750.00', '2', '260', '14', '2', '1', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('124', null, '2014-01-19 20:48:35', null, '0.00', 'Simão', '76', '0.00', '0.00', '0.00', '2', '478', '27', '15', '14', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('125', null, '2014-01-19 20:49:19', null, '0.00', 'Zaccardo', '75', '0.00', '0.00', '0.00', '2', '350', '19', '5', '3', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('126', null, '2014-01-19 20:49:54', null, '0.00', 'Natali', '75', '0.00', '0.00', '0.00', '2', '339', '19', '5', '3', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('127', '2014-01-24 09:19:41', '2014-01-21 11:54:47', '2014-01-24 09:19:41', '475.00', 'Zebina', '75', '350.00', '0.00', '500.00', '2', '262', '14', '2', '3', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('128', null, '2014-01-21 12:27:06', null, null, 'Jobson', '72', '40000.00', '0.00', '0.00', '3', '564', '33', '1', '22', '4', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('129', '2014-01-21 16:41:36', '2014-01-21 13:32:05', '2014-01-21 16:41:36', '255.00', 'Diego Costa', '83', '2900.00', '2500.00', '2900.00', '1', '468', '27', '1', '22', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('130', '2014-01-23 12:10:02', '2014-01-21 16:55:59', '2014-01-23 12:10:02', '-170.00', 'Sturridge', '80', '0.00', '3400.00', '3400.00', '1', '160', '10', '3', '22', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('131', '2014-01-22 11:36:25', '2014-01-21 17:53:32', '2014-01-22 11:36:25', '510.00', 'Fernando Torres', '82', '0.00', '1200.00', '1800.00', '1', '155', '10', '4', '22', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('132', '2014-01-23 16:15:17', '2014-01-21 17:54:45', '2014-01-23 16:15:17', '45.00', 'Benteke', '79', '0.00', '1000.00', '1100.00', '1', '153', '10', '6', '22', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('133', '2014-01-24 09:32:49', '2014-01-21 17:55:15', '2014-01-24 09:32:49', '-150.00', 'Benteke', '79', '0.00', '1100.00', '1000.00', '1', '153', '10', '6', '22', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('134', null, '2014-01-21 17:56:36', null, '0.00', 'Coutinho', '80', '0.00', '850.00', '0.00', '1', '160', '10', '1', '10', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('135', '2014-01-23 11:00:23', '2014-01-22 12:11:53', '2014-01-23 11:00:23', '-185.00', 'Walker', '79', '4300.00', '3700.00', '3700.00', '1', '166', '10', '3', '2', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('136', '2014-01-22 15:50:23', '2014-01-22 14:42:24', '2014-01-22 15:50:23', '0.00', 'Coutinho', '80', '1300.00', '1100.00', '1300.00', '1', '160', '10', '1', '10', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('137', '2014-01-23 12:09:29', '2014-01-22 21:53:18', '2014-01-23 12:09:29', '30.00', 'Diego', '84', '0.00', '1300.00', '1400.00', '1', '300', '16', '1', '10', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('138', '2014-01-23 10:58:56', '2014-01-22 21:54:05', '2014-01-23 10:58:56', '-65.00', 'Diego', '84', '0.00', '1300.00', '1300.00', '1', '300', '16', '1', '10', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('139', '2014-01-23 09:24:51', '2014-01-23 00:03:52', '2014-01-23 09:23:52', '-60.00', 'Diego Costa', '83', '0.00', '3100.00', '3200.00', '1', '468', '27', '1', '22', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('140', '2014-01-24 09:20:56', '2014-01-23 00:10:31', '2014-01-24 09:20:56', '-150.00', 'Coutinho', '80', '0.00', '1100.00', '1000.00', '1', '160', '10', '1', '10', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('141', '2014-01-23 12:10:30', '2014-01-23 00:14:10', '2014-01-23 12:10:30', '-55.00', 'Coutinho', '80', '0.00', '1100.00', '1100.00', '1', '160', '10', '1', '10', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('143', '2014-01-23 12:19:25', '2014-01-23 11:02:41', '2014-01-23 12:19:25', '-225.00', 'Cavani', '87', '0.00', '4500.00', '4500.00', '1', '257', '14', '30', '22', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('144', '2014-01-23 12:08:58', '2014-01-23 11:18:21', '2014-01-23 12:08:58', '-30.00', 'Cavani', '87', '0.00', '4400.00', '4600.00', '1', '257', '14', '30', '22', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('145', null, '2014-01-23 11:50:01', null, '0.00', 'Walcott', '81', '0.00', '2400.00', '0.00', '1', '152', '10', '3', '18', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('146', '2014-01-23 15:01:23', '2014-01-23 11:50:47', '2014-01-23 15:01:23', '-120.00', 'Walcott', '81', '0.00', '2400.00', '2400.00', '1', '152', '10', '3', '18', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('147', '2014-01-23 15:01:12', '2014-01-23 11:51:17', '2014-01-23 15:01:12', '-115.00', 'Walcott', '81', '0.00', '2300.00', '2300.00', '1', '152', '10', '3', '18', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('148', '2014-01-24 09:23:17', '2014-01-24 09:14:32', '2014-01-24 09:23:17', '-1362.50', 'Eto\'o', '84', '0.00', '22500.00', '22250.00', '1', '155', '10', '32', '22', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('149', '2014-01-24 10:29:38', '2014-01-24 09:21:41', '2014-01-24 10:29:38', '605.00', 'Fernando Torres', '82', '0.00', '1200.00', '1900.00', '1', '155', '10', '4', '22', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('150', '2014-01-24 10:29:51', '2014-01-24 09:22:10', '2014-01-24 10:29:51', '420.00', 'Fernando Torres', '82', '0.00', '1100.00', '1600.00', '1', '155', '10', '4', '22', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('151', '2014-01-24 10:28:39', '2014-01-24 09:22:44', '2014-01-24 10:28:39', '225.00', 'Fernando Torres', '82', '0.00', '1200.00', '1500.00', '1', '155', '10', '4', '22', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('152', '2014-01-24 13:06:32', '2014-01-24 09:41:37', '2014-01-24 13:06:32', '450.00', 'Dante', '84', '0.00', '2400.00', '3000.00', '1', '291', '16', '1', '3', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('153', '2014-01-24 11:43:35', '2014-01-24 09:42:31', '2014-01-24 11:43:35', '165.00', 'Dante', '84', '0.00', '2400.00', '2700.00', '1', '291', '16', '1', '3', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('154', '2014-01-24 10:26:40', '2014-01-24 09:43:47', '2014-01-24 10:26:40', '165.00', 'Dante', '84', '0.00', '2400.00', '2700.00', '1', '291', '16', '1', '3', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('155', '2014-01-24 10:26:14', '2014-01-24 09:44:17', '2014-01-24 10:26:14', '165.00', 'Dante', '84', '0.00', '2400.00', '2700.00', '1', '291', '16', '1', '3', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('156', '2014-01-25 17:34:47', '2014-01-24 09:45:40', '2014-01-25 17:34:47', '605.00', 'Hulk', '84', '0.00', '6900.00', '7900.00', '1', '454', '25', '1', '15', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('157', '2014-01-25 09:33:37', '2014-01-24 09:48:17', '2014-01-25 09:33:37', '325.00', 'Hulk', '84', '0.00', '6800.00', '7500.00', '1', '454', '25', '1', '15', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('158', '2014-01-24 09:49:19', '2014-01-24 09:49:05', '2014-01-24 09:49:19', '550.00', 'Tevez', '86', '0.00', '12750.00', '14000.00', '1', '347', '19', '10', '9', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('159', '2014-01-25 20:00:50', '2014-01-24 22:06:57', '2014-01-25 20:00:50', '487.50', 'Eto\'o', '84', '2415.00', '23500.00', '25250.00', '1', '155', '10', '32', '22', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('160', null, '2014-01-25 09:55:30', null, '0.00', 'Nasri', '84', '1128.75', '10750.00', '0.00', '1', '161', '10', '2', '10', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('161', '2014-01-25 17:48:52', '2014-01-25 17:48:31', '2014-01-25 17:48:52', '1425.00', 'Sanchez', '82', '0.00', '0.00', '1500.00', '1', '472', '27', '16', '18', '3', '1');
INSERT INTO `tb_jogadores_plantel` VALUES ('162', null, '2014-01-25 17:55:15', null, '0.00', 'Paulinho', '81', '157.50', '1500.00', '0.00', '1', '166', '10', '1', '9', '1', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('163', null, '2014-01-25 18:01:35', null, '0.00', 'Rooney', '87', '4278.75', '40750.00', '0.00', '1', '162', '10', '3', '23', '2', '0');
INSERT INTO `tb_jogadores_plantel` VALUES ('164', null, '2014-01-26 14:38:26', null, '0.00', 'David Luiz', '82', '945.00', '9000.00', '0.00', '1', '155', '10', '1', '3', '1', '0');

-- ----------------------------
-- Table structure for tb_liga
-- ----------------------------
DROP TABLE IF EXISTS `tb_liga`;
CREATE TABLE `tb_liga` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DS_LIGA` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_liga
-- ----------------------------
INSERT INTO `tb_liga` VALUES ('1', 'Mexico Liga MX');
INSERT INTO `tb_liga` VALUES ('2', 'USA Major League Soccer');
INSERT INTO `tb_liga` VALUES ('3', 'Liga Argentina');
INSERT INTO `tb_liga` VALUES ('4', 'Liga do Brasil');
INSERT INTO `tb_liga` VALUES ('5', 'Campeonato Nacional Petrobras');
INSERT INTO `tb_liga` VALUES ('6', 'Colombia Liga Postobón');
INSERT INTO `tb_liga` VALUES ('7', 'Austrian Bundesliga');
INSERT INTO `tb_liga` VALUES ('8', 'Belgium Pro League');
INSERT INTO `tb_liga` VALUES ('9', 'Denmark Superliga');
INSERT INTO `tb_liga` VALUES ('10', 'England Premier League');
INSERT INTO `tb_liga` VALUES ('11', 'England League Championship');
INSERT INTO `tb_liga` VALUES ('12', 'England League One');
INSERT INTO `tb_liga` VALUES ('13', 'England League Two');
INSERT INTO `tb_liga` VALUES ('14', 'France Ligue 1');
INSERT INTO `tb_liga` VALUES ('15', 'France Ligue 2');
INSERT INTO `tb_liga` VALUES ('16', 'Germany 1. Bundesliga');
INSERT INTO `tb_liga` VALUES ('17', 'Germany 2. Bundesliga');
INSERT INTO `tb_liga` VALUES ('18', 'Holland Eredivisie');
INSERT INTO `tb_liga` VALUES ('19', 'Italy Serie A');
INSERT INTO `tb_liga` VALUES ('20', 'Italy Serie B');
INSERT INTO `tb_liga` VALUES ('21', 'Norway Tippeligaen');
INSERT INTO `tb_liga` VALUES ('22', 'Poland T-Mobile Ekstraklasa');
INSERT INTO `tb_liga` VALUES ('23', 'Portugal Liga ZON SAGRES');
INSERT INTO `tb_liga` VALUES ('24', 'Rep. Ireland Airticity League');
INSERT INTO `tb_liga` VALUES ('25', 'Russia Premier League');
INSERT INTO `tb_liga` VALUES ('26', 'Scotland Premier League');
INSERT INTO `tb_liga` VALUES ('27', 'Spain Primera Division');
INSERT INTO `tb_liga` VALUES ('28', 'Spain Segunda A');
INSERT INTO `tb_liga` VALUES ('29', 'Sweden Allvenskan');
INSERT INTO `tb_liga` VALUES ('30', 'Switzerland Super League');
INSERT INTO `tb_liga` VALUES ('31', 'Hyundai A-League');
INSERT INTO `tb_liga` VALUES ('32', 'Korea K League Classic');
INSERT INTO `tb_liga` VALUES ('33', 'Saudi Abdul Latif Jameel League');
INSERT INTO `tb_liga` VALUES ('34', 'Resto do mundo');

-- ----------------------------
-- Table structure for tb_nacionalidade_jogador
-- ----------------------------
DROP TABLE IF EXISTS `tb_nacionalidade_jogador`;
CREATE TABLE `tb_nacionalidade_jogador` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DS_NACIONALIDADE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_nacionalidade_jogador
-- ----------------------------
INSERT INTO `tb_nacionalidade_jogador` VALUES ('1', 'Brasileiro');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('2', 'Francês');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('3', 'Inglês');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('4', 'Espanhol');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('5', 'Italiano');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('6', 'Belga');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('7', 'Coreano');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('8', 'Australiano');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('9', 'Alemão');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('10', 'Argentino');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('11', 'Senegalês');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('12', 'Holandês');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('13', 'Americano');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('14', 'Ganês');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('15', 'Português');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('16', 'Chileno');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('17', 'Polonês');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('18', 'Bosnio');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('19', 'Tcheco');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('20', 'Grego');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('21', 'Argelino');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('22', 'Colombiano');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('23', 'Finlandês');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('24', 'Tunisiano');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('25', 'Romeno');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('26', 'Russo');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('27', 'Irlandês');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('28', 'Sueco');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('29', 'Peruano');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('30', 'Uruguaio');
INSERT INTO `tb_nacionalidade_jogador` VALUES ('32', 'Camaronês');

-- ----------------------------
-- Table structure for tb_partida
-- ----------------------------
DROP TABLE IF EXISTS `tb_partida`;
CREATE TABLE `tb_partida` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DT_DATA_PARTIDA` datetime DEFAULT NULL,
  `NU_GOLS_TIME_CASA` int(11) DEFAULT NULL,
  `NU_GOLS_TIME_VISITANTE` int(11) DEFAULT NULL,
  `DS_TIME_CASA` varchar(255) DEFAULT NULL,
  `DS_TIME_VISITANTE` varchar(255) DEFAULT NULL,
  `VL_GANHO_PARTIDA` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tb_partida
-- ----------------------------
INSERT INTO `tb_partida` VALUES ('1', '2014-01-20 00:30:35', '1', '0', 'Scoroz United', 'AvanteBR', '336.00');
INSERT INTO `tb_partida` VALUES ('2', '2014-01-20 00:55:52', '0', '1', 'Palestra', 'Scoroz United A', '511.00');
INSERT INTO `tb_partida` VALUES ('3', '2014-01-20 01:17:09', '2', '1', 'BARSEMLONA FC', 'Scoroz United A', '450.00');
INSERT INTO `tb_partida` VALUES ('4', '2014-01-20 01:40:44', '3', '4', 'Fe Galacticos', 'Scoroz United A', '499.00');
INSERT INTO `tb_partida` VALUES ('5', '2014-01-20 01:47:58', '0', '0', 'Colonos de Sc', 'Scoroz United A', '179.00');
INSERT INTO `tb_partida` VALUES ('6', '2014-01-20 02:07:09', '1', '2', 'powerguido', 'Scoroz United A', '490.00');
INSERT INTO `tb_partida` VALUES ('7', '2014-01-20 02:51:26', '2', '2', 'Class On Grass', 'Scoroz United A', '475.00');
INSERT INTO `tb_partida` VALUES ('8', '2014-01-20 22:05:00', '2', '0', 'Herkot FC', 'Scoroz United A', '419.00');
INSERT INTO `tb_partida` VALUES ('9', '2014-01-20 22:27:14', '3', '1', 'Haliyuu', 'Scoroz United A', '443.00');
INSERT INTO `tb_partida` VALUES ('10', '2014-01-22 09:21:37', '4', '1', 'Scoroz United ', 'Campinho FC', '546.00');
INSERT INTO `tb_partida` VALUES ('11', '2014-01-22 09:22:09', '1', '2', 'Scoroz United', 'craques ', '431.00');
INSERT INTO `tb_partida` VALUES ('12', '2014-01-22 09:24:12', '0', '1', 'Scoroz United', 'Bonsucesso FC', '434.00');
INSERT INTO `tb_partida` VALUES ('13', '2014-01-22 09:24:33', '1', '0', 'Scoroz United', 'Jockos FC', '513.00');
INSERT INTO `tb_partida` VALUES ('14', '2014-01-22 09:24:52', '3', '1', 'Scoroz United', 'CACIQUE FC', '521.00');
INSERT INTO `tb_partida` VALUES ('15', '2014-01-22 09:25:09', '4', '4', 'Scoroz United', 'LSCRDYT ', '511.00');
INSERT INTO `tb_partida` VALUES ('16', '2014-01-24 09:15:25', '2', '0', 'Scoroz United', 'Kingdons FC', '553.00');
INSERT INTO `tb_partida` VALUES ('17', '2014-01-24 09:15:47', '1', '1', 'SANTOS FTBC', 'Scoroz United', '464.00');
INSERT INTO `tb_partida` VALUES ('18', '2014-01-24 20:02:57', '0', '4', 'Scoroz United', 'MARTINS FC', '400.00');
INSERT INTO `tb_partida` VALUES ('19', '2014-01-24 20:26:51', '3', '2', 'Scoroz United', 'Malok12 FC', '503.00');
INSERT INTO `tb_partida` VALUES ('20', '2014-01-24 20:37:08', '0', '1', 'Pipoca Doce FC', 'Scoroz United', '255.00');
INSERT INTO `tb_partida` VALUES ('21', '2014-01-24 20:58:28', '1', '1', 'Scoroz United', 'S FURRENTS', '456.00');
INSERT INTO `tb_partida` VALUES ('22', '2014-01-24 23:51:15', '0', '4', 'Scoroz United', 'Rock n Roll Utd', '383.00');
INSERT INTO `tb_partida` VALUES ('23', '2014-01-25 00:20:54', '2', '0', 'Scoroz United', 'ASTROS FC', '502.00');
INSERT INTO `tb_partida` VALUES ('24', '2014-01-25 00:46:30', '0', '6', 'corta pa nois', 'Scoroz United', '590.00');
INSERT INTO `tb_partida` VALUES ('25', '2014-01-25 01:06:18', '1', '2', 'Scoroz United', 'JOGA 10 FC', '414.00');
INSERT INTO `tb_partida` VALUES ('26', '2014-01-25 01:26:53', '2', '1', 'Scoroz United', 'Corinthians FC', '460.00');
INSERT INTO `tb_partida` VALUES ('27', '2014-01-25 01:52:36', '3', '1', 'Scoroz United', 'GLORIOUS FC', '479.00');
INSERT INTO `tb_partida` VALUES ('28', '2014-01-25 02:12:26', '1', '1', 'Scoroz United', 'foo fighters ', '439.00');
INSERT INTO `tb_partida` VALUES ('29', '2014-01-25 02:34:54', '1', '1', 'Scoroz United', 'EC Carmosina', '441.00');
INSERT INTO `tb_partida` VALUES ('30', '2014-01-25 02:54:10', '5', '1', 'Scoroz United', 'Gidaro FC', '541.00');
INSERT INTO `tb_partida` VALUES ('31', '2014-01-25 03:14:45', '1', '3', 'galaticos cf', 'Scoroz United', '501.00');
INSERT INTO `tb_partida` VALUES ('32', '2014-01-25 03:36:12', '0', '1', 'Scoroz United', 'vovo FC', '408.00');
INSERT INTO `tb_partida` VALUES ('33', '2014-01-25 04:00:19', '9', '2', 'Scoroz United', 'Schmeat FC', '562.00');
INSERT INTO `tb_partida` VALUES ('34', '2014-01-25 04:25:04', '0', '9', 'GUILHERME FC', 'Scoroz United', '623.00');
INSERT INTO `tb_partida` VALUES ('35', '2014-01-25 11:55:04', '1', '1', 'Scoroz United', 'Atletico Garcia', '443.00');
INSERT INTO `tb_partida` VALUES ('36', '2014-01-25 12:14:45', '0', '1', 'Scoroz United', 'Tiguez FC', '426.00');
INSERT INTO `tb_partida` VALUES ('37', '2014-01-25 12:37:08', '2', '1', 'Timao FC', 'Scoroz United', '426.00');
INSERT INTO `tb_partida` VALUES ('38', '2014-01-25 12:59:13', '1', '0', 'Scoroz United', 'IPIAU FUTEBOL', '529.00');
INSERT INTO `tb_partida` VALUES ('39', '2014-01-25 13:18:14', '2', '4', 'Scoroz United', 'spirit', '421.00');
INSERT INTO `tb_partida` VALUES ('40', '2014-01-25 13:37:35', '0', '4', 'Yolo FC', 'Scoroz United', '621.00');
INSERT INTO `tb_partida` VALUES ('41', '2014-01-25 18:31:07', '4', '0', 'Scoroz United', 'tri mundial', '544.00');
INSERT INTO `tb_partida` VALUES ('42', '2014-01-25 19:03:53', '2', '1', 'Scoroz United', 'GRANDES FAMOSOS', '458.00');
INSERT INTO `tb_partida` VALUES ('43', '2014-01-25 19:16:11', '3', '0', 'Scoroz United', 'Parque Orlanda1', '329.00');
INSERT INTO `tb_partida` VALUES ('44', '2014-01-25 19:34:57', '2', '1', 'Adelaide FC', 'Scoroz United', '401.00');
INSERT INTO `tb_partida` VALUES ('45', '2014-01-25 19:58:21', '3', '2', 'Scoroz United', 'Quase Perdi FC', '469.00');
INSERT INTO `tb_partida` VALUES ('46', '2014-01-25 20:27:10', '7', '1', 'Scoroz United', 'Maniadeser FC', '543.00');
INSERT INTO `tb_partida` VALUES ('47', '2014-01-26 12:04:23', '0', '0', 'Scoroz United', 'ESTRAGA DOMINGO', '466.00');
INSERT INTO `tb_partida` VALUES ('48', '2014-01-26 12:28:24', '1', '0', 'Scoroz United', 'Annihilation', '497.00');
INSERT INTO `tb_partida` VALUES ('49', '2014-01-26 13:46:22', '1', '1', 'Scoroz United', 'Dragons FC', '444.00');
INSERT INTO `tb_partida` VALUES ('50', '2014-01-26 14:06:07', '2', '3', 'Vista Alegre', 'Scoroz United', '489.00');
INSERT INTO `tb_partida` VALUES ('51', '2014-01-26 14:25:20', '2', '2', 'Scoroz United', 'PASQUALI FBPA', '467.00');
INSERT INTO `tb_partida` VALUES ('52', '2014-01-26 15:05:21', '1', '0', 'W13', 'Scoroz United', '405.00');
INSERT INTO `tb_partida` VALUES ('53', '2014-01-26 15:24:28', '0', '3', 'Scoroz United', 'PANICO NA LIVE', '394.00');
INSERT INTO `tb_partida` VALUES ('54', '2014-01-26 15:43:51', '3', '2', 'Scoroz United', 'letzgettricky', '516.00');
INSERT INTO `tb_partida` VALUES ('55', '2014-01-26 16:03:03', '1', '0', 'nalim united', 'Scoroz United', '423.00');
INSERT INTO `tb_partida` VALUES ('56', '2014-01-26 16:50:38', '1', '1', 'Real Favela FC', 'Scoroz United', '459.00');
INSERT INTO `tb_partida` VALUES ('57', '2014-01-26 17:11:26', '3', '1', 'Chaanuz FC', 'Scoroz United', '435.00');
INSERT INTO `tb_partida` VALUES ('58', '2014-01-26 17:32:59', '0', '4', 'GLORIOUS FC', 'Scoroz United', '606.00');
INSERT INTO `tb_partida` VALUES ('59', '2014-01-26 17:54:12', '6', '2', 'Scoroz United', 'AmigosDoMessi', '573.00');
INSERT INTO `tb_partida` VALUES ('60', '2014-01-26 18:24:33', '1', '1', 'Gladiadores', 'Scoroz United', '456.00');
INSERT INTO `tb_partida` VALUES ('61', '2014-01-26 18:44:00', '1', '1', 'coXa DoiDo FC', 'Scoroz United', '441.00');

-- ----------------------------
-- Table structure for tb_pos_jogador
-- ----------------------------
DROP TABLE IF EXISTS `tb_pos_jogador`;
CREATE TABLE `tb_pos_jogador` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DS_POSICAO` varchar(255) DEFAULT NULL,
  `DS_SIGLA` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_pos_jogador
-- ----------------------------
INSERT INTO `tb_pos_jogador` VALUES ('1', 'Goalkeeper – Goleiro.', 'GK ');
INSERT INTO `tb_pos_jogador` VALUES ('2', ' Right Back – Zagueiro Direito.', 'RB');
INSERT INTO `tb_pos_jogador` VALUES ('3', 'Central Back – Zagueiro Central.', 'CB ');
INSERT INTO `tb_pos_jogador` VALUES ('4', 'Left Back – Zagueiro Esquerdo.', 'LB ');
INSERT INTO `tb_pos_jogador` VALUES ('5', ' Sweeper – Líbero.', 'SW');
INSERT INTO `tb_pos_jogador` VALUES ('6', 'Right Wing Back – Lateral Direito.', 'RWB');
INSERT INTO `tb_pos_jogador` VALUES ('7', 'Left Wing back – Lateral Esquerdo.', 'LWB');
INSERT INTO `tb_pos_jogador` VALUES ('8', 'Central Defensive Midfielder – Meio Campo Defensivo / Volante.', 'CDM');
INSERT INTO `tb_pos_jogador` VALUES ('9', 'Central Midfielder – Meia Central.', 'CM');
INSERT INTO `tb_pos_jogador` VALUES ('10', 'Center Attacking Middlefielder – Meio Campo Ofensivo / Armador.', 'CAM');
INSERT INTO `tb_pos_jogador` VALUES ('11', 'Offensive Midfielder – Meia Ofensivo.', 'OM');
INSERT INTO `tb_pos_jogador` VALUES ('12', 'Left Offensive Midfielder – Meia Esquerda Ofensivo.', 'LOM');
INSERT INTO `tb_pos_jogador` VALUES ('13', 'Right Offensive Midfielder – Meia Direita Ofensivo.', 'ROM');
INSERT INTO `tb_pos_jogador` VALUES ('14', ' Left Midfielder – Meia Esquerda.', 'LM');
INSERT INTO `tb_pos_jogador` VALUES ('15', 'Right Midfielder – Meia Direita.', 'RM');
INSERT INTO `tb_pos_jogador` VALUES ('16', 'Left Wing Midfielder – Meio Ala Esquerdo.', 'LWM');
INSERT INTO `tb_pos_jogador` VALUES ('17', ' Right Wing Midfielder – Meio Ala Direito.', 'RWM');
INSERT INTO `tb_pos_jogador` VALUES ('18', 'Right Winger – Ala Direito.', 'RW');
INSERT INTO `tb_pos_jogador` VALUES ('19', 'Left Winger – Ala Esquerto.', 'LW');
INSERT INTO `tb_pos_jogador` VALUES ('20', 'Left Forward – Atacante Esquerdo.', 'LF');
INSERT INTO `tb_pos_jogador` VALUES ('21', 'Right Forward – Atacante Direito.', 'RF');
INSERT INTO `tb_pos_jogador` VALUES ('22', ' Striker – Atacante.', 'ST');
INSERT INTO `tb_pos_jogador` VALUES ('23', 'Center Forward – Centro Avante.', 'CF');
INSERT INTO `tb_pos_jogador` VALUES ('24', 'Right Striker – Atacante Direito.', 'RS');
INSERT INTO `tb_pos_jogador` VALUES ('25', 'Left Striker – Atacante Esquerdo.', 'LS');

-- ----------------------------
-- Table structure for tb_status_jogador
-- ----------------------------
DROP TABLE IF EXISTS `tb_status_jogador`;
CREATE TABLE `tb_status_jogador` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DS_STATUS` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_status_jogador
-- ----------------------------
INSERT INTO `tb_status_jogador` VALUES ('1', 'No Clube');
INSERT INTO `tb_status_jogador` VALUES ('2', 'A Venda');
INSERT INTO `tb_status_jogador` VALUES ('3', 'Vendido');
INSERT INTO `tb_status_jogador` VALUES ('4', 'Na Mira');
