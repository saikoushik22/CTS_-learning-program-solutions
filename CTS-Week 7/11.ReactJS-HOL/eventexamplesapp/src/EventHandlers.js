import React, { useState } from "react";

const EventHandlers = () => {
  const [count, setCount] = useState(0);

  const increment = () => {
    setCount(prev => prev + 1);
    sayHello();
  };

  const sayHello = () => {
    console.log("Hello! You clicked Increment.");
  };

  const decrement = () => {
    setCount(prev => prev - 1);
  };

  const sayWelcome = (msg) => {
    alert("Say Welcome: " + msg);
  };

  const handleClick = (e) => {
    alert("I was clicked");
    console.log("Synthetic event:", e);
  };

  return (
    <div style={{ textAlign: "center", padding: "20px" }}>
      <h2>Event Handling Example</h2>
      <p>Counter: {count}</p>
      <button onClick={increment}>Increment</button>&nbsp;
      <button onClick={decrement}>Decrement</button>&nbsp;
      <button onClick={() => sayWelcome("Welcome to React!")}>Say Welcome</button>&nbsp;
      <button onClick={handleClick}>Synthetic Event</button>
    </div>
  );
};

export default EventHandlers;
