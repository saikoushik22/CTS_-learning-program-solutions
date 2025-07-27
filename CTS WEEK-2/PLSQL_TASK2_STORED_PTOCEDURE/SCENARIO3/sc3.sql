DELIMITER //

CREATE PROCEDURE TransferFunds(
    IN p_source_account_id INT,
    IN p_target_account_id INT,
    IN p_amount DECIMAL(10,2)
)
BEGIN
    DECLARE v_source_balance DECIMAL(10,2);

    START TRANSACTION;

    SELECT Balance INTO v_source_balance
    FROM Accounts
    WHERE AccountID = p_source_account_id
    FOR UPDATE;

    IF v_source_balance < p_amount THEN
        ROLLBACK;
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Insufficient funds in source account';
    ELSE
        UPDATE Accounts
        SET Balance = Balance - p_amount,
            LastModified = NOW()
        WHERE AccountID = p_source_account_id;

        UPDATE Accounts
        SET Balance = Balance + p_amount,
            LastModified = NOW()
        WHERE AccountID = p_target_account_id;

        INSERT INTO Transactions (AccountID, TransactionDate, Amount, TransactionType)
        VALUES (p_source_account_id, NOW(), p_amount, 'Debit');

        INSERT INTO Transactions (AccountID, TransactionDate, Amount, TransactionType)
        VALUES (p_target_account_id, NOW(), p_amount, 'Credit');

        COMMIT;
    END IF;
END //

DELIMITER ;
