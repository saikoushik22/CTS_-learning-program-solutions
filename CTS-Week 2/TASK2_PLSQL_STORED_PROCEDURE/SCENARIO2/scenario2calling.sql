SELECT EmployeeID, Name, Department AS Dept, Salary
FROM Employees
WHERE Dept IN ('IT', 'HR')
ORDER BY Dept, Name;
