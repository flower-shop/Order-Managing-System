CREATE TABLE Employee (
lastName VARCHAR (20) NOT NULL,
firstName VARCHAR(20) NOT NULL,
employeeId VARCHAR (15) NOT NULL,
password VARCHAR (15) NOT NULL,
isAdmin VARCHAR (5) NOT NULL,
PRIMARY KEY (employeeId));

CREATE TABLE Customer (
lastName VARCHAR (20) NOT NULL,
firstName VARCHAR(20) NOT NULL,
phoneNumber VARCHAR(15) NOT NULL, 
email VARCHAR(35) NOT NULL,
PRIMARY KEY(phoneNumber));

CREATE TABLE Flower (
flowerType VARCHAR(15) NOT NULL, 
flowerCost DECIMAL,
flowerQty INT,
PRIMARY KEY(flowerType));

CREATE TABLE Accessory (
accessoryType VARCHAR (15),
CONSTRAINT aType CHECK(accessoryType IN ('Vase','Wreath','Bouquet','None')),
accessoryCost DECIMAL,
PRIMARY KEY(accessoryType));

CREATE TABLE Arrangement (
arrangementId INT NOT NULL,
arrangementTheme VARCHAR(10) NOT NULL,
CONSTRAINT aTheme CHECK(arrangementTheme IN ('Birthday','Funeral','Romantic','None')),
arrangementCost DECIMAL,
flowerType VARCHAR (15) NOT NULL,
accessoryType VARCHAR (15) NOT NULL,
hasCard VARCHAR(3),
CONSTRAINT hCard CHECK(hasCard IN ('yes','no')),
cardText VARCHAR(50),
PRIMARY KEY(arrangementID),
FOREIGN KEY(flowerType) REFERENCES Flower(flowerType),
FOREIGN KEY(accessoryType) REFERENCES Accessory(accessoryType));

CREATE TABLE Orders (
orderID INT NOT NULL,
arrangementID INT NOT NULL,
phoneNumber VARCHAR(15) NOT NULL,
orderDate DATE NOT NULL,
deliveryDate DATE,
isPaid VARCHAR(3), 
CONSTRAINT opaid CHECK(isPaid IN ('yes','no')),
isDelivered VARCHAR(3),
CONSTRAINT odeliv CHECK(isDelivered IN ('yes','no')),
PRIMARY KEY(orderID),
FOREIGN KEY(arrangementID) REFERENCES Arrangement(arrangementID),
FOREIGN KEY(phoneNumber) REFERENCES Customer(phoneNumber));






