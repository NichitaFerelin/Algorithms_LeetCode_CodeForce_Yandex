package problems.leetcode.easy

class LeetCode_929 {

    fun numUniqueEmails(emails: Array<String>): Int {
        val convertedEmails = HashMap<String, Unit>(emails.size)
        var willBeSend = 0
        emails.forEach { mail ->
            val converted = clearEmailLocalName(mail)
            if (convertedEmails[converted] == null) {
                willBeSend++
                convertedEmails[converted] = Unit
            }
        }

        return willBeSend
    }

    private fun clearEmailLocalName(address: String): String {
        var addressCursor = 0
        while (addressCursor < address.length && address[addressCursor] != '@') {
            addressCursor++
        }

        val localName = address.substring(0, addressCursor)
        val domainName = address.substring(addressCursor + 1)

        var localNameCursor = 0
        var resultLocalName = ""
        while (localNameCursor < localName.length && localName[localNameCursor] != '+') {
            if (localName[localNameCursor].isLetter()) {
                resultLocalName += localName[localNameCursor]
            }
            localNameCursor++
        }

        return "${resultLocalName}@${domainName}"
    }
}