INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (3, 'Senior Citizen', '1950-01-01', 2000.00, NOW());
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (2, 3, 10000.00, 8.00, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 5 YEAR));

CALL ApplyInterestDiscountForSeniors();
