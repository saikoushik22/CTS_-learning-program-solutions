CALL SendLoanDueReminders();



INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (5, 'Loan Reminder User', '1980-01-01', 9000, NOW());

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (3, 5, 5000, 7.5, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 15 DAY));
CALL SendLoanDueReminders();