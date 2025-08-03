import React from "react";
import EmployeeCard from "./EmployeeCard";

const employees = [
  { id: 1, name: "KOUSHIK", role: "Frontend Developer" },
  { id: 2, name: "KARTHIK", role: "Backend Developer" }
];

const EmployeesList = () => {
  return (
    <div style={{ marginTop: "20px" }}>
      {employees.map((emp) => (
        <EmployeeCard key={emp.id} employee={emp} />
      ))}
    </div>
  );
};

export default EmployeesList;
