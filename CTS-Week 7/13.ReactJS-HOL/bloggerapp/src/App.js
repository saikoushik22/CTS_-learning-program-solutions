import React, { useState } from "react";
import CourseDetails from "./CourseDetails";
import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";

function App() {
  const [show, setShow] = useState("book");

  let element;
  if (show === "book") {
    element = <BookDetails />;
  } else if (show === "blog") {
    element = <BlogDetails />;
  } else if (show === "course") {
    element = <CourseDetails />;
  }

  return (
    <div style={{ textAlign: "center" }}>
      <h1>Blogger App</h1>

      <div style={{ marginBottom: "20px" }}>
        <button onClick={() => setShow("book")}>Show Book</button>&nbsp;
        <button onClick={() => setShow("blog")}>Show Blog</button>&nbsp;
        <button onClick={() => setShow("course")}>Show Course</button>
      </div>

      <hr style={{ marginBottom: "30px" }} />

      {element}
    </div>
  );
}

export default App;
