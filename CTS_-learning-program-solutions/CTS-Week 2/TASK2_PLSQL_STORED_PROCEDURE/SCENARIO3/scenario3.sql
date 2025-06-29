DELIMITER //

CREATE PROCEDURE TransferFunds(
    IN src_account_id INT,
    IN dest_account_id INT,
    IN transfer_amt DECIMAL(10,2)
)
BEGIN
    DECLARE src_balance DECIMAL(10,2);

    START TRANSACTION;

    SELECT Balance INTO src_balance
    FROM Accounts
    WHERE AccountID = src_account_id
    FOR UPDATE;

    IF src_balance < transfer_amt THEN
        ROLLBACK;
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Insufficient funds in source account';
    ELSE
        UPDATE Accounts
        SET Balance = Balance - transfer_amt,
            LastModified = NOW()
        WHERE AccountID = src_account_id;

        UPDATE Accounts
        SET Balance = Balance + transfer_amt,
            LastModified = NOW()
        WHERE AccountID = dest_account_id;

        INSERT INTO Transactions (AccountID, TransactionDate, Amount, TransactionType)
        VALUES (src_account_id, NOW(), transfer_amt, 'Debit');

        INSERT INTO Transactions (AccountID, TransactionDate, Amount, TransactionType)
        VALUES (dest_account_id, NOW(), transfer_amt, 'Credit');

        COMMIT;
    END IF;
END //

DELIMITER ;
