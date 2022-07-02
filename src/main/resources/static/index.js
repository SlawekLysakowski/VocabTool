// 'use strict';

// let koreanCur = document.getElementById('current-display-word');



    //
    // if (wordsArray.length < 10) {
    //   document.getElementById(`word-${wordsArray.length + 1}`).textContent = '';
    // }







// console.log(kor);

// console.log(koreanCur);


// let koreanCur = document.getElementById('current-display-word').textContent;
// let feedback = document.getElementById('feedback');
// console.log(jap);
//
// const arr = `[[${arr}]]`;
// console.log(arrJS[0]);
// //
// document.getElementById('check').addEventListener('click', function () {
//   const answer = document.getElementById('enter-word').value;
//   console.log(answer);
// if (answer === jap) {
//   feedback.textContent= `correct`;
// } else {
//   feedback.textContent= 'wrong answer';
// }
//
// })


//
// let wordsArray = [];
// let highlightedWord;
// let wordIndex;
// let answerKor;
// let answerJpy;
// let index;
// let newRandomNumber;
// let correctNbr = 0;
// let wrongNbr = 0;
// let japToKor = true;


//
// document.getElementById('correct').textContent = `Correct answers: ${correctNbr}`;
// document.getElementById('wrong').textContent = `Wrong answers:\u00A0 ${wrongNbr}`;
// const displayedWord = document.querySelector('#current-display-word');
//
// console.log(displayedWord.style.fontSize)
//

// let wordsArray = [];
//
// const newWordsArray = function (vocab) {
//   wordsArray = [...new Array(10)]
//     .map(() => vocab[Math.round(Math.random() * vocab.size())]);
//
//   updateWords();
//   document.getElementById(`word-1`).style.color = '#ff4800';
//   return wordsArray;
// }
//
// const newWord = function () {
//   newRandomNumber = Math.trunc(Math.random() * wordsArray.length);
//   let randomWord = wordsArray[newRandomNumber];
//   wordIndex = japToKor ? japaneseWords.indexOf(randomWord) : koreanWords.indexOf(randomWord);
//   document.getElementById('current-display-word').textContent = randomWord;
//   console.log(displayedWord.textContent.length)
//   if (displayedWord.textContent.length > 10) {
//     displayedWord.style.fontSize = `30px`;
//   } else {
//     displayedWord.style.fontSize = `40px`;
//   }
//   console.log(displayedWord.style.fontSize)
//   japToKor ? answerKor = koreanWords[wordIndex] : answerJpy = japaneseWords[wordIndex];
//   document.getElementById('polishWord').textContent = polishWords[wordIndex];
//   document.getElementById('englishWord').textContent = englishWords[wordIndex];
//   document.getElementById("enter-word").value = "";
//   // console.log(wordsArray.indexOf(randomWord));
//   updateWords();
//   highlightedWord = document.getElementById(`word-${wordsArray.indexOf(randomWord) + 1}`).style.color = '#ff4800';
//   // console.log(wordIndex);
// }
//
//
// const updateWords = function () {
//   if (wordsArray.length === 0) {
//     document.querySelector('.word-array-box').style.height = '';
//     newWordsArray(japToKor ? japaneseWords : koreanWords);
//     appSizing();
//   }
//   wordsArray.forEach((word, i) => {
//
//     document.getElementById(`word-${i + 1}`).textContent = word;
//     document.getElementById(`word-${i + 1}`).style.color = '#495057';
//
//     if (wordsArray.length < 10) {
//       document.getElementById(`word-${wordsArray.length + 1}`).textContent = '';
//     }
//   })
// }
//
//
// const switchTransDir = function () {
//   japToKor = true ? !japToKor : japToKor;
//   document.getElementById('translation').textContent = japToKor ? `KOR : JAP` : 'JAP : KOR';
//   document.querySelector('.word-array-box').style.height = '';
//   newWordsArray(japToKor ? japaneseWords : koreanWords);
//   appSizing();
//   newWord();
// }
//
// document.getElementById('translation').addEventListener('click', switchTransDir);
//
// const hideShowLang = function (selectedSwitch, word) {
//   document.getElementById(`${selectedSwitch}`).addEventListener("click", function () {
//     let display = document.getElementById(`${word}`);
//     display.style.display === "grid" ? display.style.display = "none" : display.style.display = "grid";
//   })
// }
//
//
// const correctAnswer = function () {
//   newWord();
//   correctNbr++;
//   document.getElementById('correct').textContent = `Correct answers: ${correctNbr}`;
//   document.getElementById('feedback').textContent = `Correct answer! 😊 Congratulations!🎉`;
//   setTimeout(function () {
//     document.getElementById('feedback').textContent = ``;
//   }, 2000);
// };
//
// const wrongAnswer = function () {
//   newWord();
//   ++wrongNbr;
//   document.getElementById('wrong').textContent = `Wrong answers: ${wrongNbr}`;
//   setTimeout(function () {
//     document.getElementById('feedback').textContent = ``;
//   }, 3500);
// };
//
// const checkAnswer = function () {
//   let input = document.getElementById("enter-word").value;
//   if (japToKor) {
//     if (input === answerKor || answerKor.includes(input) && input !== "") {
//       wordsArray.splice(index, 1);
//       updateWords();
//       correctAnswer();
//     } else {
//       document.getElementById('feedback').textContent =
//         `wrong answer! 😢 Correct answer was: \u00A0 \u00A0
//                    ` + `  ${answerKor}`;
//       wrongAnswer();
//     }
//
//   }
//   if (!japToKor) {
//     if (input === answerJpy || answerJpy.includes(input) && input !== "") {
//       // wordsArray.splice(wordsArray.indexOf(wordsArray[newRandomNumber]));
//       wordsArray.splice(index, 1);
//       updateWords();
//       correctAnswer();
//       if (wordsArray.length === 0) newWordsArray(koreanWords);
//
//     } else {
//
//       document.getElementById('feedback').textContent =
//         `wrong answer! 😢 Correct answer was: \u00A0 \u00A0
//                      ${answerJpy}`;
//       wrongAnswer();
//     }
//   }
// };
//
// document.querySelector('#enter-word').addEventListener('keypress', function (e) {
//   if (e.key === 'Enter') checkAnswer();
// });
//
// document.querySelector('#check').addEventListener('click', checkAnswer);
//
// // console.log(japaneseWords.length);
// // console.log(koreanWords.length);
// // console.log(polishWords.length);
// // console.log(englishWords.length);
// // console.log(polishWords[180])
const appSizing = function () {
  const wordsDiv = document.querySelector('.word-array-box');
  const wordsDivHeight = wordsDiv.scrollHeight;
  const heightRatio = wordsDivHeight / visualViewport.height;

  console.log(wordsDivHeight, heightRatio)
  wordsDiv.style.height = `${wordsDivHeight}px`;

  if (heightRatio > 0.80) {
    wordsDiv.style.height = `80%`;
    wordsDiv.style.fontSize = `23px`
  }
  if (heightRatio < 0.50) {
    wordsDiv.style.height = `70%`;
    wordsDiv.style.fontSize = `45px`
  }

}

window.onload = function () {
//   newWordsArray(japaneseWords);
//   newWord()
  appSizing();
//   hideShowLang('polish', 'polishWord');
//   hideShowLang('english', 'englishWord');
//
}
