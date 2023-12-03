DROP DATABASE IF EXISTS TESTAIRLINE;
CREATE DATABASE IF NOT EXISTS TESTAIRLINE; 
USE TESTAIRLINE;

DROP TABLE IF EXISTS User;
CREATE TABLE User (
	userID			integer not null auto_increment,
    fName			varchar(100),
    lName			varchar(100),
    email           varchar(100),
    password        varchar(100),
    address			varchar(100),
    city            varchar(100),
    province        varchar(100),
    postal          varchar(100),
    country         varchar(100),
    phoneNumber 	varchar(100),
    companionPass  	boolean,
    loungePass 		boolean,
    joinedOnDate 	date,
    role		    varchar(100),
	primary key (userID)
);

DROP TABLE IF EXISTS Aircraft;
CREATE TABLE Aircraft (
	aircraftID 			integer not null auto_increment,
    rowNums 			integer,
    colNums				integer, #all planes will be 2 column so colNums refers to number of seats per col	
    capacity			integer,
    name				varchar(100),
    type				varchar(100),
    crewNum				integer,
    numBusinessRows		integer,
    primary key (aircraftID)
);

DROP TABLE IF EXISTS Flight;
CREATE TABLE Flight (
	flightID			integer not null auto_increment,
    flightNumber		varchar(100),
    origin				varchar(100),
    destination			varchar(100),
    departureDateTime	datetime,
    arrivalDateTime		datetime,
    aircraftID			integer not null,
    coachSeatPrice		real,
    businessSeatPrice	real,
    primary key (flightID),
    foreign key (aircraftID) references Aircraft(aircraftID)
);

DROP TABLE IF EXISTS Booking;
CREATE TABLE Booking (
	bookingID			integer not null auto_increment,
    userID				integer not null,
    flightID			integer not null,
    cancelInsurance		boolean,
    paid				real, 
    payMethod			varchar(50),
    class				varchar(50),
    seatRow				integer,
    seatCol				varchar(1),
    passengerName		varchar(100),
    primary key (bookingID),
    foreign key (userID) references User(userID),
    foreign key (flightID) references Flight(flightID),
    CONSTRAINT UC_Booking UNIQUE (flightID, seatRow, seatCol)
);

DROP TABLE IF EXISTS Crew;
CREATE TABLE Crew (
	crewID			integer not null auto_increment,
    userID			integer not null,
    flightID		integer not null,
    position		varchar(50),
    primary key (crewID),
    foreign key (userID) references User(userID),
    foreign key (flightID) references Flight(flightID)
);

INSERT INTO User (fName, lName, email, password, address, phoneNumber, companionPass, loungePass, joinedOnDate, role)
VALUES
('Bob', 'Jones', 'bobjones@gmail.com', 'password', 'somewhere', '1234567891', false, false, '20230212', 'Admin'),
('Hillary', 'Clinton', 'hillaryclinton@gmail.com', 'password', 'somewhere', '1234567891', false, false, '20230212', 'Admin'),
('Jim', 'Jeffries', 'jimjeffries@gmail.com', 'password', 'somewhere', '1234567891', false, false, '20230212', 'Admin'),
('Another', 'Person', 'anotherperson@gmail.com', 'password', 'somewhere', '1234567891', false, false, '20230212', 'Admin'),
('Captain', 'Jeffries', 'captainjeffries@gmail.com', 'password', 'somewhere', '1234567891', false, false, '20230212', 'Admin'),
('Jessica', 'James', 'jessicajames@gmail.com', 'password', 'somewhere', '1234567891', false, false, '20230212', 'Admin'),
('Sarah', 'Shaw', 'sarahshaw@gmail.com', 'password', 'somewhere', '1234567891', false, false, '20230212', 'Admin');

INSERT INTO Aircraft (rowNums, colNums, capacity, name, type, crewNum, numBusinessRows)
VALUES
(30, 2, 30*4, 'A220', 'Airbus', 3, 7),
(50, 3, 50*6, '737 MAX', 'Boeing', 5, 7),
(20, 2, 20*4, '767', 'Boeing', 5, 3),
(45, 3, 45*6, 'A350', 'Airbus', 3, 10);

INSERT INTO Flight (flightNumber, origin, destination, departureDateTime, 
					arrivalDateTime, aircraftID, coachSeatPrice,
                    businessSeatPrice)
