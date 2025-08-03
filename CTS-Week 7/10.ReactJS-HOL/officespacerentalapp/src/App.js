import React from "react";

const App = () => {
  const officeList = [
    {
      name: "Eco Tower",
      rent: 55000,
      address: "MG Road, Bengaluru",
      image: "https://images.unsplash.com/photo-1564013799919-ab600027ffc6"
    },
    {
      name: "Skyline Plaza",
      rent: 72000,
      address: "Banjara Hills, Hyderabad",
      image: "https://images.unsplash.com/photo-1503387762-592deb58ef4e"
    },
    {
      name: "Cyber Heights",
      rent: 60000,
      address: "Hinjewadi, Pune",
      image: "https://images.unsplash.com/photo-1528909514045-2fa4ac7a08ba"
    }
  ];

  const heading = <h1 style={{ color: "blue" }}>Office Space Rental App</h1>;

  return (
    <div style={{ textAlign: "center", padding: "20px" }}>
      {heading}

      {officeList.map((office, index) => (
        <div
          key={index}
          style={{
            border: "1px solid #ccc",
            borderRadius: "8px",
            padding: "10px",
            margin: "10px",
            display: "inline-block",
            width: "250px"
          }}
        >
          <img src={office.image} alt="office" width="100%" />
          <h2>{office.name}</h2>
          <p>{office.address}</p>
          <p
            style={{
              color: office.rent < 60000 ? "red" : "green",
              fontWeight: "bold"
            }}
          >
            ₹{office.rent}
          </p>
        </div>
      ))}
    </div>
  );
};

export default App;
