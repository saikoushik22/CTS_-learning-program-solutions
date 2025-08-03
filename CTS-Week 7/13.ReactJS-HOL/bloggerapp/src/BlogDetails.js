import React from "react";

const BlogDetails = () => {
  const blogs = [
    {
      title: "React Learning",
      author: "Stephen Biz",
      content: "Welcome to learning React!",
    },
    {
      title: "Installation",
      author: "Schewzdenier",
      content: "You can install React from npm.",
    },
  ];

  return (
    <div>
      <h2>Blog Details</h2>
      {blogs.map((blog, index) => (
        <div key={index}>
          <b>{blog.title}</b><br />
          <i>{blog.author}</i><br />
          {blog.content}
          <br /><br />
        </div>
      ))}
    </div>
  );
};

export default BlogDetails;
