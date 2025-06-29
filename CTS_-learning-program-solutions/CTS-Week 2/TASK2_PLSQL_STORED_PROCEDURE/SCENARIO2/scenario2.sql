DELIMITER //

CREATE PROCEDURE UpdateEmployeeBonus (
    IN dept_name  VARCHAR(50),
    IN bonus_percent DECIMAL(5,2)
)
BEGIN
    START TRANSACTION;

        UPDATE Employees
        SET Salary = Salary * (1 + bonus_percent / 100)
        WHERE Department = dept_name;

    COMMIT;
END //
DELIMITER ;
