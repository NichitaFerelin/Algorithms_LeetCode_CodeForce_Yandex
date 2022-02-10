/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    int pairSum(ListNode* head) {
         auto listSize{1};
      auto current = head;

      while (current->next != nullptr) {
         current = current->next;
         listSize++;
      }

      current = head;
      stack<int> firstHalf;
      auto currentNodeIndex{0};
      while (currentNodeIndex != listSize / 2) {
         currentNodeIndex++;
         current = current->next;
      }
      while (currentNodeIndex != listSize) {
         firstHalf.push(current->val);
         currentNodeIndex++;
         current = current->next;
      }

      auto maxSum{INT_MIN};
      current = head;
      currentNodeIndex = 0;
      while (currentNodeIndex != listSize / 2) {
         int stepSum = current->val + firstHalf.top();
         firstHalf.pop();

         if (stepSum > maxSum) {
            maxSum = stepSum;
         }
         current = current->next;
         currentNodeIndex++;
      }

      return maxSum;
    }
};