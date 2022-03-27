import React, { useState } from "react";
import SingleWord from "../SingleWord/SingleWord";
import "./wordList.css";

function WordList(props) {
  return (
    <div className="list-parent">
      {props.wordsList.map((element, index) => {
        return (
          <div className="single-word" key={index}>
            <SingleWord
              word={element}
              key={index}
              elementindex={index + 1}
              refreshOnWordUpdate={props.refreshOnWordUpdate}
              wordPostSuccessState={props.wordPostSuccessState}
            />
          </div>
        );
      })}
    </div>
  );
}

export default WordList;
