import axios from "axios";

const restUrl = "https://oshobackend.herokuapp.com";
// const restUrl = "http://localhost:8080";

export const postWord = async (data) => {
  const res = await axios.post(`${restUrl}/api/add/word?word=${data}`);
  if (res.status === 200) {
    return 1;
  }
  return 0;
};

export const getWords = async () => {
  const res = await axios.get(`${restUrl}/api/get/words`);
  if (res.status === 200) {
    return res.data;
  }
  return [];
};

export const updateWord = async (wordId, newWord) => {
  const res = await axios.put(
    `${restUrl}/api/update/word?wordId=${wordId}&newWord=${newWord}`
  );
  if (res.status === 200) {
    return res.data;
  }
  return [];
};

export const deleteWord = async (wordId) => {
  const res = await axios.delete(`${restUrl}/api/delete/word?wordId=${wordId}`);
  if (res.status === 200) {
    return 1;
  }
  return 0;
};
