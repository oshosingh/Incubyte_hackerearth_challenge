import React, { useState } from "react";
import { updateWord } from "../../RestApi";

function SingleWord(props) {
  const [newWord, setNewWord] = useState("");
  const [invalidInput, setInvalidInput] = useState(false);

  const handleChange = (event) => {
    setNewWord(event.target.value);
    if (newWord.length > 0) {
      setInvalidInput(false);
    }
    if (props.wordPostSuccessUpdate === true) {
      props.refreshOnWordUpdate(false);
    }
  };

  const handleEditWord = () => {
    if (newWord.length === 0) {
      setInvalidInput(true);
      return;
    }
    updateWord(props.elementindex, newWord).then((data) => {
      props.refreshOnWordUpdate(true);
      setNewWord("");
    });
  };

  return (
    <>
      <h4> {props.word.wordId}. </h4>
      <h4> {props.word.word} </h4>
      <button onClick={handleEditWord}> Edit Word </button>
      <input
        type="text"
        onChange={handleChange}
        value={newWord}
        className={invalidInput ? "error" : "edit-word-input"}
      />
    </>
  );
}

export default SingleWord;
