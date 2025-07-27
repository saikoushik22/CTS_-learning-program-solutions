ALTER TABLE Customers
ADD COLUMN IsVIP BOOLEAN DEFAULT FALSE;
DELIMITER //

CREATE PROCEDURE PromoteToVIP()
BEGIN
    UPDATE Customers
    SET IsVIP = TRUE
    WHERE Balance > 10000 AND CustomerID IS NOT NULL;  -- key column used
    
    SELECT COUNT(*) AS Promoted_Customers
    FROM Customers
    WHERE Balance > 10000 AND IsVIP = TRUE;
END;
//

DELIMITER ;

