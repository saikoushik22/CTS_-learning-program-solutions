import React, { useState } from "react";

const CurrencyConvertor = () => {
  const [amount, setAmount] = useState("");
  const [currency, setCurrency] = useState("euro");
  const [result, setResult] = useState("");

  const rates = {
    euro: 90,
    usd: 83,
    gbp: 105,
    jpy: 0.56
  };

  const handleConvert = () => {
    alert("Converting...");

    const rate = rates[currency];
    const rupees = (parseFloat(amount) * rate).toFixed(2);
    setResult(`₹ ${rupees}`);
  };

  return (
    <div style={{ textAlign: "center", marginTop: "30px" }}>
      <h2>Foreign Currency to INR Converter</h2>

      <input
        type="number"
        value={amount}
        onChange={(e) => setAmount(e.target.value)}
        placeholder="Enter amount"
      />
      &nbsp;

      <select value={currency} onChange={(e) => setCurrency(e.target.value)}>
        <option value="euro">Euro (€)</option>
        <option value="usd">USD ($)</option>
        <option value="gbp">GBP (£)</option>
        <option value="jpy">Yen (¥)</option>
      </select>
      &nbsp;

      <button onClick={handleConvert}>Convert</button>

      {result && <h3>{result}</h3>}
    </div>
  );
};

export default CurrencyConvertor;
