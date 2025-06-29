DELIMITER //

CREATE PROCEDURE ApplyMonthlySavingsInterest()
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01),
        LastModified = CURRENT_TIMESTAMP
    WHERE AccountType = 'Savings';
END //
DELIMITER ;
