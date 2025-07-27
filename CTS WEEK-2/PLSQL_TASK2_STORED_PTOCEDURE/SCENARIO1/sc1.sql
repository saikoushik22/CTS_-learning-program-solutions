DELIMITER //

CREATE PROCEDURE ProcessMonthlyInterest()
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01,  
        LastModified = NOW()
    WHERE AccountType = 'Savings';
END //

DELIMITER ;
