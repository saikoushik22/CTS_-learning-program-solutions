import React from "react";

const IndianPlayers = () => {
  const T20Players = ["Rohit", "Virat", "Surya", "Jadeja", "Bumrah"];
  const RanjiPlayers = ["Gill", "Rahul", "Ashwin", "Shami", "Hardik"];

  // Merging using ES6
  const allPlayers = [...T20Players, ...RanjiPlayers];

  const [odd, even] = allPlayers.reduce(
    ([odd, even], player, index) => {
      if (index % 2 === 0) odd.push(player);
      else even.push(player);
      return [odd, even];
    },
    [[], []]
  );

  return (
    <div>
      <h2>Indian Players</h2>
      <h3>Odd Team Players</h3>
      <ul>{odd.map((player, i) => <li key={i}>{player}</li>)}</ul>

      <h3>Even Team Players</h3>
      <ul>{even.map((player, i) => <li key={i}>{player}</li>)}</ul>
    </div>
  );
};

export default IndianPlayers;
