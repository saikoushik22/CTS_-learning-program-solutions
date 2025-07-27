DELIMITER //

CREATE PROCEDURE ApplyInterestDiscountForSeniors()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE v_customer_id INT;
    DECLARE v_rows_updated INT DEFAULT 0;

    DECLARE senior_cursor CURSOR FOR
        SELECT CustomerID
        FROM Customers
        WHERE TIMESTAMPDIFF(YEAR, DOB, CURDATE()) > 60;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN senior_cursor;

    read_loop: LOOP
        FETCH senior_cursor INTO v_customer_id;
        IF done THEN
            LEAVE read_loop;
        END IF;

        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE CustomerID = v_customer_id
          AND InterestRate > 1;

        SET v_rows_updated = v_rows_updated + ROW_COUNT();
    END LOOP;

    CLOSE senior_cursor;

    SELECT CONCAT('Loan records updated: ', v_rows_updated) AS Result;
END;
//

DELIMITER ;
