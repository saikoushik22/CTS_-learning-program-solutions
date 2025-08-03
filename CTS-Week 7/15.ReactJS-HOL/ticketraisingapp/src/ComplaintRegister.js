import React, { useState } from 'react';
import './ComplaintRegister.css';

function ComplaintRegister() {
  const [name, setName] = useState('');
  const [complaint, setComplaint] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    const referenceNumber = 'REF' + Math.floor(Math.random() * 10000);
    alert(`Complaint Submitted!\nName: ${name}\nComplaint: ${complaint}\nReference: ${referenceNumber}`);
    setName('');
    setComplaint('');
  };

  return (
    <div className="form-container">
      <form onSubmit={handleSubmit}>
        <h2>Complaint Form</h2>
        <label>Employee Name:</label><br />
        <input type="text" value={name} onChange={(e) => setName(e.target.value)} required /><br /><br />
        <label>Complaint:</label><br />
        <textarea value={complaint} onChange={(e) => setComplaint(e.target.value)} required></textarea><br /><br />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default ComplaintRegister;