VALUES
-- ('1', 'Edmonton', 'Calgary', '2023-11-24 10:34:08', '2023-11-24 11:04:08',
-- 1, 150, 300);
('EN1403','Victoria','Saskatoon','2024-01-01 10:22:17.643348','2024-01-01 14:04:17.643348',2,161,354),
('EN1240','Calgary','St. Johns','2024-01-16 10:22:17.643348','2024-01-16 12:10:17.643348',4,241,530),
('EN1232','Victoria','Winnipeg','2023-12-14 10:22:17.643348','2023-12-14 10:38:17.643348',3,249,548),
('EN1254','Calgary','Montreal','2023-12-21 10:22:17.643348','2023-12-21 13:33:17.643348',2,176,387),
('EN1894','Victoria','St. Johns','2023-12-21 10:22:17.643348','2023-12-21 10:48:17.643348',3,117,257),
('EN1839','Regina','Vancouver','2023-12-17 10:22:17.643348','2023-12-17 16:18:17.643348',4,160,352),
('EN1962','Toronto','Montreal','2023-12-17 10:22:17.643348','2023-12-17 10:26:17.643348',3,177,389),
('EN1183','Toronto','St. Johns','2024-01-08 10:22:17.643348','2024-01-08 12:06:17.643348',1,248,546),
('EN1483','Winnipeg','Victoria','2023-12-27 10:22:17.643348','2023-12-27 11:14:17.643348',1,120,264),
('EN1793','Toronto','Edmonton','2024-01-10 10:22:17.643348','2024-01-10 10:27:17.643348',2,208,458),
('EN1946','Vancouver','Ottawa','2024-01-07 10:22:17.643348','2024-01-07 13:02:17.643348',4,141,310),
('EN1410','Ottawa','Calgary','2023-12-19 10:22:17.643348','2023-12-19 12:45:17.643348',2,101,222),
('EN1799','Winnipeg','Ottawa','2023-12-14 10:22:17.643348','2023-12-14 14:13:17.643348',1,205,451),
('EN1212','Vancouver','Montreal','2023-12-14 10:22:17.643348','2023-12-14 11:45:17.643348',2,186,409),
('EN1809','Regina','Toronto','2024-01-04 10:22:17.643348','2024-01-04 11:33:17.643348',1,202,444),
('EN1206','Ottawa','Winnipeg','2023-12-16 10:22:17.643348','2023-12-16 10:52:17.643348',4,250,550),
('EN1358','Regina','Halifax','2023-12-24 10:22:17.643348','2023-12-24 14:57:17.643348',3,187,411),
('EN1228','Halifax','Victoria','2024-01-01 10:22:17.643348','2024-01-01 14:23:17.643348',4,220,484),
('EN1357','Winnipeg','Vancouver','2024-01-07 10:22:17.643348','2024-01-07 11:05:17.643348',4,247,543),
('EN1461','Ottawa','Winnipeg','2023-12-05 10:22:17.643348','2023-12-05 14:50:17.643348',2,179,394),
('EN1218','Toronto','Ottawa','2023-12-05 10:22:17.643348','2023-12-05 12:00:17.643348',4,135,297),
('EN1971','Edmonton','Vancouver','2023-12-05 10:22:17.643348','2023-12-05 10:34:17.643348',4,161,354),
('EN1192','St. Johns','Toronto','2023-12-18 10:22:17.643348','2023-12-18 11:21:17.643348',1,159,350),
('EN1904','Victoria','Halifax','2023-12-25 10:22:17.643348','2023-12-25 10:35:17.643348',1,145,319),
('EN1500','Montreal','Winnipeg','2023-12-07 10:22:17.643348','2023-12-07 11:33:17.643348',3,183,403),
('EN1273','Ottawa','Vancouver','2023-12-22 10:22:17.643348','2023-12-22 14:58:17.643348',4,124,273),
('EN1726','Victoria','Saskatoon','2023-12-06 10:22:17.643348','2023-12-06 12:19:17.643348',2,142,312),
('EN1969','Halifax','Ottawa','2023-12-21 10:22:17.643348','2023-12-21 16:07:17.643348',4,187,411),
('EN1598','Montreal','Halifax','2024-01-02 10:22:17.643348','2024-01-02 11:21:17.643348',4,210,462),
('EN1439','Calgary','Vancouver','2023-12-13 10:22:17.643348','2023-12-13 14:29:17.643348',1,212,466),
('EN1498','Edmonton','Saskatoon','2023-12-04 10:22:17.643348','2023-12-04 13:48:17.643348',4,189,416),
('EN1374','Saskatoon','St. Johns','2023-12-19 10:22:17.643348','2023-12-19 12:59:17.643348',1,104,229),
('EN1892','Calgary','St. Johns','2024-01-07 10:22:17.643348','2024-01-07 12:33:17.643348',3,215,473),
('EN1174','Victoria','Regina','2024-01-07 10:22:17.643348','2024-01-07 14:43:17.643348',2,127,279),
('EN1945','Edmonton','Calgary','2024-01-15 10:22:17.643348','2024-01-15 13:51:17.643348',2,220,484),
('EN1556','Victoria','Montreal','2024-01-03 10:22:17.643348','2024-01-03 14:50:17.643348',4,120,264),
('EN1838','St. Johns','Saskatoon','2023-12-16 10:22:17.643348','2023-12-16 16:20:17.643348',3,110,242),
('EN1542','Saskatoon','Ottawa','2023-12-26 10:22:17.643348','2023-12-26 16:00:17.643348',3,226,497),
('EN1414','St. Johns','Vancouver','2023-12-28 10:22:17.643348','2023-12-28 12:27:17.643348',2,131,288),
('EN1826','Ottawa','Toronto','2023-12-31 10:22:17.643348','2023-12-31 12:39:17.643348',3,239,526),
('EN1305','Toronto','Halifax','2023-12-25 10:22:17.643348','2023-12-25 16:01:17.643348',1,219,482),
('EN1389','Halifax','Montreal','2023-12-07 10:22:17.643348','2023-12-07 13:01:17.643348',3,149,328),
('EN1667','Halifax','Ottawa','2024-01-07 10:22:17.643348','2024-01-07 10:59:17.643348',3,241,530),
('EN1416','Calgary','Halifax','2024-01-16 10:22:17.643348','2024-01-16 10:56:17.643348',3,250,550),
('EN1388','Toronto','Halifax','2023-12-08 10:22:17.643348','2023-12-08 13:13:17.643348',3,248,546),
('EN1112','Victoria','Winnipeg','2024-01-07 10:22:17.643348','2024-01-07 13:50:17.643348',2,107,235),
('EN1855','Regina','Winnipeg','2023-12-07 10:22:17.643348','2023-12-07 14:12:17.643348',2,195,429),
('EN1745','Montreal','Halifax','2023-12-07 10:22:17.643348','2023-12-07 15:10:17.643348',4,242,532),
('EN1464','St. Johns','Montreal','2023-12-20 10:22:17.643348','2023-12-20 12:36:17.643348',3,168,370),
('EN1564','Winnipeg','Montreal','2024-01-12 10:22:17.643348','2024-01-12 15:52:17.643348',3,200,440),
('EN1420','Toronto','Saskatoon','2024-01-11 10:22:17.643348','2024-01-11 11:26:17.643348',3,241,530),
('EN1555','Saskatoon','Winnipeg','2023-12-28 10:22:17.643348','2023-12-28 11:47:17.643348',4,230,506),
('EN1620','Victoria','St. Johns','2023-12-15 10:22:17.643348','2023-12-15 12:12:17.643348',4,187,411),
('EN1958','Halifax','Toronto','2024-01-14 10:22:17.643348','2024-01-14 11:07:17.643348',1,231,508),
('EN1177','Vancouver','Montreal','2024-01-11 10:22:17.643348','2024-01-11 15:08:17.643348',4,217,477),
('EN1692','Calgary','Toronto','2023-12-04 10:22:17.643348','2023-12-04 11:32:17.643348',2,106,233),
('EN1285','Halifax','Vancouver','2023-12-03 10:22:17.643348','2023-12-03 15:07:17.643348',1,233,513),
('EN1168','Halifax','Winnipeg','2023-12-29 10:22:17.643348','2023-12-29 14:19:17.643348',3,231,508),
('EN1407','Montreal','Toronto','2023-12-23 10:22:17.643348','2023-12-23 14:06:17.643348',2,146,321),
('EN1272','Edmonton','Victoria','2023-12-27 10:22:17.643348','2023-12-27 15:55:17.643348',4,109,240),
('EN1659','Saskatoon','Toronto','2023-12-15 10:22:17.643348','2023-12-15 15:22:17.643348',2,160,352),
('EN1387','Halifax','Calgary','2023-12-20 10:22:17.643348','2023-12-20 15:18:17.643348',2,201,442),
('EN1655','Ottawa','St. Johns','2023-12-11 10:22:17.643348','2023-12-11 14:24:17.643348',3,174,383),
('EN1887','Vancouver','Montreal','2023-12-23 10:22:17.643348','2023-12-23 15:30:17.643348',1,128,282),
('EN1393','Victoria','Vancouver','2024-01-03 10:22:17.643348','2024-01-03 13:37:17.643348',4,109,240),
('EN1784','Saskatoon','Winnipeg','2023-12-28 10:22:17.643348','2023-12-28 10:42:17.643348',4,112,246),
('EN1898','Calgary','St. Johns','2023-12-15 10:22:17.643348','2023-12-15 12:44:17.643348',1,158,348),
('EN1828','Montreal','Regina','2023-12-15 10:22:17.643348','2023-12-15 12:17:17.643348',2,108,238),
('EN1173','Calgary','Halifax','2023-12-28 10:22:17.643348','2023-12-28 13:53:17.643348',4,215,473),
('EN1861','Victoria','Vancouver','2023-12-07 10:22:17.643348','2023-12-07 11:32:17.643348',1,132,290),
('EN1292','Calgary','Saskatoon','2024-01-05 10:22:17.643348','2024-01-05 14:57:17.643348',2,240,528),
('EN1310','Victoria','Regina','2023-12-19 10:22:17.643348','2023-12-19 15:19:17.643348',3,225,495),
('EN1628','Toronto','Calgary','2024-01-04 10:22:17.643348','2024-01-04 15:11:17.643348',3,163,359),
('EN1375','Victoria','Regina','2023-12-11 10:22:17.643348','2023-12-11 15:13:17.643348',1,172,378),
('EN1131','Toronto','Winnipeg','2023-12-15 10:22:17.643348','2023-12-15 14:18:17.643348',2,186,409),
('EN1827','Toronto','Halifax','2023-12-06 10:22:17.643348','2023-12-06 13:07:17.643348',3,110,242),
('EN1864','Toronto','Montreal','2024-01-09 10:22:17.643348','2024-01-09 15:11:17.643348',1,155,341),
('EN1773','Vancouver','Calgary','2023-12-16 10:22:17.643348','2023-12-16 12:54:17.643348',4,224,493),
('EN1271','Halifax','Toronto','2024-01-15 10:22:17.643348','2024-01-15 11:53:17.643348',3,129,284),
('EN1606','Victoria','Regina','2023-12-03 10:22:17.643348','2023-12-03 11:40:17.643348',3,205,451),
('EN1630','Winnipeg','Toronto','2023-12-12 10:22:17.643348','2023-12-12 15:22:17.643348',3,178,392),
('EN1581','Edmonton','Victoria','2023-12-23 10:22:17.643348','2023-12-23 12:16:17.643348',2,113,249),
('EN1668','Edmonton','Regina','2023-12-28 10:22:17.643348','2023-12-28 15:06:17.643348',3,186,409),
('EN1735','Winnipeg','Saskatoon','2024-01-10 10:22:17.643348','2024-01-10 10:44:17.643348',3,147,323),
('EN1528','St. Johns','Saskatoon','2023-12-21 10:22:17.643348','2023-12-21 14:49:17.643348',2,204,449),
('EN1885','Montreal','Toronto','2024-01-05 10:22:17.643348','2024-01-05 15:40:17.643348',4,125,275),
('EN1405','Calgary','Halifax','2023-12-23 10:22:17.643348','2023-12-23 13:38:17.643348',1,211,464),
('EN1957','Toronto','Montreal','2024-01-02 10:22:17.643348','2024-01-02 14:38:17.643348',2,152,334),
('EN1886','Vancouver','Regina','2024-01-08 10:22:17.643348','2024-01-08 15:21:17.643348',3,154,339),
('EN1237','St. Johns','Calgary','2023-12-12 10:22:17.643348','2023-12-12 14:35:17.643348',2,143,315),
('EN1646','Ottawa','Montreal','2023-12-22 10:22:17.643348','2023-12-22 11:46:17.643348',4,123,271),
('EN1455','Regina','Montreal','2023-12-13 10:22:17.643348','2023-12-13 15:28:17.643348',1,164,361),
('EN1460','Montreal','Victoria','2024-01-15 10:22:17.643348','2024-01-15 13:28:17.643348',2,218,480),
('EN1449','Halifax','Victoria','2023-12-03 10:22:17.643348','2023-12-03 14:32:17.643348',4,239,526),
('EN1234','Toronto','Vancouver','2024-01-06 10:22:17.643348','2024-01-06 10:23:17.643348',4,179,394),
('EN1513','Edmonton','Saskatoon','2023-12-31 10:22:17.643348','2023-12-31 15:06:17.643348',3,237,521),
('EN1432','Saskatoon','Victoria','2023-12-11 10:22:17.643348','2023-12-11 11:31:17.643348',1,155,341),
('EN1333','Winnipeg','Edmonton','2024-01-13 10:22:17.643348','2024-01-13 12:26:17.643348',3,128,282),
('EN1115','Saskatoon','Halifax','2023-12-14 10:22:17.643348','2023-12-14 10:23:17.643348',1,240,528),
('EN1548','Vancouver','Regina','2023-12-15 10:22:17.643348','2023-12-15 16:06:17.643348',3,241,530);



INSERT INTO Booking (userID, flightID, cancelInsurance, paid, payMethod, class, seatRow, seatCol, passengerName)
VALUES
(1, 1, false, true, 'credit', 'business', 1, 'A', 'Bob Jones'),
(2, 1, false, true, 'credit', 'economy', 10, 'C', 'Hillary Clinton'),
(3, 1, false, true, 'credit', 'economy', 17, 'E', 'Jim Jeffries');

INSERT INTO Crew (userID, flightID, position)
VALUES
(5, 1, 'pilot'),
(6, 1, 'attendant'),
(7, 1, 'co-pilot');