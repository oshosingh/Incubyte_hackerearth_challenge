import React, { useState } from "react";
import { deleteWord, updateWord } from "../../RestApi";

function SingleWord(props) {
  const [newWord, setNewWord] = useState("");
  const [invalidInput, setInvalidInput] = useState(false);

  const handleChange = (event) => {
    setNewWord(event.target.value);
    if (newWord.length > 0) {
      setInvalidInput(false);
    }
    if (props.wordPostSuccessState === true) {
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

  const handleDeleteWord = () => {
    if (props.wordPostSuccessState === true) {
      props.refreshOnWordUpdate(false);
    }
    deleteWord(props.elementindex).then((data) => {
      if (data === 1) {
        props.refreshOnWordUpdate(true);
      }
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
      <button onClick={handleDeleteWord}> Delete Word </button>
    </>
  );
}

export default SingleWord;
