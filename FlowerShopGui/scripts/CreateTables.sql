CREATE TABLE Employee (
lastName VARCHAR (20) NOT NULL,
firstName VARCHAR(20) NOT NULL,
employeeId VARCHAR (15) NOT NULL,
password VARCHAR (15) NOT NULL,
isAdmin VARCHAR (5) NOT NULL,
PRIMARY KEY (employeeId));

CREATE TABLE Flower (
flowerType VARCHAR(15) NOT NULL, 
flowerCost DECIMAL (5,2),
flowerQty INT,
PRIMARY KEY(flowerType));

CREATE TABLE Orders (
orderID INT NOT NULL,
orderDate VARCHAR (20) NOT NULL,
lastName VARCHAR (20) NOT NULL,
firstName VARCHAR(20) NOT NULL,
phoneNumber VARCHAR(15) NOT NULL,
email VARCHAR(35) NOT NULL,
flowerType VARCHAR(15) NOT NULL,
quantity INT NOT NULL,
accessoryType VARCHAR (15),
arrangementTheme VARCHAR(10),
address VARCHAR(50),
deliveryDate VARCHAR (20),
totalCost DECIMAL (5,2),
hasCard VARCHAR(5),
cardText VARCHAR(50),
isPaid VARCHAR(5),
isDelivered VARCHAR(5),
PRIMARY KEY(orderID));
