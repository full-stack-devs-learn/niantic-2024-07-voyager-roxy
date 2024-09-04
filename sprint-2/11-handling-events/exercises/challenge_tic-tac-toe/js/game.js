// players player 1,2
const player1 = {
    name: 'Player One',
    value: 'X'
}
const player2 = {
    name: 'Player Two',
    value: 'O'
}

// current
let currentPlayer = player1;


function setNextPlayer()
{
    if(currentPlayer == player1)
    {
        currentPlayer = player2
    }
    else
    {
        currentPlayer = player1
    }
}

function playerMove(event)
{
    const btn = event.target;

    if(btn.textContent == "")
    {
        btn.textContent = currentPlayer.value
        setNextPlayer()
    }
}


function init()
{
    const btns = document.querySelectorAll(".btn")

    btns.forEach(btn => {
        btn.addEventListener("click", playerMove)
    })

    const resetButton = document.getElementById("resetButton")

    resetButton.addEventListener("click", reset)
}

function reset()
{
    const btns = document.querySelectorAll(".btn-secondary ")

    btns.forEach(btn => {
        btn.textContent = "";
    })
}

// main
document.addEventListener('DOMContentLoaded', () =>
{
    init()
})
