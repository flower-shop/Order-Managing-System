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
flowerCost DECIMAL (5,2),
flowerQty INT,
PRIMARY KEY(flowerType));

CREATE TABLE Accessory (
accessoryType VARCHAR (15),
CONSTRAINT aType CHECK(accessoryType IN ('Vase','Wreath','Bouquet','None')),
accessoryCost DECIMAL,
PRIMARY KEY(accessoryType));

CREATE TABLE Arrangement (
arrangementTheme VARCHAR(10) NOT NULL,
CONSTRAINT aTheme CHECK(arrangementTheme IN ('Birthday','Funeral','Romantic','None')),
arrangementCost DECIMAL,
PRIMARY KEY(arrangementTheme));

CREATE TABLE Orders (
orderID INT NOT NULL,
arrangementTheme VARCHAR(10) NOT NULL,
phoneNumber VARCHAR(15) NOT NULL,
flowerType VARCHAR(15) NOT NULL,
accessoryType VARCHAR (15),
hasCard VARCHAR(3),
CONSTRAINT hCard CHECK(hasCard IN ('yes','no')),
cardText VARCHAR(50),
orderDate DATE NOT NULL,
deliveryDate DATE,
isPaid VARCHAR(3), 
CONSTRAINT opaid CHECK(isPaid IN ('yes','no')),
isDelivered VARCHAR(3),
CONSTRAINT odeliv CHECK(isDelivered IN ('yes','no')),
PRIMARY KEY(orderID),
FOREIGN KEY(arrangementTheme) REFERENCES Arrangement(arrangementTheme),
FOREIGN KEY(phoneNumber) REFERENCES Customer(phoneNumber),
FOREIGN KEY(flowerType) REFERENCES Flower(flowerType),
FOREIGN KEY(accessoryType) REFERENCES Accessory(accessoryType));






