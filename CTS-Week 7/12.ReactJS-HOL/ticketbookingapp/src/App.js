import React, { useState } from "react";
import GuestPage from "./GuestPage";
import UserPage from "./UserPage";

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogin = () => {
    alert("Logging in...");
    setIsLoggedIn(true);
  };

  const handleLogout = () => {
    alert("Logging out...");
    setIsLoggedIn(false);
  };

  return (
    <div className="App" style={{ textAlign: "center" }}>
      <h1>✈️ Flight Ticket Booking App</h1>

      <div style={{ marginBottom: "20px" }}>
        {isLoggedIn ? (
          <button onClick={handleLogout}>Logout</button>
        ) : (
          <button onClick={handleLogin}>Login</button>
        )}
      </div>

      {/* Conditional Rendering */}
      {isLoggedIn ? <UserPage /> : <GuestPage />}
    </div>
  );
}

export default App;
