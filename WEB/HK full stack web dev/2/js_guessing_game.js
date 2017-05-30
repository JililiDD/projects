var randomNum;
var numOfGuess = 0;
var correct=false;

function do_game(){
  randomNum = Math.floor(Math.random() * 101);
  numOfGuess = 0;
  while(!correct){
    var userInput = prompt("Please type in an integer between 0 - 100:");
    while(!isValid(userInput)){
      userInput = prompt("Please type in an integer between 0 - 100:");
    }
    checkGuess(userInput);
  }
}

function isValid(num){
  if(isNaN(parseInt(num))){
    alert("Please type in a number!");
    return false;
  }
  else if(parseInt(num) < 0 || parseInt(num) > 100){
    alert("your guess is out of range. It should be from 0 - 100");
    return false;
  }
  else{
    return true;
  }
}

function checkGuess(num){
  if(num > randomNum){
    alert("your guess is too big");
    numOfGuess++;
  }
  else if(num < randomNum){
    alert("your guess is too small");
    numOfGuess++;
  }
  else{
    alert("Bingo!\nYou get the correct guess in " + numOfGuess + " guesses!!");
    correct = true;
  }
}
