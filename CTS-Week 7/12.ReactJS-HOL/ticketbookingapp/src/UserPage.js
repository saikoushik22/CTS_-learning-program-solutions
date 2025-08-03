import React, { useState } from "react";

const UserPage = () => {
  const [bookedFlights, setBookedFlights] = useState([]);

  const flights = [
    { id: 1, airline: "IndiGo", from: "Hyderabad", to: "Mumbai", price: 3200 },
    { id: 2, airline: "Air India", from: "Delhi", to: "Chennai", price: 4500 },
    { id: 3, airline: "SpiceJet", from: "Bangalore", to: "Kolkata", price: 3900 }
  ];

  const handleBook = (flight) => {
    alert(`Booking confirmed for ${flight.airline}`);
    setBookedFlights([...bookedFlights, flight.id]);
  };

  return (
    <div style={{ textAlign: "center", marginTop: "20px" }}>
      <h2>Welcome, User!</h2>
      <p>You can now book your tickets.</p>

      <h3>Available Flights</h3>
      {flights.map((flight) => (
        <div
          key={flight.id}
          style={{
            border: "1px solid #ccc",
            padding: "10px",
            margin: "10px auto",
            width: "300px",
            borderRadius: "8px"
          }}
        >
          <p><strong>Airline:</strong> {flight.airline}</p>
          <p><strong>From:</strong> {flight.from} → <strong>To:</strong> {flight.to}</p>
          <p><strong>Price:</strong> ₹{flight.price}</p>

          <button
            onClick={() => handleBook(flight)}
            disabled={bookedFlights.includes(flight.id)}
          >
            {bookedFlights.includes(flight.id) ? "Booked" : "Book"}
          </button>
        </div>
      ))}
    </div>
  );
};

export default UserPage;
