DELIMITER //

CREATE PROCEDURE SendLoanDueReminders()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE v_customer_id INT;
    DECLARE v_name VARCHAR(100);
    DECLARE v_end_date DATE;

    
    DECLARE cur CURSOR FOR
        SELECT c.CustomerID, c.Name, l.EndDate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE l.EndDate BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 30 DAY);

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN cur;

    reminder_loop: LOOP
        FETCH cur INTO v_customer_id, v_name, v_end_date;
        IF done THEN
            LEAVE reminder_loop;
        END IF;

    
        SELECT CONCAT('Reminder: Dear ', v_name, ', your loan is due on ', DATE_FORMAT(v_end_date, '%Y-%m-%d')) AS Reminder_Message;
    END LOOP;

    CLOSE cur;
END;
//

DELIMITER ;
