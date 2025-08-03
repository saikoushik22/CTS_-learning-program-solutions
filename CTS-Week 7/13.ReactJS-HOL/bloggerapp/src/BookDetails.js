import React from "react";

const BookDetails = () => {
  const books = [
    { title: "Master React", price: 670 },
    { title: "Deep Dive into Angular 11", price: 800 },
    { title: "Mongo Essentials", price: 450 },
  ];

  return (
    <div>
      <h2>Book Details</h2>
      {books.map((book, index) => (
        <div key={index}>
          <b>{book.title}</b><br />
          {book.price}
          <br /><br />
        </div>
      ))}
    </div>
  );
};

export default BookDetails;
