
DELIMITER //

CREATE PROCEDURE UpdateEmployeeBonus (
    IN p_department  VARCHAR(50),
    IN p_bonus_pct   DECIMAL(5,2)   
)
BEGIN
    
    START TRANSACTION;

        UPDATE Employees
        SET Salary = Salary * (1 + p_bonus_pct / 100)
        WHERE Department = p_department;

    COMMIT;
END //
DELIMITER ;
