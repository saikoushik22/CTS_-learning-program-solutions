
SELECT EmployeeID, Name, Department, Salary
FROM Employees
WHERE Department IN ('IT','HR')
ORDER BY Department, Name;
