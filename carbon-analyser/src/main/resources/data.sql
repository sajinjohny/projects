INSERT INTO `city_details` (`city_id`,`city_name`) VALUES (1,'munich');
INSERT INTO `city_details` (`city_id`,`city_name`) VALUES (2,'frankfurt');

INSERT INTO `district_detail` (`district_id`,`district_name`,`city`) VALUES (1,'Altstadt',1);
INSERT INTO `district_detail` (`district_id`,`district_name`,`city`) VALUES (2,'Schwabing',1);
INSERT INTO `district_detail` (`district_id`,`district_name`,`city`) VALUES (3,'Haidhausen',1);
INSERT INTO `district_detail` (`district_id`,`district_name`,`city`) VALUES (4,'Westend',2);
INSERT INTO `district_detail` (`district_id`,`district_name`,`city`) VALUES (5,'Nordend',2);
INSERT INTO `district_detail` (`district_id`,`district_name`,`city`) VALUES (6,'Bornheim',2);


INSERT INTO `sensor_detail` (`sensor_id`,`sensor_loc`,`district`) VALUES (1,'Rheintreppe',1);
INSERT INTO `sensor_detail` (`sensor_id`,`sensor_loc`,`district`) VALUES (2,'Ehra oder Kind mit Ball',1);
INSERT INTO `sensor_detail` (`sensor_id`,`sensor_loc`,`district`) VALUES (3,'Jan-Wellem-Denkmal',1);
INSERT INTO `sensor_detail` (`sensor_id`,`sensor_loc`,`district`) VALUES (4,'English garden',2);
INSERT INTO `sensor_detail` (`sensor_id`,`sensor_loc`,`district`) VALUES (5,'Marianplatz',2);
INSERT INTO `sensor_detail` (`sensor_id`,`sensor_loc`,`district`) VALUES (6,'Nymphenburg Palace',2);
INSERT INTO `sensor_detail` (`sensor_id`,`sensor_loc`,`district`) VALUES (7,'Mariahilfplatz',3);
INSERT INTO `sensor_detail` (`sensor_id`,`sensor_loc`,`district`) VALUES (8,'Mariahilfkirche',3);
INSERT INTO `sensor_detail` (`sensor_id`,`sensor_loc`,`district`) VALUES (9,'Maximiliansanlagen',3);
INSERT INTO `sensor_detail` (`sensor_id`,`sensor_loc`,`district`) VALUES (10,'Theodor Heuss Platz',4);
INSERT INTO `sensor_detail` (`sensor_id`,`sensor_loc`,`district`) VALUES (11,'Palais am Funkturm',4);
INSERT INTO `sensor_detail` (`sensor_id`,`sensor_loc`,`district`) VALUES (12,'Waldfriedhof HeerstraÃŸe',4);
INSERT INTO `sensor_detail` (`sensor_id`,`sensor_loc`,`district`) VALUES (13,'Baeckerweg',5);
INSERT INTO `sensor_detail` (`sensor_id`,`sensor_loc`,`district`) VALUES (14,'Castle Holzhausen',5);
INSERT INTO `sensor_detail` (`sensor_id`,`sensor_loc`,`district`) VALUES (15,'Epizentrum',5);
INSERT INTO `sensor_detail` (`sensor_id`,`sensor_loc`,`district`) VALUES (16,'Berger Strasse',6);
INSERT INTO `sensor_detail` (`sensor_id`,`sensor_loc`,`district`) VALUES (17,'Alte Oper',6);
INSERT INTO `sensor_detail` (`sensor_id`,`sensor_loc`,`district`) VALUES (18,'Romerberg',6);
