import React, { useContext } from "react";
import ThemeContext from "./ThemeContext";

const EmployeeCard = ({ employee }) => {
  const theme = useContext(ThemeContext);

  const cardStyle = {
    backgroundColor: theme === "dark" ? "#222" : "#f4f4f4",
    color: theme === "dark" ? "#fff" : "#000",
    margin: "10px auto",
    padding: "20px",
    borderRadius: "10px",
    width: "300px"
  };

  const buttonStyle = {
    padding: "10px",
    backgroundColor: theme === "dark" ? "#555" : "#fff",
    color: theme === "dark" ? "#fff" : "#000",
    border: "1px solid #ccc",
    borderRadius: "5px",
    marginTop: "10px"
  };

  return (
    <div style={cardStyle}>
      <h2>{employee.name}</h2>
      <p>{employee.role}</p>
      <button style={buttonStyle}>View Details</button>
    </div>
  );
};

export default EmployeeCard;
