const matchPoints = {
  0: 'Love',
  1: '15',
  2: '30',
  3: '40',
  4: 'Deuce',
  5: 'Advantage',
  6: 'Win'
}

enum Player {
  P1 = 'P1',
  P2 = 'P2'
}

interface Game {
  [Player.P1]: number,
  [Player.P2]: number,
}

function matchPointsGame(game: Game, playerPoint: Player): void {
  game[playerPoint] += 1
  
  const pointsP1 = game[Player.P1]
  const pointsP2 = game[Player.P2]

  if (playerPoint === Player.P1 && game[Player.P1] === 4 && game[Player.P2] <= 2) {
      game[Player.P1] = 6
  }

  if (playerPoint === Player.P2 && game[Player.P2] === 4 && game[Player.P1] <= 2) {
    game[Player.P2] = 6
}

  if (pointsP1 === 3 && pointsP2 === 3) {
    game[Player.P1] = 4
    game[Player.P2] = 4
    return
  }

  if (pointsP1 === 4 && pointsP2 === 4) {
    if (playerPoint === Player.P1) {
      game[Player.P1] += 1
      game[Player.P2] -= 1
    }

    if (playerPoint === Player.P2) {
      game[Player.P1] -= 1
      game[Player.P2] += 1
    }

    return
  }

  if (pointsP1 === 5 && pointsP2 === 5) {
    game[Player.P1] = 4
    game[Player.P2] = 4

    return
  }

}

const tennisMatch = (matchSequence: Player[]): void => {
  let game: Game = {
    P1: 0,
    P2: 0
  }

  matchSequence.forEach(playerPoint => {
    matchPointsGame(game, playerPoint)
    
    if (game[playerPoint] === 4) {
      console.log(matchPoints[game[playerPoint]])
    } else if (game[playerPoint] === 5 || game[playerPoint] === 6) {
      console.log(matchPoints[game[playerPoint]] + " " + playerPoint)
    } else {
      console.log(matchPoints[game.P1] + " - " + matchPoints[game.P2])
    }
    
  })
  
}

tennisMatch([Player.P1, Player.P2, Player.P2, Player.P1, Player.P2, Player.P1, Player.P1, Player.P2, Player.P1, Player.P1])
//            15-0,     15-15,     15-30,      30-30,    30-40,     Deuce,  advantage p1, Deuce,    advantage p1, win p1

console.log('----------------------------------------------------------------')

tennisMatch([Player.P1, Player.P1, Player.P1, Player.P1])
//            15-0,     30-0,     40-0,      win p1

console.log('----------------------------------------------------------------')

tennisMatch([Player.P2, Player.P2, Player.P2, Player.P2])
//            15-0,     30-0,     40-0,      win p1


