import React from "react";

const ListofPlayers = () => {
  const players = [
    { name: "Virat Kohli", score: 92 },
    { name: "Rohit Sharma", score: 85 },
    { name: "MS Dhoni", score: 78 },
    { name: "Sachin Tendulkar", score: 99 },
    { name: "Rahul Dravid", score: 80 },
    { name: "Sourav Ganguly", score: 70 },
    { name: "Yuvraj Singh", score: 66 },
    { name: "Jasprit Bumrah", score: 60 },
    { name: "Ravindra Jadeja", score: 74 },
    { name: "Harbhajan Singh", score: 62 },
    { name: "Anil Kumble", score: 55 },
  ];


  const below70 = players.filter(player => player.score < 70);
  const uniqueScores = [...new Set(players.map(p => p.score))];
  const scoreMap = new Map(players.map(player => [player.name, player.score]));

  return (
    <div>
      <h2 style={{ color: "blue" }}>Cricket App</h2>
      <h3>All Players</h3>
      <ul>
        {players.map((player, i) => (
          <li key={i}>{player.name} - {player.score}</li>
        ))}
      </ul>

      <h3>Players with Score Below 70</h3>
      <ul>
        {below70.map((player, i) => (
          <li key={i}>{player.name} - {player.score}</li>
        ))}
      </ul>

      <h3>Unique Scores (Set)</h3>
      <p>{uniqueScores.join(", ")}</p>

      <h3>Player Scores (Map)</h3>
      <ul>
        {[...scoreMap].map(([name, score], i) => (
          <li key={i}>{name}: {score}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
