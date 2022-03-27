import React, { useState, useEffect } from "react";
import "./wordForm.css";
import WordList from "./WordList/WordList";
import { getWords, postWord } from "../RestApi";

function WordForm() {
  const [word, setWord] = useState("");
  const [invalidInput, setInvalidInput] = useState(false);
  const [wordsList, setWordsList] = useState([]);
  const [wordPostSuccess, setWordPostSuccess] = useState(false);

  useEffect(() => {
    getWords().then((data) => {
      setWordsList(data);
    });
  }, [wordPostSuccess]);

  const handleChange = (event) => {
    setWord(event.target.value);
    if (word.length > 0 && invalidInput === true) {
      setInvalidInput(false);
    }

    // Update the state value to false, working on newWord
    if (wordPostSuccess === true) {
      setWordPostSuccess(false);
    }
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    if (word.length === 0) {
      setInvalidInput(true);
      return;
    }

    postWord(word).then((data) => {
      if (data === 1) {
        setWordPostSuccess(true);
      }
    });
  };

  const refreshOnWordUpdate = (value) => {
    setWordPostSuccess(value);
  };

  return (
    <>
      <div className="form-parent">
        <form onSubmit={handleSubmit}>
          <div className="form-header">
            <label>Dictionary</label>
          </div>
          <div className="form-body">
            <h4>Enter Word</h4>
            <input
              type="text"
              onChange={handleChange}
              className={invalidInput ? "error" : ""}
            />
          </div>
          <button type="submit">Add Word</button>
        </form>
      </div>
      <WordList
        wordsList={wordsList}
        refreshOnWordUpdate={refreshOnWordUpdate}
        wordPostSuccessState={wordPostSuccess}
      />
    </>
  );
}

export default WordForm;
