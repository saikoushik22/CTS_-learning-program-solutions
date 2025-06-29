ALTER TABLE Customers
ADD COLUMN IsVIP BOOLEAN DEFAULT FALSE;

DELIMITER //

CREATE PROCEDURE PromoteToVIP()
BEGIN
    DECLARE vip_counter INT DEFAULT 0;

    UPDATE Customers
    SET IsVIP = TRUE
    WHERE Balance > 10000 AND CustomerID IS NOT NULL;

    SELECT COUNT(*) INTO vip_counter
    FROM Customers
    WHERE Balance > 10000 AND IsVIP = TRUE;

    SELECT vip_counter AS Promoted_Customers;
END;
//

DELIMITER ;
