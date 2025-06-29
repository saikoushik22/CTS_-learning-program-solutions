DELIMITER //

CREATE PROCEDURE ApplySeniorLoanDiscount()
BEGIN
    DECLARE is_done INT DEFAULT 0;
    DECLARE cust_id INT;
    DECLARE total_updates INT DEFAULT 0;

    DECLARE senior_loan_cursor CURSOR FOR
        SELECT CustomerID
        FROM Customers
        WHERE TIMESTAMPDIFF(YEAR, DOB, CURRENT_DATE) > 60;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET is_done = 1;

    OPEN senior_loan_cursor;

    process_loop: LOOP
        FETCH senior_loan_cursor INTO cust_id;
        IF is_done THEN
            LEAVE process_loop;
        END IF;

        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE CustomerID = cust_id
          AND InterestRate > 1;

        SET total_updates = total_updates + ROW_COUNT();
    END LOOP;

    CLOSE senior_loan_cursor;

    SELECT CONCAT('Loan records updated: ', total_updates) AS OutputMessage;
END;
//

DELIMITER ;

