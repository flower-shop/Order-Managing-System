CREATE TABLE Employee (
lastName VARCHAR (20) NOT NULL,
firstName VARCHAR(20) NOT NULL,
username VARCHAR (15) NOT NULL,
password VARCHAR (15) NOT NULL,
isAdmin VARCHAR(3) NOT NULL,
CONSTRAINT isAdmin CHECK(format IN('yes', 'no')),
PRIMARY KEY (employeeID));

CREATE TABLE Customer (
lastName VARCHAR (20) NOT NULL,
firstName VARCHAR(20) NOT NULL,
phoneNumber INT NOT NULL, 
email VARCHAR(35) NOT NULL,
PRIMARY KEY(phoneNumber));

CREATE TABLE Flower (
flowerType VARCHAR(15) NOT NULL, 
flowerCost DECIMAL,
flowerQty INT,
PRIMARY KEY(flowerType));

CREATE TABLE Accessory (
accessoryType VARCHAR (15),
CONSTRAINT atype CHECK(format IN ('Vase','Wreath','Bouquet','None')),
accessoryCost DECIMAL,
PRIMARY KEY(accessoryType));

CREATE TABLE Arrangement (
arrangementId INT NOT NULL,
arrangementTheme VARCHAR(10) NOT NULL,--CONSTRAINT atheme CHECK(format IN ('Birthday','Funeral','Romantic','None')),
arrangementCost DECIMAL,
flowerType VARCHAR (15) NOT NULL,
accessoryType VARCHAR (15) NOT NULL,
hasCard VARCHAR(3),
    --CONSTRAINT acard CHECK(format IN ('yes','no')),
cardText VARCHAR(50),
PRIMARY KEY(arrangementID),
FOREIGN KEY(flowerType) REFERENCES Flower(flowerType),
FOREIGN KEY(accessoryType) REFERENCES Accessory(accessoryType));

CREATE TABLE Orders (
orderID INT NOT NULL,
arrangementID INT NOT NULL,
phoneNum VARCHAR(15) NOT NULL,
orderDate DATE NOT NULL,
deliveryDate DATE,
paid VARCHAR(3), 
    --CONSTRAINT opaid CHECK(format IN ('yes','no')),
delivered VARCHAR(3),
    --CONSTRAINT odeliv CHECK(format IN ('yes','no')),
PRIMARY KEY(orderID),
FOREIGN KEY(arrangementID) REFERENCES Arrangement(arrangementID),
FOREIGN KEY(phoneNum) REFERENCES Customer(phoneNum));






