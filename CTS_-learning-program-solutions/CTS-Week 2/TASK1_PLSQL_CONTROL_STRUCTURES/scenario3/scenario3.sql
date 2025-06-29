DELIMITER //

CREATE PROCEDURE SendLoanDueReminders()
BEGIN
    DECLARE finished INT DEFAULT 0;
    DECLARE cust_id INT;
    DECLARE cust_name VARCHAR(100);
    DECLARE loan_due_date DATE;

    DECLARE loan_cursor CURSOR FOR
        SELECT c.CustomerID, c.Name, l.EndDate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE l.EndDate BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 30 DAY);

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET finished = 1;

    OPEN loan_cursor;

    loan_loop: LOOP
        FETCH loan_cursor INTO cust_id, cust_name, loan_due_date;
        IF finished THEN
            LEAVE loan_loop;
        END IF;

        SELECT CONCAT('Reminder: Dear ', cust_name, ', your loan is due on ', DATE_FORMAT(loan_due_date, '%Y-%m-%d')) AS Reminder_Message;
    END LOOP;

    CLOSE loan_cursor;
END;
//

DELIMITER ;
