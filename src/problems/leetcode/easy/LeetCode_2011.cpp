class Solution {
public:
    int finalValueAfterOperations(vector<string>& operations) {
         auto result{0};
            std::for_each(
            operations.begin(),
            operations.end(),
            [&result](const string &row) {
               if (row[0] == '-' || row[2] == '-') {
                  result--;
               } else {
                  result++;
               }
            }
      );
      return result;
    }
};