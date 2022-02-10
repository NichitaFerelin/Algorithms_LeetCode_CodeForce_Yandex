class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
        auto totalBeams{0};
      auto previousStepDevices{0};

      std::for_each(
            bank.begin(),
            bank.end(),
            [&totalBeams, &previousStepDevices](const string &row) {
               auto stepDevices{0};
               for (auto symbol: row) {
                  if (symbol == '1') stepDevices++;
               }
               totalBeams += previousStepDevices * stepDevices;

               if (stepDevices != 0) {
                  previousStepDevices = stepDevices;
               }
            }
      );
      return totalBeams;
    }
};