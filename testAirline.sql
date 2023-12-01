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
    paid				boolean, 
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
(50, 3, 50*3, 'plane1', 'Airbus A380', 3, 30),
(30, 2, 30*2, 'plane2', 'Airbus A320', 3, 10);

INSERT INTO Flight (flightNumber, origin, destination, departureDateTime, 
					arrivalDateTime, aircraftID, coachSeatPrice,
                    businessSeatPrice)
VALUES
('1', 'Edmonton', 'Calgary', '2023-11-24 10:34:08', '2023-11-24 11:04:08',
1, 150, 300);

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