package problems.leetcode.easy

/*
* Given a valid (IPv4) IP address, return a defanged version of that IP address.
* A defanged IP address replaces every period "." with "[.]".
* */

class LeetCode_1108 {

    fun defangIPaddr(address: String): String {
        return address.replace(".", "[.]")
    }
}