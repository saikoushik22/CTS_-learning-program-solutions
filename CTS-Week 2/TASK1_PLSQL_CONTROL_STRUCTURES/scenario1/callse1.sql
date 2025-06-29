INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (103, 'Retired Individual', '1950-01-01', 2000.00, CURRENT_TIMESTAMP);
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (202, 103, 10000.00, 8.00, CURRENT_DATE, DATE_ADD(CURRENT_DATE, INTERVAL 5 YEAR));

CALL ApplyInterestDiscountForSeniors();
