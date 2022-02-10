class Solution {
public:
    int mostWordsFound(vector<string>& sentences) {
         int maxWordsAtSentence = 0;

      std::for_each(
            sentences.begin(),
            sentences.end(),
            [&maxWordsAtSentence](const string &sentence) {
               int wordsAtSentence = 1;
               for (char symbol: sentence) {
                  if (symbol == ' ') {
                     wordsAtSentence++;
                  }
               }

               if (maxWordsAtSentence < wordsAtSentence) {
                  maxWordsAtSentence = wordsAtSentence;
               }
            }
      );

      return maxWordsAtSentence;
    }
};