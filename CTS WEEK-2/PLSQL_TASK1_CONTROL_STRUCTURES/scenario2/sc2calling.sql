CALL PromoteToVIP();
SELECT CustomerID, Name, Balance, IsVIP FROM Customers WHERE IsVIP = TRUE;
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (4, 'VIP Test User', '1970-01-01', 15000, NOW());

SELECT * FROM Customers WHERE IsVIP = TRUE;
